// Generated from D:/mathe/Documents/GITHUB/Compiladores/CompiladorGyh/src\GyhLang.g4 by ANTLR 4.10.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link GyhLangParser}.
 */
public interface GyhLangListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link GyhLangParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(GyhLangParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link GyhLangParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(GyhLangParser.ProgContext ctx);
}