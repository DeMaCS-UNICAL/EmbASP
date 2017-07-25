package it.unical.mat.embasp.specializations.dlv.parser;

import java.util.LinkedList;
import java.util.List;
import it.unical.mat.embasp.languages.asp.AnswerSet;

class DLVParserListenerImplementation extends DLVParserBaseListener {
    private AnswerSet current;
    private final List <AnswerSet> answerSets;

    DLVParserListenerImplementation(List <AnswerSet> answerSets) {
        this.answerSets = answerSets;
    }

    private void addNewAnswerSet() {
        answerSets.add(current = new AnswerSet(new LinkedList <> ()));
    }

    @Override
    public void enterSimpleModel(DLVParser.SimpleModelContext ctx) {
        addNewAnswerSet();
    }

    @Override
    public void enterWeightedModel(DLVParser.WeightedModelContext ctx) {
        addNewAnswerSet();
    }

    @Override
    public void enterWitness(DLVParser.WitnessContext ctx) {
        addNewAnswerSet();
    }

    @Override
    public void exitCost_level(DLVParser.Cost_levelContext ctx) {
        current.getLevelWeight().put(Integer.parseInt(ctx.INTEGER_CONSTANT(1).getText()), Integer.parseInt(ctx.INTEGER_CONSTANT(0).getText()));
    }
    
    @Override
    public void exitPredicate(DLVParser.PredicateContext ctx) {
        if(!(ctx.getParent() instanceof DLVParser.FunctionalTermContext))
            current.getValue().add(ctx.getText());
    }
}