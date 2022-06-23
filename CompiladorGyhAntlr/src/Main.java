import java.io.IOException;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;

public class Main {
    public static void main(String[] args) {
        try {
            CharStream charStream = CharStreams.fromFileName("programa1.gyh");

            GyhLexer lexer = new GyhLexer(charStream);
            Token token;
            CommonTokenStream tokens = new CommonTokenStream(lexer);

            GyhParser parser = new GyhParser(tokens);
            parser.programa();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
