parser grammar ClingoParser;

options {tokenVocab=ClingoLexer;}

answer_set    : START model;
model         : predicate_atom* NEW_LINE;
output        : answer_set*;
predicate_atom: IDENTIFIER (TERMS_BEGIN term (COMMA term)* TERMS_END)?;
term          : IDENTIFIER | INTEGER_CONSTANT | predicate_atom | STRING_CONSTANT;
