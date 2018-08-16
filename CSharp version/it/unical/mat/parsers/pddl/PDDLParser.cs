using System;
using System.Collections.Generic;
using Antlr4.Runtime;
using Antlr4.Runtime.Atn;

namespace Parsers.PDDL
{
	public class PDDLParser : PDDLGrammarBaseVisitor <object> 
	{
		private readonly List <string> Parameters = new List <string> ();
		
		private PDDLParser() 
		{
			
		}
		
		public static PDDLParser Parse(string action) 
		{
			CommonTokenStream Tokens = new CommonTokenStream(new PDDLGrammarLexer(CharStreams.fromstring(action)));
			PDDLGrammarParser Parser = new PDDLGrammarParser(Tokens);
			PDDLParser Visitor = new PDDLParser();
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
			
			return Visitor;
		}
		
		public string[] GetParameters() 
		{
			return Parameters.ToArray();
		}
		
		public override object VisitAtom(PDDLGrammarParser.AtomContext context) 
		{
			for(int index = 1; index < context.IDENTIFIER().Length; index++)
				Parameters.Add(context.IDENTIFIER()[index].GetText());
			
			return null;
		}
	}
}