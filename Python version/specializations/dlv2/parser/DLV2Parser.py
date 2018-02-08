# Generated from DLV2Parser.g4 by ANTLR 4.7
# encoding: utf-8
from __future__ import print_function
from antlr4 import *
from io import StringIO
import sys

def serializedATN():
    with StringIO() as buf:
        buf.write(u"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3")
        buf.write(u"\22I\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7")
        buf.write(u"\4\b\t\b\3\2\3\2\3\2\5\2\24\n\2\3\3\3\3\7\3\30\n\3\f")
        buf.write(u"\3\16\3\33\13\3\3\3\3\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\7")
        buf.write(u"\5&\n\5\f\5\16\5)\13\5\5\5+\n\5\3\5\3\5\3\6\7\6\60\n")
        buf.write(u"\6\f\6\16\6\63\13\6\3\7\3\7\3\7\3\7\3\7\7\7:\n\7\f\7")
        buf.write(u"\16\7=\13\7\3\7\3\7\5\7A\n\7\3\b\3\b\3\b\3\b\5\bG\n\b")
        buf.write(u"\3\b\2\2\t\2\4\6\b\n\f\16\2\2\2K\2\20\3\2\2\2\4\25\3")
        buf.write(u"\2\2\2\6\36\3\2\2\2\b*\3\2\2\2\n\61\3\2\2\2\f\64\3\2")
        buf.write(u"\2\2\16F\3\2\2\2\20\21\7\3\2\2\21\23\5\b\5\2\22\24\5")
        buf.write(u"\4\3\2\23\22\3\2\2\2\23\24\3\2\2\2\24\3\3\2\2\2\25\31")
        buf.write(u"\7\4\2\2\26\30\5\6\4\2\27\26\3\2\2\2\30\33\3\2\2\2\31")
        buf.write(u"\27\3\2\2\2\31\32\3\2\2\2\32\34\3\2\2\2\33\31\3\2\2\2")
        buf.write(u"\34\35\7\t\2\2\35\5\3\2\2\2\36\37\7\b\2\2\37 \7\7\2\2")
        buf.write(u" !\7\b\2\2!\7\3\2\2\2\"\'\5\f\7\2#$\7\13\2\2$&\5\f\7")
        buf.write(u"\2%#\3\2\2\2&)\3\2\2\2\'%\3\2\2\2\'(\3\2\2\2(+\3\2\2")
        buf.write(u"\2)\'\3\2\2\2*\"\3\2\2\2*+\3\2\2\2+,\3\2\2\2,-\7\16\2")
        buf.write(u"\2-\t\3\2\2\2.\60\5\2\2\2/.\3\2\2\2\60\63\3\2\2\2\61")
        buf.write(u"/\3\2\2\2\61\62\3\2\2\2\62\13\3\2\2\2\63\61\3\2\2\2\64")
        buf.write(u"@\7\r\2\2\65\66\7\20\2\2\66;\5\16\b\2\678\7\13\2\28:")
        buf.write(u"\5\16\b\29\67\3\2\2\2:=\3\2\2\2;9\3\2\2\2;<\3\2\2\2<")
        buf.write(u">\3\2\2\2=;\3\2\2\2>?\7\21\2\2?A\3\2\2\2@\65\3\2\2\2")
        buf.write(u"@A\3\2\2\2A\r\3\2\2\2BG\7\r\2\2CG\7\f\2\2DG\5\f\7\2E")
        buf.write(u"G\7\17\2\2FB\3\2\2\2FC\3\2\2\2FD\3\2\2\2FE\3\2\2\2G\17")
        buf.write(u"\3\2\2\2\n\23\31\'*\61;@F")
        return buf.getvalue()


class DLV2Parser ( Parser ):

    grammarFileName = "DLV2Parser.g4"

    atn = ATNDeserializer().deserialize(serializedATN())

    decisionsToDFA = [ DFA(ds, i) for i, ds in enumerate(atn.decisionToState) ]

    sharedContextCache = PredictionContextCache()

    literalNames = [ u"<INVALID>", u"'{'", u"<INVALID>", u"<INVALID>", u"<INVALID>", 
                     u"'@'", u"<INVALID>", u"<INVALID>", u"<INVALID>", u"','", 
                     u"<INVALID>", u"<INVALID>", u"'}'", u"<INVALID>", u"'('", 
                     u"')'" ]

    symbolicNames = [ u"<INVALID>", u"START", u"COST_LABEL", u"ANY", u"IGNORE", 
                      u"AT", u"INTEGER", u"NEW_LINE", u"BLANK_SPACE", u"COMMA", 
                      u"INTEGER_CONSTANT", u"IDENTIFIER", u"MODEL_END", 
                      u"STRING_CONSTANT", u"TERMS_BEGIN", u"TERMS_END", 
                      u"WHITE_SPACE" ]

    RULE_answer_set = 0
    RULE_cost = 1
    RULE_level = 2
    RULE_model = 3
    RULE_output = 4
    RULE_predicate_atom = 5
    RULE_term = 6

    ruleNames =  [ u"answer_set", u"cost", u"level", u"model", u"output", 
                   u"predicate_atom", u"term" ]

    EOF = Token.EOF
    START=1
    COST_LABEL=2
    ANY=3
    IGNORE=4
    AT=5
    INTEGER=6
    NEW_LINE=7
    BLANK_SPACE=8
    COMMA=9
    INTEGER_CONSTANT=10
    IDENTIFIER=11
    MODEL_END=12
    STRING_CONSTANT=13
    TERMS_BEGIN=14
    TERMS_END=15
    WHITE_SPACE=16

    def __init__(self, input, output=sys.stdout):
        super(DLV2Parser, self).__init__(input, output=output)
        self.checkVersion("4.7")
        self._interp = ParserATNSimulator(self, self.atn, self.decisionsToDFA, self.sharedContextCache)
        self._predicates = None



    class Answer_setContext(ParserRuleContext):

        def __init__(self, parser, parent=None, invokingState=-1):
            super(DLV2Parser.Answer_setContext, self).__init__(parent, invokingState)
            self.parser = parser

        def START(self):
            return self.getToken(DLV2Parser.START, 0)

        def model(self):
            return self.getTypedRuleContext(DLV2Parser.ModelContext,0)


        def cost(self):
            return self.getTypedRuleContext(DLV2Parser.CostContext,0)


        def getRuleIndex(self):
            return DLV2Parser.RULE_answer_set

        def accept(self, visitor):
            if hasattr(visitor, "visitAnswer_set"):
                return visitor.visitAnswer_set(self)
            else:
                return visitor.visitChildren(self)




    def answer_set(self):

        localctx = DLV2Parser.Answer_setContext(self, self._ctx, self.state)
        self.enterRule(localctx, 0, self.RULE_answer_set)
        self._la = 0 # Token type
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 14
            self.match(DLV2Parser.START)
            self.state = 15
            self.model()
            self.state = 17
            self._errHandler.sync(self)
            _la = self._input.LA(1)
            if _la==DLV2Parser.COST_LABEL:
                self.state = 16
                self.cost()


        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx

    class CostContext(ParserRuleContext):

        def __init__(self, parser, parent=None, invokingState=-1):
            super(DLV2Parser.CostContext, self).__init__(parent, invokingState)
            self.parser = parser

        def COST_LABEL(self):
            return self.getToken(DLV2Parser.COST_LABEL, 0)

        def NEW_LINE(self):
            return self.getToken(DLV2Parser.NEW_LINE, 0)

        def level(self, i=None):
            if i is None:
                return self.getTypedRuleContexts(DLV2Parser.LevelContext)
            else:
                return self.getTypedRuleContext(DLV2Parser.LevelContext,i)


        def getRuleIndex(self):
            return DLV2Parser.RULE_cost

        def accept(self, visitor):
            if hasattr(visitor, "visitCost"):
                return visitor.visitCost(self)
            else:
                return visitor.visitChildren(self)




    def cost(self):

        localctx = DLV2Parser.CostContext(self, self._ctx, self.state)
        self.enterRule(localctx, 2, self.RULE_cost)
        self._la = 0 # Token type
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 19
            self.match(DLV2Parser.COST_LABEL)
            self.state = 23
            self._errHandler.sync(self)
            _la = self._input.LA(1)
            while _la==DLV2Parser.INTEGER:
                self.state = 20
                self.level()
                self.state = 25
                self._errHandler.sync(self)
                _la = self._input.LA(1)

            self.state = 26
            self.match(DLV2Parser.NEW_LINE)
        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx

    class LevelContext(ParserRuleContext):

        def __init__(self, parser, parent=None, invokingState=-1):
            super(DLV2Parser.LevelContext, self).__init__(parent, invokingState)
            self.parser = parser

        def INTEGER(self, i=None):
            if i is None:
                return self.getTokens(DLV2Parser.INTEGER)
            else:
                return self.getToken(DLV2Parser.INTEGER, i)

        def AT(self):
            return self.getToken(DLV2Parser.AT, 0)

        def getRuleIndex(self):
            return DLV2Parser.RULE_level

        def accept(self, visitor):
            if hasattr(visitor, "visitLevel"):
                return visitor.visitLevel(self)
            else:
                return visitor.visitChildren(self)




    def level(self):

        localctx = DLV2Parser.LevelContext(self, self._ctx, self.state)
        self.enterRule(localctx, 4, self.RULE_level)
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 28
            self.match(DLV2Parser.INTEGER)
            self.state = 29
            self.match(DLV2Parser.AT)
            self.state = 30
            self.match(DLV2Parser.INTEGER)
        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx

    class ModelContext(ParserRuleContext):

        def __init__(self, parser, parent=None, invokingState=-1):
            super(DLV2Parser.ModelContext, self).__init__(parent, invokingState)
            self.parser = parser

        def MODEL_END(self):
            return self.getToken(DLV2Parser.MODEL_END, 0)

        def predicate_atom(self, i=None):
            if i is None:
                return self.getTypedRuleContexts(DLV2Parser.Predicate_atomContext)
            else:
                return self.getTypedRuleContext(DLV2Parser.Predicate_atomContext,i)


        def COMMA(self, i=None):
            if i is None:
                return self.getTokens(DLV2Parser.COMMA)
            else:
                return self.getToken(DLV2Parser.COMMA, i)

        def getRuleIndex(self):
            return DLV2Parser.RULE_model

        def accept(self, visitor):
            if hasattr(visitor, "visitModel"):
                return visitor.visitModel(self)
            else:
                return visitor.visitChildren(self)




    def model(self):

        localctx = DLV2Parser.ModelContext(self, self._ctx, self.state)
        self.enterRule(localctx, 6, self.RULE_model)
        self._la = 0 # Token type
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 40
            self._errHandler.sync(self)
            _la = self._input.LA(1)
            if _la==DLV2Parser.IDENTIFIER:
                self.state = 32
                self.predicate_atom()
                self.state = 37
                self._errHandler.sync(self)
                _la = self._input.LA(1)
                while _la==DLV2Parser.COMMA:
                    self.state = 33
                    self.match(DLV2Parser.COMMA)
                    self.state = 34
                    self.predicate_atom()
                    self.state = 39
                    self._errHandler.sync(self)
                    _la = self._input.LA(1)



            self.state = 42
            self.match(DLV2Parser.MODEL_END)
        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx

    class OutputContext(ParserRuleContext):

        def __init__(self, parser, parent=None, invokingState=-1):
            super(DLV2Parser.OutputContext, self).__init__(parent, invokingState)
            self.parser = parser

        def answer_set(self, i=None):
            if i is None:
                return self.getTypedRuleContexts(DLV2Parser.Answer_setContext)
            else:
                return self.getTypedRuleContext(DLV2Parser.Answer_setContext,i)


        def getRuleIndex(self):
            return DLV2Parser.RULE_output

        def accept(self, visitor):
            if hasattr(visitor, "visitOutput"):
                return visitor.visitOutput(self)
            else:
                return visitor.visitChildren(self)




    def output(self):

        localctx = DLV2Parser.OutputContext(self, self._ctx, self.state)
        self.enterRule(localctx, 8, self.RULE_output)
        self._la = 0 # Token type
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 47
            self._errHandler.sync(self)
            _la = self._input.LA(1)
            while _la==DLV2Parser.START:
                self.state = 44
                self.answer_set()
                self.state = 49
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

        def __init__(self, parser, parent=None, invokingState=-1):
            super(DLV2Parser.Predicate_atomContext, self).__init__(parent, invokingState)
            self.parser = parser

        def IDENTIFIER(self):
            return self.getToken(DLV2Parser.IDENTIFIER, 0)

        def TERMS_BEGIN(self):
            return self.getToken(DLV2Parser.TERMS_BEGIN, 0)

        def term(self, i=None):
            if i is None:
                return self.getTypedRuleContexts(DLV2Parser.TermContext)
            else:
                return self.getTypedRuleContext(DLV2Parser.TermContext,i)


        def TERMS_END(self):
            return self.getToken(DLV2Parser.TERMS_END, 0)

        def COMMA(self, i=None):
            if i is None:
                return self.getTokens(DLV2Parser.COMMA)
            else:
                return self.getToken(DLV2Parser.COMMA, i)

        def getRuleIndex(self):
            return DLV2Parser.RULE_predicate_atom

        def accept(self, visitor):
            if hasattr(visitor, "visitPredicate_atom"):
                return visitor.visitPredicate_atom(self)
            else:
                return visitor.visitChildren(self)




    def predicate_atom(self):

        localctx = DLV2Parser.Predicate_atomContext(self, self._ctx, self.state)
        self.enterRule(localctx, 10, self.RULE_predicate_atom)
        self._la = 0 # Token type
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 50
            self.match(DLV2Parser.IDENTIFIER)
            self.state = 62
            self._errHandler.sync(self)
            _la = self._input.LA(1)
            if _la==DLV2Parser.TERMS_BEGIN:
                self.state = 51
                self.match(DLV2Parser.TERMS_BEGIN)
                self.state = 52
                self.term()
                self.state = 57
                self._errHandler.sync(self)
                _la = self._input.LA(1)
                while _la==DLV2Parser.COMMA:
                    self.state = 53
                    self.match(DLV2Parser.COMMA)
                    self.state = 54
                    self.term()
                    self.state = 59
                    self._errHandler.sync(self)
                    _la = self._input.LA(1)

                self.state = 60
                self.match(DLV2Parser.TERMS_END)


        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx

    class TermContext(ParserRuleContext):

        def __init__(self, parser, parent=None, invokingState=-1):
            super(DLV2Parser.TermContext, self).__init__(parent, invokingState)
            self.parser = parser

        def IDENTIFIER(self):
            return self.getToken(DLV2Parser.IDENTIFIER, 0)

        def INTEGER_CONSTANT(self):
            return self.getToken(DLV2Parser.INTEGER_CONSTANT, 0)

        def predicate_atom(self):
            return self.getTypedRuleContext(DLV2Parser.Predicate_atomContext,0)


        def STRING_CONSTANT(self):
            return self.getToken(DLV2Parser.STRING_CONSTANT, 0)

        def getRuleIndex(self):
            return DLV2Parser.RULE_term

        def accept(self, visitor):
            if hasattr(visitor, "visitTerm"):
                return visitor.visitTerm(self)
            else:
                return visitor.visitChildren(self)




    def term(self):

        localctx = DLV2Parser.TermContext(self, self._ctx, self.state)
        self.enterRule(localctx, 12, self.RULE_term)
        try:
            self.state = 68
            self._errHandler.sync(self)
            la_ = self._interp.adaptivePredict(self._input,7,self._ctx)
            if la_ == 1:
                self.enterOuterAlt(localctx, 1)
                self.state = 64
                self.match(DLV2Parser.IDENTIFIER)
                pass

            elif la_ == 2:
                self.enterOuterAlt(localctx, 2)
                self.state = 65
                self.match(DLV2Parser.INTEGER_CONSTANT)
                pass

            elif la_ == 3:
                self.enterOuterAlt(localctx, 3)
                self.state = 66
                self.predicate_atom()
                pass

            elif la_ == 4:
                self.enterOuterAlt(localctx, 4)
                self.state = 67
                self.match(DLV2Parser.STRING_CONSTANT)
                pass


        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx





