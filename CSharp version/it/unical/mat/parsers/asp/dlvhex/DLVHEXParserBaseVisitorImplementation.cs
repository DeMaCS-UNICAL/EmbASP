using System;
using Antlr4.Runtime;
using Antlr4.Runtime.Atn;

namespace Parsers.ASP.DLVHEX
{
	public class DLVHEXParserBaseVisitorImplementation : DLVHEXParserBaseVisitor <object> 
	{
		private readonly IASPDataCollection answerSets;
		
		private DLVHEXParserBaseVisitorImplementation(IASPDataCollection answerSets) 
		{
			this.answerSets = answerSets;
		}
		
		public override object VisitModel(DLVHEXParser.ModelContext context) 
		{
			answerSets.AddAnswerSet();
			
			return VisitChildren(context);
		}
		
		public override object VisitLevel(DLVHEXParser.LevelContext context) 
		{
			answerSets.StoreCost(Int32.Parse(context.INTEGER()[1].GetText()), Int32.Parse(context.INTEGER()[0].GetText()));
			
			return null;
		}
		
		public override object VisitPredicate_atom(DLVHEXParser.Predicate_atomContext context) 
		{
			answerSets.StoreAtom(context.GetText());
			
			return null;
		}
		
		public override object VisitWitness(DLVHEXParser.WitnessContext context) 
		{
			answerSets.AddAnswerSet();
			
			return VisitChildren(context);
		}
		
		public static void Parse(IASPDataCollection answerSets, string atomsList, bool two_stageParsing) 
		{
			CommonTokenStream Tokens = new CommonTokenStream(new DLVHEXLexer(CharStreams.fromstring(atomsList)));
			DLVHEXParser Parser = new DLVHEXParser(Tokens);
			DLVHEXParserBaseVisitorImplementation Visitor = new DLVHEXParserBaseVisitorImplementation(answerSets);
			
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