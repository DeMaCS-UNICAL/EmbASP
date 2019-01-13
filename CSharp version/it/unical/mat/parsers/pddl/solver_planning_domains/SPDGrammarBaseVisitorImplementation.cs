using System;
using Antlr4.Runtime;
using Antlr4.Runtime.Atn;

namespace it.unical.mat.parsers.pddl.solver_planning_domains
{
    public class SPDGrammarBaseVisitorImplementation : SPDGrammarBaseVisitor<object>
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
            SPDGrammarParser.ValueContext valueContext = context.value();
            string @string = context.STRING().GetText();

            if (status == 0 && @string.Equals("\"status\"", StringComparison.CurrentCultureIgnoreCase))
                status = valueContext.GetText().Equals("\"ok\"", StringComparison.CurrentCultureIgnoreCase) ? OK_STATUS : ERROR_STATUS;
            else if (status == ERROR_STATUS)
            {
                if (@string.Equals("\"result\"", StringComparison.CurrentCultureIgnoreCase))
                {
                    if (valueContext is SPDGrammarParser.ArrayValueContext || valueContext is SPDGrammarParser.ObjectValueContext)
                        return VisitChildren(context);
                    else
                        errors += Trim(valueContext.GetText());
                }
                else if (@string.Equals("\"error\"", StringComparison.CurrentCultureIgnoreCase))
                    errors += Trim(valueContext.GetText());
            }
            else if (status == OK_STATUS)
            {
                if (@string.Equals("\"name\"", StringComparison.CurrentCultureIgnoreCase))
                    actions.StoreAction(Trim(valueContext.GetText()));
                else if (@string.Equals("\"plan\"", StringComparison.CurrentCultureIgnoreCase) || @string.Equals("\"result\"", StringComparison.CurrentCultureIgnoreCase))
                    return VisitChildren(context);
            }

            return null;
        }

        private static string Trim(string @string)
        {
            return (@string[0] == '"' && @string[@string.Length - 1] == '"') ? @string.Substring(1, @string.Length - 2) : @string;
        }

        public static string Parse(IPDDLDataCollection actions, string spdOutput, bool two_stageParsing)
        {
            CommonTokenStream tokens = new CommonTokenStream(new SPDGrammarLexer(CharStreams.fromstring(spdOutput)));
            SPDGrammarParser parser = new SPDGrammarParser(tokens);
            SPDGrammarBaseVisitorImplementation visitor = new SPDGrammarBaseVisitorImplementation(actions);

            if (!two_stageParsing)
            {
                visitor.Visit(parser.json());

                return visitor.errors;
            }

            parser.Interpreter.PredictionMode = PredictionMode.SLL;

            parser.RemoveErrorListeners();

            parser.ErrorHandler = new BailErrorStrategy();

            try
            {
                visitor.Visit(parser.json());
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