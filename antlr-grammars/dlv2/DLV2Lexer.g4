lexer grammar DLV2Lexer;

START     : '{'-> mode(MODEL);
COST_LABEL: 'COST 'INT'@'INT-> mode(COST);
ANY       : .+?-> skip;
IGNORE    : (NL|WS)-> skip;

mode COST;
AT         : '@';
INTEGER    : INT;
NEW_LINE   : NL-> mode(DEFAULT_MODE);
BLANK_SPACE: WS-> skip;

mode MODEL;
COMMA           : ',';
INTEGER_CONSTANT: INT;
IDENTIFIER      : [a-zA-Z][a-zA-Z0-9_]*;
MODEL_END       : '}'-> mode(DEFAULT_MODE);
STRING_CONSTANT : '"'~["]*'"';
TERMS_BEGIN     : '(';
TERMS_END       : ')';
WHITE_SPACE     : (WS|NL)-> skip;

fragment INT: '0'|[1-9][0-9]*;
fragment NL : [\n\r];
fragment WS : [ \t];