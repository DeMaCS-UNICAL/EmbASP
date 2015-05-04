package it.unical.mat.embasp.base;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <p>AnswerSets is abstract class that parse each Answer Sets</p>
 */
public abstract class AnswerSets {


    protected String answerSetsString;

    protected List<AnswerSet> answerSetsList;

    public AnswerSets(String answerSets){
        answerSetsList=new ArrayList<AnswerSet>();
        this.answerSetsString = answerSets;
        parse();
    }

    abstract protected void parse();

    public String getAnswerSetsString() {
        return answerSetsString;
    }

    public List<AnswerSet> getAnswerSetsList() {
        return Collections.unmodifiableList(answerSetsList);
    }

}
