from .pddl_parser_base.PDDLGrammarLexer import PDDLGrammarLexer 
from .pddl_parser_base.PDDLGrammarParser import PDDLGrammarParser 
from .pddl_parser_base.PDDLGrammarVisitor import PDDLGrammarVisitor
from antlr4 import CommonTokenStream, InputStream

class PDDLParser(PDDLGrammarVisitor):
    def __init__(self, atomsList):
        self._contexts = PDDLGrammarParser(CommonTokenStream(PDDLGrammarLexer(InputStream(atomsList)))).output().atom()
        self._identifier = None
        self._iterator = iter(self._contexts)
        self._parameters = None
        
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
