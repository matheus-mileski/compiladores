// Generated from /Users/ribeiro/Desktop/compiladores/CompiladorGyhAntlr/src/Gyh.g4 by ANTLR 4.10.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GyhParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.10.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, PC=17, 
		Atrib=18, Delim=19, OpRel=20, OpArit=21, AbrePar=22, FechaPar=23, OpBoolE=24, 
		OpBoolOu=25, Cadeia=26, Var=27, NumInt=28, NumReal=29, Comentario=30, 
		EspacoBranco=31;
	public static final int
		RULE_programa = 0, RULE_listaDeclaracoes = 1, RULE_declaracao = 2, RULE_tipoVar = 3, 
		RULE_expressaoAritmetica = 4, RULE_termoAritmetico = 5, RULE_fatorAritmetico = 6, 
		RULE_expressaoRelacional = 7, RULE_termoRelacional = 8, RULE_operadorBooleano = 9, 
		RULE_listaComandos = 10, RULE_comando = 11, RULE_comandoAtribuicao = 12, 
		RULE_comandoEntrada = 13, RULE_comandoSaida = 14, RULE_comandoCondicao = 15, 
		RULE_comandoRepeticao = 16, RULE_subAlgoritmo = 17;
	private static String[] makeRuleNames() {
		return new String[] {
			"programa", "listaDeclaracoes", "declaracao", "tipoVar", "expressaoAritmetica", 
			"termoAritmetico", "fatorAritmetico", "expressaoRelacional", "termoRelacional", 
			"operadorBooleano", "listaComandos", "comando", "comandoAtribuicao", 
			"comandoEntrada", "comandoSaida", "comandoCondicao", "comandoRepeticao", 
			"subAlgoritmo"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'DEC'", "'PROG'", "'INT'", "'REAL'", "'+'", "'-'", "'*'", "'/'", 
			"'LER'", "'IMPRIMIR'", "'SE'", "'ENTAO'", "'SENAO'", "'ENQTO'", "'INI'", 
			"'FIM'", null, "':='", "':'", null, null, "'('", "')'", "'E'", "'OU'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, "PC", "Atrib", "Delim", "OpRel", "OpArit", 
			"AbrePar", "FechaPar", "OpBoolE", "OpBoolOu", "Cadeia", "Var", "NumInt", 
			"NumReal", "Comentario", "EspacoBranco"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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
	public String getGrammarFileName() { return "Gyh.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	    private String _varName;
	    private int _varType;
	    private String _varValue;
	    private Symbol _varSymbol;
	    private SymbolTable _symbolTable = new SymbolTable();

	public GyhParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramaContext extends ParserRuleContext {
		public List<TerminalNode> Delim() { return getTokens(GyhParser.Delim); }
		public TerminalNode Delim(int i) {
			return getToken(GyhParser.Delim, i);
		}
		public ListaDeclaracoesContext listaDeclaracoes() {
			return getRuleContext(ListaDeclaracoesContext.class,0);
		}
		public ListaComandosContext listaComandos() {
			return getRuleContext(ListaComandosContext.class,0);
		}
		public TerminalNode EOF() { return getToken(GyhParser.EOF, 0); }
		public ProgramaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programa; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GyhListener ) ((GyhListener)listener).enterPrograma(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GyhListener ) ((GyhListener)listener).exitPrograma(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GyhVisitor ) return ((GyhVisitor<? extends T>)visitor).visitPrograma(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramaContext programa() throws RecognitionException {
		ProgramaContext _localctx = new ProgramaContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_programa);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(36);
			match(Delim);
			setState(37);
			match(T__0);
			setState(38);
			listaDeclaracoes();
			setState(39);
			match(Delim);
			setState(40);
			match(T__1);
			setState(41);
			listaComandos();
			setState(42);
			match(EOF);
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

	public static class ListaDeclaracoesContext extends ParserRuleContext {
		public DeclaracaoContext declaracao() {
			return getRuleContext(DeclaracaoContext.class,0);
		}
		public ListaDeclaracoesContext listaDeclaracoes() {
			return getRuleContext(ListaDeclaracoesContext.class,0);
		}
		public ListaDeclaracoesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listaDeclaracoes; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GyhListener ) ((GyhListener)listener).enterListaDeclaracoes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GyhListener ) ((GyhListener)listener).exitListaDeclaracoes(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GyhVisitor ) return ((GyhVisitor<? extends T>)visitor).visitListaDeclaracoes(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListaDeclaracoesContext listaDeclaracoes() throws RecognitionException {
		ListaDeclaracoesContext _localctx = new ListaDeclaracoesContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_listaDeclaracoes);
		try {
			setState(48);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(44);
				declaracao();
				setState(45);
				listaDeclaracoes();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(47);
				declaracao();
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

	public static class DeclaracaoContext extends ParserRuleContext {
		public TerminalNode Var() { return getToken(GyhParser.Var, 0); }
		public TerminalNode Delim() { return getToken(GyhParser.Delim, 0); }
		public TipoVarContext tipoVar() {
			return getRuleContext(TipoVarContext.class,0);
		}
		public DeclaracaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GyhListener ) ((GyhListener)listener).enterDeclaracao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GyhListener ) ((GyhListener)listener).exitDeclaracao(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GyhVisitor ) return ((GyhVisitor<? extends T>)visitor).visitDeclaracao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclaracaoContext declaracao() throws RecognitionException {
		DeclaracaoContext _localctx = new DeclaracaoContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_declaracao);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			match(Var);
			setState(51);
			match(Delim);
			setState(52);
			tipoVar();

			    _varName = _input.LT(-3).getText();
			    if (_input.LT(-1).getText() == "INT")
			        _varType = 0;
			    else
			        _varType = 1;
			    _varValue = null;
			    _varSymbol = new Symbol(_varName, _varType, _varValue);

			    if(!_symbolTable.contains(_varSymbol.getName())) {
			        _symbolTable.addSymbol(_varSymbol);
			        System.out.println("adicionado: " + _varSymbol.toString());
			    } else
			        System.out.println("Erro semantico: " + _varSymbol.toString() + " já existe!");

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

	public static class TipoVarContext extends ParserRuleContext {
		public TipoVarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipoVar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GyhListener ) ((GyhListener)listener).enterTipoVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GyhListener ) ((GyhListener)listener).exitTipoVar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GyhVisitor ) return ((GyhVisitor<? extends T>)visitor).visitTipoVar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TipoVarContext tipoVar() throws RecognitionException {
		TipoVarContext _localctx = new TipoVarContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_tipoVar);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			_la = _input.LA(1);
			if ( !(_la==T__2 || _la==T__3) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class ExpressaoAritmeticaContext extends ParserRuleContext {
		public TermoAritmeticoContext termoAritmetico() {
			return getRuleContext(TermoAritmeticoContext.class,0);
		}
		public ExpressaoAritmeticaContext expressaoAritmetica() {
			return getRuleContext(ExpressaoAritmeticaContext.class,0);
		}
		public ExpressaoAritmeticaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressaoAritmetica; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GyhListener ) ((GyhListener)listener).enterExpressaoAritmetica(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GyhListener ) ((GyhListener)listener).exitExpressaoAritmetica(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GyhVisitor ) return ((GyhVisitor<? extends T>)visitor).visitExpressaoAritmetica(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressaoAritmeticaContext expressaoAritmetica() throws RecognitionException {
		return expressaoAritmetica(0);
	}

	private ExpressaoAritmeticaContext expressaoAritmetica(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressaoAritmeticaContext _localctx = new ExpressaoAritmeticaContext(_ctx, _parentState);
		ExpressaoAritmeticaContext _prevctx = _localctx;
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_expressaoAritmetica, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(58);
			termoAritmetico(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(68);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(66);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressaoAritmeticaContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expressaoAritmetica);
						setState(60);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(61);
						match(T__4);
						setState(62);
						termoAritmetico(0);
						}
						break;
					case 2:
						{
						_localctx = new ExpressaoAritmeticaContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expressaoAritmetica);
						setState(63);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(64);
						match(T__5);
						setState(65);
						termoAritmetico(0);
						}
						break;
					}
					} 
				}
				setState(70);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class TermoAritmeticoContext extends ParserRuleContext {
		public FatorAritmeticoContext fatorAritmetico() {
			return getRuleContext(FatorAritmeticoContext.class,0);
		}
		public TermoAritmeticoContext termoAritmetico() {
			return getRuleContext(TermoAritmeticoContext.class,0);
		}
		public TermoAritmeticoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termoAritmetico; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GyhListener ) ((GyhListener)listener).enterTermoAritmetico(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GyhListener ) ((GyhListener)listener).exitTermoAritmetico(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GyhVisitor ) return ((GyhVisitor<? extends T>)visitor).visitTermoAritmetico(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermoAritmeticoContext termoAritmetico() throws RecognitionException {
		return termoAritmetico(0);
	}

	private TermoAritmeticoContext termoAritmetico(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TermoAritmeticoContext _localctx = new TermoAritmeticoContext(_ctx, _parentState);
		TermoAritmeticoContext _prevctx = _localctx;
		int _startState = 10;
		enterRecursionRule(_localctx, 10, RULE_termoAritmetico, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(72);
			fatorAritmetico();
			}
			_ctx.stop = _input.LT(-1);
			setState(82);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(80);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
					case 1:
						{
						_localctx = new TermoAritmeticoContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_termoAritmetico);
						setState(74);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(75);
						match(T__6);
						setState(76);
						fatorAritmetico();
						}
						break;
					case 2:
						{
						_localctx = new TermoAritmeticoContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_termoAritmetico);
						setState(77);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(78);
						match(T__7);
						setState(79);
						fatorAritmetico();
						}
						break;
					}
					} 
				}
				setState(84);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class FatorAritmeticoContext extends ParserRuleContext {
		public TerminalNode NumInt() { return getToken(GyhParser.NumInt, 0); }
		public TerminalNode NumReal() { return getToken(GyhParser.NumReal, 0); }
		public TerminalNode Var() { return getToken(GyhParser.Var, 0); }
		public TerminalNode AbrePar() { return getToken(GyhParser.AbrePar, 0); }
		public ExpressaoAritmeticaContext expressaoAritmetica() {
			return getRuleContext(ExpressaoAritmeticaContext.class,0);
		}
		public TerminalNode FechaPar() { return getToken(GyhParser.FechaPar, 0); }
		public FatorAritmeticoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fatorAritmetico; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GyhListener ) ((GyhListener)listener).enterFatorAritmetico(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GyhListener ) ((GyhListener)listener).exitFatorAritmetico(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GyhVisitor ) return ((GyhVisitor<? extends T>)visitor).visitFatorAritmetico(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FatorAritmeticoContext fatorAritmetico() throws RecognitionException {
		FatorAritmeticoContext _localctx = new FatorAritmeticoContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_fatorAritmetico);
		try {
			setState(92);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NumInt:
				enterOuterAlt(_localctx, 1);
				{
				setState(85);
				match(NumInt);
				}
				break;
			case NumReal:
				enterOuterAlt(_localctx, 2);
				{
				setState(86);
				match(NumReal);
				}
				break;
			case Var:
				enterOuterAlt(_localctx, 3);
				{
				setState(87);
				match(Var);
				}
				break;
			case AbrePar:
				enterOuterAlt(_localctx, 4);
				{
				setState(88);
				match(AbrePar);
				setState(89);
				expressaoAritmetica(0);
				setState(90);
				match(FechaPar);
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

	public static class ExpressaoRelacionalContext extends ParserRuleContext {
		public TermoRelacionalContext termoRelacional() {
			return getRuleContext(TermoRelacionalContext.class,0);
		}
		public ExpressaoRelacionalContext expressaoRelacional() {
			return getRuleContext(ExpressaoRelacionalContext.class,0);
		}
		public OperadorBooleanoContext operadorBooleano() {
			return getRuleContext(OperadorBooleanoContext.class,0);
		}
		public ExpressaoRelacionalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressaoRelacional; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GyhListener ) ((GyhListener)listener).enterExpressaoRelacional(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GyhListener ) ((GyhListener)listener).exitExpressaoRelacional(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GyhVisitor ) return ((GyhVisitor<? extends T>)visitor).visitExpressaoRelacional(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressaoRelacionalContext expressaoRelacional() throws RecognitionException {
		return expressaoRelacional(0);
	}

	private ExpressaoRelacionalContext expressaoRelacional(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressaoRelacionalContext _localctx = new ExpressaoRelacionalContext(_ctx, _parentState);
		ExpressaoRelacionalContext _prevctx = _localctx;
		int _startState = 14;
		enterRecursionRule(_localctx, 14, RULE_expressaoRelacional, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(95);
			termoRelacional();
			}
			_ctx.stop = _input.LT(-1);
			setState(103);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExpressaoRelacionalContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_expressaoRelacional);
					setState(97);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(98);
					operadorBooleano();
					setState(99);
					termoRelacional();
					}
					} 
				}
				setState(105);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class TermoRelacionalContext extends ParserRuleContext {
		public List<ExpressaoAritmeticaContext> expressaoAritmetica() {
			return getRuleContexts(ExpressaoAritmeticaContext.class);
		}
		public ExpressaoAritmeticaContext expressaoAritmetica(int i) {
			return getRuleContext(ExpressaoAritmeticaContext.class,i);
		}
		public TerminalNode OpRel() { return getToken(GyhParser.OpRel, 0); }
		public TerminalNode AbrePar() { return getToken(GyhParser.AbrePar, 0); }
		public ExpressaoRelacionalContext expressaoRelacional() {
			return getRuleContext(ExpressaoRelacionalContext.class,0);
		}
		public TerminalNode FechaPar() { return getToken(GyhParser.FechaPar, 0); }
		public TermoRelacionalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termoRelacional; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GyhListener ) ((GyhListener)listener).enterTermoRelacional(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GyhListener ) ((GyhListener)listener).exitTermoRelacional(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GyhVisitor ) return ((GyhVisitor<? extends T>)visitor).visitTermoRelacional(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermoRelacionalContext termoRelacional() throws RecognitionException {
		TermoRelacionalContext _localctx = new TermoRelacionalContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_termoRelacional);
		try {
			setState(114);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(106);
				expressaoAritmetica(0);
				setState(107);
				match(OpRel);
				setState(108);
				expressaoAritmetica(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(110);
				match(AbrePar);
				setState(111);
				expressaoRelacional(0);
				setState(112);
				match(FechaPar);
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

	public static class OperadorBooleanoContext extends ParserRuleContext {
		public TerminalNode OpBoolE() { return getToken(GyhParser.OpBoolE, 0); }
		public TerminalNode OpBoolOu() { return getToken(GyhParser.OpBoolOu, 0); }
		public OperadorBooleanoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operadorBooleano; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GyhListener ) ((GyhListener)listener).enterOperadorBooleano(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GyhListener ) ((GyhListener)listener).exitOperadorBooleano(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GyhVisitor ) return ((GyhVisitor<? extends T>)visitor).visitOperadorBooleano(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OperadorBooleanoContext operadorBooleano() throws RecognitionException {
		OperadorBooleanoContext _localctx = new OperadorBooleanoContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_operadorBooleano);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			_la = _input.LA(1);
			if ( !(_la==OpBoolE || _la==OpBoolOu) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class ListaComandosContext extends ParserRuleContext {
		public ComandoContext comando() {
			return getRuleContext(ComandoContext.class,0);
		}
		public ListaComandosContext listaComandos() {
			return getRuleContext(ListaComandosContext.class,0);
		}
		public ListaComandosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listaComandos; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GyhListener ) ((GyhListener)listener).enterListaComandos(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GyhListener ) ((GyhListener)listener).exitListaComandos(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GyhVisitor ) return ((GyhVisitor<? extends T>)visitor).visitListaComandos(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListaComandosContext listaComandos() throws RecognitionException {
		ListaComandosContext _localctx = new ListaComandosContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_listaComandos);
		try {
			setState(122);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(118);
				comando();
				setState(119);
				listaComandos();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(121);
				comando();
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

	public static class ComandoContext extends ParserRuleContext {
		public ComandoAtribuicaoContext comandoAtribuicao() {
			return getRuleContext(ComandoAtribuicaoContext.class,0);
		}
		public ComandoEntradaContext comandoEntrada() {
			return getRuleContext(ComandoEntradaContext.class,0);
		}
		public ComandoSaidaContext comandoSaida() {
			return getRuleContext(ComandoSaidaContext.class,0);
		}
		public ComandoCondicaoContext comandoCondicao() {
			return getRuleContext(ComandoCondicaoContext.class,0);
		}
		public ComandoRepeticaoContext comandoRepeticao() {
			return getRuleContext(ComandoRepeticaoContext.class,0);
		}
		public SubAlgoritmoContext subAlgoritmo() {
			return getRuleContext(SubAlgoritmoContext.class,0);
		}
		public ComandoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comando; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GyhListener ) ((GyhListener)listener).enterComando(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GyhListener ) ((GyhListener)listener).exitComando(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GyhVisitor ) return ((GyhVisitor<? extends T>)visitor).visitComando(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComandoContext comando() throws RecognitionException {
		ComandoContext _localctx = new ComandoContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_comando);
		try {
			setState(130);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Var:
				enterOuterAlt(_localctx, 1);
				{
				setState(124);
				comandoAtribuicao();
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 2);
				{
				setState(125);
				comandoEntrada();
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 3);
				{
				setState(126);
				comandoSaida();
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 4);
				{
				setState(127);
				comandoCondicao();
				}
				break;
			case T__13:
				enterOuterAlt(_localctx, 5);
				{
				setState(128);
				comandoRepeticao();
				}
				break;
			case T__14:
				enterOuterAlt(_localctx, 6);
				{
				setState(129);
				subAlgoritmo();
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

	public static class ComandoAtribuicaoContext extends ParserRuleContext {
		public TerminalNode Var() { return getToken(GyhParser.Var, 0); }
		public TerminalNode Atrib() { return getToken(GyhParser.Atrib, 0); }
		public ExpressaoAritmeticaContext expressaoAritmetica() {
			return getRuleContext(ExpressaoAritmeticaContext.class,0);
		}
		public ComandoAtribuicaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comandoAtribuicao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GyhListener ) ((GyhListener)listener).enterComandoAtribuicao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GyhListener ) ((GyhListener)listener).exitComandoAtribuicao(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GyhVisitor ) return ((GyhVisitor<? extends T>)visitor).visitComandoAtribuicao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComandoAtribuicaoContext comandoAtribuicao() throws RecognitionException {
		ComandoAtribuicaoContext _localctx = new ComandoAtribuicaoContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_comandoAtribuicao);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			match(Var);
			setState(133);
			match(Atrib);
			setState(134);
			expressaoAritmetica(0);
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

	public static class ComandoEntradaContext extends ParserRuleContext {
		public TerminalNode Var() { return getToken(GyhParser.Var, 0); }
		public ComandoEntradaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comandoEntrada; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GyhListener ) ((GyhListener)listener).enterComandoEntrada(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GyhListener ) ((GyhListener)listener).exitComandoEntrada(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GyhVisitor ) return ((GyhVisitor<? extends T>)visitor).visitComandoEntrada(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComandoEntradaContext comandoEntrada() throws RecognitionException {
		ComandoEntradaContext _localctx = new ComandoEntradaContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_comandoEntrada);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136);
			match(T__8);
			setState(137);
			match(Var);
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

	public static class ComandoSaidaContext extends ParserRuleContext {
		public TerminalNode Var() { return getToken(GyhParser.Var, 0); }
		public TerminalNode Cadeia() { return getToken(GyhParser.Cadeia, 0); }
		public ComandoSaidaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comandoSaida; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GyhListener ) ((GyhListener)listener).enterComandoSaida(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GyhListener ) ((GyhListener)listener).exitComandoSaida(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GyhVisitor ) return ((GyhVisitor<? extends T>)visitor).visitComandoSaida(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComandoSaidaContext comandoSaida() throws RecognitionException {
		ComandoSaidaContext _localctx = new ComandoSaidaContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_comandoSaida);
		try {
			setState(143);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(139);
				match(T__9);
				setState(140);
				match(Var);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(141);
				match(T__9);
				setState(142);
				match(Cadeia);
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

	public static class ComandoCondicaoContext extends ParserRuleContext {
		public ExpressaoRelacionalContext expressaoRelacional() {
			return getRuleContext(ExpressaoRelacionalContext.class,0);
		}
		public List<ComandoContext> comando() {
			return getRuleContexts(ComandoContext.class);
		}
		public ComandoContext comando(int i) {
			return getRuleContext(ComandoContext.class,i);
		}
		public ComandoCondicaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comandoCondicao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GyhListener ) ((GyhListener)listener).enterComandoCondicao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GyhListener ) ((GyhListener)listener).exitComandoCondicao(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GyhVisitor ) return ((GyhVisitor<? extends T>)visitor).visitComandoCondicao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComandoCondicaoContext comandoCondicao() throws RecognitionException {
		ComandoCondicaoContext _localctx = new ComandoCondicaoContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_comandoCondicao);
		try {
			setState(157);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(145);
				match(T__10);
				setState(146);
				expressaoRelacional(0);
				setState(147);
				match(T__11);
				setState(148);
				comando();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(150);
				match(T__10);
				setState(151);
				expressaoRelacional(0);
				setState(152);
				match(T__11);
				setState(153);
				comando();
				setState(154);
				match(T__12);
				setState(155);
				comando();
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

	public static class ComandoRepeticaoContext extends ParserRuleContext {
		public ExpressaoRelacionalContext expressaoRelacional() {
			return getRuleContext(ExpressaoRelacionalContext.class,0);
		}
		public ComandoContext comando() {
			return getRuleContext(ComandoContext.class,0);
		}
		public ComandoRepeticaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comandoRepeticao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GyhListener ) ((GyhListener)listener).enterComandoRepeticao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GyhListener ) ((GyhListener)listener).exitComandoRepeticao(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GyhVisitor ) return ((GyhVisitor<? extends T>)visitor).visitComandoRepeticao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComandoRepeticaoContext comandoRepeticao() throws RecognitionException {
		ComandoRepeticaoContext _localctx = new ComandoRepeticaoContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_comandoRepeticao);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(159);
			match(T__13);
			setState(160);
			expressaoRelacional(0);
			setState(161);
			comando();
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

	public static class SubAlgoritmoContext extends ParserRuleContext {
		public ListaComandosContext listaComandos() {
			return getRuleContext(ListaComandosContext.class,0);
		}
		public SubAlgoritmoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subAlgoritmo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GyhListener ) ((GyhListener)listener).enterSubAlgoritmo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GyhListener ) ((GyhListener)listener).exitSubAlgoritmo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GyhVisitor ) return ((GyhVisitor<? extends T>)visitor).visitSubAlgoritmo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SubAlgoritmoContext subAlgoritmo() throws RecognitionException {
		SubAlgoritmoContext _localctx = new SubAlgoritmoContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_subAlgoritmo);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(163);
			match(T__14);
			setState(164);
			listaComandos();
			setState(165);
			match(T__15);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 4:
			return expressaoAritmetica_sempred((ExpressaoAritmeticaContext)_localctx, predIndex);
		case 5:
			return termoAritmetico_sempred((TermoAritmeticoContext)_localctx, predIndex);
		case 7:
			return expressaoRelacional_sempred((ExpressaoRelacionalContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expressaoAritmetica_sempred(ExpressaoAritmeticaContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 3);
		case 1:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean termoAritmetico_sempred(TermoAritmeticoContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 3);
		case 3:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean expressaoRelacional_sempred(ExpressaoRelacionalContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u001f\u00a8\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007"+
		"\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u00011\b"+
		"\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004C\b"+
		"\u0004\n\u0004\f\u0004F\t\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0005"+
		"\u0005Q\b\u0005\n\u0005\f\u0005T\t\u0005\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006]\b"+
		"\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0005\u0007f\b\u0007\n\u0007\f\u0007i\t\u0007\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003\bs\b"+
		"\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0003\n{\b\n\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003"+
		"\u000b\u0083\b\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001"+
		"\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u0090\b"+
		"\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0003\u000f\u009e\b\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0000"+
		"\u0003\b\n\u000e\u0012\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012"+
		"\u0014\u0016\u0018\u001a\u001c\u001e \"\u0000\u0002\u0001\u0000\u0003"+
		"\u0004\u0001\u0000\u0018\u0019\u00a7\u0000$\u0001\u0000\u0000\u0000\u0002"+
		"0\u0001\u0000\u0000\u0000\u00042\u0001\u0000\u0000\u0000\u00067\u0001"+
		"\u0000\u0000\u0000\b9\u0001\u0000\u0000\u0000\nG\u0001\u0000\u0000\u0000"+
		"\f\\\u0001\u0000\u0000\u0000\u000e^\u0001\u0000\u0000\u0000\u0010r\u0001"+
		"\u0000\u0000\u0000\u0012t\u0001\u0000\u0000\u0000\u0014z\u0001\u0000\u0000"+
		"\u0000\u0016\u0082\u0001\u0000\u0000\u0000\u0018\u0084\u0001\u0000\u0000"+
		"\u0000\u001a\u0088\u0001\u0000\u0000\u0000\u001c\u008f\u0001\u0000\u0000"+
		"\u0000\u001e\u009d\u0001\u0000\u0000\u0000 \u009f\u0001\u0000\u0000\u0000"+
		"\"\u00a3\u0001\u0000\u0000\u0000$%\u0005\u0013\u0000\u0000%&\u0005\u0001"+
		"\u0000\u0000&\'\u0003\u0002\u0001\u0000\'(\u0005\u0013\u0000\u0000()\u0005"+
		"\u0002\u0000\u0000)*\u0003\u0014\n\u0000*+\u0005\u0000\u0000\u0001+\u0001"+
		"\u0001\u0000\u0000\u0000,-\u0003\u0004\u0002\u0000-.\u0003\u0002\u0001"+
		"\u0000.1\u0001\u0000\u0000\u0000/1\u0003\u0004\u0002\u00000,\u0001\u0000"+
		"\u0000\u00000/\u0001\u0000\u0000\u00001\u0003\u0001\u0000\u0000\u0000"+
		"23\u0005\u001b\u0000\u000034\u0005\u0013\u0000\u000045\u0003\u0006\u0003"+
		"\u000056\u0006\u0002\uffff\uffff\u00006\u0005\u0001\u0000\u0000\u0000"+
		"78\u0007\u0000\u0000\u00008\u0007\u0001\u0000\u0000\u00009:\u0006\u0004"+
		"\uffff\uffff\u0000:;\u0003\n\u0005\u0000;D\u0001\u0000\u0000\u0000<=\n"+
		"\u0003\u0000\u0000=>\u0005\u0005\u0000\u0000>C\u0003\n\u0005\u0000?@\n"+
		"\u0002\u0000\u0000@A\u0005\u0006\u0000\u0000AC\u0003\n\u0005\u0000B<\u0001"+
		"\u0000\u0000\u0000B?\u0001\u0000\u0000\u0000CF\u0001\u0000\u0000\u0000"+
		"DB\u0001\u0000\u0000\u0000DE\u0001\u0000\u0000\u0000E\t\u0001\u0000\u0000"+
		"\u0000FD\u0001\u0000\u0000\u0000GH\u0006\u0005\uffff\uffff\u0000HI\u0003"+
		"\f\u0006\u0000IR\u0001\u0000\u0000\u0000JK\n\u0003\u0000\u0000KL\u0005"+
		"\u0007\u0000\u0000LQ\u0003\f\u0006\u0000MN\n\u0002\u0000\u0000NO\u0005"+
		"\b\u0000\u0000OQ\u0003\f\u0006\u0000PJ\u0001\u0000\u0000\u0000PM\u0001"+
		"\u0000\u0000\u0000QT\u0001\u0000\u0000\u0000RP\u0001\u0000\u0000\u0000"+
		"RS\u0001\u0000\u0000\u0000S\u000b\u0001\u0000\u0000\u0000TR\u0001\u0000"+
		"\u0000\u0000U]\u0005\u001c\u0000\u0000V]\u0005\u001d\u0000\u0000W]\u0005"+
		"\u001b\u0000\u0000XY\u0005\u0016\u0000\u0000YZ\u0003\b\u0004\u0000Z[\u0005"+
		"\u0017\u0000\u0000[]\u0001\u0000\u0000\u0000\\U\u0001\u0000\u0000\u0000"+
		"\\V\u0001\u0000\u0000\u0000\\W\u0001\u0000\u0000\u0000\\X\u0001\u0000"+
		"\u0000\u0000]\r\u0001\u0000\u0000\u0000^_\u0006\u0007\uffff\uffff\u0000"+
		"_`\u0003\u0010\b\u0000`g\u0001\u0000\u0000\u0000ab\n\u0002\u0000\u0000"+
		"bc\u0003\u0012\t\u0000cd\u0003\u0010\b\u0000df\u0001\u0000\u0000\u0000"+
		"ea\u0001\u0000\u0000\u0000fi\u0001\u0000\u0000\u0000ge\u0001\u0000\u0000"+
		"\u0000gh\u0001\u0000\u0000\u0000h\u000f\u0001\u0000\u0000\u0000ig\u0001"+
		"\u0000\u0000\u0000jk\u0003\b\u0004\u0000kl\u0005\u0014\u0000\u0000lm\u0003"+
		"\b\u0004\u0000ms\u0001\u0000\u0000\u0000no\u0005\u0016\u0000\u0000op\u0003"+
		"\u000e\u0007\u0000pq\u0005\u0017\u0000\u0000qs\u0001\u0000\u0000\u0000"+
		"rj\u0001\u0000\u0000\u0000rn\u0001\u0000\u0000\u0000s\u0011\u0001\u0000"+
		"\u0000\u0000tu\u0007\u0001\u0000\u0000u\u0013\u0001\u0000\u0000\u0000"+
		"vw\u0003\u0016\u000b\u0000wx\u0003\u0014\n\u0000x{\u0001\u0000\u0000\u0000"+
		"y{\u0003\u0016\u000b\u0000zv\u0001\u0000\u0000\u0000zy\u0001\u0000\u0000"+
		"\u0000{\u0015\u0001\u0000\u0000\u0000|\u0083\u0003\u0018\f\u0000}\u0083"+
		"\u0003\u001a\r\u0000~\u0083\u0003\u001c\u000e\u0000\u007f\u0083\u0003"+
		"\u001e\u000f\u0000\u0080\u0083\u0003 \u0010\u0000\u0081\u0083\u0003\""+
		"\u0011\u0000\u0082|\u0001\u0000\u0000\u0000\u0082}\u0001\u0000\u0000\u0000"+
		"\u0082~\u0001\u0000\u0000\u0000\u0082\u007f\u0001\u0000\u0000\u0000\u0082"+
		"\u0080\u0001\u0000\u0000\u0000\u0082\u0081\u0001\u0000\u0000\u0000\u0083"+
		"\u0017\u0001\u0000\u0000\u0000\u0084\u0085\u0005\u001b\u0000\u0000\u0085"+
		"\u0086\u0005\u0012\u0000\u0000\u0086\u0087\u0003\b\u0004\u0000\u0087\u0019"+
		"\u0001\u0000\u0000\u0000\u0088\u0089\u0005\t\u0000\u0000\u0089\u008a\u0005"+
		"\u001b\u0000\u0000\u008a\u001b\u0001\u0000\u0000\u0000\u008b\u008c\u0005"+
		"\n\u0000\u0000\u008c\u0090\u0005\u001b\u0000\u0000\u008d\u008e\u0005\n"+
		"\u0000\u0000\u008e\u0090\u0005\u001a\u0000\u0000\u008f\u008b\u0001\u0000"+
		"\u0000\u0000\u008f\u008d\u0001\u0000\u0000\u0000\u0090\u001d\u0001\u0000"+
		"\u0000\u0000\u0091\u0092\u0005\u000b\u0000\u0000\u0092\u0093\u0003\u000e"+
		"\u0007\u0000\u0093\u0094\u0005\f\u0000\u0000\u0094\u0095\u0003\u0016\u000b"+
		"\u0000\u0095\u009e\u0001\u0000\u0000\u0000\u0096\u0097\u0005\u000b\u0000"+
		"\u0000\u0097\u0098\u0003\u000e\u0007\u0000\u0098\u0099\u0005\f\u0000\u0000"+
		"\u0099\u009a\u0003\u0016\u000b\u0000\u009a\u009b\u0005\r\u0000\u0000\u009b"+
		"\u009c\u0003\u0016\u000b\u0000\u009c\u009e\u0001\u0000\u0000\u0000\u009d"+
		"\u0091\u0001\u0000\u0000\u0000\u009d\u0096\u0001\u0000\u0000\u0000\u009e"+
		"\u001f\u0001\u0000\u0000\u0000\u009f\u00a0\u0005\u000e\u0000\u0000\u00a0"+
		"\u00a1\u0003\u000e\u0007\u0000\u00a1\u00a2\u0003\u0016\u000b\u0000\u00a2"+
		"!\u0001\u0000\u0000\u0000\u00a3\u00a4\u0005\u000f\u0000\u0000\u00a4\u00a5"+
		"\u0003\u0014\n\u0000\u00a5\u00a6\u0005\u0010\u0000\u0000\u00a6#\u0001"+
		"\u0000\u0000\u0000\f0BDPR\\grz\u0082\u008f\u009d";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}