lexer grammar DLVHEXLexer;

HEADER     : 'DLVHEX '.*?NL-> skip;
WHITE_SPACE: (NL|WS)-> skip;

COLON      : ':';
COMMA      : ',';
COST_BEGIN : '<';
COST_END   : '>';
INTEGER    : '0'|[1-9][0-9]*;
LEVEL_BEGIN: '[';
LEVEL_END  : ']';

GROUND_QUERY_BEGIN: ' is '-> mode(IN_GROUND_QUERY);

ANSWER_SET_BEGIN: '{';
ANSWER_SET_END  : '}';
IDENTIFIER      : [a-zA-Z][a-zA-Z0-9_]*;
STRING_CONSTANT : '"'~["]*'"';
TERMS_BEGIN     : '(';
TERMS_END       : ')';

mode IN_GROUND_QUERY;
REASONING                 : 'bravely'|'cautiously';
DOT                       : '.'-> mode(DEFAULT_MODE);
BOOLEAN                   : 'false'|'true';
WHITESPACE_IN_GROUND_QUERY: (NL|WS)-> skip;
WITNESS_LABEL             : ', evidenced by'-> mode(DEFAULT_MODE);

fragment NL: [\n\r];
fragment WS: [ \t];