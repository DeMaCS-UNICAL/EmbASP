package it.unical.mat.embasp.specializations.dlvhex;

import it.unical.mat.embasp.languages.asp.AnswerSets;
import it.unical.mat.embasp.specializations.dlvhex.parser.DLVHEXParserBaseVisitorImplementation;

public class DLVHEXAnswerSets extends AnswerSets {
	public DLVHEXAnswerSets(final String answerSets) {
		super(answerSets);
	}

	public DLVHEXAnswerSets(final String output, final String errors) {
		super(output, errors);
	}

	@Override
	protected void parse() {
		DLVHEXParserBaseVisitorImplementation.parse(answersets, output);
	}
}
