# Generated from ClingoParser.g4 by ANTLR 4.7
from antlr4 import *
from .ClingoParser import ClingoParser

# This class defines a complete generic visitor for a parse tree produced by ClingoParser.

class ClingoParserVisitor(ParseTreeVisitor):

    # Visit a parse tree produced by ClingoParser#answer_set.
    def visitAnswer_set(self, ctx:ClingoParser.Answer_setContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by ClingoParser#model.
    def visitModel(self, ctx:ClingoParser.ModelContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by ClingoParser#output.
    def visitOutput(self, ctx:ClingoParser.OutputContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by ClingoParser#predicate_atom.
    def visitPredicate_atom(self, ctx:ClingoParser.Predicate_atomContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by ClingoParser#term.
    def visitTerm(self, ctx:ClingoParser.TermContext):
        return self.visitChildren(ctx)



del ClingoParser