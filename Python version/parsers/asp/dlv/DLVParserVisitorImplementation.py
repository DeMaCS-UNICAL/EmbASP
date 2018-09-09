from .DLVLexer import DLVLexer
from .DLVParser import DLVParser
from .DLVParserVisitor import DLVParserVisitor
from antlr4 import PredictionMode
from antlr4.CommonTokenStream import CommonTokenStream
from antlr4.error.ErrorListener import ConsoleErrorListener
from antlr4.error.Errors import RecognitionException
from antlr4.error.ErrorStrategy import BailErrorStrategy, DefaultErrorStrategy
from antlr4.InputStream import InputStream


class DLVParserVisitorImplementation(DLVParserVisitor):
    def __init__(self, answerSets):
        self._answerSets = answerSets

    def visitSimpleModel(self, ctx):
        self._answerSets.add_answer_set()

        return self.visitChildren(ctx)

    def visitWeightedModel(self, ctx):
        self._answerSets.add_answer_set()

        return self.visitChildren(ctx)

    def visitWitness(self, ctx):
        self._answerSets.add_answer_set()

        return self.visitChildren(ctx)

    def visitCost_level(self, ctx):
        self._answerSets.store_cost(
            ctx.INTEGER_CONSTANT(1).getText(),
            ctx.INTEGER_CONSTANT(0).getText())

    def visitPredicate(self, ctx):
        self._answerSets.store_atom(ctx.getText())

    @staticmethod
    def parse(answerSets, dlvOutput, two_stageParsing):
        tokens = CommonTokenStream(DLVLexer(InputStream(dlvOutput)))
        parser = DLVParser(tokens)
        visitor = DLVParserVisitorImplementation(answerSets)

        if not two_stageParsing:
            visitor.visit(parser.output())

            return

        parser._interp.predictionMode = PredictionMode.SLL
        parser.removeErrorListeners()
        parser._errHandler = BailErrorStrategy()

        try:
            visitor.visit(parser.output())
        except RuntimeError as exception:
            if isinstance(exception, RecognitionException):
                tokens.seek(0)
                parser.addErrorListener(ConsoleErrorListener.INSTANCE)
                parser._errHandler = DefaultErrorStrategy()
                parser._interp.predictionMode = PredictionMode.LL
                visitor.visit(parser.output())
