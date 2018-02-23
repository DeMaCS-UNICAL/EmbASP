package it.unical.mat.parsers.asp.dlvhex;

import it.unical.mat.parsers.asp.ASPDataCollection;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

public class DLVHEXParserBaseVisitorImplementation extends DLVHEXParserBaseVisitor <Void> {
    private final ASPDataCollection answerSets;

    private DLVHEXParserBaseVisitorImplementation(final ASPDataCollection answerSets) {
        this.answerSets = answerSets;
    }

    @Override
    public Void visitAnswer_set(DLVHEXParser.Answer_setContext ctx) {
        answerSets.addAnswerSet();

        return visitChildren(ctx);
    }

    @Override
    public Void visitLevel(DLVHEXParser.LevelContext ctx) {
        answerSets.storeCost(Integer.parseInt(ctx.INTEGER(1).getText()), Integer.parseInt(ctx.INTEGER(0).getText()));

        return null;
    }

    @Override
    public Void visitPredicate_atom(DLVHEXParser.Predicate_atomContext ctx) {
        answerSets.storeAtom(ctx.getText());

        return null;
    }

    public static void parse(final ASPDataCollection answerSets, final String atomsList) {
        new DLVHEXParserBaseVisitorImplementation(answerSets).visit(new DLVHEXParser(new CommonTokenStream(new DLVHEXLexer(CharStreams.fromString(atomsList)))).output());
    }
}