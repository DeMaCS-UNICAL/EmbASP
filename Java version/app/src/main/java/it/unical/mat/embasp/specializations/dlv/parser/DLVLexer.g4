lexer grammar DLVLexer;

COLON           : ':';
COST_BEGIN      : 'Cost ([Weight:Level]): <';
COST_END        : '>';
COST_LEVEL_BEGIN: '[';
COST_LEVEL_END  : ']';

GROUND_QUERY_BEGIN: ' is '-> mode(IN_GROUND_QUERY);

MODEL_BEGIN         : '{';
MODEL_END           : '}';
WEIGHTED_MODEL_LABEL: 'Best model:';

COMMA           : ',';
IDENTIFIER      : [a-zA-Z][a-zA-Z0-9_]*;
INTEGER_CONSTANT: '0'|[1-9][0-9]*;
STRING_CONSTANT : '"'~["]*'"';
TERMS_BEGIN     : '(';
TERMS_END       : ')';
WHITESPACE      : WS-> skip;

mode IN_GROUND_QUERY;
REASONING                 : 'bravely'|'cautiously';
DOT                       : '.'-> mode(DEFAULT_MODE);
BOOLEAN                   : 'false'|'true';
WHITESPACE_IN_GROUND_QUERY: WS-> skip;
WITNESS_LABEL             : ', evidenced by'-> mode(DEFAULT_MODE);

fragment WS: [ \n\r\t];