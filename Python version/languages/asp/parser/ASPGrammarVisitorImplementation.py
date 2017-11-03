from .ASPGrammarLexer import ASPGrammarLexer
from .ASPGrammarParser import ASPGrammarParser
from .ASPGrammarVisitor import ASPGrammarVisitor
from antlr4.CommonTokenStream import CommonTokenStream
from antlr4.InputStream import InputStream

class ASPGrammarVisitorImplementation(ASPGrammarVisitor):
    def __init__(self, atomsList):
        self._contexts = ASPGrammarParser(CommonTokenStream(ASPGrammarLexer(InputStream(atomsList)))).output().predicate_atom()
        self._identifier = None
        self._iterator = iter(self._contexts)
        self._parameters = None
        
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
