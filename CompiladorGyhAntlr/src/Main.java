// Julio Ribeiro e Matheus Mileski
// Vídeos:
// - Analisador Léxico: https://www.youtube.com/watch?v=e4KjLvzrIB4
// - Analisador Sintático: https://youtu.be/-JOJBlEuDyM
// - Analisador Semântico: https://youtu.be/CDxI334Gr1A
// - Compilador ANTLR: https://youtu.be/8_AoxqiR4K0

import java.io.IOException;

import org.antlr.v4.runtime.*;

public class Main {
    public static void main(String[] args) {
        // Nome do arquivo do programa gyh
        String filename = "testes/programa1.gyh";

        try {
            // CharStream para ler os caracteres do programa gyh
            CharStream charStream = CharStreams.fromFileName(filename);

            // Analisador léxico
            GyhLangLexer lexer = new GyhLangLexer(charStream);

            // Remove o Error Listener padrão do Lexer e adiciona ThrowingErrorListener
            lexer.removeErrorListeners();
            lexer.addErrorListener(ThrowingErrorListener.INSTANCE);

            // Stram de tokens gerados pelo léxico
            CommonTokenStream tokens = new CommonTokenStream(lexer);

            // Analisador sintático
            GyhLangParser parser = new GyhLangParser(tokens);

            // Remove o Error Listener padrão do Parser e adiciona ThrowingErrorListener
            parser.removeErrorListeners();
            parser.addErrorListener(ThrowingErrorListener.INSTANCE);

            // Chama o programa principal da gramática gyh
            parser.programa();

            parser.generateCommand(filename.substring(0, filename.length() - 4));

        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}