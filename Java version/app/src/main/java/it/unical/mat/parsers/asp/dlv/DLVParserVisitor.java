package it.unical.mat.parsers.asp.dlv;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link DLVParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface DLVParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code GroundQuery}
	 * labeled alternative in {@link DLVParser#answer_set}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGroundQuery(DLVParser.GroundQueryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SimpleModel}
	 * labeled alternative in {@link DLVParser#answer_set}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleModel(DLVParser.SimpleModelContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NonGroundQuery}
	 * labeled alternative in {@link DLVParser#answer_set}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNonGroundQuery(DLVParser.NonGroundQueryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code WeightedModel}
	 * labeled alternative in {@link DLVParser#answer_set}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWeightedModel(DLVParser.WeightedModelContext ctx);
	/**
	 * Visit a parse tree produced by {@link DLVParser#cost}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCost(DLVParser.CostContext ctx);
	/**
	 * Visit a parse tree produced by {@link DLVParser#cost_level}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCost_level(DLVParser.Cost_levelContext ctx);
	/**
	 * Visit a parse tree produced by {@link DLVParser#model}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModel(DLVParser.ModelContext ctx);
	/**
	 * Visit a parse tree produced by {@link DLVParser#output}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOutput(DLVParser.OutputContext ctx);
	/**
	 * Visit a parse tree produced by {@link DLVParser#predicate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPredicate(DLVParser.PredicateContext ctx);
	/**
	 * Visit a parse tree produced by {@link DLVParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(DLVParser.TermContext ctx);
	/**
	 * Visit a parse tree produced by {@link DLVParser#witness}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWitness(DLVParser.WitnessContext ctx);
}