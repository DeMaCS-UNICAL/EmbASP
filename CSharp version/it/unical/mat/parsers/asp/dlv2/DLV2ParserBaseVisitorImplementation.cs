using System;
using System.Collections.Generic;
using Antlr4.Runtime;
using Antlr4.Runtime.Atn;

namespace it.unical.mat.parsers.asp.dlv2
{
    public class DLV2ParserBaseVisitorImplementation : DLV2ParserBaseVisitor<object>
    {
        private readonly IASPDataCollection answerSets;
        private Dictionary<int, int> costs;

        private DLV2ParserBaseVisitorImplementation(IASPDataCollection answerSets)
        {
            this.answerSets = answerSets;
        }

        public override object VisitAnswer_set(DLV2Parser.Answer_setContext context)
        {
            answerSets.AddAnswerSet();

            if (context.cost() != null && !context.cost().IsEmpty)
            {
                costs = new Dictionary<int, int>();
                string[] FirstCost = context.cost().COST_LABEL().GetText().Split(' ')[1].Split('@');

                costs[Int32.Parse(FirstCost[1])] = Int32.Parse(FirstCost[0]);
            }

            if (costs != null)
                foreach (KeyValuePair<int, int> entry in costs)
                    answerSets.StoreCost(entry.Key, entry.Value);

            return VisitChildren(context);
        }

        public override object VisitLevel(DLV2Parser.LevelContext context)
        {
            int level = Int32.Parse(context.INTEGER()[1].GetText()), cost = Int32.Parse(context.INTEGER()[0].GetText());

            costs[level] = cost;
            answerSets.StoreCost(level, cost);

            return null;
        }

        public override object VisitPredicate_atom(DLV2Parser.Predicate_atomContext context)
        {
            answerSets.StoreAtom(context.GetText());

            return null;
        }

        public static void Parse(IASPDataCollection answerSets, string atomsList, bool two_stageParsing)
        {
            CommonTokenStream tokens = new CommonTokenStream(new DLV2Lexer(CharStreams.fromstring(atomsList)));
            DLV2Parser parser = new DLV2Parser(tokens);
            DLV2ParserBaseVisitorImplementation visitor = new DLV2ParserBaseVisitorImplementation(answerSets);

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