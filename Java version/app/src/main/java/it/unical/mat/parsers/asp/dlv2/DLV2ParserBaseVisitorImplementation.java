package it.unical.mat.parsers.asp.dlv2;

import it.unical.mat.parsers.asp.ASPDataCollection;
import java.util.HashMap;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

public class DLV2ParserBaseVisitorImplementation extends DLV2ParserBaseVisitor <Void> {
    private final ASPDataCollection answerSets;
    private HashMap <Integer, Integer> costs = new HashMap <> ();
    
    private DLV2ParserBaseVisitorImplementation(final ASPDataCollection answerSets) {
        this.answerSets = answerSets;
    }

    @Override
    public Void visitAnswer_set(DLV2Parser.Answer_setContext ctx) {
        if(ctx.cost() != null && !ctx.cost().isEmpty()) {
        	final String[] firstCost = ctx.cost().COST_LABEL().getText().split(" ")[1].split("@");
        	
        	costs.clear();
        	costs.put(Integer.parseInt(firstCost[1]), Integer.parseInt(firstCost[0]));
        } 
        
        answerSets.addAnswerSet();
        costs.forEach((level, weight) -> answerSets.storeCost(level, weight));

        return visitChildren(ctx);
    }

    @Override
    public Void visitLevel(DLV2Parser.LevelContext ctx) {
    	final int level = Integer.parseInt(ctx.INTEGER(1).getText());
    	final int weight = Integer.parseInt(ctx.INTEGER(0).getText());
    	
    	costs.put(level, weight);
        answerSets.storeCost(level, weight);

        return null;
    }

    @Override
    public Void visitPredicate_atom(DLV2Parser.Predicate_atomContext ctx) {
        answerSets.storeAtom(ctx.getText());

        return null;
    }

    public static void parse(final ASPDataCollection answerSets, final String dlv2Output) {
        new DLV2ParserBaseVisitorImplementation(answerSets).visit(new DLV2Parser(new CommonTokenStream(new DLV2Lexer(CharStreams.fromString(dlv2Output)))).output());
    }
}
