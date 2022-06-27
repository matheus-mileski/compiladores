// Programa principal

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

            // Chama o programa principal da gramatica gyh
            parser.programa();


            parser.generateCommand(filename.substring(0,filename.length()-4));

        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}