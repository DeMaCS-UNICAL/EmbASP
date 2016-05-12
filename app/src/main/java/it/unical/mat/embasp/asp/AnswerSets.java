package it.unical.mat.embasp.asp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import it.unical.mat.embasp.base.Output;

public abstract class AnswerSets extends Output {

	protected List<AnswerSet> answersets;

	public AnswerSets(String answersets) {
		this.answersets = new ArrayList<>();
		this.output = answersets;
		parse();
	}

	protected abstract void parse();

	public String getAnswerSetsString()  { return this.output;}

	public List<AnswerSet> getAnswersets(){
		return Collections.unmodifiableList(answersets);
	}
}
