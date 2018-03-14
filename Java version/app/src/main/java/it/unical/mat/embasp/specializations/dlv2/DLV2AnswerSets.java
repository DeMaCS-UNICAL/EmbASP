package it.unical.mat.embasp.specializations.dlv2;

import it.unical.mat.embasp.languages.asp.AnswerSets;
import it.unical.mat.parsers.asp.ASPSolversParser;

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
		ASPSolversParser.parseDLV2(this, output, true);
	}
}
