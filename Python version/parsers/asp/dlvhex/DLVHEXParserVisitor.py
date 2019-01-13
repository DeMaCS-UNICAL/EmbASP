# Generated from DLVHEXParser.g4 by ANTLR 4.7
from antlr4 import *

# This class defines a complete generic visitor for a parse tree produced by DLVHEXParser.

class DLVHEXParserVisitor(ParseTreeVisitor):

    # Visit a parse tree produced by DLVHEXParser#GroundQuery.
    def visitGroundQuery(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by DLVHEXParser#Model.
    def visitModel(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by DLVHEXParser#atoms.
    def visitAtoms(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by DLVHEXParser#cost.
    def visitCost(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by DLVHEXParser#level.
    def visitLevel(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by DLVHEXParser#output.
    def visitOutput(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by DLVHEXParser#predicate_atom.
    def visitPredicate_atom(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by DLVHEXParser#term.
    def visitTerm(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by DLVHEXParser#witness.
    def visitWitness(self, ctx):
        return self.visitChildren(ctx)


