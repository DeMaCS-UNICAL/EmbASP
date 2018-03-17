package it.unical.mat.parsers.pddl;

import it.unical.mat.parsers.pddl.pddl_parser_base.PDDLGrammarBaseVisitor;
import it.unical.mat.parsers.pddl.pddl_parser_base.PDDLGrammarLexer;
import it.unical.mat.parsers.pddl.pddl_parser_base.PDDLGrammarParser;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.antlr.v4.runtime.BailErrorStrategy;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ConsoleErrorListener;
import org.antlr.v4.runtime.DefaultErrorStrategy;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.atn.PredictionMode;

public class PDDLParser extends PDDLGrammarBaseVisitor <Void> {
    private final List <PDDLGrammarParser.AtomContext> contexts;
    private final Iterator<PDDLGrammarParser.AtomContext> iterator;
    private List <String> parameters;
    private String identifier;

    public PDDLParser(final String atomsList) {
    	contexts = getContexts(atomsList);
    	iterator = contexts.iterator();
    }

    private static final List <PDDLGrammarParser.AtomContext> getContexts(final String atomsList) {
		final CommonTokenStream tokens = new CommonTokenStream(new PDDLGrammarLexer(CharStreams.fromString(atomsList)));
        final PDDLGrammarParser parser = new PDDLGrammarParser(tokens);
        
        parser.getInterpreter().setPredictionMode(PredictionMode.SLL); 
        parser.removeErrorListeners();
        parser.setErrorHandler(new BailErrorStrategy());
     
        try {
        	return parser.output().atom();
        } catch (final RuntimeException exception) {
        	if(exception.getClass() == RuntimeException.class && exception.getCause() instanceof RecognitionException) {
        		tokens.seek(0);
        		parser.addErrorListener(ConsoleErrorListener.INSTANCE);
        		parser.setErrorHandler(new DefaultErrorStrategy());
        		parser.getInterpreter().setPredictionMode(PredictionMode.LL); 
        		
        		return parser.output().atom();
        	}
        }
        
        return null;
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