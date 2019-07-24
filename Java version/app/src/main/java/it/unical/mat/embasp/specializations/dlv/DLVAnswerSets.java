package it.unical.mat.embasp.specializations.dlv;

import it.unical.mat.embasp.languages.asp.AnswerSets;
import it.unical.mat.parsers.asp.ASPSolversParser;

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
		ASPSolversParser.parseDLV(this, output, true);
	}
}
