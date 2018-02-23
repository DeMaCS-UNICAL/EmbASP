package it.unical.mat.embasp.specializations.dlvhex;

import it.unical.mat.embasp.languages.asp.AnswerSets;
import it.unical.mat.parsers.asp.ASPDataCollection;

public class DLVHEXAnswerSets extends AnswerSets {
	public DLVHEXAnswerSets(final String answerSets) {
		super(answerSets);
	}

	public DLVHEXAnswerSets(final String output, final String errors) {
		super(output, errors);
	}

	@Override
	protected void parse() {
		ASPDataCollection.parseDLVHEX(this, output);
	}
}
