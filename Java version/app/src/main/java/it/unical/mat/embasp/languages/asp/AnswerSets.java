package it.unical.mat.embasp.languages.asp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
		int level = 0;
		List <AnswerSet> answerSets = getAnswersets(), optimalAnswerSets = new ArrayList <> ();
		
		for(final AnswerSet answerSet : answerSets) {
			final int maxLevel = Collections.max(answerSet.getWeights().keySet());
			
			if(level < maxLevel)
				level = maxLevel;
		}
		
		for(; level >= 1; level--) {
			int minimumCost = Integer.MAX_VALUE;
			
			for(final AnswerSet answerSet : answerSets) {
				final int cost = answerSet.getWeights().getOrDefault(level, 0);
				
				if(cost < minimumCost) {
					optimalAnswerSets.clear();
					
					minimumCost = cost;
				}
				
				if(cost == minimumCost)
					optimalAnswerSets.add(answerSet);
			}

			answerSets = new ArrayList <> (optimalAnswerSets);
		}
		
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
