using System;
using System.Collections.Generic;
using Antlr4.Runtime;
using Antlr4.Runtime.Atn;

namespace it.unical.mat.parsers.asp
{
    public class ASPParser : ASPGrammarBaseVisitor<object>
    {
        private readonly List<string> parameters = new List<string>();

        private ASPParser()
        {

        }

        public static ASPParser Parse(string atom)
        {
            CommonTokenStream tokens = new CommonTokenStream(new ASPGrammarLexer(CharStreams.fromstring(atom)));
            ASPGrammarParser parser = new ASPGrammarParser(tokens);
            ASPParser visitor = new ASPParser();
            parser.Interpreter.PredictionMode = PredictionMode.SLL;

            parser.RemoveErrorListeners();

            parser.ErrorHandler = new BailErrorStrategy();

            try
            {
                visitor.Visit(parser.output());
            }
            catch (SystemException exception)
            {
                if (exception.GetBaseException() is RecognitionException)
                {
                    tokens.Seek(0);
                    parser.AddErrorListener(ConsoleErrorListener<object>.Instance);

                    parser.ErrorHandler = new DefaultErrorStrategy();
                    parser.Interpreter.PredictionMode = PredictionMode.LL;

                    visitor.Visit(parser.output());
                }
            }

            return visitor;
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