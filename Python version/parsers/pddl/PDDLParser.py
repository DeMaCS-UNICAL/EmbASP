from .pddl_parser_base.PDDLGrammarLexer import PDDLGrammarLexer
from .pddl_parser_base.PDDLGrammarParser import PDDLGrammarParser
from .pddl_parser_base.PDDLGrammarVisitor import PDDLGrammarVisitor
from antlr4 import PredictionMode
from antlr4.CommonTokenStream import CommonTokenStream
from antlr4.error.ErrorListener import ConsoleErrorListener
from antlr4.error.Errors import RecognitionException
from antlr4.error.ErrorStrategy import BailErrorStrategy, DefaultErrorStrategy
from antlr4.InputStream import InputStream


class PDDLParser(PDDLGrammarVisitor):
    def __init__(self):
        self._parameters = []

    @staticmethod
    def parse(atomsList):
        tokens = CommonTokenStream(PDDLGrammarLexer(InputStream(atomsList)))
        parser = PDDLGrammarParser(tokens)
        visitor = PDDLParser()
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

    def visitAtom(self, ctx):
        for index in range(1, len(ctx.IDENTIFIER())):
            self._parameters.append(ctx.IDENTIFIER(index).getText())

        return None
