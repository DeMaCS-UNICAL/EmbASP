using System;
using Antlr4.Runtime;
using Antlr4.Runtime.Atn;

namespace it.unical.mat.parsers.pddl.solver_planning_domains
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
			
			if(status == 0 && _String.Equals("\"status\"", StringComparison.CurrentCultureIgnoreCase))
				status = ValueContext.GetText().Equals("\"ok\"", StringComparison.CurrentCultureIgnoreCase) ? OK_STATUS: ERROR_STATUS;
			else if(status == ERROR_STATUS)
			{
				if(_String.Equals("\"result\"", StringComparison.CurrentCultureIgnoreCase))
				{
					if(ValueContext is SPDGrammarParser.ArrayValueContext || ValueContext is SPDGrammarParser.ObjectValueContext)
						return VisitChildren(context);
					else
						errors += Trim(ValueContext.GetText());
				}
				else if(_String.Equals("\"error\"", StringComparison.CurrentCultureIgnoreCase))
					errors += Trim(ValueContext.GetText());
			}
			else if(status == OK_STATUS)
			{
                if (_String.Equals("\"name\"", StringComparison.CurrentCultureIgnoreCase))
                    actions.StoreAction(Trim(ValueContext.GetText()));
                else if (_String.Equals("\"plan\"", StringComparison.CurrentCultureIgnoreCase) || _String.Equals("\"result\"", StringComparison.CurrentCultureIgnoreCase))
                    return VisitChildren(context);
			}

            return null;
		}
		
		private static string Trim(string _string) 
		{
			return (_string[0] == '"' && _string[_string.Length - 1] == '"') ? _string.Substring(1, _string.Length - 2) : _string;
		}
		
		public static string Parse(IPDDLDataCollection actions, string spdOutput, bool two_stageParsing) 
		{
			CommonTokenStream tokens = new CommonTokenStream(new SPDGrammarLexer(CharStreams.fromstring(spdOutput)));
			SPDGrammarParser parser = new SPDGrammarParser(tokens);
			SPDGrammarBaseVisitorImplementation visitor = new SPDGrammarBaseVisitorImplementation(actions);
            
            if (!two_stageParsing) 
			{
				visitor.VisitPair(parser.pair());
				
				return visitor.errors;
			}
			
			parser.Interpreter.PredictionMode = PredictionMode.SLL;
			
			parser.RemoveErrorListeners();
			
			parser.ErrorHandler = new BailErrorStrategy();
			
			try 
			{
                visitor.VisitJson(parser.json());
            }
			catch (SystemException exception)
			{
                if (exception.GetBaseException() is RecognitionException) 
				{
					tokens.Seek(0);
					parser.AddErrorListener(ConsoleErrorListener<object>.Instance);
					
					parser.ErrorHandler = new DefaultErrorStrategy();
					parser.Interpreter.PredictionMode = PredictionMode.LL;
					
					visitor.Visit(parser.json());
				}
			}
			
			return visitor.errors;
		}
	}
}