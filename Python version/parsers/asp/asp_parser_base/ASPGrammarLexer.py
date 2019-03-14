# Generated from ASPGrammar.g4 by ANTLR 4.7
# encoding: utf-8
from __future__ import print_function
from antlr4 import *
from io import StringIO
import sys


def serializedATN():
    with StringIO() as buf:
        buf.write(u"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2")
        buf.write(u"\13=\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7")
        buf.write(u"\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3\2\3\2\3\3\3\3\3\4\3\4")
        buf.write(u"\3\5\3\5\3\6\3\6\3\7\3\7\7\7\"\n\7\f\7\16\7%\13\7\3\b")
        buf.write(u"\3\b\3\b\7\b*\n\b\f\b\16\b-\13\b\5\b/\n\b\3\t\3\t\7\t")
        buf.write(u"\63\n\t\f\t\16\t\66\13\t\3\t\3\t\3\n\3\n\3\n\3\n\2\2")
        buf.write(u"\13\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\3\2\b\4")
        buf.write(u"\2C\\c|\6\2\62;C\\aac|\3\2\63;\3\2\62;\3\2$$\5\2\13\f")
        buf.write(u"\17\17\"\"\2@\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t")
        buf.write(u"\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3")
        buf.write(u"\2\2\2\2\23\3\2\2\2\3\25\3\2\2\2\5\27\3\2\2\2\7\31\3")
        buf.write(u"\2\2\2\t\33\3\2\2\2\13\35\3\2\2\2\r\37\3\2\2\2\17.\3")
        buf.write(u"\2\2\2\21\60\3\2\2\2\239\3\2\2\2\25\26\7*\2\2\26\4\3")
        buf.write(u"\2\2\2\27\30\7.\2\2\30\6\3\2\2\2\31\32\7+\2\2\32\b\3")
        buf.write(u"\2\2\2\33\34\7]\2\2\34\n\3\2\2\2\35\36\7_\2\2\36\f\3")
        buf.write(u"\2\2\2\37#\t\2\2\2 \"\t\3\2\2! \3\2\2\2\"%\3\2\2\2#!")
        buf.write(u"\3\2\2\2#$\3\2\2\2$\16\3\2\2\2%#\3\2\2\2&/\7\62\2\2\'")
        buf.write(u"+\t\4\2\2(*\t\5\2\2)(\3\2\2\2*-\3\2\2\2+)\3\2\2\2+,\3")
        buf.write(u"\2\2\2,/\3\2\2\2-+\3\2\2\2.&\3\2\2\2.\'\3\2\2\2/\20\3")
        buf.write(u"\2\2\2\60\64\7$\2\2\61\63\n\6\2\2\62\61\3\2\2\2\63\66")
        buf.write(u"\3\2\2\2\64\62\3\2\2\2\64\65\3\2\2\2\65\67\3\2\2\2\66")
        buf.write(u"\64\3\2\2\2\678\7$\2\28\22\3\2\2\29:\t\7\2\2:;\3\2\2")
        buf.write(u"\2;<\b\n\2\2<\24\3\2\2\2\7\2#+.\64\3\b\2\2")
        return buf.getvalue()


class ASPGrammarLexer(Lexer):

    atn = ATNDeserializer().deserialize(serializedATN())

    decisionsToDFA = [ DFA(ds, i) for i, ds in enumerate(atn.decisionToState) ]

    T__0 = 1
    T__1 = 2
    T__2 = 3
    T__3 = 4
    T__4 = 5
    IDENTIFIER = 6
    INTEGER = 7
    STRING = 8
    WHITESPACE = 9

    channelNames = [ u"DEFAULT_TOKEN_CHANNEL", u"HIDDEN" ]

    modeNames = [ u"DEFAULT_MODE" ]

    literalNames = [ u"<INVALID>",
            u"'('", u"','", u"')'", u"'['", u"']'" ]

    symbolicNames = [ u"<INVALID>",
            u"IDENTIFIER", u"INTEGER", u"STRING", u"WHITESPACE" ]

    ruleNames = [ u"T__0", u"T__1", u"T__2", u"T__3", u"T__4", u"IDENTIFIER", 
                  u"INTEGER", u"STRING", u"WHITESPACE" ]

    grammarFileName = u"ASPGrammar.g4"

    def __init__(self, input=None, output=sys.stdout):
        super(ASPGrammarLexer, self).__init__(input, output=output)
        self.checkVersion("4.7")
        self._interp = LexerATNSimulator(self, self.atn, self.decisionsToDFA, PredictionContextCache())
        self._actions = None
        self._predicates = None


