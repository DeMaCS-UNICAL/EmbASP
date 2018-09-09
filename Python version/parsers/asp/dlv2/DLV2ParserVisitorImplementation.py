from .DLV2Lexer import DLV2Lexer
from .DLV2Parser import DLV2Parser
from .DLV2ParserVisitor import DLV2ParserVisitor
from antlr4 import PredictionMode
from antlr4.CommonTokenStream import CommonTokenStream
from antlr4.error.ErrorListener import ConsoleErrorListener
from antlr4.error.Errors import RecognitionException
from antlr4.error.ErrorStrategy import BailErrorStrategy, DefaultErrorStrategy
from antlr4.InputStream import InputStream


class DLV2ParserVisitorImplementation(DLV2ParserVisitor):
    def __init__(self, answerSets):
        self._answerSets = answerSets
        self._costs = None

    def visitAnswer_set(self, ctx):
        self._answerSets.add_answer_set()

        if ctx.cost() is not None and not ctx.cost().isEmpty():
            self._costs = {}
            firstCost = ctx.cost().COST_LABEL(
            ).getText().split(' ')[1].split('@')

            self._costs[firstCost[1]] = firstCost[0]

        if self._costs is not None:
            for level, cost in self._costs.items():
                self._answerSets.store_cost(level, cost)

        return self.visitChildren(ctx)

    def visitLevel(self, ctx):
        level = ctx.INTEGER(1).getText()
        cost = ctx.INTEGER(0).getText()

        self._costs[level] = cost
        self._answerSets.store_cost(level, cost)

    def visitPredicate_atom(self, ctx):
        self._answerSets.store_atom(ctx.getText())

    @staticmethod
    def parse(answerSets, dlv2Output, two_stageParsing):
        tokens = CommonTokenStream(DLV2Lexer(InputStream(dlv2Output)))
        parser = DLV2Parser(tokens)
        visitor = DLV2ParserVisitorImplementation(answerSets)

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
