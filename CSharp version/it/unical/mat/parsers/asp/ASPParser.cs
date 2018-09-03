using System;
using System.Collections.Generic;
using Antlr4.Runtime;
using Antlr4.Runtime.Atn;

namespace it.unical.mat.parsers.asp
{
	public class ASPParser : ASPGrammarBaseVisitor <object> 
	{
		private readonly List <string> parameters = new List <string> ();
		
		private ASPParser() 
		{
			
		}
		
		public static ASPParser Parse(string atom) 
		{
			CommonTokenStream Tokens = new CommonTokenStream(new ASPGrammarLexer(CharStreams.fromstring(atom)));
			ASPGrammarParser Parser = new ASPGrammarParser(Tokens);
			ASPParser Visitor = new ASPParser();
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
			return parameters.ToArray();
		}
		
		public override object VisitTerm(ASPGrammarParser.TermContext context) 
		{
			parameters.Add(context.GetText());
			
			return null;
		}
	}
}