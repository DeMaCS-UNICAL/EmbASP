package it.unical.mat.embasp.base;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <p>AnswerSets class store and parse Answer Sets</p>
 */
public abstract class AnswerSets {

    //contains String Answer Sets (output generated from ASPService)
    protected String answerSetsString;

    protected List<AnswerSet> answerSetsList;

    /**
     * Constructor initialize AnswerSets object with a String that contains ALL Answer Set generated from ASPService.
     * @param answerSets
     */
    public AnswerSets(String answerSets){
        answerSetsList=new ArrayList<AnswerSet>();
        this.answerSetsString = answerSets;
        parse();
    }

    /**
     * Parse outputToParse String and generate AnswerSet objects
     * Create AnswerSet objects from outputToParse String. Then add objects to answerSetList
     */
    abstract protected void parse();

    public String getAnswerSetsString() {
        return answerSetsString;
    }

    public List<AnswerSet> getAnswerSetsList() {
        return Collections.unmodifiableList(answerSetsList);
    }

}
