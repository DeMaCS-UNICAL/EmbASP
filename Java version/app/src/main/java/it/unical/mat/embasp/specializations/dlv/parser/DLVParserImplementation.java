package it.unical.mat.embasp.specializations.dlv.parser;

import java.util.LinkedList;
import java.util.List;
import it.unical.mat.embasp.languages.asp.AnswerSet;

class DLVParserImplementation extends DLVParserBaseListener {
	private final List <AnswerSet> answerSets;
    
    DLVParserImplementation(List <AnswerSet> answerSets) {
        this.answerSets = answerSets;
    }

    @Override
    public void enterSimpleModel(DLVParser.SimpleModelContext ctx) {
    	answerSets.add(new AnswerSet(new LinkedList <> ()));
    }

    @Override
    public void enterWeightedModel(DLVParser.WeightedModelContext ctx) {
    	answerSets.add(new AnswerSet(new LinkedList <> ()));
    }

    @Override
    public void exitPredicate(DLVParser.PredicateContext ctx) {
        if(!(ctx.getParent() instanceof DLVParser.FunctionalTermContext))
            ((LinkedList <AnswerSet>)answerSets).peekLast().getValue().add(ctx.getText());
    }

    @Override
    public void exitCost_level(DLVParser.Cost_levelContext ctx) {
        ((LinkedList <AnswerSet>)answerSets).peekLast().getLevelWeight().put(Integer.parseInt(ctx.INTEGER_CONSTANT(1).getText()), Integer.parseInt(ctx.INTEGER_CONSTANT(0).getText()));
    }
}