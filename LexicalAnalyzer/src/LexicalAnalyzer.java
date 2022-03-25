import java.util.ArrayList;

public class LexicalAnalyzer {
    public static void main(String[] args) {
        ArrayList<Token> tokens = new ArrayList<>();

        System.out.println("----------------------- Erros -----------------------");

        // Chama o construtor da classe GyhLex
        GyhLex lex = new GyhLex(args[0]);
        // Salva os tokens retornador
        tokens = lex.tokenizer();

        System.out.println("-----------------------------------------------------");

        // Mostra os tokens retornados
        tokens.forEach(System.out::println);
    }
}