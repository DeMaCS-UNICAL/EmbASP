//------------------------------------------------------------------------------
// <auto-generated>
//     This code was generated by a tool.
//     ANTLR Version: 4.7
//
//     Changes to this file may cause incorrect behavior and will be lost if
//     the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

// Generated from SPDGrammar.g4 by ANTLR 4.7

// Unreachable code detected
#pragma warning disable 0162
// The variable '...' is assigned but its value is never used
#pragma warning disable 0219
// Missing XML comment for publicly visible type or member '...'
#pragma warning disable 1591
// Ambiguous reference in cref attribute
#pragma warning disable 419

using Antlr4.Runtime.Misc;
using Antlr4.Runtime.Tree;
using IToken = Antlr4.Runtime.IToken;

/// <summary>
/// This interface defines a complete generic visitor for a parse tree produced
/// by <see cref="SPDGrammarParser"/>.
/// </summary>
/// <typeparam name="Result">The return type of the visit operation.</typeparam>
[System.CodeDom.Compiler.GeneratedCode("ANTLR", "4.7")]
[System.CLSCompliant(false)]
public interface ISPDGrammarVisitor<Result> : IParseTreeVisitor<Result> {
	/// <summary>
	/// Visit a parse tree produced by <see cref="SPDGrammarParser.array"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitArray([NotNull] SPDGrammarParser.ArrayContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="SPDGrammarParser.json"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitJson([NotNull] SPDGrammarParser.JsonContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="SPDGrammarParser.oBjEcT"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitOBjEcT([NotNull] SPDGrammarParser.OBjEcTContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="SPDGrammarParser.pair"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitPair([NotNull] SPDGrammarParser.PairContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>ArrayValue</c>
	/// labeled alternative in <see cref="SPDGrammarParser.value"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitArrayValue([NotNull] SPDGrammarParser.ArrayValueContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>BooleanValue</c>
	/// labeled alternative in <see cref="SPDGrammarParser.value"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitBooleanValue([NotNull] SPDGrammarParser.BooleanValueContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>IntegerValue</c>
	/// labeled alternative in <see cref="SPDGrammarParser.value"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitIntegerValue([NotNull] SPDGrammarParser.IntegerValueContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>NullValue</c>
	/// labeled alternative in <see cref="SPDGrammarParser.value"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitNullValue([NotNull] SPDGrammarParser.NullValueContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>ObjectValue</c>
	/// labeled alternative in <see cref="SPDGrammarParser.value"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitObjectValue([NotNull] SPDGrammarParser.ObjectValueContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>StringValue</c>
	/// labeled alternative in <see cref="SPDGrammarParser.value"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitStringValue([NotNull] SPDGrammarParser.StringValueContext context);
}
