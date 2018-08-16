using System;
using Antlr4.Runtime;
using Antlr4.Runtime.Atn;

namespace Parsers.PDDL.Solver_Planning_Domains
{
	public class SPDGrammarBaseVisitorImplementation : SPDGrammarBaseVisitor <object> 
	{
		private const int OK_STATUS = 1;
		private const int ERROR_STATUS = -1;
		private int status;
		private readonly IPDDLDataCollection actions;
		private string errors = "";
		
		private SPDGrammarBaseVisitorImplementation(IPDDLDataCollection actions) 
		{
			this.actions = actions;
		}
		
		public override object VisitPair(SPDGrammarParser.PairContext context)
		{
			SPDGrammarParser.ValueContext ValueContext = context.value();
			string _String = context.STRING().GetText();
			
			if(status == 0 && _String.Equals("\"status\"", StringComparison.OrdinalIgnoreCase))
				status = ValueContext.GetText().Equals("\"ok\"", StringComparison.OrdinalIgnoreCase) ? OK_STATUS: ERROR_STATUS;
			else if(status == ERROR_STATUS)
			{
				if(_String.Equals("\"result\"", StringComparison.OrdinalIgnoreCase))
				{
					if(ValueContext is SPDGrammarParser.ArrayValueContext || ValueContext is SPDGrammarParser.ObjectValueContext)
						return VisitChildren(context);
					else
						errors += Trim(ValueContext.GetText());
				}
				else if(_String.Equals("\"error\"", StringComparison.OrdinalIgnoreCase))
					errors += Trim(ValueContext.GetText());
			}
			else if(status == OK_STATUS)
			{
				if(_String.Equals("\"error\"", StringComparison.OrdinalIgnoreCase))
					actions.StoreAction(Trim(ValueContext.GetText()));
				else if(_String.Equals("\"error\"", StringComparison.OrdinalIgnoreCase))
					return VisitChildren(context);
			}
			
			return null;
		}
		
		private static string Trim(string _string) 
		{
			return (_string[0] == '"' && _string[_string.Length - 1] == '"') ? _string.Substring(1, _string.Length - 1) : _string;
		}
		
		public static string Parse(IPDDLDataCollection actions, string spdOutput, bool two_stageParsing) 
		{
			CommonTokenStream Tokens = new CommonTokenStream(new ClingoLexer(CharStreams.fromstring(spdOutput)));
			SPDGrammarParser Parser = new SPDGrammarParser(Tokens);
			SPDGrammarBaseVisitorImplementation Visitor = new SPDGrammarBaseVisitorImplementation(actions);
			
			if(!two_stageParsing) 
			{
				Visitor.Visit(Parser.json());
				
				return Visitor.errors;
			}
			
			Parser.Interpreter.PredictionMode = PredictionMode.SLL;
			
			Parser.RemoveErrorListeners();
			
			Parser.ErrorHandler = new BailErrorStrategy();
			
			try 
			{
				Visitor.Visit(Parser.json());
			}
			catch (SystemException exception)
			{
				if(exception.GetBaseException() is RecognitionException) 
				{
					Tokens.Seek(0);
					Parser.AddErrorListener(ConsoleErrorListener<object>.Instance);
					
					Parser.ErrorHandler = new DefaultErrorStrategy();
					Parser.Interpreter.PredictionMode = PredictionMode.LL;
					
					Visitor.Visit(Parser.json());
				}
			}
			
			return Visitor.errors;
		}
	}
}