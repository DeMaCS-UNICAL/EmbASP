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
    def __init__(self, atomsList):
        self._contexts = PDDLParser._getContexts(atomsList)
        self._identifier = None
        self._iterator = iter(self._contexts)
        self._parameters = None
    
    @staticmethod
    def _getContexts(atomsList):
        tokens = CommonTokenStream(PDDLGrammarLexer(InputStream(atomsList)))
        parser = PDDLGrammarParser(tokens)
        parser._interp.predictionMode = PredictionMode.SLL
        parser.removeErrorListeners()
        parser._errHandler = BailErrorStrategy()
        
        try:
            return parser.output().atom()
        except RuntimeError as exception:
            if isinstance(exception, RecognitionException):
                tokens.seek(0)
                parser.addErrorListener(ConsoleErrorListener.INSTANCE)
                parser._errHandler = DefaultErrorStrategy()
                parser._interp.predictionMode = PredictionMode.LL
                
                return parser.output().atom()
    
    def getIdentifier(self):
        current = next(self._iterator, None)
        
        if current is not None:
            self._parameters = list()
            
            self.visitAtom(current)
            
            return self._identifier
        
        return None
    
    def getParameters(self):
        return self._parameters
    
    def visitAtom(self, ctx):
        self._identifier = ctx.IDENTIFIER(0).getText()
        
        for index in range(1, len(ctx.IDENTIFIER())):
            self._parameters.append(ctx.IDENTIFIER(index).getText())
        
        return None
