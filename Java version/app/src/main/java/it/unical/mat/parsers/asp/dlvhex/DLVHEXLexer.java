package it.unical.mat.parsers.asp.dlvhex;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class DLVHEXLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		HEADER=1, WHITE_SPACE=2, COLON=3, COMMA=4, COST_BEGIN=5, COST_END=6, INTEGER=7, 
		LEVEL_BEGIN=8, LEVEL_END=9, GROUND_QUERY_BEGIN=10, ANSWER_SET_BEGIN=11, 
		ANSWER_SET_END=12, IDENTIFIER=13, STRING_CONSTANT=14, TERMS_BEGIN=15, 
		TERMS_END=16, REASONING=17, DOT=18, BOOLEAN=19, WHITESPACE_IN_GROUND_QUERY=20, 
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
		"HEADER", "WHITE_SPACE", "COLON", "COMMA", "COST_BEGIN", "COST_END", "INTEGER", 
		"LEVEL_BEGIN", "LEVEL_END", "GROUND_QUERY_BEGIN", "ANSWER_SET_BEGIN", 
		"ANSWER_SET_END", "IDENTIFIER", "STRING_CONSTANT", "TERMS_BEGIN", "TERMS_END", 
		"REASONING", "DOT", "BOOLEAN", "WHITESPACE_IN_GROUND_QUERY", "WITNESS_LABEL", 
		"NL", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, "':'", "','", "'<'", "'>'", null, "'['", "']'", "' is '", 
		"'{'", "'}'", null, null, "'('", "')'", null, "'.'", null, null, "', evidenced by'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "HEADER", "WHITE_SPACE", "COLON", "COMMA", "COST_BEGIN", "COST_END", 
		"INTEGER", "LEVEL_BEGIN", "LEVEL_END", "GROUND_QUERY_BEGIN", "ANSWER_SET_BEGIN", 
		"ANSWER_SET_END", "IDENTIFIER", "STRING_CONSTANT", "TERMS_BEGIN", "TERMS_END", 
		"REASONING", "DOT", "BOOLEAN", "WHITESPACE_IN_GROUND_QUERY", "WITNESS_LABEL"
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


	public DLVHEXLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "DLVHEXLexer.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\27\u00bc\b\1\b\1"+
		"\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t"+
		"\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4"+
		"\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\7\2<\n\2\f\2\16\2?\13\2\3\2\3\2\3\2"+
		"\3\2\3\3\3\3\5\3G\n\3\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b"+
		"\3\b\7\bV\n\b\f\b\16\bY\13\b\5\b[\n\b\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\7\16n\n\16\f\16\16\16q\13"+
		"\16\3\17\3\17\7\17u\n\17\f\17\16\17x\13\17\3\17\3\17\3\20\3\20\3\21\3"+
		"\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3"+
		"\22\3\22\3\22\3\22\5\22\u0091\n\22\3\23\3\23\3\23\3\23\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u00a0\n\24\3\25\3\25\5\25\u00a4\n"+
		"\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3"+
		"\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\30\3\30\3=\2\31\4\3\6\4\b\5\n"+
		"\6\f\7\16\b\20\t\22\n\24\13\26\f\30\r\32\16\34\17\36\20 \21\"\22$\23&"+
		"\24(\25*\26,\27.\2\60\2\4\2\3\t\3\2\63;\3\2\62;\4\2C\\c|\6\2\62;C\\aa"+
		"c|\3\2$$\4\2\f\f\17\17\4\2\13\13\"\"\2\u00c1\2\4\3\2\2\2\2\6\3\2\2\2\2"+
		"\b\3\2\2\2\2\n\3\2\2\2\2\f\3\2\2\2\2\16\3\2\2\2\2\20\3\2\2\2\2\22\3\2"+
		"\2\2\2\24\3\2\2\2\2\26\3\2\2\2\2\30\3\2\2\2\2\32\3\2\2\2\2\34\3\2\2\2"+
		"\2\36\3\2\2\2\2 \3\2\2\2\2\"\3\2\2\2\3$\3\2\2\2\3&\3\2\2\2\3(\3\2\2\2"+
		"\3*\3\2\2\2\3,\3\2\2\2\4\62\3\2\2\2\6F\3\2\2\2\bJ\3\2\2\2\nL\3\2\2\2\f"+
		"N\3\2\2\2\16P\3\2\2\2\20Z\3\2\2\2\22\\\3\2\2\2\24^\3\2\2\2\26`\3\2\2\2"+
		"\30g\3\2\2\2\32i\3\2\2\2\34k\3\2\2\2\36r\3\2\2\2 {\3\2\2\2\"}\3\2\2\2"+
		"$\u0090\3\2\2\2&\u0092\3\2\2\2(\u009f\3\2\2\2*\u00a3\3\2\2\2,\u00a7\3"+
		"\2\2\2.\u00b8\3\2\2\2\60\u00ba\3\2\2\2\62\63\7F\2\2\63\64\7N\2\2\64\65"+
		"\7X\2\2\65\66\7J\2\2\66\67\7G\2\2\678\7Z\2\289\7\"\2\29=\3\2\2\2:<\13"+
		"\2\2\2;:\3\2\2\2<?\3\2\2\2=>\3\2\2\2=;\3\2\2\2>@\3\2\2\2?=\3\2\2\2@A\5"+
		".\27\2AB\3\2\2\2BC\b\2\2\2C\5\3\2\2\2DG\5.\27\2EG\5\60\30\2FD\3\2\2\2"+
		"FE\3\2\2\2GH\3\2\2\2HI\b\3\2\2I\7\3\2\2\2JK\7<\2\2K\t\3\2\2\2LM\7.\2\2"+
		"M\13\3\2\2\2NO\7>\2\2O\r\3\2\2\2PQ\7@\2\2Q\17\3\2\2\2R[\7\62\2\2SW\t\2"+
		"\2\2TV\t\3\2\2UT\3\2\2\2VY\3\2\2\2WU\3\2\2\2WX\3\2\2\2X[\3\2\2\2YW\3\2"+
		"\2\2ZR\3\2\2\2ZS\3\2\2\2[\21\3\2\2\2\\]\7]\2\2]\23\3\2\2\2^_\7_\2\2_\25"+
		"\3\2\2\2`a\7\"\2\2ab\7k\2\2bc\7u\2\2cd\7\"\2\2de\3\2\2\2ef\b\13\3\2f\27"+
		"\3\2\2\2gh\7}\2\2h\31\3\2\2\2ij\7\177\2\2j\33\3\2\2\2ko\t\4\2\2ln\t\5"+
		"\2\2ml\3\2\2\2nq\3\2\2\2om\3\2\2\2op\3\2\2\2p\35\3\2\2\2qo\3\2\2\2rv\7"+
		"$\2\2su\n\6\2\2ts\3\2\2\2ux\3\2\2\2vt\3\2\2\2vw\3\2\2\2wy\3\2\2\2xv\3"+
		"\2\2\2yz\7$\2\2z\37\3\2\2\2{|\7*\2\2|!\3\2\2\2}~\7+\2\2~#\3\2\2\2\177"+
		"\u0080\7d\2\2\u0080\u0081\7t\2\2\u0081\u0082\7c\2\2\u0082\u0083\7x\2\2"+
		"\u0083\u0084\7g\2\2\u0084\u0085\7n\2\2\u0085\u0091\7{\2\2\u0086\u0087"+
		"\7e\2\2\u0087\u0088\7c\2\2\u0088\u0089\7w\2\2\u0089\u008a\7v\2\2\u008a"+
		"\u008b\7k\2\2\u008b\u008c\7q\2\2\u008c\u008d\7w\2\2\u008d\u008e\7u\2\2"+
		"\u008e\u008f\7n\2\2\u008f\u0091\7{\2\2\u0090\177\3\2\2\2\u0090\u0086\3"+
		"\2\2\2\u0091%\3\2\2\2\u0092\u0093\7\60\2\2\u0093\u0094\3\2\2\2\u0094\u0095"+
		"\b\23\4\2\u0095\'\3\2\2\2\u0096\u0097\7h\2\2\u0097\u0098\7c\2\2\u0098"+
		"\u0099\7n\2\2\u0099\u009a\7u\2\2\u009a\u00a0\7g\2\2\u009b\u009c\7v\2\2"+
		"\u009c\u009d\7t\2\2\u009d\u009e\7w\2\2\u009e\u00a0\7g\2\2\u009f\u0096"+
		"\3\2\2\2\u009f\u009b\3\2\2\2\u00a0)\3\2\2\2\u00a1\u00a4\5.\27\2\u00a2"+
		"\u00a4\5\60\30\2\u00a3\u00a1\3\2\2\2\u00a3\u00a2\3\2\2\2\u00a4\u00a5\3"+
		"\2\2\2\u00a5\u00a6\b\25\2\2\u00a6+\3\2\2\2\u00a7\u00a8\7.\2\2\u00a8\u00a9"+
		"\7\"\2\2\u00a9\u00aa\7g\2\2\u00aa\u00ab\7x\2\2\u00ab\u00ac\7k\2\2\u00ac"+
		"\u00ad\7f\2\2\u00ad\u00ae\7g\2\2\u00ae\u00af\7p\2\2\u00af\u00b0\7e\2\2"+
		"\u00b0\u00b1\7g\2\2\u00b1\u00b2\7f\2\2\u00b2\u00b3\7\"\2\2\u00b3\u00b4"+
		"\7d\2\2\u00b4\u00b5\7{\2\2\u00b5\u00b6\3\2\2\2\u00b6\u00b7\b\26\4\2\u00b7"+
		"-\3\2\2\2\u00b8\u00b9\t\7\2\2\u00b9/\3\2\2\2\u00ba\u00bb\t\b\2\2\u00bb"+
		"\61\3\2\2\2\r\2\3=FWZov\u0090\u009f\u00a3\5\b\2\2\4\3\2\4\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}