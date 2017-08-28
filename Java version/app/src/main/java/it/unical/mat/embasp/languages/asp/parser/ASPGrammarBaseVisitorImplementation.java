package it.unical.mat.embasp.languages.asp.parser;

import java.util.LinkedList;
import java.util.List;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import it.unical.mat.embasp.languages.asp.parser.ASPGrammarParser.Predicate_atomContext;

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
    	ctx.term().forEach(parameter -> parameters.add(visit(parameter)));
    	
    	return ctx.IDENTIFIER().getText();
    }

    @Override
    public String visitSymbolicTerm(ASPGrammarParser.SymbolicTermContext ctx) {
        return ctx.getText();
    }

    @Override
    public String visitIntegerTerm(ASPGrammarParser.IntegerTermContext ctx) {
        return ctx.getText();
    }

    @Override
    public String visitFunctionalTerm(ASPGrammarParser.FunctionalTermContext ctx) {
        return ctx.getText();
    }

    @Override
    public String visitStringTerm(ASPGrammarParser.StringTermContext ctx) {
        return ctx.getText();
    }

    public static List<Predicate_atomContext> getPredicateAtoms(final String atomsList) {
    	return new ASPGrammarParser(new CommonTokenStream(new ASPGrammarLexer(CharStreams.fromString(atomsList)))).output().predicate_atom();
    }
}