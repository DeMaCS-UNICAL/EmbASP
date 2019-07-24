package it.unical.mat.parsers.asp.dlvhex;

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
		HEADER=1, WHITE_SPACE=2, COLON=3, COMMA=4, COST_BEGIN=5, COST_END=6, INTEGER=7, 
		LEVEL_BEGIN=8, LEVEL_END=9, GROUND_QUERY_BEGIN=10, ANSWER_SET_BEGIN=11, 
		ANSWER_SET_END=12, IDENTIFIER=13, STRING_CONSTANT=14, TERMS_BEGIN=15, 
		TERMS_END=16, REASONING=17, DOT=18, BOOLEAN=19, WHITESPACE_IN_GROUND_QUERY=20, 
		WITNESS_LABEL=21;
	public static final int
		RULE_answer_set = 0, RULE_atoms = 1, RULE_cost = 2, RULE_level = 3, RULE_output = 4, 
		RULE_predicate_atom = 5, RULE_term = 6, RULE_witness = 7;
	public static final String[] ruleNames = {
		"answer_set", "atoms", "cost", "level", "output", "predicate_atom", "term", 
		"witness"
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
		public Answer_setContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_answer_set; }
	 
		public Answer_setContext() { }
		public void copyFrom(Answer_setContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class GroundQueryContext extends Answer_setContext {
		public List<TerminalNode> IDENTIFIER() { return getTokens(DLVHEXParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(DLVHEXParser.IDENTIFIER, i);
		}
		public TerminalNode GROUND_QUERY_BEGIN() { return getToken(DLVHEXParser.GROUND_QUERY_BEGIN, 0); }
		public TerminalNode REASONING() { return getToken(DLVHEXParser.REASONING, 0); }
		public TerminalNode BOOLEAN() { return getToken(DLVHEXParser.BOOLEAN, 0); }
		public TerminalNode DOT() { return getToken(DLVHEXParser.DOT, 0); }
		public WitnessContext witness() {
			return getRuleContext(WitnessContext.class,0);
		}
		public List<TerminalNode> COMMA() { return getTokens(DLVHEXParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(DLVHEXParser.COMMA, i);
		}
		public GroundQueryContext(Answer_setContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DLVHEXParserVisitor ) return ((DLVHEXParserVisitor<? extends T>)visitor).visitGroundQuery(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ModelContext extends Answer_setContext {
		public AtomsContext atoms() {
			return getRuleContext(AtomsContext.class,0);
		}
		public ModelContext(Answer_setContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DLVHEXParserVisitor ) return ((DLVHEXParserVisitor<? extends T>)visitor).visitModel(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Answer_setContext answer_set() throws RecognitionException {
		Answer_setContext _localctx = new Answer_setContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_answer_set);
		int _la;
		try {
			setState(32);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				_localctx = new GroundQueryContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(16);
				match(IDENTIFIER);
				setState(21);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(17);
					match(COMMA);
					setState(18);
					match(IDENTIFIER);
					}
					}
					setState(23);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(24);
				match(GROUND_QUERY_BEGIN);
				setState(25);
				match(REASONING);
				setState(26);
				match(BOOLEAN);
				setState(29);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case DOT:
					{
					setState(27);
					match(DOT);
					}
					break;
				case WITNESS_LABEL:
					{
					setState(28);
					witness();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case ANSWER_SET_BEGIN:
				_localctx = new ModelContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(31);
				atoms();
				}
				break;
			default:
				throw new NoViableAltException(this);
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
		public TerminalNode ANSWER_SET_BEGIN() { return getToken(DLVHEXParser.ANSWER_SET_BEGIN, 0); }
		public TerminalNode ANSWER_SET_END() { return getToken(DLVHEXParser.ANSWER_SET_END, 0); }
		public List<Predicate_atomContext> predicate_atom() {
			return getRuleContexts(Predicate_atomContext.class);
		}
		public Predicate_atomContext predicate_atom(int i) {
			return getRuleContext(Predicate_atomContext.class,i);
		}
		public CostContext cost() {
			return getRuleContext(CostContext.class,0);
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
			setState(34);
			match(ANSWER_SET_BEGIN);
			setState(43);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(35);
				predicate_atom();
				setState(40);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(36);
					match(COMMA);
					setState(37);
					predicate_atom();
					}
					}
					setState(42);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(45);
			match(ANSWER_SET_END);
			setState(47);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COST_BEGIN) {
				{
				setState(46);
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
		public TerminalNode COST_BEGIN() { return getToken(DLVHEXParser.COST_BEGIN, 0); }
		public List<LevelContext> level() {
			return getRuleContexts(LevelContext.class);
		}
		public LevelContext level(int i) {
			return getRuleContext(LevelContext.class,i);
		}
		public TerminalNode COST_END() { return getToken(DLVHEXParser.COST_END, 0); }
		public List<TerminalNode> COMMA() { return getTokens(DLVHEXParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(DLVHEXParser.COMMA, i);
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
			setState(49);
			match(COST_BEGIN);
			setState(50);
			level();
			setState(55);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(51);
				match(COMMA);
				setState(52);
				level();
				}
				}
				setState(57);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(58);
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
			setState(60);
			match(LEVEL_BEGIN);
			setState(61);
			match(INTEGER);
			setState(62);
			match(COLON);
			setState(63);
			match(INTEGER);
			setState(64);
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
			setState(69);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ANSWER_SET_BEGIN || _la==IDENTIFIER) {
				{
				{
				setState(66);
				answer_set();
				}
				}
				setState(71);
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
			setState(72);
			match(IDENTIFIER);
			setState(84);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TERMS_BEGIN) {
				{
				setState(73);
				match(TERMS_BEGIN);
				setState(74);
				term();
				setState(79);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(75);
					match(COMMA);
					setState(76);
					term();
					}
					}
					setState(81);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(82);
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
		public TerminalNode INTEGER() { return getToken(DLVHEXParser.INTEGER, 0); }
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
			setState(90);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(86);
				match(IDENTIFIER);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(87);
				match(INTEGER);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(88);
				predicate_atom();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(89);
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

	public static class WitnessContext extends ParserRuleContext {
		public TerminalNode WITNESS_LABEL() { return getToken(DLVHEXParser.WITNESS_LABEL, 0); }
		public AtomsContext atoms() {
			return getRuleContext(AtomsContext.class,0);
		}
		public WitnessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_witness; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DLVHEXParserVisitor ) return ((DLVHEXParserVisitor<? extends T>)visitor).visitWitness(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WitnessContext witness() throws RecognitionException {
		WitnessContext _localctx = new WitnessContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_witness);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			match(WITNESS_LABEL);
			setState(93);
			atoms();
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\27b\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\3\2\3\2\3\2\7\2\26"+
		"\n\2\f\2\16\2\31\13\2\3\2\3\2\3\2\3\2\3\2\5\2 \n\2\3\2\5\2#\n\2\3\3\3"+
		"\3\3\3\3\3\7\3)\n\3\f\3\16\3,\13\3\5\3.\n\3\3\3\3\3\5\3\62\n\3\3\4\3\4"+
		"\3\4\3\4\7\48\n\4\f\4\16\4;\13\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\7"+
		"\6F\n\6\f\6\16\6I\13\6\3\7\3\7\3\7\3\7\3\7\7\7P\n\7\f\7\16\7S\13\7\3\7"+
		"\3\7\5\7W\n\7\3\b\3\b\3\b\3\b\5\b]\n\b\3\t\3\t\3\t\3\t\2\2\n\2\4\6\b\n"+
		"\f\16\20\2\2\2f\2\"\3\2\2\2\4$\3\2\2\2\6\63\3\2\2\2\b>\3\2\2\2\nG\3\2"+
		"\2\2\fJ\3\2\2\2\16\\\3\2\2\2\20^\3\2\2\2\22\27\7\17\2\2\23\24\7\6\2\2"+
		"\24\26\7\17\2\2\25\23\3\2\2\2\26\31\3\2\2\2\27\25\3\2\2\2\27\30\3\2\2"+
		"\2\30\32\3\2\2\2\31\27\3\2\2\2\32\33\7\f\2\2\33\34\7\23\2\2\34\37\7\25"+
		"\2\2\35 \7\24\2\2\36 \5\20\t\2\37\35\3\2\2\2\37\36\3\2\2\2 #\3\2\2\2!"+
		"#\5\4\3\2\"\22\3\2\2\2\"!\3\2\2\2#\3\3\2\2\2$-\7\r\2\2%*\5\f\7\2&\'\7"+
		"\6\2\2\')\5\f\7\2(&\3\2\2\2),\3\2\2\2*(\3\2\2\2*+\3\2\2\2+.\3\2\2\2,*"+
		"\3\2\2\2-%\3\2\2\2-.\3\2\2\2./\3\2\2\2/\61\7\16\2\2\60\62\5\6\4\2\61\60"+
		"\3\2\2\2\61\62\3\2\2\2\62\5\3\2\2\2\63\64\7\7\2\2\649\5\b\5\2\65\66\7"+
		"\6\2\2\668\5\b\5\2\67\65\3\2\2\28;\3\2\2\29\67\3\2\2\29:\3\2\2\2:<\3\2"+
		"\2\2;9\3\2\2\2<=\7\b\2\2=\7\3\2\2\2>?\7\n\2\2?@\7\t\2\2@A\7\5\2\2AB\7"+
		"\t\2\2BC\7\13\2\2C\t\3\2\2\2DF\5\2\2\2ED\3\2\2\2FI\3\2\2\2GE\3\2\2\2G"+
		"H\3\2\2\2H\13\3\2\2\2IG\3\2\2\2JV\7\17\2\2KL\7\21\2\2LQ\5\16\b\2MN\7\6"+
		"\2\2NP\5\16\b\2OM\3\2\2\2PS\3\2\2\2QO\3\2\2\2QR\3\2\2\2RT\3\2\2\2SQ\3"+
		"\2\2\2TU\7\22\2\2UW\3\2\2\2VK\3\2\2\2VW\3\2\2\2W\r\3\2\2\2X]\7\17\2\2"+
		"Y]\7\t\2\2Z]\5\f\7\2[]\7\20\2\2\\X\3\2\2\2\\Y\3\2\2\2\\Z\3\2\2\2\\[\3"+
		"\2\2\2]\17\3\2\2\2^_\7\27\2\2_`\5\4\3\2`\21\3\2\2\2\r\27\37\"*-\619GQ"+
		"V\\";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}