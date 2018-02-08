# Generated from SPDGrammar.g4 by ANTLR 4.7
# encoding: utf-8
from __future__ import print_function
from antlr4 import *
from io import StringIO
import sys


def serializedATN():
    with StringIO() as buf:
        buf.write(u"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2")
        buf.write(u"\rN\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t")
        buf.write(u"\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\3\2\3\2")
        buf.write(u"\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\b")
        buf.write(u"\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\64\n")
        buf.write(u"\t\3\n\3\n\3\n\7\n9\n\n\f\n\16\n<\13\n\5\n>\n\n\3\13")
        buf.write(u"\3\13\3\13\3\13\7\13D\n\13\f\13\16\13G\13\13\3\13\3\13")
        buf.write(u"\3\f\3\f\3\f\3\f\2\2\r\3\3\5\4\7\5\t\6\13\7\r\b\17\t")
        buf.write(u"\21\n\23\13\25\f\27\r\3\2\6\3\2\63;\3\2\62;\3\2$$\5\2")
        buf.write(u"\13\f\17\17\"\"\2R\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2")
        buf.write(u"\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2")
        buf.write(u"\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2")
        buf.write(u"\3\31\3\2\2\2\5\33\3\2\2\2\7\35\3\2\2\2\t\37\3\2\2\2")
        buf.write(u"\13!\3\2\2\2\r#\3\2\2\2\17%\3\2\2\2\21\63\3\2\2\2\23")
        buf.write(u"=\3\2\2\2\25?\3\2\2\2\27J\3\2\2\2\31\32\7]\2\2\32\4\3")
        buf.write(u"\2\2\2\33\34\7.\2\2\34\6\3\2\2\2\35\36\7_\2\2\36\b\3")
        buf.write(u"\2\2\2\37 \7}\2\2 \n\3\2\2\2!\"\7\177\2\2\"\f\3\2\2\2")
        buf.write(u"#$\7<\2\2$\16\3\2\2\2%&\7p\2\2&\'\7w\2\2\'(\7n\2\2()")
        buf.write(u"\7n\2\2)\20\3\2\2\2*+\7v\2\2+,\7t\2\2,-\7w\2\2-\64\7")
        buf.write(u"g\2\2./\7h\2\2/\60\7c\2\2\60\61\7n\2\2\61\62\7u\2\2\62")
        buf.write(u"\64\7g\2\2\63*\3\2\2\2\63.\3\2\2\2\64\22\3\2\2\2\65>")
        buf.write(u"\7\62\2\2\66:\t\2\2\2\679\t\3\2\28\67\3\2\2\29<\3\2\2")
        buf.write(u"\2:8\3\2\2\2:;\3\2\2\2;>\3\2\2\2<:\3\2\2\2=\65\3\2\2")
        buf.write(u"\2=\66\3\2\2\2>\24\3\2\2\2?E\7$\2\2@D\n\4\2\2AB\7^\2")
        buf.write(u"\2BD\7$\2\2C@\3\2\2\2CA\3\2\2\2DG\3\2\2\2EC\3\2\2\2E")
        buf.write(u"F\3\2\2\2FH\3\2\2\2GE\3\2\2\2HI\7$\2\2I\26\3\2\2\2JK")
        buf.write(u"\t\5\2\2KL\3\2\2\2LM\b\f\2\2M\30\3\2\2\2\b\2\63:=CE\3")
        buf.write(u"\b\2\2")
        return buf.getvalue()


class SPDGrammarLexer(Lexer):

    atn = ATNDeserializer().deserialize(serializedATN())

    decisionsToDFA = [ DFA(ds, i) for i, ds in enumerate(atn.decisionToState) ]

    T__0 = 1
    T__1 = 2
    T__2 = 3
    T__3 = 4
    T__4 = 5
    T__5 = 6
    T__6 = 7
    BOOLEAN = 8
    INTEGER = 9
    STRING = 10
    WHITE_SPACE = 11

    channelNames = [ u"DEFAULT_TOKEN_CHANNEL", u"HIDDEN" ]

    modeNames = [ u"DEFAULT_MODE" ]

    literalNames = [ u"<INVALID>",
            u"'['", u"','", u"']'", u"'{'", u"'}'", u"':'", u"'null'" ]

    symbolicNames = [ u"<INVALID>",
            u"BOOLEAN", u"INTEGER", u"STRING", u"WHITE_SPACE" ]

    ruleNames = [ u"T__0", u"T__1", u"T__2", u"T__3", u"T__4", u"T__5", 
                  u"T__6", u"BOOLEAN", u"INTEGER", u"STRING", u"WHITE_SPACE" ]

    grammarFileName = u"SPDGrammar.g4"

    def __init__(self, input=None, output=sys.stdout):
        super(SPDGrammarLexer, self).__init__(input, output=output)
        self.checkVersion("4.7")
        self._interp = LexerATNSimulator(self, self.atn, self.decisionsToDFA, PredictionContextCache())
        self._actions = None
        self._predicates = None


