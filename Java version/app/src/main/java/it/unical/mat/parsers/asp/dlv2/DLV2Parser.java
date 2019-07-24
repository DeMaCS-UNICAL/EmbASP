package it.unical.mat.parsers.asp.dlv2;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class DLV2Parser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		START=1, COST_LABEL=2, ANY=3, IGNORE=4, AT=5, INTEGER=6, NEW_LINE=7, BLANK_SPACE=8, 
		COMMA=9, INTEGER_CONSTANT=10, IDENTIFIER=11, MODEL_END=12, STRING_CONSTANT=13, 
		TERMS_BEGIN=14, TERMS_END=15, WHITE_SPACE=16;
	public static final int
		RULE_answer_set = 0, RULE_cost = 1, RULE_level = 2, RULE_model = 3, RULE_output = 4, 
		RULE_predicate_atom = 5, RULE_term = 6;
	public static final String[] ruleNames = {
		"answer_set", "cost", "level", "model", "output", "predicate_atom", "term"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'{'", null, null, null, "'@'", null, null, null, "','", null, null, 
		"'}'", null, "'('", "')'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "START", "COST_LABEL", "ANY", "IGNORE", "AT", "INTEGER", "NEW_LINE", 
		"BLANK_SPACE", "COMMA", "INTEGER_CONSTANT", "IDENTIFIER", "MODEL_END", 
		"STRING_CONSTANT", "TERMS_BEGIN", "TERMS_END", "WHITE_SPACE"
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

	@Override
	public String getGrammarFileName() { return "DLV2Parser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public DLV2Parser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class Answer_setContext extends ParserRuleContext {
		public TerminalNode START() { return getToken(DLV2Parser.START, 0); }
		public ModelContext model() {
			return getRuleContext(ModelContext.class,0);
		}
		public CostContext cost() {
			return getRuleContext(CostContext.class,0);
		}
		public Answer_setContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_answer_set; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DLV2ParserVisitor ) return ((DLV2ParserVisitor<? extends T>)visitor).visitAnswer_set(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Answer_setContext answer_set() throws RecognitionException {
		Answer_setContext _localctx = new Answer_setContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_answer_set);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(14);
			match(START);
			setState(15);
			model();
			setState(17);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COST_LABEL) {
				{
				setState(16);
				cost();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CostContext extends ParserRuleContext {
		public TerminalNode COST_LABEL() { return getToken(DLV2Parser.COST_LABEL, 0); }
		public TerminalNode NEW_LINE() { return getToken(DLV2Parser.NEW_LINE, 0); }
		public List<LevelContext> level() {
			return getRuleContexts(LevelContext.class);
		}
		public LevelContext level(int i) {
			return getRuleContext(LevelContext.class,i);
		}
		public CostContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cost; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DLV2ParserVisitor ) return ((DLV2ParserVisitor<? extends T>)visitor).visitCost(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CostContext cost() throws RecognitionException {
		CostContext _localctx = new CostContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_cost);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(19);
			match(COST_LABEL);
			setState(23);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==INTEGER) {
				{
				{
				setState(20);
				level();
				}
				}
				setState(25);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(26);
			match(NEW_LINE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LevelContext extends ParserRuleContext {
		public List<TerminalNode> INTEGER() { return getTokens(DLV2Parser.INTEGER); }
		public TerminalNode INTEGER(int i) {
			return getToken(DLV2Parser.INTEGER, i);
		}
		public TerminalNode AT() { return getToken(DLV2Parser.AT, 0); }
		public LevelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_level; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DLV2ParserVisitor ) return ((DLV2ParserVisitor<? extends T>)visitor).visitLevel(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LevelContext level() throws RecognitionException {
		LevelContext _localctx = new LevelContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_level);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(28);
			match(INTEGER);
			setState(29);
			match(AT);
			setState(30);
			match(INTEGER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ModelContext extends ParserRuleContext {
		public TerminalNode MODEL_END() { return getToken(DLV2Parser.MODEL_END, 0); }
		public List<Predicate_atomContext> predicate_atom() {
			return getRuleContexts(Predicate_atomContext.class);
		}
		public Predicate_atomContext predicate_atom(int i) {
			return getRuleContext(Predicate_atomContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(DLV2Parser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(DLV2Parser.COMMA, i);
		}
		public ModelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_model; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DLV2ParserVisitor ) return ((DLV2ParserVisitor<? extends T>)visitor).visitModel(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ModelContext model() throws RecognitionException {
		ModelContext _localctx = new ModelContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_model);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(40);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(32);
				predicate_atom();
				setState(37);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(33);
					match(COMMA);
					setState(34);
					predicate_atom();
					}
					}
					setState(39);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(42);
			match(MODEL_END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OutputContext extends ParserRuleContext {
		public List<Answer_setContext> answer_set() {
			return getRuleContexts(Answer_setContext.class);
		}
		public Answer_setContext answer_set(int i) {
			return getRuleContext(Answer_setContext.class,i);
		}
		public OutputContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_output; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DLV2ParserVisitor ) return ((DLV2ParserVisitor<? extends T>)visitor).visitOutput(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OutputContext output() throws RecognitionException {
		OutputContext _localctx = new OutputContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_output);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(47);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==START) {
				{
				{
				setState(44);
				answer_set();
				}
				}
				setState(49);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Predicate_atomContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(DLV2Parser.IDENTIFIER, 0); }
		public TerminalNode TERMS_BEGIN() { return getToken(DLV2Parser.TERMS_BEGIN, 0); }
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public TerminalNode TERMS_END() { return getToken(DLV2Parser.TERMS_END, 0); }
		public List<TerminalNode> COMMA() { return getTokens(DLV2Parser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(DLV2Parser.COMMA, i);
		}
		public Predicate_atomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicate_atom; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DLV2ParserVisitor ) return ((DLV2ParserVisitor<? extends T>)visitor).visitPredicate_atom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Predicate_atomContext predicate_atom() throws RecognitionException {
		Predicate_atomContext _localctx = new Predicate_atomContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_predicate_atom);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			match(IDENTIFIER);
			setState(62);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TERMS_BEGIN) {
				{
				setState(51);
				match(TERMS_BEGIN);
				setState(52);
				term();
				setState(57);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(53);
					match(COMMA);
					setState(54);
					term();
					}
					}
					setState(59);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(60);
				match(TERMS_END);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TermContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(DLV2Parser.IDENTIFIER, 0); }
		public TerminalNode INTEGER_CONSTANT() { return getToken(DLV2Parser.INTEGER_CONSTANT, 0); }
		public Predicate_atomContext predicate_atom() {
			return getRuleContext(Predicate_atomContext.class,0);
		}
		public TerminalNode STRING_CONSTANT() { return getToken(DLV2Parser.STRING_CONSTANT, 0); }
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DLV2ParserVisitor ) return ((DLV2ParserVisitor<? extends T>)visitor).visitTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_term);
		try {
			setState(68);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(64);
				match(IDENTIFIER);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(65);
				match(INTEGER_CONSTANT);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(66);
				predicate_atom();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(67);
				match(STRING_CONSTANT);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\22I\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3\2\3\2\3\2\5\2\24\n\2\3\3"+
		"\3\3\7\3\30\n\3\f\3\16\3\33\13\3\3\3\3\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\7"+
		"\5&\n\5\f\5\16\5)\13\5\5\5+\n\5\3\5\3\5\3\6\7\6\60\n\6\f\6\16\6\63\13"+
		"\6\3\7\3\7\3\7\3\7\3\7\7\7:\n\7\f\7\16\7=\13\7\3\7\3\7\5\7A\n\7\3\b\3"+
		"\b\3\b\3\b\5\bG\n\b\3\b\2\2\t\2\4\6\b\n\f\16\2\2\2K\2\20\3\2\2\2\4\25"+
		"\3\2\2\2\6\36\3\2\2\2\b*\3\2\2\2\n\61\3\2\2\2\f\64\3\2\2\2\16F\3\2\2\2"+
		"\20\21\7\3\2\2\21\23\5\b\5\2\22\24\5\4\3\2\23\22\3\2\2\2\23\24\3\2\2\2"+
		"\24\3\3\2\2\2\25\31\7\4\2\2\26\30\5\6\4\2\27\26\3\2\2\2\30\33\3\2\2\2"+
		"\31\27\3\2\2\2\31\32\3\2\2\2\32\34\3\2\2\2\33\31\3\2\2\2\34\35\7\t\2\2"+
		"\35\5\3\2\2\2\36\37\7\b\2\2\37 \7\7\2\2 !\7\b\2\2!\7\3\2\2\2\"\'\5\f\7"+
		"\2#$\7\13\2\2$&\5\f\7\2%#\3\2\2\2&)\3\2\2\2\'%\3\2\2\2\'(\3\2\2\2(+\3"+
		"\2\2\2)\'\3\2\2\2*\"\3\2\2\2*+\3\2\2\2+,\3\2\2\2,-\7\16\2\2-\t\3\2\2\2"+
		".\60\5\2\2\2/.\3\2\2\2\60\63\3\2\2\2\61/\3\2\2\2\61\62\3\2\2\2\62\13\3"+
		"\2\2\2\63\61\3\2\2\2\64@\7\r\2\2\65\66\7\20\2\2\66;\5\16\b\2\678\7\13"+
		"\2\28:\5\16\b\29\67\3\2\2\2:=\3\2\2\2;9\3\2\2\2;<\3\2\2\2<>\3\2\2\2=;"+
		"\3\2\2\2>?\7\21\2\2?A\3\2\2\2@\65\3\2\2\2@A\3\2\2\2A\r\3\2\2\2BG\7\r\2"+
		"\2CG\7\f\2\2DG\5\f\7\2EG\7\17\2\2FB\3\2\2\2FC\3\2\2\2FD\3\2\2\2FE\3\2"+
		"\2\2G\17\3\2\2\2\n\23\31\'*\61;@F";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}