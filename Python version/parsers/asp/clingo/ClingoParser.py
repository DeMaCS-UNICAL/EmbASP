# Generated from ClingoParser.g4 by ANTLR 4.7
# encoding: utf-8
from __future__ import print_function
from antlr4 import *
from io import StringIO
import sys

def serializedATN():
    with StringIO() as buf:
        buf.write(u"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3")
        buf.write(u"\f\62\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\3\2\3\2")
        buf.write(u"\3\2\3\3\7\3\21\n\3\f\3\16\3\24\13\3\3\3\3\3\3\4\7\4")
        buf.write(u"\31\n\4\f\4\16\4\34\13\4\3\5\3\5\3\5\3\5\3\5\7\5#\n\5")
        buf.write(u"\f\5\16\5&\13\5\3\5\3\5\5\5*\n\5\3\6\3\6\3\6\3\6\5\6")
        buf.write(u"\60\n\6\3\6\2\2\7\2\4\6\b\n\2\2\2\63\2\f\3\2\2\2\4\22")
        buf.write(u"\3\2\2\2\6\32\3\2\2\2\b\35\3\2\2\2\n/\3\2\2\2\f\r\7\3")
        buf.write(u"\2\2\r\16\5\4\3\2\16\3\3\2\2\2\17\21\5\b\5\2\20\17\3")
        buf.write(u"\2\2\2\21\24\3\2\2\2\22\20\3\2\2\2\22\23\3\2\2\2\23\25")
        buf.write(u"\3\2\2\2\24\22\3\2\2\2\25\26\7\7\2\2\26\5\3\2\2\2\27")
        buf.write(u"\31\5\2\2\2\30\27\3\2\2\2\31\34\3\2\2\2\32\30\3\2\2\2")
        buf.write(u"\32\33\3\2\2\2\33\7\3\2\2\2\34\32\3\2\2\2\35)\7\b\2\2")
        buf.write(u"\36\37\7\n\2\2\37$\5\n\6\2 !\7\5\2\2!#\5\n\6\2\" \3\2")
        buf.write(u"\2\2#&\3\2\2\2$\"\3\2\2\2$%\3\2\2\2%\'\3\2\2\2&$\3\2")
        buf.write(u"\2\2\'(\7\13\2\2(*\3\2\2\2)\36\3\2\2\2)*\3\2\2\2*\t\3")
        buf.write(u"\2\2\2+\60\7\b\2\2,\60\7\6\2\2-\60\5\b\5\2.\60\7\t\2")
        buf.write(u"\2/+\3\2\2\2/,\3\2\2\2/-\3\2\2\2/.\3\2\2\2\60\13\3\2")
        buf.write(u"\2\2\7\22\32$)/")
        return buf.getvalue()


class ClingoParser ( Parser ):

    grammarFileName = "ClingoParser.g4"

    atn = ATNDeserializer().deserialize(serializedATN())

    decisionsToDFA = [ DFA(ds, i) for i, ds in enumerate(atn.decisionToState) ]

    sharedContextCache = PredictionContextCache()

    literalNames = [ u"<INVALID>", u"<INVALID>", u"<INVALID>", u"','", u"<INVALID>", 
                     u"<INVALID>", u"<INVALID>", u"<INVALID>", u"'('", u"')'" ]

    symbolicNames = [ u"<INVALID>", u"START", u"ANY", u"COMMA", u"INTEGER_CONSTANT", 
                      u"NEW_LINE", u"IDENTIFIER", u"STRING_CONSTANT", u"TERMS_BEGIN", 
                      u"TERMS_END", u"WHITE_SPACE" ]

    RULE_answer_set = 0
    RULE_model = 1
    RULE_output = 2
    RULE_predicate_atom = 3
    RULE_term = 4

    ruleNames =  [ u"answer_set", u"model", u"output", u"predicate_atom", 
                   u"term" ]

    EOF = Token.EOF
    START=1
    ANY=2
    COMMA=3
    INTEGER_CONSTANT=4
    NEW_LINE=5
    IDENTIFIER=6
    STRING_CONSTANT=7
    TERMS_BEGIN=8
    TERMS_END=9
    WHITE_SPACE=10

    def __init__(self, input, output=sys.stdout):
        super(ClingoParser, self).__init__(input, output=output)
        self.checkVersion("4.7")
        self._interp = ParserATNSimulator(self, self.atn, self.decisionsToDFA, self.sharedContextCache)
        self._predicates = None



    class Answer_setContext(ParserRuleContext):

        def __init__(self, parser, parent=None, invokingState=-1):
            super(ClingoParser.Answer_setContext, self).__init__(parent, invokingState)
            self.parser = parser

        def START(self):
            return self.getToken(ClingoParser.START, 0)

        def model(self):
            return self.getTypedRuleContext(ClingoParser.ModelContext,0)


        def getRuleIndex(self):
            return ClingoParser.RULE_answer_set

        def accept(self, visitor):
            if hasattr(visitor, "visitAnswer_set"):
                return visitor.visitAnswer_set(self)
            else:
                return visitor.visitChildren(self)




    def answer_set(self):

        localctx = ClingoParser.Answer_setContext(self, self._ctx, self.state)
        self.enterRule(localctx, 0, self.RULE_answer_set)
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 10
            self.match(ClingoParser.START)
            self.state = 11
            self.model()
        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx

    class ModelContext(ParserRuleContext):

        def __init__(self, parser, parent=None, invokingState=-1):
            super(ClingoParser.ModelContext, self).__init__(parent, invokingState)
            self.parser = parser

        def NEW_LINE(self):
            return self.getToken(ClingoParser.NEW_LINE, 0)

        def predicate_atom(self, i=None):
            if i is None:
                return self.getTypedRuleContexts(ClingoParser.Predicate_atomContext)
            else:
                return self.getTypedRuleContext(ClingoParser.Predicate_atomContext,i)


        def getRuleIndex(self):
            return ClingoParser.RULE_model

        def accept(self, visitor):
            if hasattr(visitor, "visitModel"):
                return visitor.visitModel(self)
            else:
                return visitor.visitChildren(self)




    def model(self):

        localctx = ClingoParser.ModelContext(self, self._ctx, self.state)
        self.enterRule(localctx, 2, self.RULE_model)
        self._la = 0 # Token type
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 16
            self._errHandler.sync(self)
            _la = self._input.LA(1)
            while _la==ClingoParser.IDENTIFIER:
                self.state = 13
                self.predicate_atom()
                self.state = 18
                self._errHandler.sync(self)
                _la = self._input.LA(1)

            self.state = 19
            self.match(ClingoParser.NEW_LINE)
        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx

    class OutputContext(ParserRuleContext):

        def __init__(self, parser, parent=None, invokingState=-1):
            super(ClingoParser.OutputContext, self).__init__(parent, invokingState)
            self.parser = parser

        def answer_set(self, i=None):
            if i is None:
                return self.getTypedRuleContexts(ClingoParser.Answer_setContext)
            else:
                return self.getTypedRuleContext(ClingoParser.Answer_setContext,i)


        def getRuleIndex(self):
            return ClingoParser.RULE_output

        def accept(self, visitor):
            if hasattr(visitor, "visitOutput"):
                return visitor.visitOutput(self)
            else:
                return visitor.visitChildren(self)




    def output(self):

        localctx = ClingoParser.OutputContext(self, self._ctx, self.state)
        self.enterRule(localctx, 4, self.RULE_output)
        self._la = 0 # Token type
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 24
            self._errHandler.sync(self)
            _la = self._input.LA(1)
            while _la==ClingoParser.START:
                self.state = 21
                self.answer_set()
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

    class Predicate_atomContext(ParserRuleContext):

        def __init__(self, parser, parent=None, invokingState=-1):
            super(ClingoParser.Predicate_atomContext, self).__init__(parent, invokingState)
            self.parser = parser

        def IDENTIFIER(self):
            return self.getToken(ClingoParser.IDENTIFIER, 0)

        def TERMS_BEGIN(self):
            return self.getToken(ClingoParser.TERMS_BEGIN, 0)

        def term(self, i=None):
            if i is None:
                return self.getTypedRuleContexts(ClingoParser.TermContext)
            else:
                return self.getTypedRuleContext(ClingoParser.TermContext,i)


        def TERMS_END(self):
            return self.getToken(ClingoParser.TERMS_END, 0)

        def COMMA(self, i=None):
            if i is None:
                return self.getTokens(ClingoParser.COMMA)
            else:
                return self.getToken(ClingoParser.COMMA, i)

        def getRuleIndex(self):
            return ClingoParser.RULE_predicate_atom

        def accept(self, visitor):
            if hasattr(visitor, "visitPredicate_atom"):
                return visitor.visitPredicate_atom(self)
            else:
                return visitor.visitChildren(self)




    def predicate_atom(self):

        localctx = ClingoParser.Predicate_atomContext(self, self._ctx, self.state)
        self.enterRule(localctx, 6, self.RULE_predicate_atom)
        self._la = 0 # Token type
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 27
            self.match(ClingoParser.IDENTIFIER)
            self.state = 39
            self._errHandler.sync(self)
            _la = self._input.LA(1)
            if _la==ClingoParser.TERMS_BEGIN:
                self.state = 28
                self.match(ClingoParser.TERMS_BEGIN)
                self.state = 29
                self.term()
                self.state = 34
                self._errHandler.sync(self)
                _la = self._input.LA(1)
                while _la==ClingoParser.COMMA:
                    self.state = 30
                    self.match(ClingoParser.COMMA)
                    self.state = 31
                    self.term()
                    self.state = 36
                    self._errHandler.sync(self)
                    _la = self._input.LA(1)

                self.state = 37
                self.match(ClingoParser.TERMS_END)


        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx

    class TermContext(ParserRuleContext):

        def __init__(self, parser, parent=None, invokingState=-1):
            super(ClingoParser.TermContext, self).__init__(parent, invokingState)
            self.parser = parser

        def IDENTIFIER(self):
            return self.getToken(ClingoParser.IDENTIFIER, 0)

        def INTEGER_CONSTANT(self):
            return self.getToken(ClingoParser.INTEGER_CONSTANT, 0)

        def predicate_atom(self):
            return self.getTypedRuleContext(ClingoParser.Predicate_atomContext,0)


        def STRING_CONSTANT(self):
            return self.getToken(ClingoParser.STRING_CONSTANT, 0)

        def getRuleIndex(self):
            return ClingoParser.RULE_term

        def accept(self, visitor):
            if hasattr(visitor, "visitTerm"):
                return visitor.visitTerm(self)
            else:
                return visitor.visitChildren(self)




    def term(self):

        localctx = ClingoParser.TermContext(self, self._ctx, self.state)
        self.enterRule(localctx, 8, self.RULE_term)
        try:
            self.state = 45
            self._errHandler.sync(self)
            la_ = self._interp.adaptivePredict(self._input,4,self._ctx)
            if la_ == 1:
                self.enterOuterAlt(localctx, 1)
                self.state = 41
                self.match(ClingoParser.IDENTIFIER)
                pass

            elif la_ == 2:
                self.enterOuterAlt(localctx, 2)
                self.state = 42
                self.match(ClingoParser.INTEGER_CONSTANT)
                pass

            elif la_ == 3:
                self.enterOuterAlt(localctx, 3)
                self.state = 43
                self.predicate_atom()
                pass

            elif la_ == 4:
                self.enterOuterAlt(localctx, 4)
                self.state = 44
                self.match(ClingoParser.STRING_CONSTANT)
                pass


        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx





