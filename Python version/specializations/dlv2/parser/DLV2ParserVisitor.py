# Generated from DLV2Parser.g4 by ANTLR 4.7
from antlr4 import *
from .DLV2Parser import DLV2Parser

# This class defines a complete generic visitor for a parse tree produced by DLV2Parser.

class DLV2ParserVisitor(ParseTreeVisitor):

    # Visit a parse tree produced by DLV2Parser#answer_set.
    def visitAnswer_set(self, ctx:DLV2Parser.Answer_setContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by DLV2Parser#cost.
    def visitCost(self, ctx:DLV2Parser.CostContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by DLV2Parser#level.
    def visitLevel(self, ctx:DLV2Parser.LevelContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by DLV2Parser#model.
    def visitModel(self, ctx:DLV2Parser.ModelContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by DLV2Parser#output.
    def visitOutput(self, ctx:DLV2Parser.OutputContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by DLV2Parser#predicate_atom.
    def visitPredicate_atom(self, ctx:DLV2Parser.Predicate_atomContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by DLV2Parser#term.
    def visitTerm(self, ctx:DLV2Parser.TermContext):
        return self.visitChildren(ctx)



del DLV2Parser