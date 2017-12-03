# Generated from DLVParser.g4 by ANTLR 4.7
from antlr4 import *
from .DLVParser import DLVParser

# This class defines a complete generic visitor for a parse tree produced by DLVParser.

class DLVParserVisitor(ParseTreeVisitor):

    # Visit a parse tree produced by DLVParser#GroundQuery.
    def visitGroundQuery(self, ctx:DLVParser.GroundQueryContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by DLVParser#SimpleModel.
    def visitSimpleModel(self, ctx:DLVParser.SimpleModelContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by DLVParser#NonGroundQuery.
    def visitNonGroundQuery(self, ctx:DLVParser.NonGroundQueryContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by DLVParser#WeightedModel.
    def visitWeightedModel(self, ctx:DLVParser.WeightedModelContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by DLVParser#cost.
    def visitCost(self, ctx:DLVParser.CostContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by DLVParser#cost_level.
    def visitCost_level(self, ctx:DLVParser.Cost_levelContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by DLVParser#model.
    def visitModel(self, ctx:DLVParser.ModelContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by DLVParser#output.
    def visitOutput(self, ctx:DLVParser.OutputContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by DLVParser#predicate.
    def visitPredicate(self, ctx:DLVParser.PredicateContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by DLVParser#term.
    def visitTerm(self, ctx:DLVParser.TermContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by DLVParser#witness.
    def visitWitness(self, ctx:DLVParser.WitnessContext):
        return self.visitChildren(ctx)



del DLVParser