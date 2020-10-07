lexer grammar IDLVLexer;

IGNORE    		: (NL|WS)-> skip;
COMMA           : ',';
INTEGER_CONSTANT: INT;
ATOM_END 		: '.';
IDENTIFIER      : [a-zA-Z][a-zA-Z0-9_]*;
STRING_CONSTANT : '"'~["]*'"';
TERMS_BEGIN     : '(';
TERMS_END       : ')';

fragment INT: '0'|[1-9][0-9]*;
fragment NL : [\n\r];
fragment WS : [ \t];