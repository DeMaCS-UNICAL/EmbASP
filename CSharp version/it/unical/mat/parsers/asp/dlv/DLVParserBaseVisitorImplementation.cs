using System;
using Antlr4.Runtime;
using Antlr4.Runtime.Atn;

namespace it.unical.mat.parsers.asp.dlv
{
	public class DLVParserBaseVisitorImplementation : DLVParserBaseVisitor <object> 
	{
		private readonly IASPDataCollection answerSets;
		
		private DLVParserBaseVisitorImplementation(IASPDataCollection answerSets) 
		{
			this.answerSets = answerSets;
		}
		
		public override object VisitSimpleModel(DLVParser.SimpleModelContext context) 
		{
			answerSets.AddAnswerSet();
			
			return VisitChildren(context);
		}
		
		public override object VisitWeightedModel(DLVParser.WeightedModelContext context) 
		{
			answerSets.AddAnswerSet();
			
			return VisitChildren(context);
		}
		
		public override object VisitWitness(DLVParser.WitnessContext context) 
		{
			answerSets.AddAnswerSet();
			
			return VisitChildren(context);
		}
		
		public override object VisitCost_level(DLVParser.Cost_levelContext context) 
		{
			answerSets.StoreCost(Int32.Parse(context.INTEGER_CONSTANT()[1].GetText()), Int32.Parse(context.INTEGER_CONSTANT()[0].GetText()));
			
			return null;
		}
		
		public override object VisitPredicate(DLVParser.PredicateContext context) 
		{
			answerSets.StoreAtom(context.GetText());
			
			return null;
		}
		
		public static void Parse(IASPDataCollection answerSets, string atomsList, bool two_stageParsing) 
		{
			CommonTokenStream Tokens = new CommonTokenStream(new DLVLexer(CharStreams.fromstring(atomsList)));
			DLVParser Parser = new DLVParser(Tokens);
			DLVParserBaseVisitorImplementation Visitor = new DLVParserBaseVisitorImplementation(answerSets);
			
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