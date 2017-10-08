package it.unical.mat.embasp.specializations.dlv2.parser;

import it.unical.mat.embasp.languages.asp.AnswerSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

public class DLV2ParserBaseVisitorImplementation extends DLV2ParserBaseVisitor <Void> {
    private final List<AnswerSet> answerSets;
    private Map <Integer, Integer> cost;
    
    private DLV2ParserBaseVisitorImplementation(final List <AnswerSet> answerSets) {
        this.answerSets = answerSets;
    }

    @Override
    public Void visitAnswer_set(DLV2Parser.Answer_setContext ctx) {
        final AnswerSet answerSet = new AnswerSet(new LinkedList <> ());

        if(cost != null && (ctx.cost() == null || ctx.cost().isEmpty()))
            answerSet.getLevelWeight().putAll(cost);
        else
            cost = answerSet.getLevelWeight();

        answerSets.add(answerSet);

        return visitChildren(ctx);
    }

    @Override
    public Void visitLevel(DLV2Parser.LevelContext ctx) {
        answerSets.get(answerSets.size() - 1).getLevelWeight().put(Integer.parseInt(ctx.INTEGER(1).getText()), Integer.parseInt(ctx.INTEGER(0).getText()));

        return null;
    }

    @Override
    public Void visitPredicate_atom(DLV2Parser.Predicate_atomContext ctx) {
        if(!(ctx.getParent() instanceof DLV2Parser.FunctionalTermContext))
            answerSets.get(answerSets.size() - 1).getValue().add(ctx.getText());

        return null;
    }

    public static void parse(final List <AnswerSet> answerSets, final String dlv2Output) {
        new DLV2ParserBaseVisitorImplementation(answerSets).visit(new DLV2Parser(new CommonTokenStream(new DLV2Lexer(CharStreams.fromString(dlv2Output)))).output());
    }
}
