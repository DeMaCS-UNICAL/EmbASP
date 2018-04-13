# Generated from DLVHEXParser.g4 by ANTLR 4.7
# encoding: utf-8
from __future__ import print_function
from antlr4 import *
from io import StringIO
import sys

def serializedATN():
    with StringIO() as buf:
        buf.write(u"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3")
        buf.write(u"\27b\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7")
        buf.write(u"\4\b\t\b\4\t\t\t\3\2\3\2\3\2\7\2\26\n\2\f\2\16\2\31\13")
        buf.write(u"\2\3\2\3\2\3\2\3\2\3\2\5\2 \n\2\3\2\5\2#\n\2\3\3\3\3")
        buf.write(u"\3\3\3\3\7\3)\n\3\f\3\16\3,\13\3\5\3.\n\3\3\3\3\3\5\3")
        buf.write(u"\62\n\3\3\4\3\4\3\4\3\4\7\48\n\4\f\4\16\4;\13\4\3\4\3")
        buf.write(u"\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\7\6F\n\6\f\6\16\6I\13")
        buf.write(u"\6\3\7\3\7\3\7\3\7\3\7\7\7P\n\7\f\7\16\7S\13\7\3\7\3")
        buf.write(u"\7\5\7W\n\7\3\b\3\b\3\b\3\b\5\b]\n\b\3\t\3\t\3\t\3\t")
        buf.write(u"\2\2\n\2\4\6\b\n\f\16\20\2\2\2f\2\"\3\2\2\2\4$\3\2\2")
        buf.write(u"\2\6\63\3\2\2\2\b>\3\2\2\2\nG\3\2\2\2\fJ\3\2\2\2\16\\")
        buf.write(u"\3\2\2\2\20^\3\2\2\2\22\27\7\17\2\2\23\24\7\6\2\2\24")
        buf.write(u"\26\7\17\2\2\25\23\3\2\2\2\26\31\3\2\2\2\27\25\3\2\2")
        buf.write(u"\2\27\30\3\2\2\2\30\32\3\2\2\2\31\27\3\2\2\2\32\33\7")
        buf.write(u"\f\2\2\33\34\7\23\2\2\34\37\7\25\2\2\35 \7\24\2\2\36")
        buf.write(u" \5\20\t\2\37\35\3\2\2\2\37\36\3\2\2\2 #\3\2\2\2!#\5")
        buf.write(u"\4\3\2\"\22\3\2\2\2\"!\3\2\2\2#\3\3\2\2\2$-\7\r\2\2%")
        buf.write(u"*\5\f\7\2&\'\7\6\2\2\')\5\f\7\2(&\3\2\2\2),\3\2\2\2*")
        buf.write(u"(\3\2\2\2*+\3\2\2\2+.\3\2\2\2,*\3\2\2\2-%\3\2\2\2-.\3")
        buf.write(u"\2\2\2./\3\2\2\2/\61\7\16\2\2\60\62\5\6\4\2\61\60\3\2")
        buf.write(u"\2\2\61\62\3\2\2\2\62\5\3\2\2\2\63\64\7\7\2\2\649\5\b")
        buf.write(u"\5\2\65\66\7\6\2\2\668\5\b\5\2\67\65\3\2\2\28;\3\2\2")
        buf.write(u"\29\67\3\2\2\29:\3\2\2\2:<\3\2\2\2;9\3\2\2\2<=\7\b\2")
        buf.write(u"\2=\7\3\2\2\2>?\7\n\2\2?@\7\t\2\2@A\7\5\2\2AB\7\t\2\2")
        buf.write(u"BC\7\13\2\2C\t\3\2\2\2DF\5\2\2\2ED\3\2\2\2FI\3\2\2\2")
        buf.write(u"GE\3\2\2\2GH\3\2\2\2H\13\3\2\2\2IG\3\2\2\2JV\7\17\2\2")
        buf.write(u"KL\7\21\2\2LQ\5\16\b\2MN\7\6\2\2NP\5\16\b\2OM\3\2\2\2")
        buf.write(u"PS\3\2\2\2QO\3\2\2\2QR\3\2\2\2RT\3\2\2\2SQ\3\2\2\2TU")
        buf.write(u"\7\22\2\2UW\3\2\2\2VK\3\2\2\2VW\3\2\2\2W\r\3\2\2\2X]")
        buf.write(u"\7\17\2\2Y]\7\t\2\2Z]\5\f\7\2[]\7\20\2\2\\X\3\2\2\2\\")
        buf.write(u"Y\3\2\2\2\\Z\3\2\2\2\\[\3\2\2\2]\17\3\2\2\2^_\7\27\2")
        buf.write(u"\2_`\5\4\3\2`\21\3\2\2\2\r\27\37\"*-\619GQV\\")
        return buf.getvalue()


class DLVHEXParser ( Parser ):

    grammarFileName = "DLVHEXParser.g4"

    atn = ATNDeserializer().deserialize(serializedATN())

    decisionsToDFA = [ DFA(ds, i) for i, ds in enumerate(atn.decisionToState) ]

    sharedContextCache = PredictionContextCache()

    literalNames = [ u"<INVALID>", u"<INVALID>", u"<INVALID>", u"':'", u"','", 
                     u"'<'", u"'>'", u"<INVALID>", u"'['", u"']'", u"' is '", 
                     u"'{'", u"'}'", u"<INVALID>", u"<INVALID>", u"'('", 
                     u"')'", u"<INVALID>", u"'.'", u"<INVALID>", u"<INVALID>", 
                     u"', evidenced by'" ]

    symbolicNames = [ u"<INVALID>", u"HEADER", u"WHITE_SPACE", u"COLON", 
                      u"COMMA", u"COST_BEGIN", u"COST_END", u"INTEGER", 
                      u"LEVEL_BEGIN", u"LEVEL_END", u"GROUND_QUERY_BEGIN", 
                      u"ANSWER_SET_BEGIN", u"ANSWER_SET_END", u"IDENTIFIER", 
                      u"STRING_CONSTANT", u"TERMS_BEGIN", u"TERMS_END", 
                      u"REASONING", u"DOT", u"BOOLEAN", u"WHITESPACE_IN_GROUND_QUERY", 
                      u"WITNESS_LABEL" ]

    RULE_answer_set = 0
    RULE_atoms = 1
    RULE_cost = 2
    RULE_level = 3
    RULE_output = 4
    RULE_predicate_atom = 5
    RULE_term = 6
    RULE_witness = 7

    ruleNames =  [ u"answer_set", u"atoms", u"cost", u"level", u"output", 
                   u"predicate_atom", u"term", u"witness" ]

    EOF = Token.EOF
    HEADER=1
    WHITE_SPACE=2
    COLON=3
    COMMA=4
    COST_BEGIN=5
    COST_END=6
    INTEGER=7
    LEVEL_BEGIN=8
    LEVEL_END=9
    GROUND_QUERY_BEGIN=10
    ANSWER_SET_BEGIN=11
    ANSWER_SET_END=12
    IDENTIFIER=13
    STRING_CONSTANT=14
    TERMS_BEGIN=15
    TERMS_END=16
    REASONING=17
    DOT=18
    BOOLEAN=19
    WHITESPACE_IN_GROUND_QUERY=20
    WITNESS_LABEL=21

    def __init__(self, input, output=sys.stdout):
        super(DLVHEXParser, self).__init__(input, output=output)
        self.checkVersion("4.7")
        self._interp = ParserATNSimulator(self, self.atn, self.decisionsToDFA, self.sharedContextCache)
        self._predicates = None



    class Answer_setContext(ParserRuleContext):

        def __init__(self, parser, parent=None, invokingState=-1):
            super(DLVHEXParser.Answer_setContext, self).__init__(parent, invokingState)
            self.parser = parser


        def getRuleIndex(self):
            return DLVHEXParser.RULE_answer_set

     
        def copyFrom(self, ctx):
            super(DLVHEXParser.Answer_setContext, self).copyFrom(ctx)



    class GroundQueryContext(Answer_setContext):

        def __init__(self, parser, ctx): # actually a DLVHEXParser.Answer_setContext)
            super(DLVHEXParser.GroundQueryContext, self).__init__(parser)
            self.copyFrom(ctx)

        def IDENTIFIER(self, i=None):
            if i is None:
                return self.getTokens(DLVHEXParser.IDENTIFIER)
            else:
                return self.getToken(DLVHEXParser.IDENTIFIER, i)
        def GROUND_QUERY_BEGIN(self):
            return self.getToken(DLVHEXParser.GROUND_QUERY_BEGIN, 0)
        def REASONING(self):
            return self.getToken(DLVHEXParser.REASONING, 0)
        def BOOLEAN(self):
            return self.getToken(DLVHEXParser.BOOLEAN, 0)
        def DOT(self):
            return self.getToken(DLVHEXParser.DOT, 0)
        def witness(self):
            return self.getTypedRuleContext(DLVHEXParser.WitnessContext,0)

        def COMMA(self, i=None):
            if i is None:
                return self.getTokens(DLVHEXParser.COMMA)
            else:
                return self.getToken(DLVHEXParser.COMMA, i)

        def accept(self, visitor):
            if hasattr(visitor, "visitGroundQuery"):
                return visitor.visitGroundQuery(self)
            else:
                return visitor.visitChildren(self)


    class ModelContext(Answer_setContext):

        def __init__(self, parser, ctx): # actually a DLVHEXParser.Answer_setContext)
            super(DLVHEXParser.ModelContext, self).__init__(parser)
            self.copyFrom(ctx)

        def atoms(self):
            return self.getTypedRuleContext(DLVHEXParser.AtomsContext,0)


        def accept(self, visitor):
            if hasattr(visitor, "visitModel"):
                return visitor.visitModel(self)
            else:
                return visitor.visitChildren(self)



    def answer_set(self):

        localctx = DLVHEXParser.Answer_setContext(self, self._ctx, self.state)
        self.enterRule(localctx, 0, self.RULE_answer_set)
        self._la = 0 # Token type
        try:
            self.state = 32
            self._errHandler.sync(self)
            token = self._input.LA(1)
            if token in [DLVHEXParser.IDENTIFIER]:
                localctx = DLVHEXParser.GroundQueryContext(self, localctx)
                self.enterOuterAlt(localctx, 1)
                self.state = 16
                self.match(DLVHEXParser.IDENTIFIER)
                self.state = 21
                self._errHandler.sync(self)
                _la = self._input.LA(1)
                while _la==DLVHEXParser.COMMA:
                    self.state = 17
                    self.match(DLVHEXParser.COMMA)
                    self.state = 18
                    self.match(DLVHEXParser.IDENTIFIER)
                    self.state = 23
                    self._errHandler.sync(self)
                    _la = self._input.LA(1)

                self.state = 24
                self.match(DLVHEXParser.GROUND_QUERY_BEGIN)
                self.state = 25
                self.match(DLVHEXParser.REASONING)
                self.state = 26
                self.match(DLVHEXParser.BOOLEAN)
                self.state = 29
                self._errHandler.sync(self)
                token = self._input.LA(1)
                if token in [DLVHEXParser.DOT]:
                    self.state = 27
                    self.match(DLVHEXParser.DOT)
                    pass
                elif token in [DLVHEXParser.WITNESS_LABEL]:
                    self.state = 28
                    self.witness()
                    pass
                else:
                    raise NoViableAltException(self)

                pass
            elif token in [DLVHEXParser.ANSWER_SET_BEGIN]:
                localctx = DLVHEXParser.ModelContext(self, localctx)
                self.enterOuterAlt(localctx, 2)
                self.state = 31
                self.atoms()
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

    class AtomsContext(ParserRuleContext):

        def __init__(self, parser, parent=None, invokingState=-1):
            super(DLVHEXParser.AtomsContext, self).__init__(parent, invokingState)
            self.parser = parser

        def ANSWER_SET_BEGIN(self):
            return self.getToken(DLVHEXParser.ANSWER_SET_BEGIN, 0)

        def ANSWER_SET_END(self):
            return self.getToken(DLVHEXParser.ANSWER_SET_END, 0)

        def predicate_atom(self, i=None):
            if i is None:
                return self.getTypedRuleContexts(DLVHEXParser.Predicate_atomContext)
            else:
                return self.getTypedRuleContext(DLVHEXParser.Predicate_atomContext,i)


        def cost(self):
            return self.getTypedRuleContext(DLVHEXParser.CostContext,0)


        def COMMA(self, i=None):
            if i is None:
                return self.getTokens(DLVHEXParser.COMMA)
            else:
                return self.getToken(DLVHEXParser.COMMA, i)

        def getRuleIndex(self):
            return DLVHEXParser.RULE_atoms

        def accept(self, visitor):
            if hasattr(visitor, "visitAtoms"):
                return visitor.visitAtoms(self)
            else:
                return visitor.visitChildren(self)




    def atoms(self):

        localctx = DLVHEXParser.AtomsContext(self, self._ctx, self.state)
        self.enterRule(localctx, 2, self.RULE_atoms)
        self._la = 0 # Token type
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 34
            self.match(DLVHEXParser.ANSWER_SET_BEGIN)
            self.state = 43
            self._errHandler.sync(self)
            _la = self._input.LA(1)
            if _la==DLVHEXParser.IDENTIFIER:
                self.state = 35
                self.predicate_atom()
                self.state = 40
                self._errHandler.sync(self)
                _la = self._input.LA(1)
                while _la==DLVHEXParser.COMMA:
                    self.state = 36
                    self.match(DLVHEXParser.COMMA)
                    self.state = 37
                    self.predicate_atom()
                    self.state = 42
                    self._errHandler.sync(self)
                    _la = self._input.LA(1)



            self.state = 45
            self.match(DLVHEXParser.ANSWER_SET_END)
            self.state = 47
            self._errHandler.sync(self)
            _la = self._input.LA(1)
            if _la==DLVHEXParser.COST_BEGIN:
                self.state = 46
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
            super(DLVHEXParser.CostContext, self).__init__(parent, invokingState)
            self.parser = parser

        def COST_BEGIN(self):
            return self.getToken(DLVHEXParser.COST_BEGIN, 0)

        def level(self, i=None):
            if i is None:
                return self.getTypedRuleContexts(DLVHEXParser.LevelContext)
            else:
                return self.getTypedRuleContext(DLVHEXParser.LevelContext,i)


        def COST_END(self):
            return self.getToken(DLVHEXParser.COST_END, 0)

        def COMMA(self, i=None):
            if i is None:
                return self.getTokens(DLVHEXParser.COMMA)
            else:
                return self.getToken(DLVHEXParser.COMMA, i)

        def getRuleIndex(self):
            return DLVHEXParser.RULE_cost

        def accept(self, visitor):
            if hasattr(visitor, "visitCost"):
                return visitor.visitCost(self)
            else:
                return visitor.visitChildren(self)




    def cost(self):

        localctx = DLVHEXParser.CostContext(self, self._ctx, self.state)
        self.enterRule(localctx, 4, self.RULE_cost)
        self._la = 0 # Token type
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 49
            self.match(DLVHEXParser.COST_BEGIN)
            self.state = 50
            self.level()
            self.state = 55
            self._errHandler.sync(self)
            _la = self._input.LA(1)
            while _la==DLVHEXParser.COMMA:
                self.state = 51
                self.match(DLVHEXParser.COMMA)
                self.state = 52
                self.level()
                self.state = 57
                self._errHandler.sync(self)
                _la = self._input.LA(1)

            self.state = 58
            self.match(DLVHEXParser.COST_END)
        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx

    class LevelContext(ParserRuleContext):

        def __init__(self, parser, parent=None, invokingState=-1):
            super(DLVHEXParser.LevelContext, self).__init__(parent, invokingState)
            self.parser = parser

        def LEVEL_BEGIN(self):
            return self.getToken(DLVHEXParser.LEVEL_BEGIN, 0)

        def INTEGER(self, i=None):
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

        def accept(self, visitor):
            if hasattr(visitor, "visitLevel"):
                return visitor.visitLevel(self)
            else:
                return visitor.visitChildren(self)




    def level(self):

        localctx = DLVHEXParser.LevelContext(self, self._ctx, self.state)
        self.enterRule(localctx, 6, self.RULE_level)
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 60
            self.match(DLVHEXParser.LEVEL_BEGIN)
            self.state = 61
            self.match(DLVHEXParser.INTEGER)
            self.state = 62
            self.match(DLVHEXParser.COLON)
            self.state = 63
            self.match(DLVHEXParser.INTEGER)
            self.state = 64
            self.match(DLVHEXParser.LEVEL_END)
        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx

    class OutputContext(ParserRuleContext):

        def __init__(self, parser, parent=None, invokingState=-1):
            super(DLVHEXParser.OutputContext, self).__init__(parent, invokingState)
            self.parser = parser

        def answer_set(self, i=None):
            if i is None:
                return self.getTypedRuleContexts(DLVHEXParser.Answer_setContext)
            else:
                return self.getTypedRuleContext(DLVHEXParser.Answer_setContext,i)


        def getRuleIndex(self):
            return DLVHEXParser.RULE_output

        def accept(self, visitor):
            if hasattr(visitor, "visitOutput"):
                return visitor.visitOutput(self)
            else:
                return visitor.visitChildren(self)




    def output(self):

        localctx = DLVHEXParser.OutputContext(self, self._ctx, self.state)
        self.enterRule(localctx, 8, self.RULE_output)
        self._la = 0 # Token type
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 69
            self._errHandler.sync(self)
            _la = self._input.LA(1)
            while _la==DLVHEXParser.ANSWER_SET_BEGIN or _la==DLVHEXParser.IDENTIFIER:
                self.state = 66
                self.answer_set()
                self.state = 71
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
            super(DLVHEXParser.Predicate_atomContext, self).__init__(parent, invokingState)
            self.parser = parser

        def IDENTIFIER(self):
            return self.getToken(DLVHEXParser.IDENTIFIER, 0)

        def TERMS_BEGIN(self):
            return self.getToken(DLVHEXParser.TERMS_BEGIN, 0)

        def term(self, i=None):
            if i is None:
                return self.getTypedRuleContexts(DLVHEXParser.TermContext)
            else:
                return self.getTypedRuleContext(DLVHEXParser.TermContext,i)


        def TERMS_END(self):
            return self.getToken(DLVHEXParser.TERMS_END, 0)

        def COMMA(self, i=None):
            if i is None:
                return self.getTokens(DLVHEXParser.COMMA)
            else:
                return self.getToken(DLVHEXParser.COMMA, i)

        def getRuleIndex(self):
            return DLVHEXParser.RULE_predicate_atom

        def accept(self, visitor):
            if hasattr(visitor, "visitPredicate_atom"):
                return visitor.visitPredicate_atom(self)
            else:
                return visitor.visitChildren(self)




    def predicate_atom(self):

        localctx = DLVHEXParser.Predicate_atomContext(self, self._ctx, self.state)
        self.enterRule(localctx, 10, self.RULE_predicate_atom)
        self._la = 0 # Token type
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 72
            self.match(DLVHEXParser.IDENTIFIER)
            self.state = 84
            self._errHandler.sync(self)
            _la = self._input.LA(1)
            if _la==DLVHEXParser.TERMS_BEGIN:
                self.state = 73
                self.match(DLVHEXParser.TERMS_BEGIN)
                self.state = 74
                self.term()
                self.state = 79
                self._errHandler.sync(self)
                _la = self._input.LA(1)
                while _la==DLVHEXParser.COMMA:
                    self.state = 75
                    self.match(DLVHEXParser.COMMA)
                    self.state = 76
                    self.term()
                    self.state = 81
                    self._errHandler.sync(self)
                    _la = self._input.LA(1)

                self.state = 82
                self.match(DLVHEXParser.TERMS_END)


        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx

    class TermContext(ParserRuleContext):

        def __init__(self, parser, parent=None, invokingState=-1):
            super(DLVHEXParser.TermContext, self).__init__(parent, invokingState)
            self.parser = parser

        def IDENTIFIER(self):
            return self.getToken(DLVHEXParser.IDENTIFIER, 0)

        def INTEGER(self):
            return self.getToken(DLVHEXParser.INTEGER, 0)

        def predicate_atom(self):
            return self.getTypedRuleContext(DLVHEXParser.Predicate_atomContext,0)


        def STRING_CONSTANT(self):
            return self.getToken(DLVHEXParser.STRING_CONSTANT, 0)

        def getRuleIndex(self):
            return DLVHEXParser.RULE_term

        def accept(self, visitor):
            if hasattr(visitor, "visitTerm"):
                return visitor.visitTerm(self)
            else:
                return visitor.visitChildren(self)




    def term(self):

        localctx = DLVHEXParser.TermContext(self, self._ctx, self.state)
        self.enterRule(localctx, 12, self.RULE_term)
        try:
            self.state = 90
            self._errHandler.sync(self)
            la_ = self._interp.adaptivePredict(self._input,10,self._ctx)
            if la_ == 1:
                self.enterOuterAlt(localctx, 1)
                self.state = 86
                self.match(DLVHEXParser.IDENTIFIER)
                pass

            elif la_ == 2:
                self.enterOuterAlt(localctx, 2)
                self.state = 87
                self.match(DLVHEXParser.INTEGER)
                pass

            elif la_ == 3:
                self.enterOuterAlt(localctx, 3)
                self.state = 88
                self.predicate_atom()
                pass

            elif la_ == 4:
                self.enterOuterAlt(localctx, 4)
                self.state = 89
                self.match(DLVHEXParser.STRING_CONSTANT)
                pass


        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx

    class WitnessContext(ParserRuleContext):

        def __init__(self, parser, parent=None, invokingState=-1):
            super(DLVHEXParser.WitnessContext, self).__init__(parent, invokingState)
            self.parser = parser

        def WITNESS_LABEL(self):
            return self.getToken(DLVHEXParser.WITNESS_LABEL, 0)

        def atoms(self):
            return self.getTypedRuleContext(DLVHEXParser.AtomsContext,0)


        def getRuleIndex(self):
            return DLVHEXParser.RULE_witness

        def accept(self, visitor):
            if hasattr(visitor, "visitWitness"):
                return visitor.visitWitness(self)
            else:
                return visitor.visitChildren(self)




    def witness(self):

        localctx = DLVHEXParser.WitnessContext(self, self._ctx, self.state)
        self.enterRule(localctx, 14, self.RULE_witness)
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 92
            self.match(DLVHEXParser.WITNESS_LABEL)
            self.state = 93
            self.atoms()
        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx





