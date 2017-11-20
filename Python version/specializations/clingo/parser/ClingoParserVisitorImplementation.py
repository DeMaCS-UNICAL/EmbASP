from .ClingoLexer import ClingoLexer
from .ClingoParser import ClingoParser
from .ClingoParserVisitor import ClingoParserVisitor
from antlr4 import CommonTokenStream
from antlr4 import InputStream
from languages.asp.AnswerSet import AnserSet

class ClingoParserVisitorImplementation(ClingoParserVisitor):
    def __init__(self, answerSets):
        self._answerSets = answerSets
        
    def visitAnswer_set(self, ctx:ClingoParser.Answer_setContext):
        self._answerSets.append(AnserSet([]))
        
        return self.visitChildren(ctx)
        
    def visitModel(self, ctx:ClingoParser.ModelContext):
        cost = ctx.NEW_LINE().getText().strip()
        
        if len(cost) > 1:
            tokens = cost.split(' ')
            levels = len(tokens) - 1
            
            for index in range(1, len(tokens)):
                self._answerSets[-1].getWeights()[levels] = tokens[index]
                levels -= 1
        
        return self.visitChildren(ctx)
    
    def visitPredicate_atom(self, ctx):
        self._answerSets[-1].getAnswerSet().append(ctx.getText())
    
    @staticmethod
    def parse(answerSets, clingoOutput):
        ClingoParserVisitorImplementation(answerSets).visit(ClingoParser(CommonTokenStream(ClingoLexer(InputStream(clingoOutput)))).output())
