import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GyhLex lex = new GyhLex(args[0]);
        Scanner sc = new Scanner(lex.ldat.is);

        ArrayList<Token> tokensLinha = null;
        ArrayList<Token> tokensPrograma = null;

        while (true) {
            if (sc.hasNextLine()) {
                String linha = sc.nextLine();
                System.out.println(linha);

                if (linha.isEmpty()) {
                    continue;
                }

                if (linha.charAt(0) == '#') {
                    continue;
                }
                //          Add dummy at the end of the line '&
                tokensLinha = lex.tokenizer(linha + '&');
                tokensLinha.forEach(System.out::print);
                System.out.println("\n");
                if (tokensPrograma != null) {
                    tokensPrograma.addAll(tokensLinha);
                } else {
                    tokensPrograma = tokensLinha;
                }
            } else {
                Token tokenEOF = new Token(TipoToken.EOF);
                System.out.println(tokenEOF);
                if (tokensPrograma != null) {
                    tokensPrograma.add(tokenEOF);
                }
                break;
            }
        }

        sc.close();

        System.out.println("\n==============================================\n");
        if (tokensPrograma != null) {
            tokensPrograma.forEach(System.out::print);
        }

        // TODO: Escrever todos os tokens em um arquivo ou exibir

    }

}
