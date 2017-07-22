parser grammar DLVParser;

options {tokenVocab=DLVLexer;}

answer_set: IDENTIFIER (COMMA IDENTIFIER)* GROUND_QUERY_BEGIN REASONING BOOLEAN (DOT | witness) #GroundQuery |
            model #SimpleModel |
            term (COMMA term)* #NonGroundQuery |
            WEIGHTED_MODEL_LABEL? model cost #WeightedModel;
cost      : COST_BEGIN cost_level (COMMA cost_level)* COST_END;
cost_level: COST_LEVEL_BEGIN INTEGER_CONSTANT COLON INTEGER_CONSTANT COST_LEVEL_END;
model     : MODEL_BEGIN MODEL_END | MODEL_BEGIN predicate (COMMA predicate)* MODEL_END;
output    : answer_set*;
predicate : IDENTIFIER (TERMS_BEGIN term (COMMA term)* TERMS_END)?;
term      : IDENTIFIER #SymbolicTerm |
            INTEGER_CONSTANT #IntegerTerm |
            predicate #FunctionalTerm |
            STRING_CONSTANT #StringTerm;
witness   : WITNESS_LABEL model;