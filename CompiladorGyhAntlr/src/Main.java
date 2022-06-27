import java.io.IOException;

import org.antlr.v4.runtime.*;

public class Main {
    public static void main(String[] args) {
        String filename = "testes/programa3.gyh";
        try {
            CharStream charStream = CharStreams.fromFileName(filename);

            GyhLangLexer lexer = new GyhLangLexer(charStream);

            // Remove o Error Listener padrão do Lexer e adiciona ThrowingErrorListener
            lexer.removeErrorListeners();
            lexer.addErrorListener(ThrowingErrorListener.INSTANCE);

            CommonTokenStream tokens = new CommonTokenStream(lexer);

            GyhLangParser parser = new GyhLangParser(tokens);

            // Remove o Error Listener padrão do Parser e adiciona ThrowingErrorListener
            parser.removeErrorListeners();
            parser.addErrorListener(ThrowingErrorListener.INSTANCE);

            parser.programa();

            parser.generateCommand(filename.substring(0,filename.length()-4));

        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
