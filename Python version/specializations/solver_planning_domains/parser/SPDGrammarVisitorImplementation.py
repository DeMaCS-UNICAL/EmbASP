from .SPDGrammarLexer import SPDGrammarLexer
from .SPDGrammarParser import SPDGrammarParser
from .SPDGrammarVisitor import SPDGrammarVisitor
from antlr4.CommonTokenStream import CommonTokenStream
from antlr4.InputStream import InputStream
from languages.pddl.Action import Action

class SPDGrammarVisitorImplementation(SPDGrammarVisitor):
    def __init__(self, actions):
        self._actions = actions
        self._ERROR_STATUS = -1
        self._errors = ""
        self._OK_STATUS = 1
        self._status = 0
        
    def visitPair(self, ctx):
        string = ctx.STRING().getText()
        valueContext = ctx.value()
        
        if self._status == 0 and string == '"status"':
            self._status = self._OK_STATUS if (valueContext.getText() == '"ok"') else self._ERROR_STATUS;
        elif self._status == self._ERROR_STATUS:
            if string =='"result"' :
                if isinstance(valueContext, SPDGrammarParser.ArrayValueContext) or isinstance(valueContext, SPDGrammarParser.ObjectValueContext):
                    return self.visitChildren(ctx);
                else:
                    self._errors += SPDGrammarVisitorImplementation._trim(valueContext.getText());
            elif string == '"error"':
                self._errors += SPDGrammarVisitorImplementation._trim(valueContext.getText());
        elif self._status == self._OK_STATUS:
            if string == '"name"':
                self._actions.append(Action(SPDGrammarVisitorImplementation._trim(valueContext.getText())));
            elif string == '"plan"' or string == '"result"':
                return self.visitChildren(ctx);

        return None;
    
    @staticmethod
    def _trim(string):
        return string[1:-1] if (string[0] == '"' and string[-1] == '"') else string
        
    @staticmethod
    def parse(actions, spdOutput):
        parser = SPDGrammarVisitorImplementation(actions)
        
        parser.visit(SPDGrammarParser(CommonTokenStream(SPDGrammarLexer(InputStream(spdOutput)))).json());
        
        return parser._errors #return bytes(parser._errors, "utf-8").decode("unicode_escape")