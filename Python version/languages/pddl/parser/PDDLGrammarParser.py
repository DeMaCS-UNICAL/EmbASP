# Generated from PDDLGrammar.g4 by ANTLR 4.7
# encoding: utf-8
from antlr4 import *
from io import StringIO
from typing.io import TextIO
import sys

def serializedATN():
    with StringIO() as buf:
        buf.write("\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\6")
        buf.write("\26\4\2\t\2\4\3\t\3\3\2\3\2\7\2\t\n\2\f\2\16\2\f\13\2")
        buf.write("\3\2\3\2\3\3\7\3\21\n\3\f\3\16\3\24\13\3\3\3\2\2\4\2\4")
        buf.write("\2\2\2\25\2\6\3\2\2\2\4\22\3\2\2\2\6\n\7\3\2\2\7\t\7\5")
        buf.write("\2\2\b\7\3\2\2\2\t\f\3\2\2\2\n\b\3\2\2\2\n\13\3\2\2\2")
        buf.write("\13\r\3\2\2\2\f\n\3\2\2\2\r\16\7\4\2\2\16\3\3\2\2\2\17")
        buf.write("\21\5\2\2\2\20\17\3\2\2\2\21\24\3\2\2\2\22\20\3\2\2\2")
        buf.write("\22\23\3\2\2\2\23\5\3\2\2\2\24\22\3\2\2\2\4\n\22")
        return buf.getvalue()


class PDDLGrammarParser ( Parser ):

    grammarFileName = "PDDLGrammar.g4"

    atn = ATNDeserializer().deserialize(serializedATN())

    decisionsToDFA = [ DFA(ds, i) for i, ds in enumerate(atn.decisionToState) ]

    sharedContextCache = PredictionContextCache()

    literalNames = [ "<INVALID>", "'('", "')'" ]

    symbolicNames = [ "<INVALID>", "<INVALID>", "<INVALID>", "IDENTIFIER", 
                      "SEPARATOR" ]

    RULE_atom = 0
    RULE_output = 1

    ruleNames =  [ "atom", "output" ]

    EOF = Token.EOF
    T__0=1
    T__1=2
    IDENTIFIER=3
    SEPARATOR=4

    def __init__(self, input:TokenStream, output:TextIO = sys.stdout):
        super().__init__(input, output)
        self.checkVersion("4.7")
        self._interp = ParserATNSimulator(self, self.atn, self.decisionsToDFA, self.sharedContextCache)
        self._predicates = None



    class AtomContext(ParserRuleContext):

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser

        def IDENTIFIER(self, i:int=None):
            if i is None:
                return self.getTokens(PDDLGrammarParser.IDENTIFIER)
            else:
                return self.getToken(PDDLGrammarParser.IDENTIFIER, i)

        def getRuleIndex(self):
            return PDDLGrammarParser.RULE_atom

        def accept(self, visitor:ParseTreeVisitor):
            if hasattr( visitor, "visitAtom" ):
                return visitor.visitAtom(self)
            else:
                return visitor.visitChildren(self)




    def atom(self):

        localctx = PDDLGrammarParser.AtomContext(self, self._ctx, self.state)
        self.enterRule(localctx, 0, self.RULE_atom)
        self._la = 0 # Token type
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 4
            self.match(PDDLGrammarParser.T__0)
            self.state = 8
            self._errHandler.sync(self)
            _la = self._input.LA(1)
            while _la==PDDLGrammarParser.IDENTIFIER:
                self.state = 5
                self.match(PDDLGrammarParser.IDENTIFIER)
                self.state = 10
                self._errHandler.sync(self)
                _la = self._input.LA(1)

            self.state = 11
            self.match(PDDLGrammarParser.T__1)
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

        def atom(self, i:int=None):
            if i is None:
                return self.getTypedRuleContexts(PDDLGrammarParser.AtomContext)
            else:
                return self.getTypedRuleContext(PDDLGrammarParser.AtomContext,i)


        def getRuleIndex(self):
            return PDDLGrammarParser.RULE_output

        def accept(self, visitor:ParseTreeVisitor):
            if hasattr( visitor, "visitOutput" ):
                return visitor.visitOutput(self)
            else:
                return visitor.visitChildren(self)




    def output(self):

        localctx = PDDLGrammarParser.OutputContext(self, self._ctx, self.state)
        self.enterRule(localctx, 2, self.RULE_output)
        self._la = 0 # Token type
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 16
            self._errHandler.sync(self)
            _la = self._input.LA(1)
            while _la==PDDLGrammarParser.T__0:
                self.state = 13
                self.atom()
                self.state = 18
                self._errHandler.sync(self)
                _la = self._input.LA(1)

        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx





