# Generated from SPDGrammar.g4 by ANTLR 4.7
# encoding: utf-8
from __future__ import print_function
from antlr4 import *
from io import StringIO
import sys

def serializedATN():
    with StringIO() as buf:
        buf.write(u"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3")
        buf.write(u"\r9\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\3\2\3\2\3")
        buf.write(u"\2\3\2\7\2\21\n\2\f\2\16\2\24\13\2\3\2\3\2\3\3\7\3\31")
        buf.write(u"\n\3\f\3\16\3\34\13\3\3\4\3\4\3\4\3\4\7\4\"\n\4\f\4\16")
        buf.write(u"\4%\13\4\3\4\3\4\3\4\3\4\5\4+\n\4\3\5\3\5\3\5\3\5\3\6")
        buf.write(u"\3\6\3\6\3\6\3\6\3\6\5\6\67\n\6\3\6\2\2\7\2\4\6\b\n\2")
        buf.write(u"\2\2<\2\f\3\2\2\2\4\32\3\2\2\2\6*\3\2\2\2\b,\3\2\2\2")
        buf.write(u"\n\66\3\2\2\2\f\r\7\3\2\2\r\22\5\n\6\2\16\17\7\4\2\2")
        buf.write(u"\17\21\5\n\6\2\20\16\3\2\2\2\21\24\3\2\2\2\22\20\3\2")
        buf.write(u"\2\2\22\23\3\2\2\2\23\25\3\2\2\2\24\22\3\2\2\2\25\26")
        buf.write(u"\7\5\2\2\26\3\3\2\2\2\27\31\5\n\6\2\30\27\3\2\2\2\31")
        buf.write(u"\34\3\2\2\2\32\30\3\2\2\2\32\33\3\2\2\2\33\5\3\2\2\2")
        buf.write(u"\34\32\3\2\2\2\35\36\7\6\2\2\36#\5\b\5\2\37 \7\4\2\2")
        buf.write(u" \"\5\b\5\2!\37\3\2\2\2\"%\3\2\2\2#!\3\2\2\2#$\3\2\2")
        buf.write(u"\2$&\3\2\2\2%#\3\2\2\2&\'\7\7\2\2\'+\3\2\2\2()\7\6\2")
        buf.write(u"\2)+\7\7\2\2*\35\3\2\2\2*(\3\2\2\2+\7\3\2\2\2,-\7\f\2")
        buf.write(u"\2-.\7\b\2\2./\5\n\6\2/\t\3\2\2\2\60\67\5\2\2\2\61\67")
        buf.write(u"\7\n\2\2\62\67\7\13\2\2\63\67\7\t\2\2\64\67\5\6\4\2\65")
        buf.write(u"\67\7\f\2\2\66\60\3\2\2\2\66\61\3\2\2\2\66\62\3\2\2\2")
        buf.write(u"\66\63\3\2\2\2\66\64\3\2\2\2\66\65\3\2\2\2\67\13\3\2")
        buf.write(u"\2\2\7\22\32#*\66")
        return buf.getvalue()


class SPDGrammarParser ( Parser ):

    grammarFileName = "SPDGrammar.g4"

    atn = ATNDeserializer().deserialize(serializedATN())

    decisionsToDFA = [ DFA(ds, i) for i, ds in enumerate(atn.decisionToState) ]

    sharedContextCache = PredictionContextCache()

    literalNames = [ u"<INVALID>", u"'['", u"','", u"']'", u"'{'", u"'}'", 
                     u"':'", u"'null'" ]

    symbolicNames = [ u"<INVALID>", u"<INVALID>", u"<INVALID>", u"<INVALID>", 
                      u"<INVALID>", u"<INVALID>", u"<INVALID>", u"<INVALID>", 
                      u"BOOLEAN", u"INTEGER", u"STRING", u"WHITE_SPACE" ]

    RULE_array = 0
    RULE_json = 1
    RULE_oBjEcT = 2
    RULE_pair = 3
    RULE_value = 4

    ruleNames =  [ u"array", u"json", u"oBjEcT", u"pair", u"value" ]

    EOF = Token.EOF
    T__0=1
    T__1=2
    T__2=3
    T__3=4
    T__4=5
    T__5=6
    T__6=7
    BOOLEAN=8
    INTEGER=9
    STRING=10
    WHITE_SPACE=11

    def __init__(self, input, output=sys.stdout):
        super(SPDGrammarParser, self).__init__(input, output=output)
        self.checkVersion("4.7")
        self._interp = ParserATNSimulator(self, self.atn, self.decisionsToDFA, self.sharedContextCache)
        self._predicates = None



    class ArrayContext(ParserRuleContext):

        def __init__(self, parser, parent=None, invokingState=-1):
            super(SPDGrammarParser.ArrayContext, self).__init__(parent, invokingState)
            self.parser = parser

        def value(self, i=None):
            if i is None:
                return self.getTypedRuleContexts(SPDGrammarParser.ValueContext)
            else:
                return self.getTypedRuleContext(SPDGrammarParser.ValueContext,i)


        def getRuleIndex(self):
            return SPDGrammarParser.RULE_array

        def accept(self, visitor):
            if hasattr(visitor, "visitArray"):
                return visitor.visitArray(self)
            else:
                return visitor.visitChildren(self)




    def array(self):

        localctx = SPDGrammarParser.ArrayContext(self, self._ctx, self.state)
        self.enterRule(localctx, 0, self.RULE_array)
        self._la = 0 # Token type
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 10
            self.match(SPDGrammarParser.T__0)
            self.state = 11
            self.value()
            self.state = 16
            self._errHandler.sync(self)
            _la = self._input.LA(1)
            while _la==SPDGrammarParser.T__1:
                self.state = 12
                self.match(SPDGrammarParser.T__1)
                self.state = 13
                self.value()
                self.state = 18
                self._errHandler.sync(self)
                _la = self._input.LA(1)

            self.state = 19
            self.match(SPDGrammarParser.T__2)
        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx

    class JsonContext(ParserRuleContext):

        def __init__(self, parser, parent=None, invokingState=-1):
            super(SPDGrammarParser.JsonContext, self).__init__(parent, invokingState)
            self.parser = parser

        def value(self, i=None):
            if i is None:
                return self.getTypedRuleContexts(SPDGrammarParser.ValueContext)
            else:
                return self.getTypedRuleContext(SPDGrammarParser.ValueContext,i)


        def getRuleIndex(self):
            return SPDGrammarParser.RULE_json

        def accept(self, visitor):
            if hasattr(visitor, "visitJson"):
                return visitor.visitJson(self)
            else:
                return visitor.visitChildren(self)




    def json(self):

        localctx = SPDGrammarParser.JsonContext(self, self._ctx, self.state)
        self.enterRule(localctx, 2, self.RULE_json)
        self._la = 0 # Token type
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 24
            self._errHandler.sync(self)
            _la = self._input.LA(1)
            while (((_la) & ~0x3f) == 0 and ((1 << _la) & ((1 << SPDGrammarParser.T__0) | (1 << SPDGrammarParser.T__3) | (1 << SPDGrammarParser.T__6) | (1 << SPDGrammarParser.BOOLEAN) | (1 << SPDGrammarParser.INTEGER) | (1 << SPDGrammarParser.STRING))) != 0):
                self.state = 21
                self.value()
                self.state = 26
                self._errHandler.sync(self)
                _la = self._input.LA(1)

        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx

    class OBjEcTContext(ParserRuleContext):

        def __init__(self, parser, parent=None, invokingState=-1):
            super(SPDGrammarParser.OBjEcTContext, self).__init__(parent, invokingState)
            self.parser = parser

        def pair(self, i=None):
            if i is None:
                return self.getTypedRuleContexts(SPDGrammarParser.PairContext)
            else:
                return self.getTypedRuleContext(SPDGrammarParser.PairContext,i)


        def getRuleIndex(self):
            return SPDGrammarParser.RULE_oBjEcT

        def accept(self, visitor):
            if hasattr(visitor, "visitOBjEcT"):
                return visitor.visitOBjEcT(self)
            else:
                return visitor.visitChildren(self)




    def oBjEcT(self):

        localctx = SPDGrammarParser.OBjEcTContext(self, self._ctx, self.state)
        self.enterRule(localctx, 4, self.RULE_oBjEcT)
        self._la = 0 # Token type
        try:
            self.state = 40
            self._errHandler.sync(self)
            la_ = self._interp.adaptivePredict(self._input,3,self._ctx)
            if la_ == 1:
                self.enterOuterAlt(localctx, 1)
                self.state = 27
                self.match(SPDGrammarParser.T__3)
                self.state = 28
                self.pair()
                self.state = 33
                self._errHandler.sync(self)
                _la = self._input.LA(1)
                while _la==SPDGrammarParser.T__1:
                    self.state = 29
                    self.match(SPDGrammarParser.T__1)
                    self.state = 30
                    self.pair()
                    self.state = 35
                    self._errHandler.sync(self)
                    _la = self._input.LA(1)

                self.state = 36
                self.match(SPDGrammarParser.T__4)
                pass

            elif la_ == 2:
                self.enterOuterAlt(localctx, 2)
                self.state = 38
                self.match(SPDGrammarParser.T__3)
                self.state = 39
                self.match(SPDGrammarParser.T__4)
                pass


        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx

    class PairContext(ParserRuleContext):

        def __init__(self, parser, parent=None, invokingState=-1):
            super(SPDGrammarParser.PairContext, self).__init__(parent, invokingState)
            self.parser = parser

        def STRING(self):
            return self.getToken(SPDGrammarParser.STRING, 0)

        def value(self):
            return self.getTypedRuleContext(SPDGrammarParser.ValueContext,0)


        def getRuleIndex(self):
            return SPDGrammarParser.RULE_pair

        def accept(self, visitor):
            if hasattr(visitor, "visitPair"):
                return visitor.visitPair(self)
            else:
                return visitor.visitChildren(self)




    def pair(self):

        localctx = SPDGrammarParser.PairContext(self, self._ctx, self.state)
        self.enterRule(localctx, 6, self.RULE_pair)
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 42
            self.match(SPDGrammarParser.STRING)
            self.state = 43
            self.match(SPDGrammarParser.T__5)
            self.state = 44
            self.value()
        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx

    class ValueContext(ParserRuleContext):

        def __init__(self, parser, parent=None, invokingState=-1):
            super(SPDGrammarParser.ValueContext, self).__init__(parent, invokingState)
            self.parser = parser


        def getRuleIndex(self):
            return SPDGrammarParser.RULE_value

     
        def copyFrom(self, ctx):
            super(SPDGrammarParser.ValueContext, self).copyFrom(ctx)



    class NullValueContext(ValueContext):

        def __init__(self, parser, ctx): # actually a SPDGrammarParser.ValueContext)
            super(SPDGrammarParser.NullValueContext, self).__init__(parser)
            self.copyFrom(ctx)


        def accept(self, visitor):
            if hasattr(visitor, "visitNullValue"):
                return visitor.visitNullValue(self)
            else:
                return visitor.visitChildren(self)


    class ObjectValueContext(ValueContext):

        def __init__(self, parser, ctx): # actually a SPDGrammarParser.ValueContext)
            super(SPDGrammarParser.ObjectValueContext, self).__init__(parser)
            self.copyFrom(ctx)

        def oBjEcT(self):
            return self.getTypedRuleContext(SPDGrammarParser.OBjEcTContext,0)


        def accept(self, visitor):
            if hasattr(visitor, "visitObjectValue"):
                return visitor.visitObjectValue(self)
            else:
                return visitor.visitChildren(self)


    class BooleanValueContext(ValueContext):

        def __init__(self, parser, ctx): # actually a SPDGrammarParser.ValueContext)
            super(SPDGrammarParser.BooleanValueContext, self).__init__(parser)
            self.copyFrom(ctx)

        def BOOLEAN(self):
            return self.getToken(SPDGrammarParser.BOOLEAN, 0)

        def accept(self, visitor):
            if hasattr(visitor, "visitBooleanValue"):
                return visitor.visitBooleanValue(self)
            else:
                return visitor.visitChildren(self)


    class IntegerValueContext(ValueContext):

        def __init__(self, parser, ctx): # actually a SPDGrammarParser.ValueContext)
            super(SPDGrammarParser.IntegerValueContext, self).__init__(parser)
            self.copyFrom(ctx)

        def INTEGER(self):
            return self.getToken(SPDGrammarParser.INTEGER, 0)

        def accept(self, visitor):
            if hasattr(visitor, "visitIntegerValue"):
                return visitor.visitIntegerValue(self)
            else:
                return visitor.visitChildren(self)


    class StringValueContext(ValueContext):

        def __init__(self, parser, ctx): # actually a SPDGrammarParser.ValueContext)
            super(SPDGrammarParser.StringValueContext, self).__init__(parser)
            self.copyFrom(ctx)

        def STRING(self):
            return self.getToken(SPDGrammarParser.STRING, 0)

        def accept(self, visitor):
            if hasattr(visitor, "visitStringValue"):
                return visitor.visitStringValue(self)
            else:
                return visitor.visitChildren(self)


    class ArrayValueContext(ValueContext):

        def __init__(self, parser, ctx): # actually a SPDGrammarParser.ValueContext)
            super(SPDGrammarParser.ArrayValueContext, self).__init__(parser)
            self.copyFrom(ctx)

        def array(self):
            return self.getTypedRuleContext(SPDGrammarParser.ArrayContext,0)


        def accept(self, visitor):
            if hasattr(visitor, "visitArrayValue"):
                return visitor.visitArrayValue(self)
            else:
                return visitor.visitChildren(self)



    def value(self):

        localctx = SPDGrammarParser.ValueContext(self, self._ctx, self.state)
        self.enterRule(localctx, 8, self.RULE_value)
        try:
            self.state = 52
            self._errHandler.sync(self)
            token = self._input.LA(1)
            if token in [SPDGrammarParser.T__0]:
                localctx = SPDGrammarParser.ArrayValueContext(self, localctx)
                self.enterOuterAlt(localctx, 1)
                self.state = 46
                self.array()
                pass
            elif token in [SPDGrammarParser.BOOLEAN]:
                localctx = SPDGrammarParser.BooleanValueContext(self, localctx)
                self.enterOuterAlt(localctx, 2)
                self.state = 47
                self.match(SPDGrammarParser.BOOLEAN)
                pass
            elif token in [SPDGrammarParser.INTEGER]:
                localctx = SPDGrammarParser.IntegerValueContext(self, localctx)
                self.enterOuterAlt(localctx, 3)
                self.state = 48
                self.match(SPDGrammarParser.INTEGER)
                pass
            elif token in [SPDGrammarParser.T__6]:
                localctx = SPDGrammarParser.NullValueContext(self, localctx)
                self.enterOuterAlt(localctx, 4)
                self.state = 49
                self.match(SPDGrammarParser.T__6)
                pass
            elif token in [SPDGrammarParser.T__3]:
                localctx = SPDGrammarParser.ObjectValueContext(self, localctx)
                self.enterOuterAlt(localctx, 5)
                self.state = 50
                self.oBjEcT()
                pass
            elif token in [SPDGrammarParser.STRING]:
                localctx = SPDGrammarParser.StringValueContext(self, localctx)
                self.enterOuterAlt(localctx, 6)
                self.state = 51
                self.match(SPDGrammarParser.STRING)
                pass
            else:
                raise NoViableAltException(self)

        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx





