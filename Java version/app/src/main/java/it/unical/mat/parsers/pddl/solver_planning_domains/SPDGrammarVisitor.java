package it.unical.mat.parsers.pddl.solver_planning_domains;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SPDGrammarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SPDGrammarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link SPDGrammarParser#array}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray(SPDGrammarParser.ArrayContext ctx);
	/**
	 * Visit a parse tree produced by {@link SPDGrammarParser#json}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJson(SPDGrammarParser.JsonContext ctx);
	/**
	 * Visit a parse tree produced by {@link SPDGrammarParser#oBjEcT}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOBjEcT(SPDGrammarParser.OBjEcTContext ctx);
	/**
	 * Visit a parse tree produced by {@link SPDGrammarParser#pair}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPair(SPDGrammarParser.PairContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArrayValue}
	 * labeled alternative in {@link SPDGrammarParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayValue(SPDGrammarParser.ArrayValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BooleanValue}
	 * labeled alternative in {@link SPDGrammarParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanValue(SPDGrammarParser.BooleanValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IntegerValue}
	 * labeled alternative in {@link SPDGrammarParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntegerValue(SPDGrammarParser.IntegerValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NullValue}
	 * labeled alternative in {@link SPDGrammarParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNullValue(SPDGrammarParser.NullValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ObjectValue}
	 * labeled alternative in {@link SPDGrammarParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectValue(SPDGrammarParser.ObjectValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StringValue}
	 * labeled alternative in {@link SPDGrammarParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringValue(SPDGrammarParser.StringValueContext ctx);
}