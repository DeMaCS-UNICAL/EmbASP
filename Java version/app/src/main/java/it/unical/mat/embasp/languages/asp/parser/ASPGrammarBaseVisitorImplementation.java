package it.unical.mat.embasp.languages.asp.parser;

import java.util.LinkedList;
import java.util.List;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

public class ASPGrammarBaseVisitorImplementation extends ASPGrammarBaseVisitor <String> {	
	private List <String> parameters;
	
	public ASPGrammarBaseVisitorImplementation() {
		
    }

	public String [] getParameters() {
		return parameters.toArray(new String [0]);
	}
	
	public void resetParameters() {
		parameters = new LinkedList <> ();
	}
	
    @Override
    public String visitPredicate_atom(ASPGrammarParser.Predicate_atomContext ctx) {
    	visitChildren(ctx);
    	
    	return ctx.IDENTIFIER().getText();
    }

    @Override
    public String visitSymbolicTerm(ASPGrammarParser.SymbolicTermContext ctx) {
        parameters.add(ctx.getText());
        
        return null;
    }

    @Override
    public String visitIntegerTerm(ASPGrammarParser.IntegerTermContext ctx) {
    	parameters.add(ctx.getText());
    	
    	return null;
    }

    @Override
    public String visitFunctionalTerm(ASPGrammarParser.FunctionalTermContext ctx) {
    	parameters.add(ctx.getText());
    	
    	return null;
    }

    @Override
    public String visitStringTerm(ASPGrammarParser.StringTermContext ctx) {
    	parameters.add(ctx.getText());
    	
    	return null;
    }

    public static List<ASPGrammarParser.Predicate_atomContext> getPredicateAtoms(final String atomsList) {
    	return new ASPGrammarParser(new CommonTokenStream(new ASPGrammarLexer(CharStreams.fromString(atomsList)))).output().predicate_atom();
    }
}