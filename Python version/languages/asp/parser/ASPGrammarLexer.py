# Generated from ASPGrammar.g4 by ANTLR 4.7
from antlr4 import *
from io import StringIO
from typing.io import TextIO
import sys


def serializedATN():
    with StringIO() as buf:
        buf.write("\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\13")
        buf.write("=\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7")
        buf.write("\4\b\t\b\4\t\t\t\4\n\t\n\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3")
        buf.write("\5\3\6\3\6\3\7\3\7\7\7\"\n\7\f\7\16\7%\13\7\3\b\3\b\3")
        buf.write("\b\7\b*\n\b\f\b\16\b-\13\b\5\b/\n\b\3\t\3\t\7\t\63\n\t")
        buf.write("\f\t\16\t\66\13\t\3\t\3\t\3\n\3\n\3\n\3\n\2\2\13\3\3\5")
        buf.write("\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\3\2\b\4\2C\\c|\6\2")
        buf.write("\62;C\\aac|\3\2\63;\3\2\62;\3\2$$\5\2\13\f\17\17\"\"\2")
        buf.write("@\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13")
        buf.write("\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3")
        buf.write("\2\2\2\3\25\3\2\2\2\5\27\3\2\2\2\7\31\3\2\2\2\t\33\3\2")
        buf.write("\2\2\13\35\3\2\2\2\r\37\3\2\2\2\17.\3\2\2\2\21\60\3\2")
        buf.write("\2\2\239\3\2\2\2\25\26\7*\2\2\26\4\3\2\2\2\27\30\7.\2")
        buf.write("\2\30\6\3\2\2\2\31\32\7+\2\2\32\b\3\2\2\2\33\34\7]\2\2")
        buf.write("\34\n\3\2\2\2\35\36\7_\2\2\36\f\3\2\2\2\37#\t\2\2\2 \"")
        buf.write("\t\3\2\2! \3\2\2\2\"%\3\2\2\2#!\3\2\2\2#$\3\2\2\2$\16")
        buf.write("\3\2\2\2%#\3\2\2\2&/\7\62\2\2\'+\t\4\2\2(*\t\5\2\2)(\3")
        buf.write("\2\2\2*-\3\2\2\2+)\3\2\2\2+,\3\2\2\2,/\3\2\2\2-+\3\2\2")
        buf.write("\2.&\3\2\2\2.\'\3\2\2\2/\20\3\2\2\2\60\64\7$\2\2\61\63")
        buf.write("\n\6\2\2\62\61\3\2\2\2\63\66\3\2\2\2\64\62\3\2\2\2\64")
        buf.write("\65\3\2\2\2\65\67\3\2\2\2\66\64\3\2\2\2\678\7$\2\28\22")
        buf.write("\3\2\2\29:\t\7\2\2:;\3\2\2\2;<\b\n\2\2<\24\3\2\2\2\7\2")
        buf.write("#+.\64\3\b\2\2")
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

    modeNames = [ "DEFAULT_MODE" ]

    literalNames = [ "<INVALID>",
            "'('", "','", "')'", "'['", "']'" ]

    symbolicNames = [ "<INVALID>",
            "IDENTIFIER", "INTEGER", "STRING", "WHITESPACE" ]

    ruleNames = [ "T__0", "T__1", "T__2", "T__3", "T__4", "IDENTIFIER", 
                  "INTEGER", "STRING", "WHITESPACE" ]

    grammarFileName = "ASPGrammar.g4"

    def __init__(self, input=None, output:TextIO = sys.stdout):
        super().__init__(input, output)
        self.checkVersion("4.7")
        self._interp = LexerATNSimulator(self, self.atn, self.decisionsToDFA, PredictionContextCache())
        self._actions = None
        self._predicates = None


