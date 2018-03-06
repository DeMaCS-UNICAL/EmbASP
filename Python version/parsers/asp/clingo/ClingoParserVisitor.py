# Generated from ClingoParser.g4 by ANTLR 4.7
from antlr4 import *

# This class defines a complete generic visitor for a parse tree produced by ClingoParser.

class ClingoParserVisitor(ParseTreeVisitor):

    # Visit a parse tree produced by ClingoParser#answer_set.
    def visitAnswer_set(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by ClingoParser#model.
    def visitModel(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by ClingoParser#output.
    def visitOutput(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by ClingoParser#predicate_atom.
    def visitPredicate_atom(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by ClingoParser#term.
    def visitTerm(self, ctx):
        return self.visitChildren(ctx)


