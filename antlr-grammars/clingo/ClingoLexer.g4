lexer grammar ClingoLexer;

START: 'Answer: 'INT NL-> mode(SIGNIFICANT);
ANY  : .*?NL-> skip;

mode SIGNIFICANT;
COMMA           : ',';
INTEGER_CONSTANT: INT;
NEW_LINE        : NL('Optimization:' (WS INT)* NL)?-> mode(DEFAULT_MODE);
IDENTIFIER      : [a-zA-Z][a-zA-Z0-9_]*;
STRING_CONSTANT : '"'~["]*'"';
TERMS_BEGIN     : '(';
TERMS_END       : ')';
WHITE_SPACE     : WS-> skip;

fragment INT: '0'|[1-9][0-9]*;
fragment NL : ('\n'|'\r'|'\r\n');
fragment WS : [ \t];