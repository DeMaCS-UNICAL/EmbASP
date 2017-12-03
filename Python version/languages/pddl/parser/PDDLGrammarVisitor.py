# Generated from PDDLGrammar.g4 by ANTLR 4.7
from antlr4 import *
from .PDDLGrammarParser import PDDLGrammarParser

# This class defines a complete generic visitor for a parse tree produced by PDDLGrammarParser.

class PDDLGrammarVisitor(ParseTreeVisitor):

    # Visit a parse tree produced by PDDLGrammarParser#atom.
    def visitAtom(self, ctx:PDDLGrammarParser.AtomContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by PDDLGrammarParser#output.
    def visitOutput(self, ctx:PDDLGrammarParser.OutputContext):
        return self.visitChildren(ctx)



del PDDLGrammarParser