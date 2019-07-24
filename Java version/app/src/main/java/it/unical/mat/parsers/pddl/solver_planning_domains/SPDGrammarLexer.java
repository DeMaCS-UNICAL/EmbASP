package it.unical.mat.parsers.pddl.solver_planning_domains;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SPDGrammarLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, BOOLEAN=8, INTEGER=9, 
		STRING=10, WHITE_SPACE=11;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "BOOLEAN", "INTEGER", 
		"STRING", "WHITE_SPACE"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'['", "','", "']'", "'{'", "'}'", "':'", "'null'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, "BOOLEAN", "INTEGER", 
		"STRING", "WHITE_SPACE"
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


	public SPDGrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "SPDGrammar.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\rN\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3"+
		"\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\64\n\t\3\n\3\n\3\n"+
		"\7\n9\n\n\f\n\16\n<\13\n\5\n>\n\n\3\13\3\13\3\13\3\13\7\13D\n\13\f\13"+
		"\16\13G\13\13\3\13\3\13\3\f\3\f\3\f\3\f\2\2\r\3\3\5\4\7\5\t\6\13\7\r\b"+
		"\17\t\21\n\23\13\25\f\27\r\3\2\6\3\2\63;\3\2\62;\3\2$$\5\2\13\f\17\17"+
		"\"\"\2R\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2"+
		"\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3"+
		"\2\2\2\3\31\3\2\2\2\5\33\3\2\2\2\7\35\3\2\2\2\t\37\3\2\2\2\13!\3\2\2\2"+
		"\r#\3\2\2\2\17%\3\2\2\2\21\63\3\2\2\2\23=\3\2\2\2\25?\3\2\2\2\27J\3\2"+
		"\2\2\31\32\7]\2\2\32\4\3\2\2\2\33\34\7.\2\2\34\6\3\2\2\2\35\36\7_\2\2"+
		"\36\b\3\2\2\2\37 \7}\2\2 \n\3\2\2\2!\"\7\177\2\2\"\f\3\2\2\2#$\7<\2\2"+
		"$\16\3\2\2\2%&\7p\2\2&\'\7w\2\2\'(\7n\2\2()\7n\2\2)\20\3\2\2\2*+\7v\2"+
		"\2+,\7t\2\2,-\7w\2\2-\64\7g\2\2./\7h\2\2/\60\7c\2\2\60\61\7n\2\2\61\62"+
		"\7u\2\2\62\64\7g\2\2\63*\3\2\2\2\63.\3\2\2\2\64\22\3\2\2\2\65>\7\62\2"+
		"\2\66:\t\2\2\2\679\t\3\2\28\67\3\2\2\29<\3\2\2\2:8\3\2\2\2:;\3\2\2\2;"+
		">\3\2\2\2<:\3\2\2\2=\65\3\2\2\2=\66\3\2\2\2>\24\3\2\2\2?E\7$\2\2@D\n\4"+
		"\2\2AB\7^\2\2BD\7$\2\2C@\3\2\2\2CA\3\2\2\2DG\3\2\2\2EC\3\2\2\2EF\3\2\2"+
		"\2FH\3\2\2\2GE\3\2\2\2HI\7$\2\2I\26\3\2\2\2JK\t\5\2\2KL\3\2\2\2LM\b\f"+
		"\2\2M\30\3\2\2\2\b\2\63:=CE\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}