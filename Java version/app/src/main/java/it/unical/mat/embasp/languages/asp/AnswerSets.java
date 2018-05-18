package it.unical.mat.embasp.languages.asp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import it.unical.mat.embasp.base.Output;
import it.unical.mat.parsers.asp.ASPDataCollection;

/** A collection of {@link AnswerSet} */

public abstract class AnswerSets extends Output implements ASPDataCollection {
	/** Where Answer Sets are stored */
	protected List<AnswerSet> answersets;

	public AnswerSets(final String out) {
		super(out);
	}

	public AnswerSets(final String out, final String err) {
		super(out, err);
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	public List<AnswerSet> getAnswersets() {
		if (answersets == null) {
			answersets = new ArrayList<>();
			parse();
		}

		return Collections.unmodifiableList(answersets);
	}

	public List<AnswerSet> getOptimalAnswerSets() {
		final List <AnswerSet> answerSets = getAnswersets(), optimalAnswerSets = new ArrayList <> ();
		int levels = 0;
		
		for(final AnswerSet answerSet : answerSets) {
			final int maxLevel = Collections.max(answerSet.getWeights().keySet());
			
			if(levels < maxLevel)
				levels = maxLevel;
		}
		
		final HashMap <Integer, Integer> minimumCostPerLevel = new HashMap <> (levels);
		
		for(int level = levels; level >= 1; level--) {
			int current, minimum = Integer.MAX_VALUE;
			
			for(final AnswerSet answerSet : answerSets) {
				boolean notOptimal = false;
				final Map <Integer, Integer> weights = answerSet.getWeights();
				
				for(int previousLevel = levels; previousLevel > level; previousLevel--)
					if(minimumCostPerLevel.getOrDefault(previousLevel, 0) != weights.getOrDefault(previousLevel, 0)) {
						notOptimal = true;
						
						break;
					}
				
				if(!notOptimal && (current = weights.getOrDefault(level, 0)) < minimum)
					minimumCostPerLevel.put(level, (minimum = current));
			}
		}
		
		answerSets.forEach(answerSet -> {
			for(final int level : minimumCostPerLevel.keySet())
				if(answerSet.getWeights().getOrDefault(level, 0) != minimumCostPerLevel.get(level))
					return;
			
			optimalAnswerSets.add(answerSet);
		});
		
		return optimalAnswerSets;
	}
	
	public String getAnswerSetsString() {
		return output;
	}

	@Override
	public void addAnswerSet() {
		answersets.add(new AnswerSet(new ArrayList <String> ()));
	}
	
	@Override
	public void storeAtom(final String result) {
		answersets.get(answersets.size() - 1).getValue().add(result);
	}
	
	@Override
	public void storeCost(final int level, final int weight) {
		answersets.get(answersets.size() - 1).getLevelWeight().put(level, weight);
	}
}
