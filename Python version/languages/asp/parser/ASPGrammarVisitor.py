# Generated from ASPGrammar.g4 by ANTLR 4.7
from antlr4 import *
from .ASPGrammarParser import ASPGrammarParser

# This class defines a complete generic visitor for a parse tree produced by ASPGrammarParser.

class ASPGrammarVisitor(ParseTreeVisitor):

    # Visit a parse tree produced by ASPGrammarParser#output.
    def visitOutput(self, ctx:ASPGrammarParser.OutputContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by ASPGrammarParser#predicate_atom.
    def visitPredicate_atom(self, ctx:ASPGrammarParser.Predicate_atomContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by ASPGrammarParser#term.
    def visitTerm(self, ctx:ASPGrammarParser.TermContext):
        return self.visitChildren(ctx)



del ASPGrammarParser