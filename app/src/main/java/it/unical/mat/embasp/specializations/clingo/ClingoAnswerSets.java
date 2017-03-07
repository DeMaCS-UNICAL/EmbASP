package it.unical.mat.embasp.specializations.clingo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import it.unical.mat.embasp.languages.asp.AnswerSet;
import it.unical.mat.embasp.languages.asp.AnswerSets;

/** represents Clingo's answersets */

public class ClingoAnswerSets extends AnswerSets {

	public ClingoAnswerSets(final String answersets) {
		super(answersets);
	}

	public ClingoAnswerSets(final String out, final String err) {
		super(out, err);
	}

	@Override
	protected void parse() {
		final boolean optimum = output.contains("OPTIMUM");
		final Pattern pattern = !optimum ? Pattern.compile("Answer: (\\d+)\\r?\\n(.*)")
				: Pattern.compile("Answer: (\\d+)\\r?\\n(.*)(\\r?\\nOptimization: (.+))");
		final Matcher matcher = pattern.matcher(output);
		while (matcher.find()) {

			try {
				if (matcher.group(1) == null || Integer.parseInt(matcher.group(1)) <= answersets.size())
					continue;
			} catch (final NumberFormatException e1) {
				e1.printStackTrace();
				break;
			}

			final Pattern patternAnswerSet = Pattern.compile("-?[a-z][A-Za-z0-9_]*(\\(.*?\\))?");
			final Matcher matcherAnswerSet = patternAnswerSet.matcher(matcher.group(2));
			final List<String> answerSetList = new ArrayList<>();
			while (matcherAnswerSet.find())
				answerSetList.add(matcherAnswerSet.group());

			if (optimum) {

				final Map<Integer, Integer> weightMap = new HashMap<>();
				try {
					final String[] split = matcher.group(4).split(" ");
					int level = split.length;
					for (final String weight : split)
						weightMap.put(level--, Integer.parseInt(weight));
				} catch (final NumberFormatException e) {
					e.printStackTrace();
				}

				answersets.add(new AnswerSet(answerSetList, weightMap));

			} else
				answersets.add(new AnswerSet(answerSetList));
		}

	}

}
