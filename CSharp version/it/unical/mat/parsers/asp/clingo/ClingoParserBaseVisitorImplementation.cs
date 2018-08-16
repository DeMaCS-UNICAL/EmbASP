using System;
using Antlr4.Runtime;
using Antlr4.Runtime.Atn;

namespace Parsers.ASP.Clingo
{
	public class ClingoParserBaseVisitorImplementation : ClingoParserBaseVisitor <object> 
	{
		private readonly IASPDataCollection AnswerSets;
		
		private ClingoParserBaseVisitorImplementation(IASPDataCollection answerSets) 
		{
			AnswerSets = answerSets;
		}
		
		public override object VisitAnswer_set(ClingoParser.Answer_setContext context)
		{
			AnswerSets.AddAnswerSet();
			
			return VisitChildren(context);
		}
		
		public override object VisitModel(ClingoParser.ModelContext context) 
		{
			string Cost = context.NEW_LINE().GetText().Trim();
			
			if(Cost.Length > 1)
			{
				string[] Tokens = Cost.Split(' ');
				int Levels = Tokens.Length - 1;
				
				for(int i = 1; i < Tokens.Length; i++)
					AnswerSets.StoreCost(Levels--, Int32.Parse(Tokens[i]));
			}
			
			return VisitChildren(context);
		}
		
		public override object VisitPredicate_atom(ClingoParser.Predicate_atomContext context) 
		{
			AnswerSets.StoreAtom(context.GetText());
			
			return null;
		}
		
		public static void Parse(IASPDataCollection answerSets, string atomsList, bool two_stageParsing) 
		{
			CommonTokenStream Tokens = new CommonTokenStream(new ClingoLexer(CharStreams.fromstring(atomsList)));
			ClingoParser Parser = new ClingoParser(Tokens);
			ClingoParserBaseVisitorImplementation Visitor = new ClingoParserBaseVisitorImplementation(answerSets);
			
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