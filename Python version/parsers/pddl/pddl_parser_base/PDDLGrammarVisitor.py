# Generated from PDDLGrammar.g4 by ANTLR 4.7
from antlr4 import *

# This class defines a complete generic visitor for a parse tree produced by PDDLGrammarParser.

class PDDLGrammarVisitor(ParseTreeVisitor):

    # Visit a parse tree produced by PDDLGrammarParser#atom.
    def visitAtom(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PDDLGrammarParser#output.
    def visitOutput(self, ctx):
        return self.visitChildren(ctx)


