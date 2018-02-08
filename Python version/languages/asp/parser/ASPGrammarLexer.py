# Generated from ASPGrammar.g4 by ANTLR 4.7
# encoding: utf-8
from __future__ import print_function
from antlr4 import *
from io import StringIO
import sys


def serializedATN():
    with StringIO() as buf:
        buf.write(u"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2")
        buf.write(u"\t\65\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7")
        buf.write(u"\t\7\4\b\t\b\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\7\5\32\n")
        buf.write(u"\5\f\5\16\5\35\13\5\3\6\3\6\3\6\7\6\"\n\6\f\6\16\6%\13")
        buf.write(u"\6\5\6\'\n\6\3\7\3\7\7\7+\n\7\f\7\16\7.\13\7\3\7\3\7")
        buf.write(u"\3\b\3\b\3\b\3\b\2\2\t\3\3\5\4\7\5\t\6\13\7\r\b\17\t")
        buf.write(u"\3\2\b\4\2C\\c|\6\2\62;C\\aac|\3\2\63;\3\2\62;\3\2$$")
        buf.write(u"\5\2\13\f\17\17\"\"\28\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3")
        buf.write(u"\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2")
        buf.write(u"\2\2\3\21\3\2\2\2\5\23\3\2\2\2\7\25\3\2\2\2\t\27\3\2")
        buf.write(u"\2\2\13&\3\2\2\2\r(\3\2\2\2\17\61\3\2\2\2\21\22\7*\2")
        buf.write(u"\2\22\4\3\2\2\2\23\24\7.\2\2\24\6\3\2\2\2\25\26\7+\2")
        buf.write(u"\2\26\b\3\2\2\2\27\33\t\2\2\2\30\32\t\3\2\2\31\30\3\2")
        buf.write(u"\2\2\32\35\3\2\2\2\33\31\3\2\2\2\33\34\3\2\2\2\34\n\3")
        buf.write(u"\2\2\2\35\33\3\2\2\2\36\'\7\62\2\2\37#\t\4\2\2 \"\t\5")
        buf.write(u"\2\2! \3\2\2\2\"%\3\2\2\2#!\3\2\2\2#$\3\2\2\2$\'\3\2")
        buf.write(u"\2\2%#\3\2\2\2&\36\3\2\2\2&\37\3\2\2\2\'\f\3\2\2\2(,")
        buf.write(u"\7$\2\2)+\n\6\2\2*)\3\2\2\2+.\3\2\2\2,*\3\2\2\2,-\3\2")
        buf.write(u"\2\2-/\3\2\2\2.,\3\2\2\2/\60\7$\2\2\60\16\3\2\2\2\61")
        buf.write(u"\62\t\7\2\2\62\63\3\2\2\2\63\64\b\b\2\2\64\20\3\2\2\2")
        buf.write(u"\7\2\33#&,\3\b\2\2")
        return buf.getvalue()


class ASPGrammarLexer(Lexer):

    atn = ATNDeserializer().deserialize(serializedATN())

    decisionsToDFA = [ DFA(ds, i) for i, ds in enumerate(atn.decisionToState) ]

    T__0 = 1
    T__1 = 2
    T__2 = 3
    IDENTIFIER = 4
    INTEGER = 5
    STRING = 6
    WHITESPACE = 7

    channelNames = [ u"DEFAULT_TOKEN_CHANNEL", u"HIDDEN" ]

    modeNames = [ u"DEFAULT_MODE" ]

    literalNames = [ u"<INVALID>",
            u"'('", u"','", u"')'" ]

    symbolicNames = [ u"<INVALID>",
            u"IDENTIFIER", u"INTEGER", u"STRING", u"WHITESPACE" ]

    ruleNames = [ u"T__0", u"T__1", u"T__2", u"IDENTIFIER", u"INTEGER", 
                  u"STRING", u"WHITESPACE" ]

    grammarFileName = u"ASPGrammar.g4"

    def __init__(self, input=None, output=sys.stdout):
        super(ASPGrammarLexer, self).__init__(input, output=output)
        self.checkVersion("4.7")
        self._interp = LexerATNSimulator(self, self.atn, self.decisionsToDFA, PredictionContextCache())
        self._actions = None
        self._predicates = None


