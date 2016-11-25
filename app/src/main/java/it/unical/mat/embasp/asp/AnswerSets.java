package it.unical.mat.embasp.asp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import it.unical.mat.embasp.base.Output;

/**A collection of {@link AnswerSet}*/

public abstract class AnswerSets extends Output implements Cloneable {
	/**Where Answer Sets are stored*/
	protected List<AnswerSet> answersets;

	public AnswerSets(String out) {
		super(out);
	}

	public AnswerSets(String out, String err) {
		super(out, err);
	}

	/**Sub classes have to implement this function in order to provide different AnswerSets*/
	protected abstract void parse();

	public String getAnswerSetsString() {
		return this.output;
	}

	public List<AnswerSet> getAnswersets() {
		if(answersets == null) {
			this.answersets = new ArrayList<>();
			parse();
		}

		return Collections.unmodifiableList(this.answersets);
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
