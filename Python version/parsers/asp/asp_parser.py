from .asp_parser_base.ASPGrammarLexer import ASPGrammarLexer
from .asp_parser_base.ASPGrammarParser import ASPGrammarParser
from .asp_parser_base.ASPGrammarVisitor import ASPGrammarVisitor
from antlr4 import PredictionMode
from antlr4.CommonTokenStream import CommonTokenStream
from antlr4.error.ErrorListener import ConsoleErrorListener
from antlr4.error.Errors import RecognitionException
from antlr4.error.ErrorStrategy import BailErrorStrategy, DefaultErrorStrategy
from antlr4.InputStream import InputStream


class ASPParser(ASPGrammarVisitor):
    def __init__(self):
        self._parameters = []

    @staticmethod
    def parse(atom):
        tokens = CommonTokenStream(ASPGrammarLexer(InputStream(atom)))
        parser = ASPGrammarParser(tokens)
        visitor = ASPParser()
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

        return visitor

    def get_parameters(self):
        return self._parameters

    def visitTerm(self, ctx):
        self._parameters.append(ctx.getText())

        return None
