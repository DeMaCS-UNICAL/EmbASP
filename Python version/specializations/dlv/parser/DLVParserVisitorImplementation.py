from .DLVLexer import DLVLexer
from .DLVParser import DLVParser
from .DLVParserVisitor import DLVParserVisitor
from antlr4.CommonTokenStream import CommonTokenStream
from antlr4.InputStream import InputStream
from languages.asp.AnswerSet import AnserSet

class DLVParserVisitorImplementation(DLVParserVisitor):
    def __init__(self, answerSets):
        self._answerSets = answerSets
    
    def visitSimpleModel(self, ctx):
        self._answerSets.append(AnserSet([]))
        
        return self.visitChildren(ctx)

    def visitWeightedModel(self, ctx):
        self._answerSets.append(AnserSet([]))
        
        return self.visitChildren(ctx)
    
    def visitWitness(self, ctx):
        self._answerSets.append(AnserSet([]))
    
        return self.visitChildren(ctx)
    
    def visitCost_level(self, ctx):
        self._answerSets[-1].getWeights()[ctx.INTEGER_CONSTANT(1).getText()] = ctx.INTEGER_CONSTANT(0).getText()
        
    def visitPredicate(self, ctx):
        self._answerSets[-1].getAnswerSet().append(ctx.getText())
        
    @staticmethod
    def parse(answerSets, dlvOutput):
        DLVParserVisitorImplementation(answerSets).visit(DLVParser(CommonTokenStream(DLVLexer(InputStream(dlvOutput)))).output())