package it.unical.mat.embasp.specializations.dlv2.parser;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link DLV2Parser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface DLV2ParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link DLV2Parser#answer_set}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnswer_set(DLV2Parser.Answer_setContext ctx);
	/**
	 * Visit a parse tree produced by {@link DLV2Parser#cost}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCost(DLV2Parser.CostContext ctx);
	/**
	 * Visit a parse tree produced by {@link DLV2Parser#level}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLevel(DLV2Parser.LevelContext ctx);
	/**
	 * Visit a parse tree produced by {@link DLV2Parser#model}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModel(DLV2Parser.ModelContext ctx);
	/**
	 * Visit a parse tree produced by {@link DLV2Parser#output}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOutput(DLV2Parser.OutputContext ctx);
	/**
	 * Visit a parse tree produced by {@link DLV2Parser#predicate_atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPredicate_atom(DLV2Parser.Predicate_atomContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SymbolicTerm}
	 * labeled alternative in {@link DLV2Parser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSymbolicTerm(DLV2Parser.SymbolicTermContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IntegerTerm}
	 * labeled alternative in {@link DLV2Parser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntegerTerm(DLV2Parser.IntegerTermContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FunctionalTerm}
	 * labeled alternative in {@link DLV2Parser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionalTerm(DLV2Parser.FunctionalTermContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StringTerm}
	 * labeled alternative in {@link DLV2Parser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringTerm(DLV2Parser.StringTermContext ctx);
}