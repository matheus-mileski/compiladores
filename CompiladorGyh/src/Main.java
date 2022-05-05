// Julio Ribeiro e Matheus Mileski
// Vídeos:
// - Analisador Léxico: https://www.youtube.com/watch?v=e4KjLvzrIB4
// - Analisador Sintático:

// TODO: Verificar erro do IMPRIMIR - Caso seja uma cadeia sem as aspas no final, a cadeira será ignorada - OK
// TODO: Adicionar SENAO ao Analisador Lexico - OK
// TODO: Verificar FatorAritmetico com Numero Real - No slide 3 das especificações parece que tem o NUMREAL no FatorAritmetico, tem que verificar - X

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Token> tokens;

        System.out.println("------------- Erros Léxicos --------------");
        GyhLexico lex = new GyhLexico(args[0]);
        tokens = lex.tokenizer();
        System.out.println("------------------------------------------");
        System.out.println();

        System.out.println("------------- Tokens Gerados -------------");
        tokens.forEach(System.out::println);
        System.out.println("------------------------------------------");
        System.out.println();

        System.out.println("---------- Analisador Sintático ----------");
        GyhSintatico sint = new GyhSintatico(tokens);
        sint.programa();
        System.out.println("------------------------------------------");
    }
}