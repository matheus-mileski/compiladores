// Generated from D:/mathe/Documents/GITHUB/Compiladores/CompiladorGyh/src\GyhLang.g4 by ANTLR 4.10.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GyhLangLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.10.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, PC=2, NumInt=3, NumReal=4, Var=5, Cadeia=6, OpRel=7, OpArit=8, 
		Delim=9, AbrePar=10, FechaPar=11, OpBoolE=12, OpBoolOu=13, Atrib=14, Comentario=15, 
		EspacoBranco=16;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "PC", "NumInt", "NumReal", "Var", "Cadeia", "OpRel", "OpArit", 
			"Delim", "AbrePar", "FechaPar", "OpBoolE", "OpBoolOu", "Atrib", "Comentario", 
			"EspacoBranco"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'Teste'", null, null, null, null, null, null, null, "':'", "'('", 
			"')'", "'E'", "'OU'", "'=:'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, "PC", "NumInt", "NumReal", "Var", "Cadeia", "OpRel", "OpArit", 
			"Delim", "AbrePar", "FechaPar", "OpBoolE", "OpBoolOu", "Atrib", "Comentario", 
			"EspacoBranco"
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


	public GyhLangLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "GyhLang.g4"; }

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
		"\u0004\u0000\u0010\u00a2\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0003\u0001X\b\u0001\u0001\u0002\u0004\u0002"+
		"[\b\u0002\u000b\u0002\f\u0002\\\u0001\u0003\u0004\u0003`\b\u0003\u000b"+
		"\u0003\f\u0003a\u0001\u0003\u0001\u0003\u0005\u0003f\b\u0003\n\u0003\f"+
		"\u0003i\t\u0003\u0001\u0004\u0001\u0004\u0003\u0004m\b\u0004\u0001\u0005"+
		"\u0001\u0005\u0005\u0005q\b\u0005\n\u0005\f\u0005t\t\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006"+
		"\u0082\b\u0006\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\t\u0001\t"+
		"\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001"+
		"\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0005\u000e\u0096\b\u000e\n"+
		"\u000e\f\u000e\u0099\t\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001r\u0000\u0010"+
		"\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r"+
		"\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e"+
		"\u001d\u000f\u001f\u0010\u0001\u0000\u0006\u0001\u000009\u0001\u0000a"+
		"z\u0003\u000009AZaz\u0003\u0000*+--//\u0001\u0000\n\n\u0003\u0000\t\n"+
		"\r\r  \u00b6\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000"+
		"\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000"+
		"\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000"+
		"\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000"+
		"\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000"+
		"\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000"+
		"\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000"+
		"\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000\u0000\u0000"+
		"\u0001!\u0001\u0000\u0000\u0000\u0003W\u0001\u0000\u0000\u0000\u0005Z"+
		"\u0001\u0000\u0000\u0000\u0007_\u0001\u0000\u0000\u0000\tj\u0001\u0000"+
		"\u0000\u0000\u000bn\u0001\u0000\u0000\u0000\r\u0081\u0001\u0000\u0000"+
		"\u0000\u000f\u0083\u0001\u0000\u0000\u0000\u0011\u0085\u0001\u0000\u0000"+
		"\u0000\u0013\u0087\u0001\u0000\u0000\u0000\u0015\u0089\u0001\u0000\u0000"+
		"\u0000\u0017\u008b\u0001\u0000\u0000\u0000\u0019\u008d\u0001\u0000\u0000"+
		"\u0000\u001b\u0090\u0001\u0000\u0000\u0000\u001d\u0093\u0001\u0000\u0000"+
		"\u0000\u001f\u009e\u0001\u0000\u0000\u0000!\"\u0005T\u0000\u0000\"#\u0005"+
		"e\u0000\u0000#$\u0005s\u0000\u0000$%\u0005t\u0000\u0000%&\u0005e\u0000"+
		"\u0000&\u0002\u0001\u0000\u0000\u0000\'(\u0005D\u0000\u0000()\u0005E\u0000"+
		"\u0000)X\u0005C\u0000\u0000*+\u0005P\u0000\u0000+,\u0005R\u0000\u0000"+
		",-\u0005O\u0000\u0000-X\u0005G\u0000\u0000./\u0005I\u0000\u0000/0\u0005"+
		"N\u0000\u00000X\u0005T\u0000\u000012\u0005R\u0000\u000023\u0005E\u0000"+
		"\u000034\u0005A\u0000\u00004X\u0005L\u0000\u000056\u0005L\u0000\u0000"+
		"67\u0005E\u0000\u00007X\u0005R\u0000\u000089\u0005I\u0000\u00009:\u0005"+
		"M\u0000\u0000:;\u0005P\u0000\u0000;<\u0005R\u0000\u0000<=\u0005I\u0000"+
		"\u0000=>\u0005M\u0000\u0000>?\u0005I\u0000\u0000?X\u0005R\u0000\u0000"+
		"@A\u0005S\u0000\u0000AX\u0005E\u0000\u0000BC\u0005S\u0000\u0000CD\u0005"+
		"E\u0000\u0000DE\u0005N\u0000\u0000EF\u0005A\u0000\u0000FX\u0005O\u0000"+
		"\u0000GH\u0005E\u0000\u0000HI\u0005N\u0000\u0000IJ\u0005T\u0000\u0000"+
		"JK\u0005A\u0000\u0000KX\u0005O\u0000\u0000LM\u0005E\u0000\u0000MN\u0005"+
		"N\u0000\u0000NO\u0005Q\u0000\u0000OP\u0005T\u0000\u0000PX\u0005O\u0000"+
		"\u0000QR\u0005I\u0000\u0000RS\u0005N\u0000\u0000SX\u0005I\u0000\u0000"+
		"TU\u0005F\u0000\u0000UV\u0005I\u0000\u0000VX\u0005M\u0000\u0000W\'\u0001"+
		"\u0000\u0000\u0000W*\u0001\u0000\u0000\u0000W.\u0001\u0000\u0000\u0000"+
		"W1\u0001\u0000\u0000\u0000W5\u0001\u0000\u0000\u0000W8\u0001\u0000\u0000"+
		"\u0000W@\u0001\u0000\u0000\u0000WB\u0001\u0000\u0000\u0000WG\u0001\u0000"+
		"\u0000\u0000WL\u0001\u0000\u0000\u0000WQ\u0001\u0000\u0000\u0000WT\u0001"+
		"\u0000\u0000\u0000X\u0004\u0001\u0000\u0000\u0000Y[\u0007\u0000\u0000"+
		"\u0000ZY\u0001\u0000\u0000\u0000[\\\u0001\u0000\u0000\u0000\\Z\u0001\u0000"+
		"\u0000\u0000\\]\u0001\u0000\u0000\u0000]\u0006\u0001\u0000\u0000\u0000"+
		"^`\u0007\u0000\u0000\u0000_^\u0001\u0000\u0000\u0000`a\u0001\u0000\u0000"+
		"\u0000a_\u0001\u0000\u0000\u0000ab\u0001\u0000\u0000\u0000bc\u0001\u0000"+
		"\u0000\u0000cg\u0005.\u0000\u0000df\u0007\u0000\u0000\u0000ed\u0001\u0000"+
		"\u0000\u0000fi\u0001\u0000\u0000\u0000ge\u0001\u0000\u0000\u0000gh\u0001"+
		"\u0000\u0000\u0000h\b\u0001\u0000\u0000\u0000ig\u0001\u0000\u0000\u0000"+
		"jl\u0007\u0001\u0000\u0000km\u0007\u0002\u0000\u0000lk\u0001\u0000\u0000"+
		"\u0000m\n\u0001\u0000\u0000\u0000nr\u0005\'\u0000\u0000oq\t\u0000\u0000"+
		"\u0000po\u0001\u0000\u0000\u0000qt\u0001\u0000\u0000\u0000rs\u0001\u0000"+
		"\u0000\u0000rp\u0001\u0000\u0000\u0000su\u0001\u0000\u0000\u0000tr\u0001"+
		"\u0000\u0000\u0000uv\u0005\'\u0000\u0000v\f\u0001\u0000\u0000\u0000w\u0082"+
		"\u0005<\u0000\u0000xy\u0005<\u0000\u0000y\u0082\u0005=\u0000\u0000z\u0082"+
		"\u0005>\u0000\u0000{|\u0005>\u0000\u0000|\u0082\u0005=\u0000\u0000}~\u0005"+
		"=\u0000\u0000~\u0082\u0005=\u0000\u0000\u007f\u0080\u0005!\u0000\u0000"+
		"\u0080\u0082\u0005=\u0000\u0000\u0081w\u0001\u0000\u0000\u0000\u0081x"+
		"\u0001\u0000\u0000\u0000\u0081z\u0001\u0000\u0000\u0000\u0081{\u0001\u0000"+
		"\u0000\u0000\u0081}\u0001\u0000\u0000\u0000\u0081\u007f\u0001\u0000\u0000"+
		"\u0000\u0082\u000e\u0001\u0000\u0000\u0000\u0083\u0084\u0007\u0003\u0000"+
		"\u0000\u0084\u0010\u0001\u0000\u0000\u0000\u0085\u0086\u0005:\u0000\u0000"+
		"\u0086\u0012\u0001\u0000\u0000\u0000\u0087\u0088\u0005(\u0000\u0000\u0088"+
		"\u0014\u0001\u0000\u0000\u0000\u0089\u008a\u0005)\u0000\u0000\u008a\u0016"+
		"\u0001\u0000\u0000\u0000\u008b\u008c\u0005E\u0000\u0000\u008c\u0018\u0001"+
		"\u0000\u0000\u0000\u008d\u008e\u0005O\u0000\u0000\u008e\u008f\u0005U\u0000"+
		"\u0000\u008f\u001a\u0001\u0000\u0000\u0000\u0090\u0091\u0005=\u0000\u0000"+
		"\u0091\u0092\u0005:\u0000\u0000\u0092\u001c\u0001\u0000\u0000\u0000\u0093"+
		"\u0097\u0005#\u0000\u0000\u0094\u0096\b\u0004\u0000\u0000\u0095\u0094"+
		"\u0001\u0000\u0000\u0000\u0096\u0099\u0001\u0000\u0000\u0000\u0097\u0095"+
		"\u0001\u0000\u0000\u0000\u0097\u0098\u0001\u0000\u0000\u0000\u0098\u009a"+
		"\u0001\u0000\u0000\u0000\u0099\u0097\u0001\u0000\u0000\u0000\u009a\u009b"+
		"\u0005\n\u0000\u0000\u009b\u009c\u0001\u0000\u0000\u0000\u009c\u009d\u0006"+
		"\u000e\u0000\u0000\u009d\u001e\u0001\u0000\u0000\u0000\u009e\u009f\u0007"+
		"\u0005\u0000\u0000\u009f\u00a0\u0001\u0000\u0000\u0000\u00a0\u00a1\u0006"+
		"\u000f\u0000\u0000\u00a1 \u0001\u0000\u0000\u0000\t\u0000W\\aglr\u0081"+
		"\u0097\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}