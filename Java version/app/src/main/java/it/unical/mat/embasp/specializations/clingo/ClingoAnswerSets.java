package it.unical.mat.embasp.specializations.clingo;

import it.unical.mat.embasp.languages.asp.AnswerSets;
import it.unical.mat.parsers.asp.ASPDataCollection;

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
		ASPDataCollection.parseClingo(this, output);
	}
}
