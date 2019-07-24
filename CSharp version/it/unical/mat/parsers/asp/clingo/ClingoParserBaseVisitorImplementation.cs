using System;
using Antlr4.Runtime;
using Antlr4.Runtime.Atn;

namespace it.unical.mat.parsers.asp.clingo
{
    public class ClingoParserBaseVisitorImplementation : ClingoParserBaseVisitor<object>
    {
        private readonly IASPDataCollection answerSets;

        private ClingoParserBaseVisitorImplementation(IASPDataCollection answerSets)
        {
            this.answerSets = answerSets;
        }

        public override object VisitAnswer_set(ClingoParser.Answer_setContext context)
        {
            answerSets.AddAnswerSet();

            return VisitChildren(context);
        }

        public override object VisitModel(ClingoParser.ModelContext context)
        {
            string cost = context.NEW_LINE().GetText().Trim();

            if (cost.Length > 1)
            {
                string[] tokens = cost.Split(' ');
                int levels = tokens.Length - 1;

                for (int i = 1; i < tokens.Length; i++)
                    answerSets.StoreCost(levels--, Int32.Parse(tokens[i]));
            }

            return VisitChildren(context);
        }

        public override object VisitPredicate_atom(ClingoParser.Predicate_atomContext context)
        {
            answerSets.StoreAtom(context.GetText());

            return null;
        }

        public static void Parse(IASPDataCollection answerSets, string atomsList, bool two_stageParsing)
        {
            CommonTokenStream tokens = new CommonTokenStream(new ClingoLexer(CharStreams.fromstring(atomsList)));
            ClingoParser parser = new ClingoParser(tokens);
            ClingoParserBaseVisitorImplementation visitor = new ClingoParserBaseVisitorImplementation(answerSets);

            if (!two_stageParsing)
            {
                visitor.Visit(parser.output());

                return;
            }

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
        }
    }
}