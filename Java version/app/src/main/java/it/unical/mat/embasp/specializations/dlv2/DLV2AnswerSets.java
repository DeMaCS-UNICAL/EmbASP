package it.unical.mat.embasp.specializations.dlv2;

import it.unical.mat.embasp.languages.asp.AnswerSets;
import it.unical.mat.embasp.specializations.dlv2.parser.DLV2ParserBaseVisitorImplementation;

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
		DLV2ParserBaseVisitorImplementation.parse(answersets, output);
	}

}
