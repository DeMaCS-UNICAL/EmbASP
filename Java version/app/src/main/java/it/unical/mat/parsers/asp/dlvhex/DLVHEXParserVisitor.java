package it.unical.mat.parsers.asp.dlvhex;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link DLVHEXParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface DLVHEXParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code GroundQuery}
	 * labeled alternative in {@link DLVHEXParser#answer_set}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGroundQuery(DLVHEXParser.GroundQueryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Model}
	 * labeled alternative in {@link DLVHEXParser#answer_set}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModel(DLVHEXParser.ModelContext ctx);
	/**
	 * Visit a parse tree produced by {@link DLVHEXParser#atoms}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtoms(DLVHEXParser.AtomsContext ctx);
	/**
	 * Visit a parse tree produced by {@link DLVHEXParser#cost}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCost(DLVHEXParser.CostContext ctx);
	/**
	 * Visit a parse tree produced by {@link DLVHEXParser#level}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLevel(DLVHEXParser.LevelContext ctx);
	/**
	 * Visit a parse tree produced by {@link DLVHEXParser#output}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOutput(DLVHEXParser.OutputContext ctx);
	/**
	 * Visit a parse tree produced by {@link DLVHEXParser#predicate_atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPredicate_atom(DLVHEXParser.Predicate_atomContext ctx);
	/**
	 * Visit a parse tree produced by {@link DLVHEXParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(DLVHEXParser.TermContext ctx);
	/**
	 * Visit a parse tree produced by {@link DLVHEXParser#witness}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWitness(DLVHEXParser.WitnessContext ctx);
}