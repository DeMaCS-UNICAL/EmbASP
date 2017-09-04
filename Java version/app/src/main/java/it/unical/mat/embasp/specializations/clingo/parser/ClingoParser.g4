parser grammar ClingoParser;

options {tokenVocab=ClingoLexer;}

answer_set    : START model;
model         : predicate_atom* NEW_LINE;
output        : answer_set*;
predicate_atom: IDENTIFIER (TERMS_BEGIN term (COMMA term)* TERMS_END)? WHITE_SPACE?;
term          : IDENTIFIER #SymbolicTerm |
                INTEGER_CONSTANT #IntegerTerm |
                predicate_atom #FunctionalTerm |
                STRING_CONSTANT #StringTerm;