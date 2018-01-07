lexer grammar DLVHEXLexer;

START     : '{'-> mode(ANSWER_SET);
COST_LABEL: '<'-> mode(COST);
ANY       : .+?-> skip;
IGNORE    : (NL|WS)-> skip;

mode ANSWER_SET;
COMMA           : ',';
INTEGER_CONSTANT: INT;
IDENTIFIER      : [a-zA-Z][a-zA-Z0-9_]*;
ANSWER_SET_END  : '}'-> mode(DEFAULT_MODE);
STRING_CONSTANT : '"'~["]*'"';
TERMS_BEGIN     : '(';
TERMS_END       : ')';
WHITE_SPACE     : (WS|NL)-> skip;

mode COST;
BLANK_SPACE  : (NL|WS)-> skip;
COLON        : ':';
COMMA_IN_COST: ',';
COST_END     : '>'-> mode(DEFAULT_MODE);
INTEGER      : INT;
LEVEL_BEGIN  : '[';
LEVEL_END    : ']';

fragment INT: '0'|[1-9][0-9]*;
fragment NL : [\n\r];
fragment WS : [ \t];