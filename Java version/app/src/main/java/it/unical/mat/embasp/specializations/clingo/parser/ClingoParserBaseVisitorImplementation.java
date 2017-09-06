package it.unical.mat.embasp.specializations.clingo.parser;

import it.unical.mat.embasp.languages.asp.AnswerSet;
import java.util.LinkedList;
import java.util.List;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

public class ClingoParserBaseVisitorImplementation extends ClingoParserBaseVisitor <Void> {
	private final List <AnswerSet> answerSets;
	
	private ClingoParserBaseVisitorImplementation(final List <AnswerSet> answerSets) {
		this.answerSets = answerSets;
	}
	
	@Override 
	public Void visitAnswer_set(ClingoParser.Answer_setContext ctx) { 
		return visitChildren(ctx); 
	}
	
	@Override 
	public Void visitModel(ClingoParser.ModelContext ctx) {
		final AnswerSet answerSet = new AnswerSet(new LinkedList <> ());
		final String cost = ctx.NEW_LINE().getText().trim();
		
		if(cost.length() > 1) {
			final String[] tokens = cost.split(" ");
			int levels = tokens.length - 1;
			
			for(int i = 1; i < tokens.length; i++)
				answerSet.getLevelWeight().put(levels--, Integer.parseInt(tokens[i]));
		}
			
		answerSets.add(answerSet);
		
		return visitChildren(ctx); 
	}
	
	@Override 
	public Void visitOutput(ClingoParser.OutputContext ctx) { 
		return visitChildren(ctx); 
	}
	
	@Override 
	public Void visitPredicate_atom(ClingoParser.Predicate_atomContext ctx) {
		answerSets.get(answerSets.size() - 1).getValue().add(ctx.getText().trim());
		
		return null;
	}
	
	public static void walk(final List <AnswerSet> answerSets, final String atomsList) {
    	new ClingoParserBaseVisitorImplementation(answerSets).visit(new ClingoParser(new CommonTokenStream(new ClingoLexer(CharStreams.fromString(atomsList)))).output());
    }
}