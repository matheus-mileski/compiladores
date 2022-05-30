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
		T__0=1, PC=2, OpRel=3, Var=4, NumInt=5, NumReal=6, Delim=7, WS=8, Comment=9;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "PC", "OpRel", "Var", "NumInt", "NumReal", "Delim", "WS", "Comment"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'Prox_Aula_Falamos_Mais'", null, null, null, null, null, "':'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, "PC", "OpRel", "Var", "NumInt", "NumReal", "Delim", "WS", 
			"Comment"
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
		"\u0004\u0000\t\u008f\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0003\u0001[\b\u0001\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0003\u0002g\b\u0002\u0001\u0003\u0001\u0003\u0005"+
		"\u0003k\b\u0003\n\u0003\f\u0003n\t\u0003\u0001\u0004\u0004\u0004q\b\u0004"+
		"\u000b\u0004\f\u0004r\u0001\u0005\u0004\u0005v\b\u0005\u000b\u0005\f\u0005"+
		"w\u0001\u0005\u0001\u0005\u0005\u0005|\b\u0005\n\u0005\f\u0005\u007f\t"+
		"\u0005\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\b\u0004\b\u0088\b\b\u000b\b\f\b\u0089\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0000\u0000\t\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004"+
		"\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0001\u0000\u0004\u0001\u0000"+
		"az\u0003\u000009AZaz\u0001\u000009\u0003\u0000\t\n\r\r  \u00a3\u0000\u0001"+
		"\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005"+
		"\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001"+
		"\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000"+
		"\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000"+
		"\u0000\u0000\u0001\u0013\u0001\u0000\u0000\u0000\u0003Z\u0001\u0000\u0000"+
		"\u0000\u0005f\u0001\u0000\u0000\u0000\u0007h\u0001\u0000\u0000\u0000\t"+
		"p\u0001\u0000\u0000\u0000\u000bu\u0001\u0000\u0000\u0000\r\u0080\u0001"+
		"\u0000\u0000\u0000\u000f\u0082\u0001\u0000\u0000\u0000\u0011\u0087\u0001"+
		"\u0000\u0000\u0000\u0013\u0014\u0005P\u0000\u0000\u0014\u0015\u0005r\u0000"+
		"\u0000\u0015\u0016\u0005o\u0000\u0000\u0016\u0017\u0005x\u0000\u0000\u0017"+
		"\u0018\u0005_\u0000\u0000\u0018\u0019\u0005A\u0000\u0000\u0019\u001a\u0005"+
		"u\u0000\u0000\u001a\u001b\u0005l\u0000\u0000\u001b\u001c\u0005a\u0000"+
		"\u0000\u001c\u001d\u0005_\u0000\u0000\u001d\u001e\u0005F\u0000\u0000\u001e"+
		"\u001f\u0005a\u0000\u0000\u001f \u0005l\u0000\u0000 !\u0005a\u0000\u0000"+
		"!\"\u0005m\u0000\u0000\"#\u0005o\u0000\u0000#$\u0005s\u0000\u0000$%\u0005"+
		"_\u0000\u0000%&\u0005M\u0000\u0000&\'\u0005a\u0000\u0000\'(\u0005i\u0000"+
		"\u0000()\u0005s\u0000\u0000)\u0002\u0001\u0000\u0000\u0000*+\u0005D\u0000"+
		"\u0000+,\u0005E\u0000\u0000,[\u0005C\u0000\u0000-.\u0005P\u0000\u0000"+
		"./\u0005R\u0000\u0000/0\u0005O\u0000\u00000[\u0005G\u0000\u000012\u0005"+
		"I\u0000\u000023\u0005N\u0000\u00003[\u0005T\u0000\u000045\u0005R\u0000"+
		"\u000056\u0005E\u0000\u000067\u0005A\u0000\u00007[\u0005L\u0000\u0000"+
		"89\u0005L\u0000\u00009:\u0005E\u0000\u0000:[\u0005R\u0000\u0000;<\u0005"+
		"I\u0000\u0000<=\u0005M\u0000\u0000=>\u0005P\u0000\u0000>?\u0005R\u0000"+
		"\u0000?@\u0005I\u0000\u0000@A\u0005M\u0000\u0000AB\u0005I\u0000\u0000"+
		"B[\u0005R\u0000\u0000CD\u0005S\u0000\u0000D[\u0005E\u0000\u0000EF\u0005"+
		"S\u0000\u0000FG\u0005E\u0000\u0000GH\u0005N\u0000\u0000HI\u0005A\u0000"+
		"\u0000I[\u0005O\u0000\u0000JK\u0005E\u0000\u0000KL\u0005N\u0000\u0000"+
		"LM\u0005T\u0000\u0000MN\u0005A\u0000\u0000N[\u0005O\u0000\u0000OP\u0005"+
		"E\u0000\u0000PQ\u0005N\u0000\u0000QR\u0005Q\u0000\u0000RS\u0005T\u0000"+
		"\u0000S[\u0005O\u0000\u0000TU\u0005I\u0000\u0000UV\u0005N\u0000\u0000"+
		"V[\u0005I\u0000\u0000WX\u0005F\u0000\u0000XY\u0005I\u0000\u0000Y[\u0005"+
		"M\u0000\u0000Z*\u0001\u0000\u0000\u0000Z-\u0001\u0000\u0000\u0000Z1\u0001"+
		"\u0000\u0000\u0000Z4\u0001\u0000\u0000\u0000Z8\u0001\u0000\u0000\u0000"+
		"Z;\u0001\u0000\u0000\u0000ZC\u0001\u0000\u0000\u0000ZE\u0001\u0000\u0000"+
		"\u0000ZJ\u0001\u0000\u0000\u0000ZO\u0001\u0000\u0000\u0000ZT\u0001\u0000"+
		"\u0000\u0000ZW\u0001\u0000\u0000\u0000[\u0004\u0001\u0000\u0000\u0000"+
		"\\g\u0005<\u0000\u0000]^\u0005<\u0000\u0000^g\u0005=\u0000\u0000_g\u0005"+
		">\u0000\u0000`a\u0005>\u0000\u0000ag\u0005=\u0000\u0000bc\u0005=\u0000"+
		"\u0000cg\u0005=\u0000\u0000de\u0005!\u0000\u0000eg\u0005=\u0000\u0000"+
		"f\\\u0001\u0000\u0000\u0000f]\u0001\u0000\u0000\u0000f_\u0001\u0000\u0000"+
		"\u0000f`\u0001\u0000\u0000\u0000fb\u0001\u0000\u0000\u0000fd\u0001\u0000"+
		"\u0000\u0000g\u0006\u0001\u0000\u0000\u0000hl\u0007\u0000\u0000\u0000"+
		"ik\u0007\u0001\u0000\u0000ji\u0001\u0000\u0000\u0000kn\u0001\u0000\u0000"+
		"\u0000lj\u0001\u0000\u0000\u0000lm\u0001\u0000\u0000\u0000m\b\u0001\u0000"+
		"\u0000\u0000nl\u0001\u0000\u0000\u0000oq\u0007\u0002\u0000\u0000po\u0001"+
		"\u0000\u0000\u0000qr\u0001\u0000\u0000\u0000rp\u0001\u0000\u0000\u0000"+
		"rs\u0001\u0000\u0000\u0000s\n\u0001\u0000\u0000\u0000tv\u0007\u0002\u0000"+
		"\u0000ut\u0001\u0000\u0000\u0000vw\u0001\u0000\u0000\u0000wu\u0001\u0000"+
		"\u0000\u0000wx\u0001\u0000\u0000\u0000xy\u0001\u0000\u0000\u0000y}\u0005"+
		".\u0000\u0000z|\u0007\u0002\u0000\u0000{z\u0001\u0000\u0000\u0000|\u007f"+
		"\u0001\u0000\u0000\u0000}{\u0001\u0000\u0000\u0000}~\u0001\u0000\u0000"+
		"\u0000~\f\u0001\u0000\u0000\u0000\u007f}\u0001\u0000\u0000\u0000\u0080"+
		"\u0081\u0005:\u0000\u0000\u0081\u000e\u0001\u0000\u0000\u0000\u0082\u0083"+
		"\u0007\u0003\u0000\u0000\u0083\u0084\u0001\u0000\u0000\u0000\u0084\u0085"+
		"\u0006\u0007\u0000\u0000\u0085\u0010\u0001\u0000\u0000\u0000\u0086\u0088"+
		"\u0005#\u0000\u0000\u0087\u0086\u0001\u0000\u0000\u0000\u0088\u0089\u0001"+
		"\u0000\u0000\u0000\u0089\u0087\u0001\u0000\u0000\u0000\u0089\u008a\u0001"+
		"\u0000\u0000\u0000\u008a\u008b\u0001\u0000\u0000\u0000\u008b\u008c\u0005"+
		"\n\u0000\u0000\u008c\u008d\u0001\u0000\u0000\u0000\u008d\u008e\u0006\b"+
		"\u0000\u0000\u008e\u0012\u0001\u0000\u0000\u0000\t\u0000Zfjlrw}\u0089"+
		"\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}