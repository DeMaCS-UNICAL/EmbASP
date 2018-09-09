from .DLVHEXLexer import DLVHEXLexer
from .DLVHEXParser import DLVHEXParser
from .DLVHEXParserVisitor import DLVHEXParserVisitor
from antlr4 import PredictionMode
from antlr4.CommonTokenStream import CommonTokenStream
from antlr4.error.ErrorListener import ConsoleErrorListener
from antlr4.error.Errors import RecognitionException
from antlr4.error.ErrorStrategy import BailErrorStrategy, DefaultErrorStrategy
from antlr4.InputStream import InputStream


class DLVHEXParserVisitorImplementation(DLVHEXParserVisitor):
    def __init__(self, answerSets):
        self._answerSets = answerSets

    def visitModel(self, ctx):
        self._answerSets.add_answer_set()

        return self.visitChildren(ctx)

    def visitLevel(self, ctx):
        self._answerSets.store_cost(
            ctx.INTEGER(1).getText(),
            ctx.INTEGER(0).getText())

    def visitPredicate_atom(self, ctx):
        self._answerSets.store_atom(ctx.getText())

    def visitWitness(self, ctx):
        self._answerSets.add_answer_set()

        return self.visitChildren(ctx)

    @staticmethod
    def parse(answerSets, dlvhexOutput, two_stageParsing):
        tokens = CommonTokenStream(DLVHEXLexer(InputStream(dlvhexOutput)))
        parser = DLVHEXParser(tokens)
        visitor = DLVHEXParserVisitorImplementation(answerSets)

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
