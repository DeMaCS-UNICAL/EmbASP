# Generated from ASPGrammar.g4 by ANTLR 4.7
# encoding: utf-8
from __future__ import print_function
from antlr4 import *
from io import StringIO
import sys

def serializedATN():
    with StringIO() as buf:
        buf.write(u"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3")
        buf.write(u"\13/\4\2\t\2\4\3\t\3\4\4\t\4\3\2\7\2\n\n\2\f\2\16\2\r")
        buf.write(u"\13\2\3\3\3\3\3\3\3\3\3\3\7\3\24\n\3\f\3\16\3\27\13\3")
        buf.write(u"\3\3\3\3\5\3\33\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4$")
        buf.write(u"\n\4\f\4\16\4\'\13\4\5\4)\n\4\3\4\3\4\5\4-\n\4\3\4\2")
        buf.write(u"\2\5\2\4\6\2\2\2\64\2\13\3\2\2\2\4\16\3\2\2\2\6,\3\2")
        buf.write(u"\2\2\b\n\5\4\3\2\t\b\3\2\2\2\n\r\3\2\2\2\13\t\3\2\2\2")
        buf.write(u"\13\f\3\2\2\2\f\3\3\2\2\2\r\13\3\2\2\2\16\32\7\b\2\2")
        buf.write(u"\17\20\7\3\2\2\20\25\5\6\4\2\21\22\7\4\2\2\22\24\5\6")
        buf.write(u"\4\2\23\21\3\2\2\2\24\27\3\2\2\2\25\23\3\2\2\2\25\26")
        buf.write(u"\3\2\2\2\26\30\3\2\2\2\27\25\3\2\2\2\30\31\7\5\2\2\31")
        buf.write(u"\33\3\2\2\2\32\17\3\2\2\2\32\33\3\2\2\2\33\5\3\2\2\2")
        buf.write(u"\34-\7\b\2\2\35-\7\t\2\2\36-\5\4\3\2\37(\7\6\2\2 %\5")
        buf.write(u"\6\4\2!\"\7\4\2\2\"$\5\6\4\2#!\3\2\2\2$\'\3\2\2\2%#\3")
        buf.write(u"\2\2\2%&\3\2\2\2&)\3\2\2\2\'%\3\2\2\2( \3\2\2\2()\3\2")
        buf.write(u"\2\2)*\3\2\2\2*-\7\7\2\2+-\7\n\2\2,\34\3\2\2\2,\35\3")
        buf.write(u"\2\2\2,\36\3\2\2\2,\37\3\2\2\2,+\3\2\2\2-\7\3\2\2\2\b")
        buf.write(u"\13\25\32%(,")
        return buf.getvalue()


class ASPGrammarParser ( Parser ):

    grammarFileName = "ASPGrammar.g4"

    atn = ATNDeserializer().deserialize(serializedATN())

    decisionsToDFA = [ DFA(ds, i) for i, ds in enumerate(atn.decisionToState) ]

    sharedContextCache = PredictionContextCache()

    literalNames = [ u"<INVALID>", u"'('", u"','", u"')'", u"'['", u"']'" ]

    symbolicNames = [ u"<INVALID>", u"<INVALID>", u"<INVALID>", u"<INVALID>", 
                      u"<INVALID>", u"<INVALID>", u"IDENTIFIER", u"INTEGER", 
                      u"STRING", u"WHITESPACE" ]

    RULE_output = 0
    RULE_predicate_atom = 1
    RULE_term = 2

    ruleNames =  [ u"output", u"predicate_atom", u"term" ]

    EOF = Token.EOF
    T__0=1
    T__1=2
    T__2=3
    T__3=4
    T__4=5
    IDENTIFIER=6
    INTEGER=7
    STRING=8
    WHITESPACE=9

    def __init__(self, input, output=sys.stdout):
        super(ASPGrammarParser, self).__init__(input, output=output)
        self.checkVersion("4.7")
        self._interp = ParserATNSimulator(self, self.atn, self.decisionsToDFA, self.sharedContextCache)
        self._predicates = None



    class OutputContext(ParserRuleContext):

        def __init__(self, parser, parent=None, invokingState=-1):
            super(ASPGrammarParser.OutputContext, self).__init__(parent, invokingState)
            self.parser = parser

        def predicate_atom(self, i=None):
            if i is None:
                return self.getTypedRuleContexts(ASPGrammarParser.Predicate_atomContext)
            else:
                return self.getTypedRuleContext(ASPGrammarParser.Predicate_atomContext,i)


        def getRuleIndex(self):
            return ASPGrammarParser.RULE_output

        def accept(self, visitor):
            if hasattr(visitor, "visitOutput"):
                return visitor.visitOutput(self)
            else:
                return visitor.visitChildren(self)




    def output(self):

        localctx = ASPGrammarParser.OutputContext(self, self._ctx, self.state)
        self.enterRule(localctx, 0, self.RULE_output)
        self._la = 0 # Token type
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 9
            self._errHandler.sync(self)
            _la = self._input.LA(1)
            while _la==ASPGrammarParser.IDENTIFIER:
                self.state = 6
                self.predicate_atom()
                self.state = 11
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
            super(ASPGrammarParser.Predicate_atomContext, self).__init__(parent, invokingState)
            self.parser = parser

        def IDENTIFIER(self):
            return self.getToken(ASPGrammarParser.IDENTIFIER, 0)

        def term(self, i=None):
            if i is None:
                return self.getTypedRuleContexts(ASPGrammarParser.TermContext)
            else:
                return self.getTypedRuleContext(ASPGrammarParser.TermContext,i)


        def getRuleIndex(self):
            return ASPGrammarParser.RULE_predicate_atom

        def accept(self, visitor):
            if hasattr(visitor, "visitPredicate_atom"):
                return visitor.visitPredicate_atom(self)
            else:
                return visitor.visitChildren(self)




    def predicate_atom(self):

        localctx = ASPGrammarParser.Predicate_atomContext(self, self._ctx, self.state)
        self.enterRule(localctx, 2, self.RULE_predicate_atom)
        self._la = 0 # Token type
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 12
            self.match(ASPGrammarParser.IDENTIFIER)
            self.state = 24
            self._errHandler.sync(self)
            _la = self._input.LA(1)
            if _la==ASPGrammarParser.T__0:
                self.state = 13
                self.match(ASPGrammarParser.T__0)
                self.state = 14
                self.term()
                self.state = 19
                self._errHandler.sync(self)
                _la = self._input.LA(1)
                while _la==ASPGrammarParser.T__1:
                    self.state = 15
                    self.match(ASPGrammarParser.T__1)
                    self.state = 16
                    self.term()
                    self.state = 21
                    self._errHandler.sync(self)
                    _la = self._input.LA(1)

                self.state = 22
                self.match(ASPGrammarParser.T__2)


        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx

    class TermContext(ParserRuleContext):

        def __init__(self, parser, parent=None, invokingState=-1):
            super(ASPGrammarParser.TermContext, self).__init__(parent, invokingState)
            self.parser = parser

        def IDENTIFIER(self):
            return self.getToken(ASPGrammarParser.IDENTIFIER, 0)

        def INTEGER(self):
            return self.getToken(ASPGrammarParser.INTEGER, 0)

        def predicate_atom(self):
            return self.getTypedRuleContext(ASPGrammarParser.Predicate_atomContext,0)


        def term(self, i=None):
            if i is None:
                return self.getTypedRuleContexts(ASPGrammarParser.TermContext)
            else:
                return self.getTypedRuleContext(ASPGrammarParser.TermContext,i)


        def STRING(self):
            return self.getToken(ASPGrammarParser.STRING, 0)

        def getRuleIndex(self):
            return ASPGrammarParser.RULE_term

        def accept(self, visitor):
            if hasattr(visitor, "visitTerm"):
                return visitor.visitTerm(self)
            else:
                return visitor.visitChildren(self)




    def term(self):

        localctx = ASPGrammarParser.TermContext(self, self._ctx, self.state)
        self.enterRule(localctx, 4, self.RULE_term)
        self._la = 0 # Token type
        try:
            self.state = 42
            self._errHandler.sync(self)
            la_ = self._interp.adaptivePredict(self._input,5,self._ctx)
            if la_ == 1:
                self.enterOuterAlt(localctx, 1)
                self.state = 26
                self.match(ASPGrammarParser.IDENTIFIER)
                pass

            elif la_ == 2:
                self.enterOuterAlt(localctx, 2)
                self.state = 27
                self.match(ASPGrammarParser.INTEGER)
                pass

            elif la_ == 3:
                self.enterOuterAlt(localctx, 3)
                self.state = 28
                self.predicate_atom()
                pass

            elif la_ == 4:
                self.enterOuterAlt(localctx, 4)
                self.state = 29
                self.match(ASPGrammarParser.T__3)
                self.state = 38
                self._errHandler.sync(self)
                _la = self._input.LA(1)
                if (((_la) & ~0x3f) == 0 and ((1 << _la) & ((1 << ASPGrammarParser.T__3) | (1 << ASPGrammarParser.IDENTIFIER) | (1 << ASPGrammarParser.INTEGER) | (1 << ASPGrammarParser.STRING))) != 0):
                    self.state = 30
                    self.term()
                    self.state = 35
                    self._errHandler.sync(self)
                    _la = self._input.LA(1)
                    while _la==ASPGrammarParser.T__1:
                        self.state = 31
                        self.match(ASPGrammarParser.T__1)
                        self.state = 32
                        self.term()
                        self.state = 37
                        self._errHandler.sync(self)
                        _la = self._input.LA(1)



                self.state = 40
                self.match(ASPGrammarParser.T__4)
                pass

            elif la_ == 5:
                self.enterOuterAlt(localctx, 5)
                self.state = 41
                self.match(ASPGrammarParser.STRING)
                pass


        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx





