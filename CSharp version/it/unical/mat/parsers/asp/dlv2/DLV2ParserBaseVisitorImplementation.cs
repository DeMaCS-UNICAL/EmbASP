using System;
using System.Collections.Generic;
using Antlr4.Runtime;
using Antlr4.Runtime.Atn;

namespace it.unical.mat.parsers.asp.dlv2
{
	public class DLV2ParserBaseVisitorImplementation : DLV2ParserBaseVisitor <object> 
	{
		private readonly IASPDataCollection answerSets;
		private Dictionary <int, int> costs;
		
		private DLV2ParserBaseVisitorImplementation(IASPDataCollection answerSets) 
		{
			this.answerSets = answerSets;
		}
		
		public override object VisitAnswer_set(DLV2Parser.Answer_setContext context)
		{
			answerSets.AddAnswerSet();
			
			if(context.cost() != null && !context.cost().IsEmpty)
			{
				costs = new Dictionary <int, int> ();
				string[] FirstCost = context.cost().COST_LABEL().GetText().Split(' ')[1].Split('@');
				
				costs[Int32.Parse(FirstCost[1])] = Int32.Parse(FirstCost[0]);
			}
			
			if(costs != null)
				foreach(KeyValuePair <int, int> entry in costs)
					answerSets.StoreCost(entry.Key, entry.Value);
			
			return VisitChildren(context);
		}
		
		public override object VisitLevel(DLV2Parser.LevelContext context) 
		{
			int Level = Int32.Parse(context.INTEGER()[1].GetText()), Cost = Int32.Parse(context.INTEGER()[0].GetText());
			
			costs[Level] = Cost;
			answerSets.StoreCost(Level, Cost);
			
			return null;
		}
		
		public override object VisitPredicate_atom(DLV2Parser.Predicate_atomContext context) 
		{
			answerSets.StoreAtom(context.GetText());
			
			return null;
		}
		
		public static void Parse(IASPDataCollection answerSets, string atomsList, bool two_stageParsing) 
		{
			CommonTokenStream Tokens = new CommonTokenStream(new DLV2Lexer(CharStreams.fromstring(atomsList)));
			DLV2Parser Parser = new DLV2Parser(Tokens);
			DLV2ParserBaseVisitorImplementation Visitor = new DLV2ParserBaseVisitorImplementation(answerSets);
			
			if(!two_stageParsing) 
			{
				Visitor.Visit(Parser.output());
				
				return;
			}
			
			Parser.Interpreter.PredictionMode = PredictionMode.SLL;
			
			Parser.RemoveErrorListeners();
			
			Parser.ErrorHandler = new BailErrorStrategy();
			
			try 
			{
				Visitor.Visit(Parser.output());
			}
			catch (SystemException exception)
			{
				if(exception.GetBaseException() is RecognitionException) 
				{
					Tokens.Seek(0);
					Parser.AddErrorListener(ConsoleErrorListener<object>.Instance);
					
					Parser.ErrorHandler = new DefaultErrorStrategy();
					Parser.Interpreter.PredictionMode = PredictionMode.LL;
					
					Visitor.Visit(Parser.output());
				}
			}
		}
	}
}