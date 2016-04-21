package it.unical.mat.embasp.asp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class AnswerSets {

	protected String output;
	protected List<AnswerSet> answersets;

	public AnswerSets(String answersets) {
		this.answersets = new ArrayList<>();
		output = answersets;
		parse();
	}

	abstract protected void parse();

	public String getAnswerSetsString()  { return output;}

	public List<AnswerSet> getAnswersets(){
		return Collections.unmodifiableList(answersets);
	}
}
