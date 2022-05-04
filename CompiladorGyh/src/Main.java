// Julio Ribeiro e Matheus Mileski
// Vídeo: https://www.youtube.com/watch?v=e4KjLvzrIB4

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Token> tokens;

        System.out.println("---------- Erros Léxicos ----------");
        GyhLexico lex = new GyhLexico(args[0]);
        tokens = lex.tokenizer();
        System.out.println("-----------------------------------");
        System.out.println();

        System.out.println("---------- Tokens Gerados ----------");
        tokens.forEach(System.out::println);
        System.out.println("------------------------------------");
        System.out.println();

        System.out.println("---------- Analisador Sintático ----------");
        GyhSintatico sint = new GyhSintatico(tokens);
        sint.programa();
        System.out.println("------------------------------------------");
    }
}