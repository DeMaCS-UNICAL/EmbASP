from .ClingoLexer import ClingoLexer
from .ClingoParser import ClingoParser 
from .ClingoParserVisitor import ClingoParserVisitor
from antlr4.CommonTokenStream import CommonTokenStream
from antlr4.InputStream import InputStream

class ClingoParserVisitorImplementation(ClingoParserVisitor):
    def __init__(self, answerSets):
        self._answerSets = answerSets
        
    def visitAnswer_set(self, ctx):
        self._answerSets.addAnswerSet()
        
        return self.visitChildren(ctx)
        
    def visitModel(self, ctx):
        cost = ctx.NEW_LINE().getText().strip()
        
        if len(cost) > 1:
            tokens = cost.split(' ')
            levels = len(tokens) - 1
            
            for index in range(1, len(tokens)):
                self._answerSets.storeCost(levels, tokens[index])
                levels -= 1
        
        return self.visitChildren(ctx)
    
    def visitPredicate_atom(self, ctx):
        self._answerSets.storeAtom(ctx.getText())
    
    @staticmethod
    def parse(answerSets, clingoOutput):
        ClingoParserVisitorImplementation(answerSets).visit(ClingoParser(CommonTokenStream(ClingoLexer(InputStream(clingoOutput)))).output())
