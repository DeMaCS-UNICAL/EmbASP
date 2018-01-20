# Generated from SPDGrammar.g4 by ANTLR 4.7
from antlr4 import *
from .SPDGrammarParser import SPDGrammarParser

# This class defines a complete generic visitor for a parse tree produced by SPDGrammarParser.

class SPDGrammarVisitor(ParseTreeVisitor):

    # Visit a parse tree produced by SPDGrammarParser#array.
    def visitArray(self, ctx:SPDGrammarParser.ArrayContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SPDGrammarParser#json.
    def visitJson(self, ctx:SPDGrammarParser.JsonContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SPDGrammarParser#oBjEcT.
    def visitOBjEcT(self, ctx:SPDGrammarParser.OBjEcTContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SPDGrammarParser#pair.
    def visitPair(self, ctx:SPDGrammarParser.PairContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SPDGrammarParser#ArrayValue.
    def visitArrayValue(self, ctx:SPDGrammarParser.ArrayValueContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SPDGrammarParser#BooleanValue.
    def visitBooleanValue(self, ctx:SPDGrammarParser.BooleanValueContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SPDGrammarParser#IntegerValue.
    def visitIntegerValue(self, ctx:SPDGrammarParser.IntegerValueContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SPDGrammarParser#NullValue.
    def visitNullValue(self, ctx:SPDGrammarParser.NullValueContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SPDGrammarParser#ObjectValue.
    def visitObjectValue(self, ctx:SPDGrammarParser.ObjectValueContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SPDGrammarParser#StringValue.
    def visitStringValue(self, ctx:SPDGrammarParser.StringValueContext):
        return self.visitChildren(ctx)



del SPDGrammarParser