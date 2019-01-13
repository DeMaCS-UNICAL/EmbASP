package it.unical.mat.parsers.asp.asp_parser_base;

// Generated from ASPGrammar.g4 by ANTLR 4.7
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ASPGrammarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ASPGrammarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ASPGrammarParser#output}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOutput(ASPGrammarParser.OutputContext ctx);
	/**
	 * Visit a parse tree produced by {@link ASPGrammarParser#predicate_atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPredicate_atom(ASPGrammarParser.Predicate_atomContext ctx);
	/**
	 * Visit a parse tree produced by {@link ASPGrammarParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(ASPGrammarParser.TermContext ctx);
}