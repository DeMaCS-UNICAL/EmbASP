package it.unical.mat.embasp.base;

/**
 * <p>AnswerSetCallback an Interface of a callback, called when the result is available</p>
 */
public interface AnswerSetCallback {
    /** callback function for result handling
     * @param answerSets {@link java.util.ArrayList} of {@link AnswerSet} objects
     * @see AnswerSet
     */
    public void callback(AnswerSets answerSets);
}
