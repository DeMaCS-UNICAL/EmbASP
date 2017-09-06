package it.unical.mat.embasp.specializations.clingo.parser;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ClingoParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ClingoParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ClingoParser#answer_set}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnswer_set(ClingoParser.Answer_setContext ctx);
	/**
	 * Visit a parse tree produced by {@link ClingoParser#model}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModel(ClingoParser.ModelContext ctx);
	/**
	 * Visit a parse tree produced by {@link ClingoParser#output}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOutput(ClingoParser.OutputContext ctx);
	/**
	 * Visit a parse tree produced by {@link ClingoParser#predicate_atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPredicate_atom(ClingoParser.Predicate_atomContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SymbolicTerm}
	 * labeled alternative in {@link ClingoParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSymbolicTerm(ClingoParser.SymbolicTermContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IntegerTerm}
	 * labeled alternative in {@link ClingoParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntegerTerm(ClingoParser.IntegerTermContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FunctionalTerm}
	 * labeled alternative in {@link ClingoParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionalTerm(ClingoParser.FunctionalTermContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StringTerm}
	 * labeled alternative in {@link ClingoParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringTerm(ClingoParser.StringTermContext ctx);
}