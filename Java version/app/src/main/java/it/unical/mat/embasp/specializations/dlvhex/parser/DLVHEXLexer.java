package it.unical.mat.embasp.specializations.dlvhex.parser;

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
		START=1, COST_LABEL=2, ANY=3, IGNORE=4, COMMA=5, INTEGER_CONSTANT=6, IDENTIFIER=7, 
		ANSWER_SET_END=8, STRING_CONSTANT=9, TERMS_BEGIN=10, TERMS_END=11, WHITE_SPACE=12, 
		BLANK_SPACE=13, COLON=14, COMMA_IN_COST=15, COST_END=16, INTEGER=17, LEVEL_BEGIN=18, 
		LEVEL_END=19;
	public static final int
		ANSWER_SET=1, COST=2;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE", "ANSWER_SET", "COST"
	};

	public static final String[] ruleNames = {
		"START", "COST_LABEL", "ANY", "IGNORE", "COMMA", "INTEGER_CONSTANT", "IDENTIFIER", 
		"ANSWER_SET_END", "STRING_CONSTANT", "TERMS_BEGIN", "TERMS_END", "WHITE_SPACE", 
		"BLANK_SPACE", "COLON", "COMMA_IN_COST", "COST_END", "INTEGER", "LEVEL_BEGIN", 
		"LEVEL_END", "INT", "NL", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'{'", "'<'", null, null, null, null, null, "'}'", null, "'('", 
		"')'", null, null, "':'", null, "'>'", null, "'['", "']'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "START", "COST_LABEL", "ANY", "IGNORE", "COMMA", "INTEGER_CONSTANT", 
		"IDENTIFIER", "ANSWER_SET_END", "STRING_CONSTANT", "TERMS_BEGIN", "TERMS_END", 
		"WHITE_SPACE", "BLANK_SPACE", "COLON", "COMMA_IN_COST", "COST_END", "INTEGER", 
		"LEVEL_BEGIN", "LEVEL_END"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\25\u008a\b\1\b\1"+
		"\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4"+
		"\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t"+
		"\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\3\2\3"+
		"\2\3\2\3\2\3\3\3\3\3\3\3\3\3\4\6\4;\n\4\r\4\16\4<\3\4\3\4\3\5\3\5\5\5"+
		"C\n\5\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\7\bM\n\b\f\b\16\bP\13\b\3\t\3\t"+
		"\3\t\3\t\3\n\3\n\7\nX\n\n\f\n\16\n[\13\n\3\n\3\n\3\13\3\13\3\f\3\f\3\r"+
		"\3\r\5\re\n\r\3\r\3\r\3\16\3\16\5\16k\n\16\3\16\3\16\3\17\3\17\3\20\3"+
		"\20\3\21\3\21\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\25\7"+
		"\25\u0080\n\25\f\25\16\25\u0083\13\25\5\25\u0085\n\25\3\26\3\26\3\27\3"+
		"\27\3<\2\30\5\3\7\4\t\5\13\6\r\7\17\b\21\t\23\n\25\13\27\f\31\r\33\16"+
		"\35\17\37\20!\21#\22%\23\'\24)\25+\2-\2/\2\5\2\3\4\t\4\2C\\c|\6\2\62;"+
		"C\\aac|\3\2$$\3\2\63;\3\2\62;\4\2\f\f\17\17\4\2\13\13\"\"\2\u008c\2\5"+
		"\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\3\r\3\2\2\2\3\17\3\2\2\2"+
		"\3\21\3\2\2\2\3\23\3\2\2\2\3\25\3\2\2\2\3\27\3\2\2\2\3\31\3\2\2\2\3\33"+
		"\3\2\2\2\4\35\3\2\2\2\4\37\3\2\2\2\4!\3\2\2\2\4#\3\2\2\2\4%\3\2\2\2\4"+
		"\'\3\2\2\2\4)\3\2\2\2\5\61\3\2\2\2\7\65\3\2\2\2\t:\3\2\2\2\13B\3\2\2\2"+
		"\rF\3\2\2\2\17H\3\2\2\2\21J\3\2\2\2\23Q\3\2\2\2\25U\3\2\2\2\27^\3\2\2"+
		"\2\31`\3\2\2\2\33d\3\2\2\2\35j\3\2\2\2\37n\3\2\2\2!p\3\2\2\2#r\3\2\2\2"+
		"%v\3\2\2\2\'x\3\2\2\2)z\3\2\2\2+\u0084\3\2\2\2-\u0086\3\2\2\2/\u0088\3"+
		"\2\2\2\61\62\7}\2\2\62\63\3\2\2\2\63\64\b\2\2\2\64\6\3\2\2\2\65\66\7>"+
		"\2\2\66\67\3\2\2\2\678\b\3\3\28\b\3\2\2\29;\13\2\2\2:9\3\2\2\2;<\3\2\2"+
		"\2<=\3\2\2\2<:\3\2\2\2=>\3\2\2\2>?\b\4\4\2?\n\3\2\2\2@C\5-\26\2AC\5/\27"+
		"\2B@\3\2\2\2BA\3\2\2\2CD\3\2\2\2DE\b\5\4\2E\f\3\2\2\2FG\7.\2\2G\16\3\2"+
		"\2\2HI\5+\25\2I\20\3\2\2\2JN\t\2\2\2KM\t\3\2\2LK\3\2\2\2MP\3\2\2\2NL\3"+
		"\2\2\2NO\3\2\2\2O\22\3\2\2\2PN\3\2\2\2QR\7\177\2\2RS\3\2\2\2ST\b\t\5\2"+
		"T\24\3\2\2\2UY\7$\2\2VX\n\4\2\2WV\3\2\2\2X[\3\2\2\2YW\3\2\2\2YZ\3\2\2"+
		"\2Z\\\3\2\2\2[Y\3\2\2\2\\]\7$\2\2]\26\3\2\2\2^_\7*\2\2_\30\3\2\2\2`a\7"+
		"+\2\2a\32\3\2\2\2be\5/\27\2ce\5-\26\2db\3\2\2\2dc\3\2\2\2ef\3\2\2\2fg"+
		"\b\r\4\2g\34\3\2\2\2hk\5-\26\2ik\5/\27\2jh\3\2\2\2ji\3\2\2\2kl\3\2\2\2"+
		"lm\b\16\4\2m\36\3\2\2\2no\7<\2\2o \3\2\2\2pq\7.\2\2q\"\3\2\2\2rs\7@\2"+
		"\2st\3\2\2\2tu\b\21\5\2u$\3\2\2\2vw\5+\25\2w&\3\2\2\2xy\7]\2\2y(\3\2\2"+
		"\2z{\7_\2\2{*\3\2\2\2|\u0085\7\62\2\2}\u0081\t\5\2\2~\u0080\t\6\2\2\177"+
		"~\3\2\2\2\u0080\u0083\3\2\2\2\u0081\177\3\2\2\2\u0081\u0082\3\2\2\2\u0082"+
		"\u0085\3\2\2\2\u0083\u0081\3\2\2\2\u0084|\3\2\2\2\u0084}\3\2\2\2\u0085"+
		",\3\2\2\2\u0086\u0087\t\7\2\2\u0087.\3\2\2\2\u0088\u0089\t\b\2\2\u0089"+
		"\60\3\2\2\2\r\2\3\4<BNYdj\u0081\u0084\6\4\3\2\4\4\2\b\2\2\4\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}