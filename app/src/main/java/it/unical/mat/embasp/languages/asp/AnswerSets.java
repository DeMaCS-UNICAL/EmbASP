package it.unical.mat.embasp.languages.asp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import it.unical.mat.embasp.base.Output;

/** A collection of {@link AnswerSet} */

public abstract class AnswerSets extends Output {
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

	public String getAnswerSetsString() {
		return output;
	}

}
