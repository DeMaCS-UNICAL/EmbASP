package it.unical.mat.parsers.asp.dlv;

import it.unical.mat.parsers.asp.ASPDataCollection;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

public class DLVParserBaseVisitorImplementation extends DLVParserBaseVisitor<Void> {
	private final ASPDataCollection answerSets;
	
	private DLVParserBaseVisitorImplementation(final ASPDataCollection answerSets) {
		this.answerSets = answerSets;
	}

	@Override
	public Void visitSimpleModel(DLVParser.SimpleModelContext ctx) {
		answerSets.addAnswerSet();
		
		return visitChildren(ctx);
	}

	@Override
	public Void visitWeightedModel(DLVParser.WeightedModelContext ctx) {
		answerSets.addAnswerSet();
		
		return visitChildren(ctx);
	}

	@Override
	public Void visitWitness(DLVParser.WitnessContext ctx) {
		answerSets.addAnswerSet();
		
		return visitChildren(ctx);
	}
	
	@Override
	public Void visitCost_level(DLVParser.Cost_levelContext ctx) {
		answerSets.storeCost(Integer.parseInt(ctx.INTEGER_CONSTANT(1).getText()), Integer.parseInt(ctx.INTEGER_CONSTANT(0).getText()));
		
		return null;
	}

	@Override
	public Void visitPredicate(DLVParser.PredicateContext ctx) {
		answerSets.storeAtom(ctx.getText());
		
		return null;
	}
	
	public static void parse(final ASPDataCollection answerSets, final String atomsList) {
        new DLVParserBaseVisitorImplementation(answerSets).visit(new DLVParser(new CommonTokenStream(new DLVLexer(CharStreams.fromString(atomsList)))).output());
    }
}