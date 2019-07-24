package it.unical.mat.parsers.asp.dlv;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class DLVParser extends Parser {
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
		RULE_answer_set = 0, RULE_cost = 1, RULE_cost_level = 2, RULE_model = 3, 
		RULE_output = 4, RULE_predicate = 5, RULE_term = 6, RULE_witness = 7;
	public static final String[] ruleNames = {
		"answer_set", "cost", "cost_level", "model", "output", "predicate", "term", 
		"witness"
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

	@Override
	public String getGrammarFileName() { return "DLVParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public DLVParser(TokenStream input) {
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
	public static class SimpleModelContext extends Answer_setContext {
		public ModelContext model() {
			return getRuleContext(ModelContext.class,0);
		}
		public SimpleModelContext(Answer_setContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DLVParserVisitor ) return ((DLVParserVisitor<? extends T>)visitor).visitSimpleModel(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class GroundQueryContext extends Answer_setContext {
		public List<TerminalNode> IDENTIFIER() { return getTokens(DLVParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(DLVParser.IDENTIFIER, i);
		}
		public TerminalNode GROUND_QUERY_BEGIN() { return getToken(DLVParser.GROUND_QUERY_BEGIN, 0); }
		public TerminalNode REASONING() { return getToken(DLVParser.REASONING, 0); }
		public TerminalNode BOOLEAN() { return getToken(DLVParser.BOOLEAN, 0); }
		public TerminalNode DOT() { return getToken(DLVParser.DOT, 0); }
		public WitnessContext witness() {
			return getRuleContext(WitnessContext.class,0);
		}
		public List<TerminalNode> COMMA() { return getTokens(DLVParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(DLVParser.COMMA, i);
		}
		public GroundQueryContext(Answer_setContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DLVParserVisitor ) return ((DLVParserVisitor<? extends T>)visitor).visitGroundQuery(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class WeightedModelContext extends Answer_setContext {
		public ModelContext model() {
			return getRuleContext(ModelContext.class,0);
		}
		public CostContext cost() {
			return getRuleContext(CostContext.class,0);
		}
		public TerminalNode WEIGHTED_MODEL_LABEL() { return getToken(DLVParser.WEIGHTED_MODEL_LABEL, 0); }
		public WeightedModelContext(Answer_setContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DLVParserVisitor ) return ((DLVParserVisitor<? extends T>)visitor).visitWeightedModel(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NonGroundQueryContext extends Answer_setContext {
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(DLVParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(DLVParser.COMMA, i);
		}
		public NonGroundQueryContext(Answer_setContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DLVParserVisitor ) return ((DLVParserVisitor<? extends T>)visitor).visitNonGroundQuery(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Answer_setContext answer_set() throws RecognitionException {
		Answer_setContext _localctx = new Answer_setContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_answer_set);
		int _la;
		try {
			setState(46);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
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
			case 2:
				_localctx = new SimpleModelContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(31);
				model();
				}
				break;
			case 3:
				_localctx = new NonGroundQueryContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(32);
				term();
				setState(37);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(33);
					match(COMMA);
					setState(34);
					term();
					}
					}
					setState(39);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 4:
				_localctx = new WeightedModelContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(41);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==WEIGHTED_MODEL_LABEL) {
					{
					setState(40);
					match(WEIGHTED_MODEL_LABEL);
					}
				}

				setState(43);
				model();
				setState(44);
				cost();
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

	public static class CostContext extends ParserRuleContext {
		public TerminalNode COST_BEGIN() { return getToken(DLVParser.COST_BEGIN, 0); }
		public List<Cost_levelContext> cost_level() {
			return getRuleContexts(Cost_levelContext.class);
		}
		public Cost_levelContext cost_level(int i) {
			return getRuleContext(Cost_levelContext.class,i);
		}
		public TerminalNode COST_END() { return getToken(DLVParser.COST_END, 0); }
		public List<TerminalNode> COMMA() { return getTokens(DLVParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(DLVParser.COMMA, i);
		}
		public CostContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cost; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DLVParserVisitor ) return ((DLVParserVisitor<? extends T>)visitor).visitCost(this);
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
			setState(48);
			match(COST_BEGIN);
			setState(49);
			cost_level();
			setState(54);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(50);
				match(COMMA);
				setState(51);
				cost_level();
				}
				}
				setState(56);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(57);
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

	public static class Cost_levelContext extends ParserRuleContext {
		public TerminalNode OPEN_SQUARE_BRACKET() { return getToken(DLVParser.OPEN_SQUARE_BRACKET, 0); }
		public List<TerminalNode> INTEGER_CONSTANT() { return getTokens(DLVParser.INTEGER_CONSTANT); }
		public TerminalNode INTEGER_CONSTANT(int i) {
			return getToken(DLVParser.INTEGER_CONSTANT, i);
		}
		public TerminalNode COLON() { return getToken(DLVParser.COLON, 0); }
		public TerminalNode CLOSE_SQUARE_BRACKET() { return getToken(DLVParser.CLOSE_SQUARE_BRACKET, 0); }
		public Cost_levelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cost_level; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DLVParserVisitor ) return ((DLVParserVisitor<? extends T>)visitor).visitCost_level(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Cost_levelContext cost_level() throws RecognitionException {
		Cost_levelContext _localctx = new Cost_levelContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_cost_level);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
			match(OPEN_SQUARE_BRACKET);
			setState(60);
			match(INTEGER_CONSTANT);
			setState(61);
			match(COLON);
			setState(62);
			match(INTEGER_CONSTANT);
			setState(63);
			match(CLOSE_SQUARE_BRACKET);
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
		public TerminalNode MODEL_BEGIN() { return getToken(DLVParser.MODEL_BEGIN, 0); }
		public TerminalNode MODEL_END() { return getToken(DLVParser.MODEL_END, 0); }
		public List<PredicateContext> predicate() {
			return getRuleContexts(PredicateContext.class);
		}
		public PredicateContext predicate(int i) {
			return getRuleContext(PredicateContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(DLVParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(DLVParser.COMMA, i);
		}
		public ModelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_model; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DLVParserVisitor ) return ((DLVParserVisitor<? extends T>)visitor).visitModel(this);
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
			setState(65);
			match(MODEL_BEGIN);
			setState(74);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(66);
				predicate();
				setState(71);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(67);
					match(COMMA);
					setState(68);
					predicate();
					}
					}
					setState(73);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(76);
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
			if ( visitor instanceof DLVParserVisitor ) return ((DLVParserVisitor<? extends T>)visitor).visitOutput(this);
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
			setState(81);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OPEN_SQUARE_BRACKET) | (1L << MODEL_BEGIN) | (1L << WEIGHTED_MODEL_LABEL) | (1L << IDENTIFIER) | (1L << INTEGER_CONSTANT) | (1L << STRING_CONSTANT))) != 0)) {
				{
				{
				setState(78);
				answer_set();
				}
				}
				setState(83);
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

	public static class PredicateContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(DLVParser.IDENTIFIER, 0); }
		public TerminalNode TERMS_BEGIN() { return getToken(DLVParser.TERMS_BEGIN, 0); }
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public TerminalNode TERMS_END() { return getToken(DLVParser.TERMS_END, 0); }
		public List<TerminalNode> COMMA() { return getTokens(DLVParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(DLVParser.COMMA, i);
		}
		public PredicateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicate; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DLVParserVisitor ) return ((DLVParserVisitor<? extends T>)visitor).visitPredicate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PredicateContext predicate() throws RecognitionException {
		PredicateContext _localctx = new PredicateContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_predicate);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			match(IDENTIFIER);
			setState(96);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TERMS_BEGIN) {
				{
				setState(85);
				match(TERMS_BEGIN);
				setState(86);
				term();
				setState(91);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(87);
					match(COMMA);
					setState(88);
					term();
					}
					}
					setState(93);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(94);
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
		public TerminalNode IDENTIFIER() { return getToken(DLVParser.IDENTIFIER, 0); }
		public TerminalNode INTEGER_CONSTANT() { return getToken(DLVParser.INTEGER_CONSTANT, 0); }
		public PredicateContext predicate() {
			return getRuleContext(PredicateContext.class,0);
		}
		public TerminalNode OPEN_SQUARE_BRACKET() { return getToken(DLVParser.OPEN_SQUARE_BRACKET, 0); }
		public TerminalNode CLOSE_SQUARE_BRACKET() { return getToken(DLVParser.CLOSE_SQUARE_BRACKET, 0); }
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(DLVParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(DLVParser.COMMA, i);
		}
		public TerminalNode STRING_CONSTANT() { return getToken(DLVParser.STRING_CONSTANT, 0); }
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DLVParserVisitor ) return ((DLVParserVisitor<? extends T>)visitor).visitTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_term);
		int _la;
		try {
			setState(114);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(98);
				match(IDENTIFIER);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(99);
				match(INTEGER_CONSTANT);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(100);
				predicate();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(101);
				match(OPEN_SQUARE_BRACKET);
				setState(110);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OPEN_SQUARE_BRACKET) | (1L << IDENTIFIER) | (1L << INTEGER_CONSTANT) | (1L << STRING_CONSTANT))) != 0)) {
					{
					setState(102);
					term();
					setState(107);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(103);
						match(COMMA);
						setState(104);
						term();
						}
						}
						setState(109);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(112);
				match(CLOSE_SQUARE_BRACKET);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(113);
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
		public TerminalNode WITNESS_LABEL() { return getToken(DLVParser.WITNESS_LABEL, 0); }
		public ModelContext model() {
			return getRuleContext(ModelContext.class,0);
		}
		public WitnessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_witness; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DLVParserVisitor ) return ((DLVParserVisitor<? extends T>)visitor).visitWitness(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WitnessContext witness() throws RecognitionException {
		WitnessContext _localctx = new WitnessContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_witness);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			match(WITNESS_LABEL);
			setState(117);
			model();
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\30z\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\3\2\3\2\3\2\7\2\26"+
		"\n\2\f\2\16\2\31\13\2\3\2\3\2\3\2\3\2\3\2\5\2 \n\2\3\2\3\2\3\2\3\2\7\2"+
		"&\n\2\f\2\16\2)\13\2\3\2\5\2,\n\2\3\2\3\2\3\2\5\2\61\n\2\3\3\3\3\3\3\3"+
		"\3\7\3\67\n\3\f\3\16\3:\13\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3"+
		"\5\3\5\7\5H\n\5\f\5\16\5K\13\5\5\5M\n\5\3\5\3\5\3\6\7\6R\n\6\f\6\16\6"+
		"U\13\6\3\7\3\7\3\7\3\7\3\7\7\7\\\n\7\f\7\16\7_\13\7\3\7\3\7\5\7c\n\7\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\7\bl\n\b\f\b\16\bo\13\b\5\bq\n\b\3\b\3\b\5"+
		"\bu\n\b\3\t\3\t\3\t\3\t\2\2\n\2\4\6\b\n\f\16\20\2\2\2\u0084\2\60\3\2\2"+
		"\2\4\62\3\2\2\2\6=\3\2\2\2\bC\3\2\2\2\nS\3\2\2\2\fV\3\2\2\2\16t\3\2\2"+
		"\2\20v\3\2\2\2\22\27\7\16\2\2\23\24\7\r\2\2\24\26\7\16\2\2\25\23\3\2\2"+
		"\2\26\31\3\2\2\2\27\25\3\2\2\2\27\30\3\2\2\2\30\32\3\2\2\2\31\27\3\2\2"+
		"\2\32\33\7\t\2\2\33\34\7\24\2\2\34\37\7\26\2\2\35 \7\25\2\2\36 \5\20\t"+
		"\2\37\35\3\2\2\2\37\36\3\2\2\2 \61\3\2\2\2!\61\5\b\5\2\"\'\5\16\b\2#$"+
		"\7\r\2\2$&\5\16\b\2%#\3\2\2\2&)\3\2\2\2\'%\3\2\2\2\'(\3\2\2\2(\61\3\2"+
		"\2\2)\'\3\2\2\2*,\7\f\2\2+*\3\2\2\2+,\3\2\2\2,-\3\2\2\2-.\5\b\5\2./\5"+
		"\4\3\2/\61\3\2\2\2\60\22\3\2\2\2\60!\3\2\2\2\60\"\3\2\2\2\60+\3\2\2\2"+
		"\61\3\3\2\2\2\62\63\7\5\2\2\638\5\6\4\2\64\65\7\r\2\2\65\67\5\6\4\2\66"+
		"\64\3\2\2\2\67:\3\2\2\28\66\3\2\2\289\3\2\2\29;\3\2\2\2:8\3\2\2\2;<\7"+
		"\6\2\2<\5\3\2\2\2=>\7\7\2\2>?\7\17\2\2?@\7\4\2\2@A\7\17\2\2AB\7\b\2\2"+
		"B\7\3\2\2\2CL\7\n\2\2DI\5\f\7\2EF\7\r\2\2FH\5\f\7\2GE\3\2\2\2HK\3\2\2"+
		"\2IG\3\2\2\2IJ\3\2\2\2JM\3\2\2\2KI\3\2\2\2LD\3\2\2\2LM\3\2\2\2MN\3\2\2"+
		"\2NO\7\13\2\2O\t\3\2\2\2PR\5\2\2\2QP\3\2\2\2RU\3\2\2\2SQ\3\2\2\2ST\3\2"+
		"\2\2T\13\3\2\2\2US\3\2\2\2Vb\7\16\2\2WX\7\21\2\2X]\5\16\b\2YZ\7\r\2\2"+
		"Z\\\5\16\b\2[Y\3\2\2\2\\_\3\2\2\2][\3\2\2\2]^\3\2\2\2^`\3\2\2\2_]\3\2"+
		"\2\2`a\7\22\2\2ac\3\2\2\2bW\3\2\2\2bc\3\2\2\2c\r\3\2\2\2du\7\16\2\2eu"+
		"\7\17\2\2fu\5\f\7\2gp\7\7\2\2hm\5\16\b\2ij\7\r\2\2jl\5\16\b\2ki\3\2\2"+
		"\2lo\3\2\2\2mk\3\2\2\2mn\3\2\2\2nq\3\2\2\2om\3\2\2\2ph\3\2\2\2pq\3\2\2"+
		"\2qr\3\2\2\2ru\7\b\2\2su\7\20\2\2td\3\2\2\2te\3\2\2\2tf\3\2\2\2tg\3\2"+
		"\2\2ts\3\2\2\2u\17\3\2\2\2vw\7\30\2\2wx\5\b\5\2x\21\3\2\2\2\20\27\37\'"+
		"+\608ILS]bmpt";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}