package it.unical.mat.embasp.specializations.dlvhex.parser;

import java.util.LinkedList;
import java.util.List;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import it.unical.mat.embasp.languages.asp.AnswerSet;

public class DLVHEXParserBaseVisitorImplementation extends DLVHEXParserBaseVisitor <Void> {
    private final List<AnswerSet> answerSets;

    private DLVHEXParserBaseVisitorImplementation(final List<AnswerSet> answerSets) {
        this.answerSets = answerSets;
    }

    @Override
    public Void visitAnswer_set(DLVHEXParser.Answer_setContext ctx) {
        answerSets.add(new AnswerSet(new LinkedList<String> ()));

        return visitChildren(ctx);
    }

    @Override
    public Void visitLevel(DLVHEXParser.LevelContext ctx) {
        answerSets.get(answerSets.size() - 1).getLevelWeight().put(Integer.parseInt(ctx.INTEGER(1).getText()), Integer.parseInt(ctx.INTEGER(0).getText()));

        return null;
    }

    @Override
    public Void visitPredicate_atom(DLVHEXParser.Predicate_atomContext ctx) {
        answerSets.get(answerSets.size() - 1).getValue().add(ctx.getText());

        return null;
    }

    public static void parse(final List <AnswerSet> answerSets, final String atomsList) {
        new DLVHEXParserBaseVisitorImplementation(answerSets).visit(new DLVHEXParser(new CommonTokenStream(new DLVHEXLexer(CharStreams.fromString(atomsList)))).output());
    }
}