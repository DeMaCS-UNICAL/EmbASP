parser grammar DLVParser;

options {tokenVocab=DLVLexer;}

answer_set: IDENTIFIER (COMMA IDENTIFIER)* GROUND_QUERY_BEGIN REASONING BOOLEAN (DOT | witness) #GroundQuery |
            model #SimpleModel |
            term (COMMA term)* #NonGroundQuery |
            WEIGHTED_MODEL_LABEL? model cost #WeightedModel;
cost      : COST_BEGIN cost_level (COMMA cost_level)* COST_END;
cost_level: OPEN_SQUARE_BRACKET INTEGER_CONSTANT COLON INTEGER_CONSTANT CLOSE_SQUARE_BRACKET;
model     : MODEL_BEGIN (predicate (COMMA predicate)*)? MODEL_END;
output    : answer_set*;
predicate : IDENTIFIER (TERMS_BEGIN term (COMMA term)* TERMS_END)?;
term      : IDENTIFIER | INTEGER_CONSTANT | predicate | OPEN_SQUARE_BRACKET (term (COMMA term)*)? CLOSE_SQUARE_BRACKET | STRING_CONSTANT;
witness   : WITNESS_LABEL model;
