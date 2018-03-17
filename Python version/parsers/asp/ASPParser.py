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
    def __init__(self, atomsList):
        self._contexts = ASPParser._getContexts(atomsList)
        self._identifier = None
        self._iterator = iter(self._contexts)
        self._parameters = None
    
    @staticmethod
    def _getContexts(atomsList):
        tokens = CommonTokenStream(ASPGrammarLexer(InputStream(atomsList)))
        parser = ASPGrammarParser(tokens)
        parser._interp.predictionMode = PredictionMode.SLL
        parser.removeErrorListeners()
        parser._errHandler = BailErrorStrategy()
        
        try:
            return parser.output().predicate_atom()
        except RuntimeError as exception:
            if isinstance(exception, RecognitionException):
                tokens.seek(0)
                parser.addErrorListener(ConsoleErrorListener.INSTANCE)
                parser._errHandler = DefaultErrorStrategy()
                parser._interp.predictionMode = PredictionMode.LL
                
                return parser.output().predicate_atom()
    
    def getIdentifier(self):
        current = next(self._iterator, None)
        
        if current is not None:
            self._parameters = list()
            
            self.visitPredicate_atom(current)
            
            return self._identifier
        
        return None
        
    def getParameters(self):
        return self._parameters
    
    def visitPredicate_atom(self, ctx):
        self._identifier = ctx.IDENTIFIER().getText()
        
        return self.visitChildren(ctx)
    
    def visitTerm(self, ctx):
        self._parameters.append(ctx.getText())
        
        return None
