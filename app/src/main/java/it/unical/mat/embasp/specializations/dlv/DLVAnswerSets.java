package it.unical.mat.embasp.specializations.dlv;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import it.unical.mat.embasp.languages.asp.AnswerSet;
import it.unical.mat.embasp.languages.asp.AnswerSets;

public class DLVAnswerSets extends AnswerSets {
	/** Represent an AnswerSet specific for DLV */

	public DLVAnswerSets(final String answerSets) {
		super(answerSets);
	}

	public DLVAnswerSets(final String out, final String err) {
		super(out, err);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void parse() {
		final Pattern pattern = Pattern.compile("\\{(.*)\\}");
		final Matcher matcher = pattern.matcher(output);
		while (matcher.find()) {
			final String answerSet = matcher.group();
			final Pattern patternAnswerSet = Pattern.compile("(-?[a-z][A-Za-z0-9_]*(\\(.+?\\))?)(, |\\})");
			final Matcher matcherAnswerSet = patternAnswerSet.matcher(answerSet);
			final List<String> answerSetList = new ArrayList<>();
			while (matcherAnswerSet.find())
				answerSetList.add(matcherAnswerSet.group(1));
			answersets.add(new AnswerSet(answerSetList));
		}

	}
}
