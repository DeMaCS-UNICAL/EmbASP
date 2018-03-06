from .DLVLexer import DLVLexer
from .DLVParser import DLVParser 
from .DLVParserVisitor import DLVParserVisitor
from antlr4.CommonTokenStream import CommonTokenStream
from antlr4.InputStream import InputStream

class DLVParserVisitorImplementation(DLVParserVisitor):
    def __init__(self, answerSets):
        self._answerSets = answerSets
    
    def visitSimpleModel(self, ctx):
        self._answerSets.addAnswerSet()
        
        return self.visitChildren(ctx)

    def visitWeightedModel(self, ctx):
        self._answerSets.addAnswerSet()
        
        return self.visitChildren(ctx)
    
    def visitWitness(self, ctx):
        self._answerSets.addAnswerSet()
    
        return self.visitChildren(ctx)
    
    def visitCost_level(self, ctx):
        self._answerSets.storeCost(ctx.INTEGER_CONSTANT(1).getText(), ctx.INTEGER_CONSTANT(0).getText())
        
    def visitPredicate(self, ctx):
        self._answerSets.storeAtom(ctx.getText())
        
    @staticmethod
    def parse(answerSets, dlvOutput):
        DLVParserVisitorImplementation(answerSets).visit(DLVParser(CommonTokenStream(DLVLexer(InputStream(dlvOutput)))).output())
