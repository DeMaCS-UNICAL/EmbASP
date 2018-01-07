parser grammar DLVHEXParser;

options {tokenVocab=DLVHEXLexer;}

answer_set    : START atoms* ANSWER_SET_END cost?;
atoms         : predicate_atom (COMMA predicate_atom)*;
cost          : COST_LABEL level (COMMA_IN_COST level)* COST_END;
level         : LEVEL_BEGIN INTEGER COLON INTEGER LEVEL_END;
output        : answer_set*;
predicate_atom: IDENTIFIER (TERMS_BEGIN term (COMMA term)* TERMS_END)?;
term          : IDENTIFIER | INTEGER_CONSTANT | predicate_atom | STRING_CONSTANT;
