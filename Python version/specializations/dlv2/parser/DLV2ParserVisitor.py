# Generated from DLV2Parser.g4 by ANTLR 4.7
from antlr4 import *

# This class defines a complete generic visitor for a parse tree produced by DLV2Parser.

class DLV2ParserVisitor(ParseTreeVisitor):

    # Visit a parse tree produced by DLV2Parser#answer_set.
    def visitAnswer_set(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by DLV2Parser#cost.
    def visitCost(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by DLV2Parser#level.
    def visitLevel(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by DLV2Parser#model.
    def visitModel(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by DLV2Parser#output.
    def visitOutput(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by DLV2Parser#predicate_atom.
    def visitPredicate_atom(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by DLV2Parser#term.
    def visitTerm(self, ctx):
        return self.visitChildren(ctx)


