package it.unical.mat.parsers.asp;

import it.unical.mat.parsers.asp.asp_parser_base.ASPGrammarBaseVisitor;
import it.unical.mat.parsers.asp.asp_parser_base.ASPGrammarLexer;
import it.unical.mat.parsers.asp.asp_parser_base.ASPGrammarParser;
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

public class ASPParser extends ASPGrammarBaseVisitor <Void> {	
	private final List <ASPGrammarParser.Predicate_atomContext> contexts;
	private final Iterator <ASPGrammarParser.Predicate_atomContext> iterator;
	private List <String> parameters;
	private String identifier;
	
	public ASPParser(final String atomsList) {
		contexts = getContexts(atomsList);
		iterator = contexts.iterator();
    }
	
	private static final List <ASPGrammarParser.Predicate_atomContext> getContexts(final String atomsList) {
		final CommonTokenStream tokens = new CommonTokenStream(new ASPGrammarLexer(CharStreams.fromString(atomsList)));
        final ASPGrammarParser parser = new ASPGrammarParser(tokens);
        
        parser.getInterpreter().setPredictionMode(PredictionMode.SLL); 
        parser.removeErrorListeners();
        parser.setErrorHandler(new BailErrorStrategy());
     
        try {
        	return parser.output().predicate_atom();
        } catch (final RuntimeException exception) {
        	if(exception.getClass() == RuntimeException.class && exception.getCause() instanceof RecognitionException) {
        		tokens.seek(0);
        		parser.addErrorListener(ConsoleErrorListener.INSTANCE);
        		parser.setErrorHandler(new DefaultErrorStrategy());
        		parser.getInterpreter().setPredictionMode(PredictionMode.LL); 
        		
        		return parser.output().predicate_atom();
        	}
        }
        
        return null;
	}
	
	public String getIdentifier() {
		if(iterator.hasNext()) {
			parameters = new LinkedList <> ();
			
			visitPredicate_atom(iterator.next());
			
			return identifier;
		}
		
		return null;
	}
	
	public String [] getParameters() {
		return parameters.toArray(new String [0]);
	}
	
    @Override
    public Void visitPredicate_atom(ASPGrammarParser.Predicate_atomContext ctx) {
    	identifier = ctx.IDENTIFIER().getText();
    	
    	return visitChildren(ctx);
    }

    @Override
    public Void visitTerm(ASPGrammarParser.TermContext ctx) {
    	parameters.add(ctx.getText());
    	
    	return null;
    }
}
