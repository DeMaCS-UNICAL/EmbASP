from .DLVHEXLexer import DLVHEXLexer
from .DLVHEXParser import DLVHEXParser 
from .DLVHEXParserVisitor import DLVHEXParserVisitor
from antlr4.CommonTokenStream import CommonTokenStream
from antlr4.InputStream import InputStream

class DLVHEXParserVisitorImplementation(DLVHEXParserVisitor):
    def __init__(self, answerSets):
        self._answerSets = answerSets
        
    def visitAnswer_set(self, ctx):
        self._answerSets.addAnswerSet()
        
        return self.visitChildren(ctx)

    def visitLevel(self, ctx):
        self._answerSets.storeCost(ctx.INTEGER(1).getText(), ctx.INTEGER(0).getText())
        
        return None
        
    def visitPredicate_atom(self, ctx):
        self._answerSets.storeAtom(ctx.getText())
        
        return None
        
    @staticmethod
    def parse(answerSets, dlvhexOutput):
        DLVHEXParserVisitorImplementation(answerSets).visit(DLVHEXParser(CommonTokenStream(DLVHEXLexer(InputStream(dlvhexOutput)))).output())
