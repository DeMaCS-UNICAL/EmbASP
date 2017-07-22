package it.unical.mat.embasp.specializations.dlv.parser;

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
		COLON=1, COST_BEGIN=2, COST_END=3, COST_LEVEL_BEGIN=4, COST_LEVEL_END=5, 
		GROUND_QUERY_BEGIN=6, MODEL_BEGIN=7, MODEL_END=8, WEIGHTED_MODEL_LABEL=9, 
		COMMA=10, IDENTIFIER=11, INTEGER_CONSTANT=12, STRING_CONSTANT=13, TERMS_BEGIN=14, 
		TERMS_END=15, WHITESPACE=16, REASONING=17, DOT=18, BOOLEAN=19, WHITESPACE_IN_GROUND_QUERY=20, 
		WITNESS_LABEL=21;
	public static final int
		IN_GROUND_QUERY=1;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE", "IN_GROUND_QUERY"
	};

	public static final String[] ruleNames = {
		"COLON", "COST_BEGIN", "COST_END", "COST_LEVEL_BEGIN", "COST_LEVEL_END", 
		"GROUND_QUERY_BEGIN", "MODEL_BEGIN", "MODEL_END", "WEIGHTED_MODEL_LABEL", 
		"COMMA", "IDENTIFIER", "INTEGER_CONSTANT", "STRING_CONSTANT", "TERMS_BEGIN", 
		"TERMS_END", "WHITESPACE", "REASONING", "DOT", "BOOLEAN", "WHITESPACE_IN_GROUND_QUERY", 
		"WITNESS_LABEL", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "':'", "'Cost ([Weight:Level]): <'", "'>'", "'['", "']'", "' is '", 
		"'{'", "'}'", "'Best model:'", "','", null, null, null, "'('", "')'", 
		null, null, "'.'", null, null, "', evidenced by'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "COLON", "COST_BEGIN", "COST_END", "COST_LEVEL_BEGIN", "COST_LEVEL_END", 
		"GROUND_QUERY_BEGIN", "MODEL_BEGIN", "MODEL_END", "WEIGHTED_MODEL_LABEL", 
		"COMMA", "IDENTIFIER", "INTEGER_CONSTANT", "STRING_CONSTANT", "TERMS_BEGIN", 
		"TERMS_END", "WHITESPACE", "REASONING", "DOT", "BOOLEAN", "WHITESPACE_IN_GROUND_QUERY", 
		"WITNESS_LABEL"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\27\u00c5\b\1\b\1"+
		"\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t"+
		"\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4"+
		"\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\3\2\3\2\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\13\3\13\3\f\3\f\7\fm\n\f\f\f\16\fp\13\f\3\r\3\r\3\r\7\ru\n\r\f\r"+
		"\16\rx\13\r\5\rz\n\r\3\16\3\16\7\16~\n\16\f\16\16\16\u0081\13\16\3\16"+
		"\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u009e"+
		"\n\22\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\5\24\u00ad\n\24\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27\2\2\30\4"+
		"\3\6\4\b\5\n\6\f\7\16\b\20\t\22\n\24\13\26\f\30\r\32\16\34\17\36\20 \21"+
		"\"\22$\23&\24(\25*\26,\27.\2\4\2\3\b\4\2C\\c|\6\2\62;C\\aac|\3\2\63;\3"+
		"\2\62;\3\2$$\5\2\13\f\17\17\"\"\2\u00c8\2\4\3\2\2\2\2\6\3\2\2\2\2\b\3"+
		"\2\2\2\2\n\3\2\2\2\2\f\3\2\2\2\2\16\3\2\2\2\2\20\3\2\2\2\2\22\3\2\2\2"+
		"\2\24\3\2\2\2\2\26\3\2\2\2\2\30\3\2\2\2\2\32\3\2\2\2\2\34\3\2\2\2\2\36"+
		"\3\2\2\2\2 \3\2\2\2\2\"\3\2\2\2\3$\3\2\2\2\3&\3\2\2\2\3(\3\2\2\2\3*\3"+
		"\2\2\2\3,\3\2\2\2\4\60\3\2\2\2\6\62\3\2\2\2\bK\3\2\2\2\nM\3\2\2\2\fO\3"+
		"\2\2\2\16Q\3\2\2\2\20X\3\2\2\2\22Z\3\2\2\2\24\\\3\2\2\2\26h\3\2\2\2\30"+
		"j\3\2\2\2\32y\3\2\2\2\34{\3\2\2\2\36\u0084\3\2\2\2 \u0086\3\2\2\2\"\u0088"+
		"\3\2\2\2$\u009d\3\2\2\2&\u009f\3\2\2\2(\u00ac\3\2\2\2*\u00ae\3\2\2\2,"+
		"\u00b2\3\2\2\2.\u00c3\3\2\2\2\60\61\7<\2\2\61\5\3\2\2\2\62\63\7E\2\2\63"+
		"\64\7q\2\2\64\65\7u\2\2\65\66\7v\2\2\66\67\7\"\2\2\678\7*\2\289\7]\2\2"+
		"9:\7Y\2\2:;\7g\2\2;<\7k\2\2<=\7i\2\2=>\7j\2\2>?\7v\2\2?@\7<\2\2@A\7N\2"+
		"\2AB\7g\2\2BC\7x\2\2CD\7g\2\2DE\7n\2\2EF\7_\2\2FG\7+\2\2GH\7<\2\2HI\7"+
		"\"\2\2IJ\7>\2\2J\7\3\2\2\2KL\7@\2\2L\t\3\2\2\2MN\7]\2\2N\13\3\2\2\2OP"+
		"\7_\2\2P\r\3\2\2\2QR\7\"\2\2RS\7k\2\2ST\7u\2\2TU\7\"\2\2UV\3\2\2\2VW\b"+
		"\7\2\2W\17\3\2\2\2XY\7}\2\2Y\21\3\2\2\2Z[\7\177\2\2[\23\3\2\2\2\\]\7D"+
		"\2\2]^\7g\2\2^_\7u\2\2_`\7v\2\2`a\7\"\2\2ab\7o\2\2bc\7q\2\2cd\7f\2\2d"+
		"e\7g\2\2ef\7n\2\2fg\7<\2\2g\25\3\2\2\2hi\7.\2\2i\27\3\2\2\2jn\t\2\2\2"+
		"km\t\3\2\2lk\3\2\2\2mp\3\2\2\2nl\3\2\2\2no\3\2\2\2o\31\3\2\2\2pn\3\2\2"+
		"\2qz\7\62\2\2rv\t\4\2\2su\t\5\2\2ts\3\2\2\2ux\3\2\2\2vt\3\2\2\2vw\3\2"+
		"\2\2wz\3\2\2\2xv\3\2\2\2yq\3\2\2\2yr\3\2\2\2z\33\3\2\2\2{\177\7$\2\2|"+
		"~\n\6\2\2}|\3\2\2\2~\u0081\3\2\2\2\177}\3\2\2\2\177\u0080\3\2\2\2\u0080"+
		"\u0082\3\2\2\2\u0081\177\3\2\2\2\u0082\u0083\7$\2\2\u0083\35\3\2\2\2\u0084"+
		"\u0085\7*\2\2\u0085\37\3\2\2\2\u0086\u0087\7+\2\2\u0087!\3\2\2\2\u0088"+
		"\u0089\5.\27\2\u0089\u008a\3\2\2\2\u008a\u008b\b\21\3\2\u008b#\3\2\2\2"+
		"\u008c\u008d\7d\2\2\u008d\u008e\7t\2\2\u008e\u008f\7c\2\2\u008f\u0090"+
		"\7x\2\2\u0090\u0091\7g\2\2\u0091\u0092\7n\2\2\u0092\u009e\7{\2\2\u0093"+
		"\u0094\7e\2\2\u0094\u0095\7c\2\2\u0095\u0096\7w\2\2\u0096\u0097\7v\2\2"+
		"\u0097\u0098\7k\2\2\u0098\u0099\7q\2\2\u0099\u009a\7w\2\2\u009a\u009b"+
		"\7u\2\2\u009b\u009c\7n\2\2\u009c\u009e\7{\2\2\u009d\u008c\3\2\2\2\u009d"+
		"\u0093\3\2\2\2\u009e%\3\2\2\2\u009f\u00a0\7\60\2\2\u00a0\u00a1\3\2\2\2"+
		"\u00a1\u00a2\b\23\4\2\u00a2\'\3\2\2\2\u00a3\u00a4\7h\2\2\u00a4\u00a5\7"+
		"c\2\2\u00a5\u00a6\7n\2\2\u00a6\u00a7\7u\2\2\u00a7\u00ad\7g\2\2\u00a8\u00a9"+
		"\7v\2\2\u00a9\u00aa\7t\2\2\u00aa\u00ab\7w\2\2\u00ab\u00ad\7g\2\2\u00ac"+
		"\u00a3\3\2\2\2\u00ac\u00a8\3\2\2\2\u00ad)\3\2\2\2\u00ae\u00af\5.\27\2"+
		"\u00af\u00b0\3\2\2\2\u00b0\u00b1\b\25\3\2\u00b1+\3\2\2\2\u00b2\u00b3\7"+
		".\2\2\u00b3\u00b4\7\"\2\2\u00b4\u00b5\7g\2\2\u00b5\u00b6\7x\2\2\u00b6"+
		"\u00b7\7k\2\2\u00b7\u00b8\7f\2\2\u00b8\u00b9\7g\2\2\u00b9\u00ba\7p\2\2"+
		"\u00ba\u00bb\7e\2\2\u00bb\u00bc\7g\2\2\u00bc\u00bd\7f\2\2\u00bd\u00be"+
		"\7\"\2\2\u00be\u00bf\7d\2\2\u00bf\u00c0\7{\2\2\u00c0\u00c1\3\2\2\2\u00c1"+
		"\u00c2\b\26\4\2\u00c2-\3\2\2\2\u00c3\u00c4\t\7\2\2\u00c4/\3\2\2\2\n\2"+
		"\3nvy\177\u009d\u00ac\5\4\3\2\b\2\2\4\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}