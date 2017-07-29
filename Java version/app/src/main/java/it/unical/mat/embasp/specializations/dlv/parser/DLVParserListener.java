package it.unical.mat.embasp.specializations.dlv.parser;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link DLVParser}.
 */
public interface DLVParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code GroundQuery}
	 * labeled alternative in {@link DLVParser#answer_set}.
	 * @param ctx the parse tree
	 */
	void enterGroundQuery(DLVParser.GroundQueryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code GroundQuery}
	 * labeled alternative in {@link DLVParser#answer_set}.
	 * @param ctx the parse tree
	 */
	void exitGroundQuery(DLVParser.GroundQueryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SimpleModel}
	 * labeled alternative in {@link DLVParser#answer_set}.
	 * @param ctx the parse tree
	 */
	void enterSimpleModel(DLVParser.SimpleModelContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SimpleModel}
	 * labeled alternative in {@link DLVParser#answer_set}.
	 * @param ctx the parse tree
	 */
	void exitSimpleModel(DLVParser.SimpleModelContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NonGroundQuery}
	 * labeled alternative in {@link DLVParser#answer_set}.
	 * @param ctx the parse tree
	 */
	void enterNonGroundQuery(DLVParser.NonGroundQueryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NonGroundQuery}
	 * labeled alternative in {@link DLVParser#answer_set}.
	 * @param ctx the parse tree
	 */
	void exitNonGroundQuery(DLVParser.NonGroundQueryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code WeightedModel}
	 * labeled alternative in {@link DLVParser#answer_set}.
	 * @param ctx the parse tree
	 */
	void enterWeightedModel(DLVParser.WeightedModelContext ctx);
	/**
	 * Exit a parse tree produced by the {@code WeightedModel}
	 * labeled alternative in {@link DLVParser#answer_set}.
	 * @param ctx the parse tree
	 */
	void exitWeightedModel(DLVParser.WeightedModelContext ctx);
	/**
	 * Enter a parse tree produced by {@link DLVParser#cost}.
	 * @param ctx the parse tree
	 */
	void enterCost(DLVParser.CostContext ctx);
	/**
	 * Exit a parse tree produced by {@link DLVParser#cost}.
	 * @param ctx the parse tree
	 */
	void exitCost(DLVParser.CostContext ctx);
	/**
	 * Enter a parse tree produced by {@link DLVParser#cost_level}.
	 * @param ctx the parse tree
	 */
	void enterCost_level(DLVParser.Cost_levelContext ctx);
	/**
	 * Exit a parse tree produced by {@link DLVParser#cost_level}.
	 * @param ctx the parse tree
	 */
	void exitCost_level(DLVParser.Cost_levelContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EmptyModel}
	 * labeled alternative in {@link DLVParser#model}.
	 * @param ctx the parse tree
	 */
	void enterEmptyModel(DLVParser.EmptyModelContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EmptyModel}
	 * labeled alternative in {@link DLVParser#model}.
	 * @param ctx the parse tree
	 */
	void exitEmptyModel(DLVParser.EmptyModelContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NonemptyModel}
	 * labeled alternative in {@link DLVParser#model}.
	 * @param ctx the parse tree
	 */
	void enterNonemptyModel(DLVParser.NonemptyModelContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NonemptyModel}
	 * labeled alternative in {@link DLVParser#model}.
	 * @param ctx the parse tree
	 */
	void exitNonemptyModel(DLVParser.NonemptyModelContext ctx);
	/**
	 * Enter a parse tree produced by {@link DLVParser#output}.
	 * @param ctx the parse tree
	 */
	void enterOutput(DLVParser.OutputContext ctx);
	/**
	 * Exit a parse tree produced by {@link DLVParser#output}.
	 * @param ctx the parse tree
	 */
	void exitOutput(DLVParser.OutputContext ctx);
	/**
	 * Enter a parse tree produced by {@link DLVParser#predicate}.
	 * @param ctx the parse tree
	 */
	void enterPredicate(DLVParser.PredicateContext ctx);
	/**
	 * Exit a parse tree produced by {@link DLVParser#predicate}.
	 * @param ctx the parse tree
	 */
	void exitPredicate(DLVParser.PredicateContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SymbolicTerm}
	 * labeled alternative in {@link DLVParser#term}.
	 * @param ctx the parse tree
	 */
	void enterSymbolicTerm(DLVParser.SymbolicTermContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SymbolicTerm}
	 * labeled alternative in {@link DLVParser#term}.
	 * @param ctx the parse tree
	 */
	void exitSymbolicTerm(DLVParser.SymbolicTermContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IntegerTerm}
	 * labeled alternative in {@link DLVParser#term}.
	 * @param ctx the parse tree
	 */
	void enterIntegerTerm(DLVParser.IntegerTermContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IntegerTerm}
	 * labeled alternative in {@link DLVParser#term}.
	 * @param ctx the parse tree
	 */
	void exitIntegerTerm(DLVParser.IntegerTermContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FunctionalTerm}
	 * labeled alternative in {@link DLVParser#term}.
	 * @param ctx the parse tree
	 */
	void enterFunctionalTerm(DLVParser.FunctionalTermContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FunctionalTerm}
	 * labeled alternative in {@link DLVParser#term}.
	 * @param ctx the parse tree
	 */
	void exitFunctionalTerm(DLVParser.FunctionalTermContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StringTerm}
	 * labeled alternative in {@link DLVParser#term}.
	 * @param ctx the parse tree
	 */
	void enterStringTerm(DLVParser.StringTermContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StringTerm}
	 * labeled alternative in {@link DLVParser#term}.
	 * @param ctx the parse tree
	 */
	void exitStringTerm(DLVParser.StringTermContext ctx);
	/**
	 * Enter a parse tree produced by {@link DLVParser#witness}.
	 * @param ctx the parse tree
	 */
	void enterWitness(DLVParser.WitnessContext ctx);
	/**
	 * Exit a parse tree produced by {@link DLVParser#witness}.
	 * @param ctx the parse tree
	 */
	void exitWitness(DLVParser.WitnessContext ctx);
}