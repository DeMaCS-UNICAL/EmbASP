grammar SPDGrammar;

BOOLEAN     : 'true'|'false';
INTEGER     : '0'|[1-9][0-9]*;
STRING      : '"'(~'"'|'\\"')*'"';
WHITE_SPACE : [ \n\r\t]-> skip;

array : '['value (',' value)*']';
json  : value*;
object: '{'pair (',' pair)*'}' | '{''}';
pair  : STRING ':' value;
value : array   #ArrayValue |
		BOOLEAN #BooleanValue |
		INTEGER #IntegerValue |
		'null'  #NullValue |
		object  #ObjectValue |
		STRING  #StringValue;
