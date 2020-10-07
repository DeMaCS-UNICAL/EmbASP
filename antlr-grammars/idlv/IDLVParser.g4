parser grammar IDLVParser;

options {tokenVocab=IDLVLexer;}

output         : minimal_model;
minimal_model  : (predicate_atom ATOM_END)*;
predicate_atom : IDENTIFIER (TERMS_BEGIN term (COMMA term)* TERMS_END)?;
term           : IDENTIFIER | INTEGER_CONSTANT | STRING_CONSTANT;