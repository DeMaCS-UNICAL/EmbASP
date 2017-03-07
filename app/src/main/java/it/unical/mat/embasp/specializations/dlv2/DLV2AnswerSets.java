package it.unical.mat.embasp.specializations.dlv2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import it.unical.mat.embasp.languages.asp.AnswerSet;
import it.unical.mat.embasp.languages.asp.AnswerSets;

/** represents Dlv2's answersets */

public class DLV2AnswerSets extends AnswerSets {

	public DLV2AnswerSets(final String answersets) {
		super(answersets);
	}

	public DLV2AnswerSets(final String out, final String err) {
		super(out, err);
	}

	@Override
	protected void parse() {
		final boolean optimum = output.contains("OPTIMUM");
		final Pattern pattern = !optimum ? Pattern.compile("ANSWER\\r?\\n(.*)") : Pattern.compile("ANSWER\\r?\\n(.*)(\\r?\\nCOST (.+)\\r?\\nOPTIMUM)");

		final Matcher matcher = pattern.matcher(output);
		while (matcher.find()) {

			final Pattern patternAnswerSet = Pattern.compile("-?[a-z][A-Za-z0-9_]*(\\(.*?\\))?");
			final Matcher matcherAnswerSet = patternAnswerSet.matcher(matcher.group(1));
			final List<String> answerSetList = new ArrayList<>();
			while (matcherAnswerSet.find())
				answerSetList.add(matcherAnswerSet.group());

			if (optimum) {

				final Map<Integer, Integer> weightMap = new HashMap<>();
				try {
					final String[] split = matcher.group(3).split(" ");
					for (final String weightLevel : split) {
						final String[] weightLevelArray = weightLevel.split("@");
						weightMap.put(Integer.parseInt(weightLevelArray[1]), Integer.parseInt(weightLevelArray[0]));
					}
				} catch (final NumberFormatException e) {
					e.printStackTrace();
				}

				answersets.add(new AnswerSet(answerSetList, weightMap));

			} else
				answersets.add(new AnswerSet(answerSetList));
		}

	}

}
