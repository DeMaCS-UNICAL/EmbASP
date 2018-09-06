using System;
using System.Collections.Generic;
using Antlr4.Runtime;
using Antlr4.Runtime.Atn;

namespace it.unical.mat.parsers.pddl
{
    public class PDDLParser : PDDLGrammarBaseVisitor<object>
    {
        private readonly List<string> parameters = new List<string>();

        private PDDLParser()
        {

        }

        public static PDDLParser Parse(string action)
        {
            CommonTokenStream tokens = new CommonTokenStream(new PDDLGrammarLexer(CharStreams.fromstring(action)));
            PDDLGrammarParser parser = new PDDLGrammarParser(tokens);
            PDDLParser visitor = new PDDLParser();
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

        public override object VisitAtom(PDDLGrammarParser.AtomContext context)
        {
            for (int index = 1; index < context.IDENTIFIER().Length; index++)
                parameters.Add(context.IDENTIFIER()[index].GetText());

            return null;
        }
    }
}