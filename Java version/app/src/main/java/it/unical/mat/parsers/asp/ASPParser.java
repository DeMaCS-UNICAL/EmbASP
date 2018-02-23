package it.unical.mat.parsers.asp;

import it.unical.mat.parsers.asp.asp_parser_base.ASPGrammarBaseVisitor;
import it.unical.mat.parsers.asp.asp_parser_base.ASPGrammarLexer;
import it.unical.mat.parsers.asp.asp_parser_base.ASPGrammarParser;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

public class ASPParser extends ASPGrammarBaseVisitor <Void> {	
	private final List <ASPGrammarParser.Predicate_atomContext> contexts;
	private final Iterator <ASPGrammarParser.Predicate_atomContext> iterator;
	private List <String> parameters;
	private String identifier;
	
	public ASPParser(final String atomsList) {
		contexts = new ASPGrammarParser(new CommonTokenStream(new ASPGrammarLexer(CharStreams.fromString(atomsList)))).output().predicate_atom();
		iterator = contexts.iterator();
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
