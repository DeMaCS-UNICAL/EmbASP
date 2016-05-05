package it.unical.mat.embasp.specializations.dlv;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import it.unical.mat.embasp.asp.AnswerSets;
import it.unical.mat.embasp.asp.AnswerSet;


public class DLVAnswerSets extends AnswerSets {
    /**
     * Constructor initialize AnswerSets object with a String that contains ALL Answer Set generated from ASPService.
     *
     * @param answerSets
     */
    public DLVAnswerSets(String answerSets) {
        super(answerSets);
    }

    @Override
    protected void parse() {
        Pattern pattern = Pattern.compile("\\{(.*)\\}");
        Matcher matcher = pattern.matcher(output);
        while (matcher.find()) {
            String answerSet=matcher.group();
            Pattern patternAnswerSet = Pattern.compile("(-?[a-z][A-Za-z0-9_]*(\\(.*?\\))?)(, |\\})");
            Matcher matcherAnswerSet = patternAnswerSet.matcher(answerSet);
            List<String> answerSetList=new ArrayList<>();
            while (matcherAnswerSet.find()) {
                answerSetList.add(matcherAnswerSet.group(1));
            }
            answersets.add(new AnswerSet(answerSetList));
        }

    }
}
