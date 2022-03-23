import java.util.ArrayList;

public class GyhLex {
    private FileHandler fileHandler;
    private ArrayList<Token> tokens;

    public GyhLex(String ghySourceCode) {
        fileHandler = new FileHandler(ghySourceCode);
    }

    public ArrayList<Token> tokenizer() {
        tokens = new ArrayList<Token>();

        ArrayList<String> linhas = fileHandler.getNextLine();

        for(String linha : linhas) {
            // Se a linha for vazia é ignorada;
            if (linha.isEmpty())
                continue;

            // Se a linha começar com um indicador de comentário é ignorada
            if (linha.charAt(0) == '#')
                continue;

            // Indica o fim de uma linha (scanner remove o \n)
            linha += "\n";

            int varIndex = 0;
            int estado = 0;

            for (int i = 0; i < linha.length(); i++) {
                char c = linha.charAt(i);
                switch (estado) {
                    case 0:
                        // Controle para detectar substrings
                        varIndex = i;

                        if (c == ' ' || c == '\n') {
                            continue;
                        } else if (c == '<') {
                            estado = 1;
                        } else if (c == '=') {
                            estado = 2;
                        } else if (c == '>') {
                            estado = 3;
                        } else if (c == '!') {
                            estado = 4;
                        } else if (c == 'D') {
                            estado = 5;
                        } else if (c == 'P') {
                            estado = 7;
                        } else if (c == 'I') {
                            estado = 10;
                        } else if (c == 'L') {
                            estado = 18;
                        } else if (c == 'S') {
                            estado = 20;
                        } else if (c == 'E') {
                            estado = 21;
                        } else if (c == 'F') {
                            estado = 27;
                        } else if (c == 'R') {
                            estado = 29;
                        } else if (c == 'O') {
                            estado = 32;
                        } else if (c == ':') {
                            estado = 33;
                        } else if (Character.isLowerCase(c)) {
                            estado = 34;
                        } else if (Character.isDigit(c)) {
                            estado = 35;
                        } else if (c == '"') {
                            estado = 37;
                        } else if (c == '*') {
                            tokens.add(new Token(TipoToken.OpAritMult, "*"));
                        } else if (c == '/') {
                            tokens.add(new Token(TipoToken.OpAritDiv, "/"));
                        } else if (c == '+') {
                            tokens.add(new Token(TipoToken.OpAritSoma, "+"));
                        } else if (c == '-') {
                            tokens.add(new Token(TipoToken.OpAritSub, "-"));
                        } else if (c == '(') {
                            tokens.add(new Token(TipoToken.AbrePar, "("));
                        } else if (c == ')') {
                            tokens.add(new Token(TipoToken.FechaPar, ")"));
                        } else {
                            if (c != '\n') {
                                System.out.println("Erro Lexico -> Caractere nao reconhecido: " + c);
                            }
                        }
                        break;
                    case 1:
                        if (c == '=') {
                            tokens.add(new Token(TipoToken.OpRelMenorIgual, "<="));
                        } else {
                            tokens.add(new Token(TipoToken.OpRelMenor, "<"));
                            i--;
                        }
                        estado = 0;
                        break;
                    case 2:
                        if (c == '=') {
                            tokens.add(new Token(TipoToken.OpRelIgual, "=="));
                        } else {
                            System.out.println("Erro Lexico -> " + linha.substring(varIndex, i+1));
                            i--;
                        }
                        estado = 0;
                        break;
                    case 3:
                        if (c == '=') {
                            tokens.add(new Token(TipoToken.OpRelMaiorIgual, ">="));
                        } else {
                            tokens.add(new Token(TipoToken.OpRelMaior, ">"));
                            i--;
                        }
                        estado = 0;
                        break;
                    case 4:
                        if (c == '=') {
                            tokens.add(new Token(TipoToken.OpRelDif, "!="));
                        } else {
                            System.out.println("Erro Lexico -> " + linha.substring(varIndex, i+1));
                            i--;
                        }
                        estado = 0;
                        break;
                    case 5:
                        if (c == 'E') {
                            estado = 6;
                        } else {
                            System.out.println("Erro Lexico -> " + linha.substring(varIndex, i+1));
                            i--;
                            estado = 0;
                        }
                        break;
                    case 6:
                        if (c == 'C') {
                            tokens.add(new Token(TipoToken.PCDec, "DEC"));
                        } else {
                            System.out.println("Erro Lexico -> " + linha.substring(varIndex, i+1));
                            i--;
                        }
                        estado = 0;
                        break;
                    case 7:
                        if (c == 'R') {
                            estado = 8;
                        } else {
                            System.out.println("Erro Lexico -> " + linha.substring(varIndex, i+1));
                            i--;
                            estado = 0;
                        }
                        break;
                    case 8:
                        if (c == 'O') {
                            estado = 9;
                        } else {
                            System.out.println("Erro Lexico -> " + linha.substring(varIndex, i+1));
                            i--;
                            estado = 0;
                        }
                        break;
                    case 9:
                        if (c == 'G') {
                            tokens.add(new Token(TipoToken.PCProg, "PROG"));
                        } else {
                            System.out.println("Erro Lexico -> " + linha.substring(varIndex, i+1));
                            i--;
                        }
                        estado = 0;
                        break;
                    case 10:
                        if (c == 'N') {
                            estado = 11;
                        } else if (c == 'M') {
                            estado = 12;
                        } else {
                            System.out.println("Erro Lexico -> " + linha.substring(varIndex, i+1));
                            i--;
                            estado = 0;
                        }
                        break;
                    case 11:
                        if (c == 'I') {
                            tokens.add(new Token(TipoToken.PCIni, "INI"));
                        } else if (c == 'T') {
                            tokens.add(new Token(TipoToken.PCInt, "INT"));
                        } else {
                            System.out.println("Erro Lexico -> " + linha.substring(varIndex, i+1));
                            i--;
                        }
                        estado = 0;
                        break;
                    case 12:
                        if (c == 'P') {
                            estado = 13;
                        } else {
                            System.out.println("Erro Lexico -> " + linha.substring(varIndex, i+1));
                            i--;
                            estado = 0;
                        }
                        break;
                    case 13:
                        if (c == 'R') {
                            estado = 14;
                        } else {
                            System.out.println("Erro Lexico -> " + linha.substring(varIndex, i+1));
                            i--;
                            estado = 0;
                        }
                        break;
                    case 14:
                        if (c == 'I') {
                            estado = 15;
                        } else {
                            System.out.println("Erro Lexico -> " + linha.substring(varIndex, i+1));
                            i--;
                            estado = 0;
                        }
                        break;
                    case 15:
                        if (c == 'M') {
                            estado = 16;
                        } else {
                            System.out.println("Erro Lexico -> " + linha.substring(varIndex, i+1));
                            i--;
                            estado = 0;
                        }
                        break;
                    case 16:
                        if (c == 'I') {
                            estado = 17;
                        } else {
                            System.out.println("Erro Lexico -> " + linha.substring(varIndex, i+1));
                            i--;
                            estado = 0;
                        }
                        break;
                    case 17:
                        if (c == 'R') {
                            tokens.add(new Token(TipoToken.PCImprimir, "IMPRIMIR"));
                        } else {
                            System.out.println("Erro Lexico -> " + linha.substring(varIndex, i+1));
                            i--;
                        }
                        estado = 0;
                        break;
                    case 18:
                        if (c == 'E') {
                            estado = 19;
                        } else {
                            System.out.println("Erro Lexico -> " + linha.substring(varIndex, i+1));
                            i--;
                            estado = 0;
                        }
                        break;
                    case 19:
                        if (c == 'R') {
                            tokens.add(new Token(TipoToken.PCLer, "LER"));
                        } else {
                            System.out.println("Erro Lexico -> " + linha.substring(varIndex, i+1));
                            i--;
                        }
                        estado = 0;
                        break;
                    case 20:
                        if (c == 'E') {
                            tokens.add(new Token(TipoToken.PCSe, "SE"));
                        } else {
                            System.out.println("Erro Lexico -> " + linha.substring(varIndex, i+1));
                            i--;
                        }
                        estado = 0;
                        break;
                    case 21:
                        if (c == 'N') {
                            estado = 22;
                        } else {
                            tokens.add(new Token(TipoToken.OpBoolE, "E"));
                            i--;
                            estado = 0;
                        }
                        break;
                    case 22:
                        if (c == 'Q') {
                            estado = 23;
                        } else if (c == 'T') {
                            estado = 25;
                        } else {
                            System.out.println("Erro Lexico -> " + linha.substring(varIndex, i+1));
                            i--;
                            estado = 0;
                        }
                        break;
                    case 23:
                        if (c == 'T') {
                            estado = 24;
                        } else {
                            System.out.println("Erro Lexico -> " + linha.substring(varIndex, i+1));
                            i--;
                            estado = 0;
                        }
                        break;
                    case 24:
                        if (c == 'O') {
                            tokens.add(new Token(TipoToken.PCEnqto, "ENQTO"));
                        } else {
                            System.out.println("Erro Lexico -> " + linha.substring(varIndex, i+1));
                            i--;
                        }
                        estado = 0;
                        break;
                    case 25:
                        if (c == 'A') {
                            estado = 26;
                        } else {
                            System.out.println("Erro Lexico -> " + linha.substring(varIndex, i+1));
                            i--;
                            estado = 0;
                        }
                        break;
                    case 26:
                        if (c == 'O') {
                            tokens.add(new Token(TipoToken.PCEntao, "ENTAO"));
                        } else {
                            System.out.println("Erro Lexico -> " + linha.substring(varIndex, i+1));
                            i--;
                        }
                        estado = 0;
                        break;
                    case 27:
                        if (c == 'I') {
                            estado = 28;
                        } else {
                            System.out.println("Erro Lexico -> " + linha.substring(varIndex, i+1));
                            i--;
                            estado = 0;
                        }
                        break;
                    case 28:
                        if (c == 'M') {
                            tokens.add(new Token(TipoToken.PCFim, "FIM"));
                        } else {
                            System.out.println("Erro Lexico -> " + linha.substring(varIndex, i+1));
                            i--;
                        }
                        estado = 0;
                        break;
                    case 29:
                        if (c == 'E') {
                            estado = 30;
                        } else {
                            System.out.println("Erro Lexico -> " + linha.substring(varIndex, i+1));
                            i--;
                            estado = 0;
                        }
                        break;
                    case 30:
                        if (c == 'A') {
                            estado = 31;
                        } else {
                            System.out.println("Erro Lexico -> " + linha.substring(varIndex, i+1));
                            i--;
                            estado = 0;
                        }
                        break;
                    case 31:
                        if (c == 'L') {
                            tokens.add(new Token(TipoToken.PCReal, "REAL"));
                        } else {
                            System.out.println("Erro Lexico -> " + linha.substring(varIndex, i+1));
                            i--;
                        }
                        estado = 0;
                        break;
                    case 32:
                        if (c == 'U') {
                            tokens.add(new Token(TipoToken.OpBoolOu, "OU"));
                        } else {
                            System.out.println("Erro Lexico -> " + linha.substring(varIndex, i+1));
                            i--;
                        }
                        estado = 0;
                        break;
                    case 33:
                        if (c == '=') {
                            tokens.add(new Token(TipoToken.Atrib, ":="));
                        } else {
                            tokens.add(new Token(TipoToken.Delim, ":"));
                            i--;
                        }
                        estado = 0;
                        break;
                    case 34:
                        if (!Character.isLetterOrDigit(c)) {
                            tokens.add(new Token(TipoToken.Var, linha.substring(varIndex, i)));
                            i--;
                            estado = 0;
                        }
                        break;
                    case 35:
                        if (c == '.') {
                            estado = 36;
                        } else if (!Character.isDigit(c)) {
                            tokens.add(new Token(TipoToken.NumInt, linha.substring(varIndex, i)));
                            i--;
                            estado = 0;
                        }
                        break;
                    case 36:
                        if (!Character.isDigit(c)) {
                            tokens.add(new Token(TipoToken.NumReal, linha.substring(varIndex, i)));
                            i--;
                            estado = 0;
                        }
                        break;
                    case 37:
                        if (c == '"') {
                            tokens.add(new Token(TipoToken.Cadeia, linha.substring(varIndex+1, i)));
                            i--;
                            estado = 0;
                        }
                        break;
                    default:
                        System.out.println("Estado Invalido");
                }
            }
        }

        // Quando chegar no fim do arquivo adiciona um token de EOF
        tokens.add(new Token(TipoToken.EOF));

        tokens.forEach(System.out::println);

        return tokens;
    }
}