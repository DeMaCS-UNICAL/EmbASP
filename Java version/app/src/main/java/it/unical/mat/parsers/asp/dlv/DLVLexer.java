package it.unical.mat.parsers.asp.dlv;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class DLVLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		HEADER=1, COLON=2, COST_BEGIN=3, COST_END=4, OPEN_SQUARE_BRACKET=5, CLOSE_SQUARE_BRACKET=6, 
		GROUND_QUERY_BEGIN=7, MODEL_BEGIN=8, MODEL_END=9, WEIGHTED_MODEL_LABEL=10, 
		COMMA=11, IDENTIFIER=12, INTEGER_CONSTANT=13, STRING_CONSTANT=14, TERMS_BEGIN=15, 
		TERMS_END=16, WHITESPACE=17, REASONING=18, DOT=19, BOOLEAN=20, WHITESPACE_IN_GROUND_QUERY=21, 
		WITNESS_LABEL=22;
	public static final int
		IN_GROUND_QUERY=1;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE", "IN_GROUND_QUERY"
	};

	public static final String[] ruleNames = {
		"HEADER", "COLON", "COST_BEGIN", "COST_END", "OPEN_SQUARE_BRACKET", "CLOSE_SQUARE_BRACKET", 
		"GROUND_QUERY_BEGIN", "MODEL_BEGIN", "MODEL_END", "WEIGHTED_MODEL_LABEL", 
		"COMMA", "IDENTIFIER", "INTEGER_CONSTANT", "STRING_CONSTANT", "TERMS_BEGIN", 
		"TERMS_END", "WHITESPACE", "REASONING", "DOT", "BOOLEAN", "WHITESPACE_IN_GROUND_QUERY", 
		"WITNESS_LABEL", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, "':'", "'Cost ([Weight:Level]): <'", "'>'", "'['", "']'", 
		"' is '", "'{'", "'}'", "'Best model:'", "','", null, null, null, "'('", 
		"')'", null, null, "'.'", null, null, "', evidenced by'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "HEADER", "COLON", "COST_BEGIN", "COST_END", "OPEN_SQUARE_BRACKET", 
		"CLOSE_SQUARE_BRACKET", "GROUND_QUERY_BEGIN", "MODEL_BEGIN", "MODEL_END", 
		"WEIGHTED_MODEL_LABEL", "COMMA", "IDENTIFIER", "INTEGER_CONSTANT", "STRING_CONSTANT", 
		"TERMS_BEGIN", "TERMS_END", "WHITESPACE", "REASONING", "DOT", "BOOLEAN", 
		"WHITESPACE_IN_GROUND_QUERY", "WITNESS_LABEL"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public DLVLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "DLVLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\30\u00d7\b\1\b\1"+
		"\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t"+
		"\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4"+
		"\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\7\2:\n\2\f\2\16\2=\13\2\3\2\3\2\3\2\3\2\3\3"+
		"\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\f\3\f\3\r\3\r\7\r\177\n\r\f\r\16\r\u0082\13"+
		"\r\3\16\3\16\3\16\7\16\u0087\n\16\f\16\16\16\u008a\13\16\5\16\u008c\n"+
		"\16\3\17\3\17\7\17\u0090\n\17\f\17\16\17\u0093\13\17\3\17\3\17\3\20\3"+
		"\20\3\21\3\21\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3"+
		"\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u00b0\n\23\3\24"+
		"\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u00bf"+
		"\n\25\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3;\2\31\4\3\6\4\b\5"+
		"\n\6\f\7\16\b\20\t\22\n\24\13\26\f\30\r\32\16\34\17\36\20 \21\"\22$\23"+
		"&\24(\25*\26,\27.\30\60\2\4\2\3\b\4\2C\\c|\6\2\62;C\\aac|\3\2\63;\3\2"+
		"\62;\3\2$$\5\2\13\f\17\17\"\"\2\u00db\2\4\3\2\2\2\2\6\3\2\2\2\2\b\3\2"+
		"\2\2\2\n\3\2\2\2\2\f\3\2\2\2\2\16\3\2\2\2\2\20\3\2\2\2\2\22\3\2\2\2\2"+
		"\24\3\2\2\2\2\26\3\2\2\2\2\30\3\2\2\2\2\32\3\2\2\2\2\34\3\2\2\2\2\36\3"+
		"\2\2\2\2 \3\2\2\2\2\"\3\2\2\2\2$\3\2\2\2\3&\3\2\2\2\3(\3\2\2\2\3*\3\2"+
		"\2\2\3,\3\2\2\2\3.\3\2\2\2\4\62\3\2\2\2\6B\3\2\2\2\bD\3\2\2\2\n]\3\2\2"+
		"\2\f_\3\2\2\2\16a\3\2\2\2\20c\3\2\2\2\22j\3\2\2\2\24l\3\2\2\2\26n\3\2"+
		"\2\2\30z\3\2\2\2\32|\3\2\2\2\34\u008b\3\2\2\2\36\u008d\3\2\2\2 \u0096"+
		"\3\2\2\2\"\u0098\3\2\2\2$\u009a\3\2\2\2&\u00af\3\2\2\2(\u00b1\3\2\2\2"+
		"*\u00be\3\2\2\2,\u00c0\3\2\2\2.\u00c4\3\2\2\2\60\u00d5\3\2\2\2\62\63\7"+
		"F\2\2\63\64\7N\2\2\64\65\7X\2\2\65\66\7\"\2\2\66\67\7]\2\2\67;\3\2\2\2"+
		"8:\13\2\2\298\3\2\2\2:=\3\2\2\2;<\3\2\2\2;9\3\2\2\2<>\3\2\2\2=;\3\2\2"+
		"\2>?\7_\2\2?@\3\2\2\2@A\b\2\2\2A\5\3\2\2\2BC\7<\2\2C\7\3\2\2\2DE\7E\2"+
		"\2EF\7q\2\2FG\7u\2\2GH\7v\2\2HI\7\"\2\2IJ\7*\2\2JK\7]\2\2KL\7Y\2\2LM\7"+
		"g\2\2MN\7k\2\2NO\7i\2\2OP\7j\2\2PQ\7v\2\2QR\7<\2\2RS\7N\2\2ST\7g\2\2T"+
		"U\7x\2\2UV\7g\2\2VW\7n\2\2WX\7_\2\2XY\7+\2\2YZ\7<\2\2Z[\7\"\2\2[\\\7>"+
		"\2\2\\\t\3\2\2\2]^\7@\2\2^\13\3\2\2\2_`\7]\2\2`\r\3\2\2\2ab\7_\2\2b\17"+
		"\3\2\2\2cd\7\"\2\2de\7k\2\2ef\7u\2\2fg\7\"\2\2gh\3\2\2\2hi\b\b\3\2i\21"+
		"\3\2\2\2jk\7}\2\2k\23\3\2\2\2lm\7\177\2\2m\25\3\2\2\2no\7D\2\2op\7g\2"+
		"\2pq\7u\2\2qr\7v\2\2rs\7\"\2\2st\7o\2\2tu\7q\2\2uv\7f\2\2vw\7g\2\2wx\7"+
		"n\2\2xy\7<\2\2y\27\3\2\2\2z{\7.\2\2{\31\3\2\2\2|\u0080\t\2\2\2}\177\t"+
		"\3\2\2~}\3\2\2\2\177\u0082\3\2\2\2\u0080~\3\2\2\2\u0080\u0081\3\2\2\2"+
		"\u0081\33\3\2\2\2\u0082\u0080\3\2\2\2\u0083\u008c\7\62\2\2\u0084\u0088"+
		"\t\4\2\2\u0085\u0087\t\5\2\2\u0086\u0085\3\2\2\2\u0087\u008a\3\2\2\2\u0088"+
		"\u0086\3\2\2\2\u0088\u0089\3\2\2\2\u0089\u008c\3\2\2\2\u008a\u0088\3\2"+
		"\2\2\u008b\u0083\3\2\2\2\u008b\u0084\3\2\2\2\u008c\35\3\2\2\2\u008d\u0091"+
		"\7$\2\2\u008e\u0090\n\6\2\2\u008f\u008e\3\2\2\2\u0090\u0093\3\2\2\2\u0091"+
		"\u008f\3\2\2\2\u0091\u0092\3\2\2\2\u0092\u0094\3\2\2\2\u0093\u0091\3\2"+
		"\2\2\u0094\u0095\7$\2\2\u0095\37\3\2\2\2\u0096\u0097\7*\2\2\u0097!\3\2"+
		"\2\2\u0098\u0099\7+\2\2\u0099#\3\2\2\2\u009a\u009b\5\60\30\2\u009b\u009c"+
		"\3\2\2\2\u009c\u009d\b\22\2\2\u009d%\3\2\2\2\u009e\u009f\7d\2\2\u009f"+
		"\u00a0\7t\2\2\u00a0\u00a1\7c\2\2\u00a1\u00a2\7x\2\2\u00a2\u00a3\7g\2\2"+
		"\u00a3\u00a4\7n\2\2\u00a4\u00b0\7{\2\2\u00a5\u00a6\7e\2\2\u00a6\u00a7"+
		"\7c\2\2\u00a7\u00a8\7w\2\2\u00a8\u00a9\7v\2\2\u00a9\u00aa\7k\2\2\u00aa"+
		"\u00ab\7q\2\2\u00ab\u00ac\7w\2\2\u00ac\u00ad\7u\2\2\u00ad\u00ae\7n\2\2"+
		"\u00ae\u00b0\7{\2\2\u00af\u009e\3\2\2\2\u00af\u00a5\3\2\2\2\u00b0\'\3"+
		"\2\2\2\u00b1\u00b2\7\60\2\2\u00b2\u00b3\3\2\2\2\u00b3\u00b4\b\24\4\2\u00b4"+
		")\3\2\2\2\u00b5\u00b6\7h\2\2\u00b6\u00b7\7c\2\2\u00b7\u00b8\7n\2\2\u00b8"+
		"\u00b9\7u\2\2\u00b9\u00bf\7g\2\2\u00ba\u00bb\7v\2\2\u00bb\u00bc\7t\2\2"+
		"\u00bc\u00bd\7w\2\2\u00bd\u00bf\7g\2\2\u00be\u00b5\3\2\2\2\u00be\u00ba"+
		"\3\2\2\2\u00bf+\3\2\2\2\u00c0\u00c1\5\60\30\2\u00c1\u00c2\3\2\2\2\u00c2"+
		"\u00c3\b\26\2\2\u00c3-\3\2\2\2\u00c4\u00c5\7.\2\2\u00c5\u00c6\7\"\2\2"+
		"\u00c6\u00c7\7g\2\2\u00c7\u00c8\7x\2\2\u00c8\u00c9\7k\2\2\u00c9\u00ca"+
		"\7f\2\2\u00ca\u00cb\7g\2\2\u00cb\u00cc\7p\2\2\u00cc\u00cd\7e\2\2\u00cd"+
		"\u00ce\7g\2\2\u00ce\u00cf\7f\2\2\u00cf\u00d0\7\"\2\2\u00d0\u00d1\7d\2"+
		"\2\u00d1\u00d2\7{\2\2\u00d2\u00d3\3\2\2\2\u00d3\u00d4\b\27\4\2\u00d4/"+
		"\3\2\2\2\u00d5\u00d6\t\7\2\2\u00d6\61\3\2\2\2\13\2\3;\u0080\u0088\u008b"+
		"\u0091\u00af\u00be\5\b\2\2\4\3\2\4\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}