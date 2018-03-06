# Generated from DLVParser.g4 by ANTLR 4.7
from antlr4 import *

# This class defines a complete generic visitor for a parse tree produced by DLVParser.

class DLVParserVisitor(ParseTreeVisitor):

    # Visit a parse tree produced by DLVParser#GroundQuery.
    def visitGroundQuery(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by DLVParser#SimpleModel.
    def visitSimpleModel(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by DLVParser#NonGroundQuery.
    def visitNonGroundQuery(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by DLVParser#WeightedModel.
    def visitWeightedModel(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by DLVParser#cost.
    def visitCost(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by DLVParser#cost_level.
    def visitCost_level(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by DLVParser#model.
    def visitModel(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by DLVParser#output.
    def visitOutput(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by DLVParser#predicate.
    def visitPredicate(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by DLVParser#term.
    def visitTerm(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by DLVParser#witness.
    def visitWitness(self, ctx):
        return self.visitChildren(ctx)


