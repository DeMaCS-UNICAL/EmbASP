# Generated from SPDGrammar.g4 by ANTLR 4.7
from antlr4 import *

# This class defines a complete generic visitor for a parse tree produced by SPDGrammarParser.

class SPDGrammarVisitor(ParseTreeVisitor):

    # Visit a parse tree produced by SPDGrammarParser#array.
    def visitArray(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SPDGrammarParser#json.
    def visitJson(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SPDGrammarParser#oBjEcT.
    def visitOBjEcT(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SPDGrammarParser#pair.
    def visitPair(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SPDGrammarParser#ArrayValue.
    def visitArrayValue(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SPDGrammarParser#BooleanValue.
    def visitBooleanValue(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SPDGrammarParser#IntegerValue.
    def visitIntegerValue(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SPDGrammarParser#NullValue.
    def visitNullValue(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SPDGrammarParser#ObjectValue.
    def visitObjectValue(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SPDGrammarParser#StringValue.
    def visitStringValue(self, ctx):
        return self.visitChildren(ctx)


