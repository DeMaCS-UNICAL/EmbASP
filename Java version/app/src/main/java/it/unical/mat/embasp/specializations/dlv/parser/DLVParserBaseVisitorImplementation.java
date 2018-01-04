package it.unical.mat.embasp.specializations.dlv.parser;

import java.util.LinkedList;
import java.util.List;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import it.unical.mat.embasp.languages.asp.AnswerSet;

public class DLVParserBaseVisitorImplementation extends DLVParserBaseVisitor<Void> {
	private final List<AnswerSet> answerSets;
	
	private DLVParserBaseVisitorImplementation(final List<AnswerSet> answerSets) {
		this.answerSets = answerSets;
	}

	@Override
	public Void visitSimpleModel(DLVParser.SimpleModelContext ctx) {
		answerSets.add(new AnswerSet(new LinkedList<String> ()));
		
		return visitChildren(ctx);
	}

	@Override
	public Void visitWeightedModel(DLVParser.WeightedModelContext ctx) {
		answerSets.add(new AnswerSet(new LinkedList<String> ()));
		
		return visitChildren(ctx);
	}

	@Override
	public Void visitWitness(DLVParser.WitnessContext ctx) {
		answerSets.add(new AnswerSet(new LinkedList<String> ()));
		
		return visitChildren(ctx);
	}
	
	@Override
	public Void visitCost_level(DLVParser.Cost_levelContext ctx) {
		answerSets.get(answerSets.size() - 1).getLevelWeight().put(Integer.parseInt(ctx.INTEGER_CONSTANT(1).getText()), Integer.parseInt(ctx.INTEGER_CONSTANT(0).getText()));
		
		return null;
	}

	@Override
	public Void visitPredicate(DLVParser.PredicateContext ctx) {
		answerSets.get(answerSets.size() - 1).getValue().add(ctx.getText());
		
		return null;
	}
	
	public static void parse(final List <AnswerSet> answerSets, final String atomsList) {
        new DLVParserBaseVisitorImplementation(answerSets).visit(new DLVParser(new CommonTokenStream(new DLVLexer(CharStreams.fromString(atomsList)))).output());
    }
}