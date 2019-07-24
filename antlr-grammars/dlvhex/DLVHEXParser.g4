parser grammar DLVHEXParser;

options {tokenVocab=DLVHEXLexer;}

answer_set    : IDENTIFIER (COMMA IDENTIFIER)* GROUND_QUERY_BEGIN REASONING BOOLEAN (DOT | witness) #GroundQuery |
                atoms #Model;
atoms         : ANSWER_SET_BEGIN (predicate_atom (COMMA predicate_atom)*)? ANSWER_SET_END cost?;
cost          : COST_BEGIN level (COMMA level)* COST_END;
level         : LEVEL_BEGIN INTEGER COLON INTEGER LEVEL_END;
output        : answer_set*;
predicate_atom: IDENTIFIER (TERMS_BEGIN term (COMMA term)* TERMS_END)?;
term          : IDENTIFIER | INTEGER | predicate_atom | STRING_CONSTANT;
witness       : WITNESS_LABEL atoms;
