from .SPDGrammarLexer import SPDGrammarLexer
from .SPDGrammarParser import SPDGrammarParser
from .SPDGrammarVisitor import SPDGrammarVisitor
from antlr4 import PredictionMode
from antlr4.CommonTokenStream import CommonTokenStream
from antlr4.error.ErrorListener import ConsoleErrorListener
from antlr4.error.Errors import RecognitionException
from antlr4.error.ErrorStrategy import BailErrorStrategy, DefaultErrorStrategy
from antlr4.InputStream import InputStream


class SPDGrammarVisitorImplementation(SPDGrammarVisitor):
    ERROR_STATUS = -1
    OK_STATUS = 1

    def __init__(self, actions):
        self._actions = actions
        self._errors = ""
        self._status = 0

    def visitPair(self, ctx):
        string = ctx.STRING().getText()
        valueContext = ctx.value()

        if self._status == 0 and string == '"status"':
            self._status = SPDGrammarVisitorImplementation.OK_STATUS if (
                valueContext.getText() == '"ok"') else SPDGrammarVisitorImplementation.ERROR_STATUS
        elif self._status == SPDGrammarVisitorImplementation.ERROR_STATUS:
            if string == '"result"':
                if isinstance(
                        valueContext,
                        SPDGrammarParser.ArrayValueContext) or isinstance(
                        valueContext,
                        SPDGrammarParser.ObjectValueContext):
                    return self.visitChildren(ctx)
                else:
                    self._errors += SPDGrammarVisitorImplementation._trim(
                        valueContext.getText())
            elif string == '"error"':
                self._errors += SPDGrammarVisitorImplementation._trim(
                    valueContext.getText())
        elif self._status == SPDGrammarVisitorImplementation.OK_STATUS:
            if string == '"name"':
                self._actions.store_action(
                    SPDGrammarVisitorImplementation._trim(
                        valueContext.getText()))
            elif string == '"plan"' or string == '"result"':
                return self.visitChildren(ctx)

    @staticmethod
    def _trim(string):
        return string[1:-1] if (string[0] ==
                                '"' and string[-1] == '"') else string

    @staticmethod
    def parse(actions, spdOutput, two_stageParsing):
        tokens = CommonTokenStream(SPDGrammarLexer(InputStream(spdOutput)))
        parser = SPDGrammarParser(tokens)
        visitor = SPDGrammarVisitorImplementation(actions)

        if not two_stageParsing:
            visitor.visit(parser.json())

            return visitor._errors

        parser._interp.predictionMode = PredictionMode.SLL
        parser.removeErrorListeners()
        parser._errHandler = BailErrorStrategy()

        try:
            visitor.visit(parser.json())
        except RuntimeError as exception:
            if isinstance(exception, RecognitionException):
                tokens.seek(0)
                parser.addErrorListener(ConsoleErrorListener.INSTANCE)
                parser._errHandler = DefaultErrorStrategy()
                parser._interp.predictionMode = PredictionMode.LL
                visitor.visit(parser.json())

        return visitor._errors
