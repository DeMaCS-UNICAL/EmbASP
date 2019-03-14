using System;
using Antlr4.Runtime;
using Antlr4.Runtime.Atn;

namespace it.unical.mat.parsers.asp.dlv
{
    public class DLVParserBaseVisitorImplementation : DLVParserBaseVisitor<object>
    {
        private readonly IASPDataCollection answerSets;

        private DLVParserBaseVisitorImplementation(IASPDataCollection answerSets)
        {
            this.answerSets = answerSets;
        }

        public override object VisitSimpleModel(DLVParser.SimpleModelContext context)
        {
            answerSets.AddAnswerSet();

            return VisitChildren(context);
        }

        public override object VisitWeightedModel(DLVParser.WeightedModelContext context)
        {
            answerSets.AddAnswerSet();

            return VisitChildren(context);
        }

        public override object VisitWitness(DLVParser.WitnessContext context)
        {
            answerSets.AddAnswerSet();

            return VisitChildren(context);
        }

        public override object VisitCost_level(DLVParser.Cost_levelContext context)
        {
            answerSets.StoreCost(Int32.Parse(context.INTEGER_CONSTANT()[1].GetText()), Int32.Parse(context.INTEGER_CONSTANT()[0].GetText()));

            return null;
        }

        public override object VisitPredicate(DLVParser.PredicateContext context)
        {
            answerSets.StoreAtom(context.GetText());

            return null;
        }

        public static void Parse(IASPDataCollection answerSets, string atomsList, bool two_stageParsing)
        {
            CommonTokenStream tokens = new CommonTokenStream(new DLVLexer(CharStreams.fromstring(atomsList)));
            DLVParser parser = new DLVParser(tokens);
            DLVParserBaseVisitorImplementation visitor = new DLVParserBaseVisitorImplementation(answerSets);

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