grammar DatalogGrammar;

IDENTIFIER : [a-zA-Z][a-zA-Z0-9_]*;
INTEGER    : '0'|[1-9][0-9]*;
STRING     : '"'~["]*'"';
WHITESPACE : [ \n\r\t]-> skip;

output        : predicate_atom*;
predicate_atom: IDENTIFIER ('(' term (',' term)* ')')?;
term          : IDENTIFIER | INTEGER | STRING;