# Generated from DLVHEXParser.g4 by ANTLR 4.7
# encoding: utf-8
from antlr4 import *
from io import StringIO
from typing.io import TextIO
import sys

def serializedATN():
    with StringIO() as buf:
        buf.write("\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\25")
        buf.write("O\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b")
        buf.write("\t\b\3\2\3\2\7\2\23\n\2\f\2\16\2\26\13\2\3\2\3\2\5\2\32")
        buf.write("\n\2\3\3\3\3\3\3\7\3\37\n\3\f\3\16\3\"\13\3\3\4\3\4\3")
        buf.write("\4\3\4\7\4(\n\4\f\4\16\4+\13\4\3\4\3\4\3\5\3\5\3\5\3\5")
        buf.write("\3\5\3\5\3\6\7\6\66\n\6\f\6\16\69\13\6\3\7\3\7\3\7\3\7")
        buf.write("\3\7\7\7@\n\7\f\7\16\7C\13\7\3\7\3\7\5\7G\n\7\3\b\3\b")
        buf.write("\3\b\3\b\5\bM\n\b\3\b\2\2\t\2\4\6\b\n\f\16\2\2\2Q\2\20")
        buf.write("\3\2\2\2\4\33\3\2\2\2\6#\3\2\2\2\b.\3\2\2\2\n\67\3\2\2")
        buf.write("\2\f:\3\2\2\2\16L\3\2\2\2\20\24\7\3\2\2\21\23\5\4\3\2")
        buf.write("\22\21\3\2\2\2\23\26\3\2\2\2\24\22\3\2\2\2\24\25\3\2\2")
        buf.write("\2\25\27\3\2\2\2\26\24\3\2\2\2\27\31\7\n\2\2\30\32\5\6")
        buf.write("\4\2\31\30\3\2\2\2\31\32\3\2\2\2\32\3\3\2\2\2\33 \5\f")
        buf.write("\7\2\34\35\7\7\2\2\35\37\5\f\7\2\36\34\3\2\2\2\37\"\3")
        buf.write("\2\2\2 \36\3\2\2\2 !\3\2\2\2!\5\3\2\2\2\" \3\2\2\2#$\7")
        buf.write("\4\2\2$)\5\b\5\2%&\7\21\2\2&(\5\b\5\2\'%\3\2\2\2(+\3\2")
        buf.write("\2\2)\'\3\2\2\2)*\3\2\2\2*,\3\2\2\2+)\3\2\2\2,-\7\22\2")
        buf.write("\2-\7\3\2\2\2./\7\24\2\2/\60\7\23\2\2\60\61\7\20\2\2\61")
        buf.write("\62\7\23\2\2\62\63\7\25\2\2\63\t\3\2\2\2\64\66\5\2\2\2")
        buf.write("\65\64\3\2\2\2\669\3\2\2\2\67\65\3\2\2\2\678\3\2\2\28")
        buf.write("\13\3\2\2\29\67\3\2\2\2:F\7\t\2\2;<\7\f\2\2<A\5\16\b\2")
        buf.write("=>\7\7\2\2>@\5\16\b\2?=\3\2\2\2@C\3\2\2\2A?\3\2\2\2AB")
        buf.write("\3\2\2\2BD\3\2\2\2CA\3\2\2\2DE\7\r\2\2EG\3\2\2\2F;\3\2")
        buf.write("\2\2FG\3\2\2\2G\r\3\2\2\2HM\7\t\2\2IM\7\b\2\2JM\5\f\7")
        buf.write("\2KM\7\13\2\2LH\3\2\2\2LI\3\2\2\2LJ\3\2\2\2LK\3\2\2\2")
        buf.write("M\17\3\2\2\2\n\24\31 )\67AFL")
        return buf.getvalue()


class DLVHEXParser ( Parser ):

    grammarFileName = "DLVHEXParser.g4"

    atn = ATNDeserializer().deserialize(serializedATN())

    decisionsToDFA = [ DFA(ds, i) for i, ds in enumerate(atn.decisionToState) ]

    sharedContextCache = PredictionContextCache()

    literalNames = [ "<INVALID>", "'{'", "'<'", "<INVALID>", "<INVALID>", 
                     "<INVALID>", "<INVALID>", "<INVALID>", "'}'", "<INVALID>", 
                     "'('", "')'", "<INVALID>", "<INVALID>", "':'", "<INVALID>", 
                     "'>'", "<INVALID>", "'['", "']'" ]

    symbolicNames = [ "<INVALID>", "START", "COST_LABEL", "ANY", "IGNORE", 
                      "COMMA", "INTEGER_CONSTANT", "IDENTIFIER", "ANSWER_SET_END", 
                      "STRING_CONSTANT", "TERMS_BEGIN", "TERMS_END", "WHITE_SPACE", 
                      "BLANK_SPACE", "COLON", "COMMA_IN_COST", "COST_END", 
                      "INTEGER", "LEVEL_BEGIN", "LEVEL_END" ]

    RULE_answer_set = 0
    RULE_atoms = 1
    RULE_cost = 2
    RULE_level = 3
    RULE_output = 4
    RULE_predicate_atom = 5
    RULE_term = 6

    ruleNames =  [ "answer_set", "atoms", "cost", "level", "output", "predicate_atom", 
                   "term" ]

    EOF = Token.EOF
    START=1
    COST_LABEL=2
    ANY=3
    IGNORE=4
    COMMA=5
    INTEGER_CONSTANT=6
    IDENTIFIER=7
    ANSWER_SET_END=8
    STRING_CONSTANT=9
    TERMS_BEGIN=10
    TERMS_END=11
    WHITE_SPACE=12
    BLANK_SPACE=13
    COLON=14
    COMMA_IN_COST=15
    COST_END=16
    INTEGER=17
    LEVEL_BEGIN=18
    LEVEL_END=19

    def __init__(self, input:TokenStream, output:TextIO = sys.stdout):
        super().__init__(input, output)
        self.checkVersion("4.7")
        self._interp = ParserATNSimulator(self, self.atn, self.decisionsToDFA, self.sharedContextCache)
        self._predicates = None



    class Answer_setContext(ParserRuleContext):

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser

        def START(self):
            return self.getToken(DLVHEXParser.START, 0)

        def ANSWER_SET_END(self):
            return self.getToken(DLVHEXParser.ANSWER_SET_END, 0)

        def atoms(self, i:int=None):
            if i is None:
                return self.getTypedRuleContexts(DLVHEXParser.AtomsContext)
            else:
                return self.getTypedRuleContext(DLVHEXParser.AtomsContext,i)


        def cost(self):
            return self.getTypedRuleContext(DLVHEXParser.CostContext,0)


        def getRuleIndex(self):
            return DLVHEXParser.RULE_answer_set

        def accept(self, visitor:ParseTreeVisitor):
            if hasattr( visitor, "visitAnswer_set" ):
                return visitor.visitAnswer_set(self)
            else:
                return visitor.visitChildren(self)




    def answer_set(self):

        localctx = DLVHEXParser.Answer_setContext(self, self._ctx, self.state)
        self.enterRule(localctx, 0, self.RULE_answer_set)
        self._la = 0 # Token type
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 14
            self.match(DLVHEXParser.START)
            self.state = 18
            self._errHandler.sync(self)
            _la = self._input.LA(1)
            while _la==DLVHEXParser.IDENTIFIER:
                self.state = 15
                self.atoms()
                self.state = 20
                self._errHandler.sync(self)
                _la = self._input.LA(1)

            self.state = 21
            self.match(DLVHEXParser.ANSWER_SET_END)
            self.state = 23
            self._errHandler.sync(self)
            _la = self._input.LA(1)
            if _la==DLVHEXParser.COST_LABEL:
                self.state = 22
                self.cost()


        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx

    class AtomsContext(ParserRuleContext):

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser

        def predicate_atom(self, i:int=None):
            if i is None:
                return self.getTypedRuleContexts(DLVHEXParser.Predicate_atomContext)
            else:
                return self.getTypedRuleContext(DLVHEXParser.Predicate_atomContext,i)


        def COMMA(self, i:int=None):
            if i is None:
                return self.getTokens(DLVHEXParser.COMMA)
            else:
                return self.getToken(DLVHEXParser.COMMA, i)

        def getRuleIndex(self):
            return DLVHEXParser.RULE_atoms

        def accept(self, visitor:ParseTreeVisitor):
            if hasattr( visitor, "visitAtoms" ):
                return visitor.visitAtoms(self)
            else:
                return visitor.visitChildren(self)




    def atoms(self):

        localctx = DLVHEXParser.AtomsContext(self, self._ctx, self.state)
        self.enterRule(localctx, 2, self.RULE_atoms)
        self._la = 0 # Token type
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 25
            self.predicate_atom()
            self.state = 30
            self._errHandler.sync(self)
            _la = self._input.LA(1)
            while _la==DLVHEXParser.COMMA:
                self.state = 26
                self.match(DLVHEXParser.COMMA)
                self.state = 27
                self.predicate_atom()
                self.state = 32
                self._errHandler.sync(self)
                _la = self._input.LA(1)

        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx

    class CostContext(ParserRuleContext):

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser

        def COST_LABEL(self):
            return self.getToken(DLVHEXParser.COST_LABEL, 0)

        def level(self, i:int=None):
            if i is None:
                return self.getTypedRuleContexts(DLVHEXParser.LevelContext)
            else:
                return self.getTypedRuleContext(DLVHEXParser.LevelContext,i)


        def COST_END(self):
            return self.getToken(DLVHEXParser.COST_END, 0)

        def COMMA_IN_COST(self, i:int=None):
            if i is None:
                return self.getTokens(DLVHEXParser.COMMA_IN_COST)
            else:
                return self.getToken(DLVHEXParser.COMMA_IN_COST, i)

        def getRuleIndex(self):
            return DLVHEXParser.RULE_cost

        def accept(self, visitor:ParseTreeVisitor):
            if hasattr( visitor, "visitCost" ):
                return visitor.visitCost(self)
            else:
                return visitor.visitChildren(self)




    def cost(self):

        localctx = DLVHEXParser.CostContext(self, self._ctx, self.state)
        self.enterRule(localctx, 4, self.RULE_cost)
        self._la = 0 # Token type
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 33
            self.match(DLVHEXParser.COST_LABEL)
            self.state = 34
            self.level()
            self.state = 39
            self._errHandler.sync(self)
            _la = self._input.LA(1)
            while _la==DLVHEXParser.COMMA_IN_COST:
                self.state = 35
                self.match(DLVHEXParser.COMMA_IN_COST)
                self.state = 36
                self.level()
                self.state = 41
                self._errHandler.sync(self)
                _la = self._input.LA(1)

            self.state = 42
            self.match(DLVHEXParser.COST_END)
        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx

    class LevelContext(ParserRuleContext):

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser

        def LEVEL_BEGIN(self):
            return self.getToken(DLVHEXParser.LEVEL_BEGIN, 0)

        def INTEGER(self, i:int=None):
            if i is None:
                return self.getTokens(DLVHEXParser.INTEGER)
            else:
                return self.getToken(DLVHEXParser.INTEGER, i)

        def COLON(self):
            return self.getToken(DLVHEXParser.COLON, 0)

        def LEVEL_END(self):
            return self.getToken(DLVHEXParser.LEVEL_END, 0)

        def getRuleIndex(self):
            return DLVHEXParser.RULE_level

        def accept(self, visitor:ParseTreeVisitor):
            if hasattr( visitor, "visitLevel" ):
                return visitor.visitLevel(self)
            else:
                return visitor.visitChildren(self)




    def level(self):

        localctx = DLVHEXParser.LevelContext(self, self._ctx, self.state)
        self.enterRule(localctx, 6, self.RULE_level)
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 44
            self.match(DLVHEXParser.LEVEL_BEGIN)
            self.state = 45
            self.match(DLVHEXParser.INTEGER)
            self.state = 46
            self.match(DLVHEXParser.COLON)
            self.state = 47
            self.match(DLVHEXParser.INTEGER)
            self.state = 48
            self.match(DLVHEXParser.LEVEL_END)
        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx

    class OutputContext(ParserRuleContext):

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser

        def answer_set(self, i:int=None):
            if i is None:
                return self.getTypedRuleContexts(DLVHEXParser.Answer_setContext)
            else:
                return self.getTypedRuleContext(DLVHEXParser.Answer_setContext,i)


        def getRuleIndex(self):
            return DLVHEXParser.RULE_output

        def accept(self, visitor:ParseTreeVisitor):
            if hasattr( visitor, "visitOutput" ):
                return visitor.visitOutput(self)
            else:
                return visitor.visitChildren(self)




    def output(self):

        localctx = DLVHEXParser.OutputContext(self, self._ctx, self.state)
        self.enterRule(localctx, 8, self.RULE_output)
        self._la = 0 # Token type
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 53
            self._errHandler.sync(self)
            _la = self._input.LA(1)
            while _la==DLVHEXParser.START:
                self.state = 50
                self.answer_set()
                self.state = 55
                self._errHandler.sync(self)
                _la = self._input.LA(1)

        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx

    class Predicate_atomContext(ParserRuleContext):

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser

        def IDENTIFIER(self):
            return self.getToken(DLVHEXParser.IDENTIFIER, 0)

        def TERMS_BEGIN(self):
            return self.getToken(DLVHEXParser.TERMS_BEGIN, 0)

        def term(self, i:int=None):
            if i is None:
                return self.getTypedRuleContexts(DLVHEXParser.TermContext)
            else:
                return self.getTypedRuleContext(DLVHEXParser.TermContext,i)


        def TERMS_END(self):
            return self.getToken(DLVHEXParser.TERMS_END, 0)

        def COMMA(self, i:int=None):
            if i is None:
                return self.getTokens(DLVHEXParser.COMMA)
            else:
                return self.getToken(DLVHEXParser.COMMA, i)

        def getRuleIndex(self):
            return DLVHEXParser.RULE_predicate_atom

        def accept(self, visitor:ParseTreeVisitor):
            if hasattr( visitor, "visitPredicate_atom" ):
                return visitor.visitPredicate_atom(self)
            else:
                return visitor.visitChildren(self)




    def predicate_atom(self):

        localctx = DLVHEXParser.Predicate_atomContext(self, self._ctx, self.state)
        self.enterRule(localctx, 10, self.RULE_predicate_atom)
        self._la = 0 # Token type
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 56
            self.match(DLVHEXParser.IDENTIFIER)
            self.state = 68
            self._errHandler.sync(self)
            _la = self._input.LA(1)
            if _la==DLVHEXParser.TERMS_BEGIN:
                self.state = 57
                self.match(DLVHEXParser.TERMS_BEGIN)
                self.state = 58
                self.term()
                self.state = 63
                self._errHandler.sync(self)
                _la = self._input.LA(1)
                while _la==DLVHEXParser.COMMA:
                    self.state = 59
                    self.match(DLVHEXParser.COMMA)
                    self.state = 60
                    self.term()
                    self.state = 65
                    self._errHandler.sync(self)
                    _la = self._input.LA(1)

                self.state = 66
                self.match(DLVHEXParser.TERMS_END)


        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx

    class TermContext(ParserRuleContext):

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser

        def IDENTIFIER(self):
            return self.getToken(DLVHEXParser.IDENTIFIER, 0)

        def INTEGER_CONSTANT(self):
            return self.getToken(DLVHEXParser.INTEGER_CONSTANT, 0)

        def predicate_atom(self):
            return self.getTypedRuleContext(DLVHEXParser.Predicate_atomContext,0)


        def STRING_CONSTANT(self):
            return self.getToken(DLVHEXParser.STRING_CONSTANT, 0)

        def getRuleIndex(self):
            return DLVHEXParser.RULE_term

        def accept(self, visitor:ParseTreeVisitor):
            if hasattr( visitor, "visitTerm" ):
                return visitor.visitTerm(self)
            else:
                return visitor.visitChildren(self)




    def term(self):

        localctx = DLVHEXParser.TermContext(self, self._ctx, self.state)
        self.enterRule(localctx, 12, self.RULE_term)
        try:
            self.state = 74
            self._errHandler.sync(self)
            la_ = self._interp.adaptivePredict(self._input,7,self._ctx)
            if la_ == 1:
                self.enterOuterAlt(localctx, 1)
                self.state = 70
                self.match(DLVHEXParser.IDENTIFIER)
                pass

            elif la_ == 2:
                self.enterOuterAlt(localctx, 2)
                self.state = 71
                self.match(DLVHEXParser.INTEGER_CONSTANT)
                pass

            elif la_ == 3:
                self.enterOuterAlt(localctx, 3)
                self.state = 72
                self.predicate_atom()
                pass

            elif la_ == 4:
                self.enterOuterAlt(localctx, 4)
                self.state = 73
                self.match(DLVHEXParser.STRING_CONSTANT)
                pass


        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx





