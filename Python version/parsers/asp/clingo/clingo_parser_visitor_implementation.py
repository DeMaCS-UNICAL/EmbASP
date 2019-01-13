from .ClingoLexer import ClingoLexer
from .ClingoParser import ClingoParser
from .ClingoParserVisitor import ClingoParserVisitor
from antlr4 import PredictionMode
from antlr4.CommonTokenStream import CommonTokenStream
from antlr4.error.ErrorListener import ConsoleErrorListener
from antlr4.error.Errors import RecognitionException
from antlr4.error.ErrorStrategy import BailErrorStrategy, DefaultErrorStrategy
from antlr4.InputStream import InputStream


class ClingoParserVisitorImplementation(ClingoParserVisitor):
    def __init__(self, answerSets):
        self._answerSets = answerSets

    def visitAnswer_set(self, ctx):
        self._answerSets.add_answer_set()

        return self.visitChildren(ctx)

    def visitModel(self, ctx):
        cost = ctx.NEW_LINE().getText().strip()

        if len(cost) > 1:
            tokens = cost.split(' ')
            levels = len(tokens) - 1

            for index in range(1, len(tokens)):
                self._answerSets.store_cost(levels, tokens[index])
                levels -= 1

        return self.visitChildren(ctx)

    def visitPredicate_atom(self, ctx):
        self._answerSets.store_atom(ctx.getText())

    @staticmethod
    def parse(answerSets, clingoOutput, two_stageParsing):
        tokens = CommonTokenStream(ClingoLexer(InputStream(clingoOutput)))
        parser = ClingoParser(tokens)
        visitor = ClingoParserVisitorImplementation(answerSets)

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
