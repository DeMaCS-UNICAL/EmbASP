parser grammar DLV2Parser;

options {tokenVocab=DLV2Lexer;}

answer_set    : START model cost?;
cost          : COST_LABEL level* NEW_LINE;
level         : INTEGER AT INTEGER;
model         : (predicate_atom (COMMA predicate_atom)*)? MODEL_END;
output        : answer_set*;
predicate_atom: IDENTIFIER (TERMS_BEGIN term (COMMA term)* TERMS_END)?;
term          : IDENTIFIER | INTEGER_CONSTANT | predicate_atom | STRING_CONSTANT;
