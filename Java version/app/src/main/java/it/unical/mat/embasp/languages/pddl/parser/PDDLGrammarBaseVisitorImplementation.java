package it.unical.mat.embasp.languages.pddl.parser;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

public class PDDLGrammarBaseVisitorImplementation extends PDDLGrammarBaseVisitor <Void> {
    private final List <PDDLGrammarParser.AtomContext> contexts;
    private final Iterator<PDDLGrammarParser.AtomContext> iterator;
    private List <String> parameters;
    private String identifier;

    public PDDLGrammarBaseVisitorImplementation(final String atomsList) {
        contexts = new PDDLGrammarParser(new CommonTokenStream(new PDDLGrammarLexer(CharStreams.fromString(atomsList)))).output().atom();
        iterator = contexts.iterator();
    }

    public String getIdentifier() {
        if(iterator.hasNext()) {
            parameters = new LinkedList <> ();

            visitAtom(iterator.next());

            return identifier;
        }

        return null;
    }

    public String [] getParameters() {
        return parameters.toArray(new String [0]);
    }

    @Override
    public Void visitAtom(PDDLGrammarParser.AtomContext ctx) {
        identifier = ctx.IDENTIFIER(0).getText();

        for(int index = 1; index < ctx.IDENTIFIER().size(); index++)
            parameters.add(ctx.IDENTIFIER(index).getText());

        return null;
    }
}