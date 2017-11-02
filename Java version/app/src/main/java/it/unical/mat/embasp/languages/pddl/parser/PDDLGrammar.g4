grammar PDDLGrammar;

IDENTIFIER: [A-Za-z0-9\-_]+;
SEPARATOR : [ \n\r\t]-> skip;

atom  : '(' IDENTIFIER* ')';
output: atom*;