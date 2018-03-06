from .DLV2Lexer import DLV2Lexer
from .DLV2Parser import DLV2Parser 
from .DLV2ParserVisitor import DLV2ParserVisitor
from antlr4.CommonTokenStream import CommonTokenStream
from antlr4.InputStream import InputStream

class DLV2ParserVisitorImplementation(DLV2ParserVisitor):
    def __init__(self, answerSets):
        self._answerSets = answerSets
        self._costs = {}
    
    def visitAnswer_set(self, ctx):
        if not ctx.cost().isEmpty():
            firstCost = ctx.cost().COST_LABEL().getText().split(' ')[1].split('@')
            
            self._costs.clear()
            self._costs[firstCost[1]] = firstCost[0]
        
        self._answerSets.addAnswerSet()
        
        for level, weight in self._costs.items():
            self._answerSets.storeCost(level, weight)
        
        return self.visitChildren(ctx)
    
    def visitLevel(self, ctx):
        level = ctx.INTEGER(1).getText()
        weight = ctx.INTEGER(0).getText()
        self._costs[level] = weight
        
        self._answerSets.storeCost(level, weight)
    
    def visitPredicate_atom(self, ctx):
        self._answerSets.storeAtom(ctx.getText())
    
    @staticmethod
    def parse(answerSets, dlv2Output):
        DLV2ParserVisitorImplementation(answerSets).visit(DLV2Parser(CommonTokenStream(DLV2Lexer(InputStream(dlv2Output)))).output())
