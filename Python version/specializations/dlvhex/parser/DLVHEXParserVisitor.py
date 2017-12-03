# Generated from DLVHEXParser.g4 by ANTLR 4.7
from antlr4 import *
from .DLVHEXParser import DLVHEXParser

# This class defines a complete generic visitor for a parse tree produced by DLVHEXParser.

class DLVHEXParserVisitor(ParseTreeVisitor):

    # Visit a parse tree produced by DLVHEXParser#answer_set.
    def visitAnswer_set(self, ctx:DLVHEXParser.Answer_setContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by DLVHEXParser#atoms.
    def visitAtoms(self, ctx:DLVHEXParser.AtomsContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by DLVHEXParser#cost.
    def visitCost(self, ctx:DLVHEXParser.CostContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by DLVHEXParser#level.
    def visitLevel(self, ctx:DLVHEXParser.LevelContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by DLVHEXParser#output.
    def visitOutput(self, ctx:DLVHEXParser.OutputContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by DLVHEXParser#predicate_atom.
    def visitPredicate_atom(self, ctx:DLVHEXParser.Predicate_atomContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by DLVHEXParser#term.
    def visitTerm(self, ctx:DLVHEXParser.TermContext):
        return self.visitChildren(ctx)



del DLVHEXParser