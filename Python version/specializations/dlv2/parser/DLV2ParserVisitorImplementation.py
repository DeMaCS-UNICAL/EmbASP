from .DLV2Lexer import DLV2Lexer
from .DLV2Parser import DLV2Parser
from .DLV2ParserVisitor import DLV2ParserVisitor
from antlr4.CommonTokenStream import CommonTokenStream
from antlr4.InputStream import InputStream
from languages.asp.AnswerSet import AnserSet

class DLV2ParserVisitorImplementation(DLV2ParserVisitor):
    def __init__(self, answerSets):
        self._answerSets = answerSets
        self._cost = None
    
    def visitAnswer_set(self, ctx:DLV2Parser.Answer_setContext):
        answerSet = AnserSet([])
        
        if not self._cost is None and (ctx.cost() is None or ctx.cost().isEmpty()):
            answerSet.getWeights().update(self._cost)
        else:
            self._cost = answerSet.getWeights()
            
        self._answerSets.append(answerSet)
        
        return self.visitChildren(ctx)
    
    def visitLevel(self, ctx:DLV2Parser.LevelContext):
        self._answerSets[-1].getWeights()[ctx.INTEGER(1).getText()] = ctx.INTEGER(0).getText()
        
    def visitPredicate_atom(self, ctx):
        self._answerSets[-1].getAnswerSet().append(ctx.getText())
    
    @staticmethod
    def parse(answerSets, dlv2Output):
        DLV2ParserVisitorImplementation(answerSets).visit(DLV2Parser(CommonTokenStream(DLV2Lexer(InputStream(dlv2Output)))).output())
