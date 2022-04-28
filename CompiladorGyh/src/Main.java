// Julio Ribeiro e Matheus Mileski
// Vídeo: https://www.youtube.com/watch?v=e4KjLvzrIB4

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Token> tokens;

        System.out.println("----------------------- Erros -----------------------");

        // Chama o construtor da classe GyhLex
        GyhLexico lex = new GyhLexico(args[0]);
        // Salva os tokens retornados
        tokens = lex.tokenizer();

        System.out.println("-----------------------------------------------------");

        // Mostra os tokens retornados
        tokens.forEach(System.out::println);
    }
}