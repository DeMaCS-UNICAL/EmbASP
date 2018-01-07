package it.unical.mat.embasp.specializations.dlvhex.parser;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class DLVHEXParser extends Parser {
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
		RULE_answer_set = 0, RULE_atoms = 1, RULE_cost = 2, RULE_level = 3, RULE_output = 4, 
		RULE_predicate_atom = 5, RULE_term = 6;
	public static final String[] ruleNames = {
		"answer_set", "atoms", "cost", "level", "output", "predicate_atom", "term"
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

	@Override
	public String getGrammarFileName() { return "DLVHEXParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public DLVHEXParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class Answer_setContext extends ParserRuleContext {
		public TerminalNode START() { return getToken(DLVHEXParser.START, 0); }
		public TerminalNode ANSWER_SET_END() { return getToken(DLVHEXParser.ANSWER_SET_END, 0); }
		public List<AtomsContext> atoms() {
			return getRuleContexts(AtomsContext.class);
		}
		public AtomsContext atoms(int i) {
			return getRuleContext(AtomsContext.class,i);
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
			if ( visitor instanceof DLVHEXParserVisitor ) return ((DLVHEXParserVisitor<? extends T>)visitor).visitAnswer_set(this);
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
			setState(18);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IDENTIFIER) {
				{
				{
				setState(15);
				atoms();
				}
				}
				setState(20);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(21);
			match(ANSWER_SET_END);
			setState(23);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COST_LABEL) {
				{
				setState(22);
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

	public static class AtomsContext extends ParserRuleContext {
		public List<Predicate_atomContext> predicate_atom() {
			return getRuleContexts(Predicate_atomContext.class);
		}
		public Predicate_atomContext predicate_atom(int i) {
			return getRuleContext(Predicate_atomContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(DLVHEXParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(DLVHEXParser.COMMA, i);
		}
		public AtomsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atoms; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DLVHEXParserVisitor ) return ((DLVHEXParserVisitor<? extends T>)visitor).visitAtoms(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomsContext atoms() throws RecognitionException {
		AtomsContext _localctx = new AtomsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_atoms);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(25);
			predicate_atom();
			setState(30);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(26);
				match(COMMA);
				setState(27);
				predicate_atom();
				}
				}
				setState(32);
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

	public static class CostContext extends ParserRuleContext {
		public TerminalNode COST_LABEL() { return getToken(DLVHEXParser.COST_LABEL, 0); }
		public List<LevelContext> level() {
			return getRuleContexts(LevelContext.class);
		}
		public LevelContext level(int i) {
			return getRuleContext(LevelContext.class,i);
		}
		public TerminalNode COST_END() { return getToken(DLVHEXParser.COST_END, 0); }
		public List<TerminalNode> COMMA_IN_COST() { return getTokens(DLVHEXParser.COMMA_IN_COST); }
		public TerminalNode COMMA_IN_COST(int i) {
			return getToken(DLVHEXParser.COMMA_IN_COST, i);
		}
		public CostContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cost; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DLVHEXParserVisitor ) return ((DLVHEXParserVisitor<? extends T>)visitor).visitCost(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CostContext cost() throws RecognitionException {
		CostContext _localctx = new CostContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_cost);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(33);
			match(COST_LABEL);
			setState(34);
			level();
			setState(39);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA_IN_COST) {
				{
				{
				setState(35);
				match(COMMA_IN_COST);
				setState(36);
				level();
				}
				}
				setState(41);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(42);
			match(COST_END);
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
		public TerminalNode LEVEL_BEGIN() { return getToken(DLVHEXParser.LEVEL_BEGIN, 0); }
		public List<TerminalNode> INTEGER() { return getTokens(DLVHEXParser.INTEGER); }
		public TerminalNode INTEGER(int i) {
			return getToken(DLVHEXParser.INTEGER, i);
		}
		public TerminalNode COLON() { return getToken(DLVHEXParser.COLON, 0); }
		public TerminalNode LEVEL_END() { return getToken(DLVHEXParser.LEVEL_END, 0); }
		public LevelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_level; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DLVHEXParserVisitor ) return ((DLVHEXParserVisitor<? extends T>)visitor).visitLevel(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LevelContext level() throws RecognitionException {
		LevelContext _localctx = new LevelContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_level);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44);
			match(LEVEL_BEGIN);
			setState(45);
			match(INTEGER);
			setState(46);
			match(COLON);
			setState(47);
			match(INTEGER);
			setState(48);
			match(LEVEL_END);
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
			if ( visitor instanceof DLVHEXParserVisitor ) return ((DLVHEXParserVisitor<? extends T>)visitor).visitOutput(this);
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
			setState(53);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==START) {
				{
				{
				setState(50);
				answer_set();
				}
				}
				setState(55);
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
		public TerminalNode IDENTIFIER() { return getToken(DLVHEXParser.IDENTIFIER, 0); }
		public TerminalNode TERMS_BEGIN() { return getToken(DLVHEXParser.TERMS_BEGIN, 0); }
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public TerminalNode TERMS_END() { return getToken(DLVHEXParser.TERMS_END, 0); }
		public List<TerminalNode> COMMA() { return getTokens(DLVHEXParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(DLVHEXParser.COMMA, i);
		}
		public Predicate_atomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicate_atom; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DLVHEXParserVisitor ) return ((DLVHEXParserVisitor<? extends T>)visitor).visitPredicate_atom(this);
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
			setState(56);
			match(IDENTIFIER);
			setState(68);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TERMS_BEGIN) {
				{
				setState(57);
				match(TERMS_BEGIN);
				setState(58);
				term();
				setState(63);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(59);
					match(COMMA);
					setState(60);
					term();
					}
					}
					setState(65);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(66);
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
		public TerminalNode IDENTIFIER() { return getToken(DLVHEXParser.IDENTIFIER, 0); }
		public TerminalNode INTEGER_CONSTANT() { return getToken(DLVHEXParser.INTEGER_CONSTANT, 0); }
		public Predicate_atomContext predicate_atom() {
			return getRuleContext(Predicate_atomContext.class,0);
		}
		public TerminalNode STRING_CONSTANT() { return getToken(DLVHEXParser.STRING_CONSTANT, 0); }
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DLVHEXParserVisitor ) return ((DLVHEXParserVisitor<? extends T>)visitor).visitTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_term);
		try {
			setState(74);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(70);
				match(IDENTIFIER);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(71);
				match(INTEGER_CONSTANT);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(72);
				predicate_atom();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(73);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\25O\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3\2\3\2\7\2\23\n\2\f\2\16\2"+
		"\26\13\2\3\2\3\2\5\2\32\n\2\3\3\3\3\3\3\7\3\37\n\3\f\3\16\3\"\13\3\3\4"+
		"\3\4\3\4\3\4\7\4(\n\4\f\4\16\4+\13\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\6\7\6\66\n\6\f\6\16\69\13\6\3\7\3\7\3\7\3\7\3\7\7\7@\n\7\f\7\16\7C\13"+
		"\7\3\7\3\7\5\7G\n\7\3\b\3\b\3\b\3\b\5\bM\n\b\3\b\2\2\t\2\4\6\b\n\f\16"+
		"\2\2\2Q\2\20\3\2\2\2\4\33\3\2\2\2\6#\3\2\2\2\b.\3\2\2\2\n\67\3\2\2\2\f"+
		":\3\2\2\2\16L\3\2\2\2\20\24\7\3\2\2\21\23\5\4\3\2\22\21\3\2\2\2\23\26"+
		"\3\2\2\2\24\22\3\2\2\2\24\25\3\2\2\2\25\27\3\2\2\2\26\24\3\2\2\2\27\31"+
		"\7\n\2\2\30\32\5\6\4\2\31\30\3\2\2\2\31\32\3\2\2\2\32\3\3\2\2\2\33 \5"+
		"\f\7\2\34\35\7\7\2\2\35\37\5\f\7\2\36\34\3\2\2\2\37\"\3\2\2\2 \36\3\2"+
		"\2\2 !\3\2\2\2!\5\3\2\2\2\" \3\2\2\2#$\7\4\2\2$)\5\b\5\2%&\7\21\2\2&("+
		"\5\b\5\2\'%\3\2\2\2(+\3\2\2\2)\'\3\2\2\2)*\3\2\2\2*,\3\2\2\2+)\3\2\2\2"+
		",-\7\22\2\2-\7\3\2\2\2./\7\24\2\2/\60\7\23\2\2\60\61\7\20\2\2\61\62\7"+
		"\23\2\2\62\63\7\25\2\2\63\t\3\2\2\2\64\66\5\2\2\2\65\64\3\2\2\2\669\3"+
		"\2\2\2\67\65\3\2\2\2\678\3\2\2\28\13\3\2\2\29\67\3\2\2\2:F\7\t\2\2;<\7"+
		"\f\2\2<A\5\16\b\2=>\7\7\2\2>@\5\16\b\2?=\3\2\2\2@C\3\2\2\2A?\3\2\2\2A"+
		"B\3\2\2\2BD\3\2\2\2CA\3\2\2\2DE\7\r\2\2EG\3\2\2\2F;\3\2\2\2FG\3\2\2\2"+
		"G\r\3\2\2\2HM\7\t\2\2IM\7\b\2\2JM\5\f\7\2KM\7\13\2\2LH\3\2\2\2LI\3\2\2"+
		"\2LJ\3\2\2\2LK\3\2\2\2M\17\3\2\2\2\n\24\31 )\67AFL";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}