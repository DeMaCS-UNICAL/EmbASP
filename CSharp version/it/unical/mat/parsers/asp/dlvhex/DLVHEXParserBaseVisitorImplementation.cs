using System;
using Antlr4.Runtime;
using Antlr4.Runtime.Atn;

namespace it.unical.mat.parsers.asp.dlvhex
{
    public class DLVHEXParserBaseVisitorImplementation : DLVHEXParserBaseVisitor<object>
    {
        private readonly IASPDataCollection answerSets;

        private DLVHEXParserBaseVisitorImplementation(IASPDataCollection answerSets)
        {
            this.answerSets = answerSets;
        }

        public override object VisitModel(DLVHEXParser.ModelContext context)
        {
            answerSets.AddAnswerSet();

            return VisitChildren(context);
        }

        public override object VisitLevel(DLVHEXParser.LevelContext context)
        {
            answerSets.StoreCost(Int32.Parse(context.INTEGER()[1].GetText()), Int32.Parse(context.INTEGER()[0].GetText()));

            return null;
        }

        public override object VisitPredicate_atom(DLVHEXParser.Predicate_atomContext context)
        {
            answerSets.StoreAtom(context.GetText());

            return null;
        }

        public override object VisitWitness(DLVHEXParser.WitnessContext context)
        {
            answerSets.AddAnswerSet();

            return VisitChildren(context);
        }

        public static void Parse(IASPDataCollection answerSets, string atomsList, bool two_stageParsing)
        {
            CommonTokenStream tokens = new CommonTokenStream(new DLVHEXLexer(CharStreams.fromstring(atomsList)));
            DLVHEXParser parser = new DLVHEXParser(tokens);
            DLVHEXParserBaseVisitorImplementation visitor = new DLVHEXParserBaseVisitorImplementation(answerSets);

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