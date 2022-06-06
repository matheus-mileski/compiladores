import java.util.ArrayList;
import java.util.HashMap;

public class GyhSemantico {
    public HashMap<String, Variavel> variaveis;
    public ArrayList<Token> tokens;    // Lista de tokens que é preenchida pelo analisador léxico
    private final int tamanhoBuffer = 2; // Tamanho do buffer de tokens
    public ArrayList<Token> bufferTokens;  // Buffer de tokens
    private boolean terminou = false;   // Auxiliar para verificar se terminaram os tokens do lexico

    public GyhSemantico(HashMap<String, Variavel> variaveis, ArrayList<Token> tokens) {
        this.variaveis = new HashMap<String, Variavel>(variaveis);
        this.tokens = new ArrayList<>(tokens);
        this.bufferTokens = new ArrayList<>();
        getToken();
    }

    public void analisador() {
        //pula a lista de declaracoes e inicia o analisador a partir de PROG
        while (!match(TipoToken.PCProg)) getToken();

        //carrega o primeiro token após PCProg
        getToken();

        while (!match(TipoToken.EOF)) {
            if (match(TipoToken.Var)) {
                //verificar se a variavel foi declarada e marca como utilizada
                if (this.variaveis.containsKey(lookahead(1).getLexema())) {
                    if (!this.variaveis.get(lookahead(1).getLexema()).utilizada) {
                        this.variaveis.get(lookahead(1).getLexema()).setUtilizada();
                    }
                } else {
                    erroSemantico("Variavel \"" + lookahead(1).getLexema() + "\" nao declarada");
                }

                //verificar se int recebe int, compara com int ou recebe divisao
                //real não precisa verificar, pois recebe int ou real
                if (this.variaveis.get(lookahead(1).getLexema()).tipo == Variavel.INT) {
                    if (lookahead(2).getNome() == TipoToken.Atrib || lookahead(2).getNome() == TipoToken.OpRelDif || lookahead(2).getNome() == TipoToken.OpRelIgual || lookahead(2).getNome() == TipoToken.OpRelMaiorIgual || lookahead(2).getNome() == TipoToken.OpRelMaior || lookahead(2).getNome() == TipoToken.OpRelMenorIgual || lookahead(2).getNome() == TipoToken.OpRelMenor) {

                        for (int i = 0; ; i++) {
                            if (this.tokens.get(i).getNome() == TipoToken.OpAritDiv) {
                                erroSemantico("Tipo de variavel INT, valor a ser atribuido/comparado REAL");
                            } else if (this.tokens.get(i).getNome() == TipoToken.Var) {
                                if (this.variaveis.get(this.tokens.get(i).getLexema()).tipo == Variavel.REAL) {
                                    erroSemantico("Tipo de variavel INT, valor a ser atribuido/comparado REAL");
                                }
                            } else if (this.tokens.get(i).getNome() == TipoToken.NumReal) {
                                erroSemantico("Tipo de variavel INT, valor a ser atribuido/comparado REAL");
                            } else if (!(this.tokens.get(i).getNome() == TipoToken.OpAritMult || this.tokens.get(i).getNome() == TipoToken.OpAritSub || this.tokens.get(i).getNome() == TipoToken.OpAritSoma || this.tokens.get(i).getNome() == TipoToken.AbrePar || this.tokens.get(i).getNome() == TipoToken.FechaPar)) {
                                break;
                            }
                        }
                    }
                }
            } else if (match(TipoToken.NumInt)) {
                //verificar overflow INT
                try {
                    Integer.parseInt(lookahead(1).getLexema());
                } catch (NumberFormatException e) {
                    erroSemantico("Overflow");
                }
            } else if (match(TipoToken.NumReal)) {
                //verificar overflow e precisao REAL
                String[] digitos = lookahead(1).getLexema().split("\\.");
                if (digitos[1].length() > 8) {
                    System.out.println("\nWarning: Variavel excede a precisao maxima de 8 digitos. Valor truncado.");
                    System.out.println(lookahead(1).getLexema() + " -> " + digitos[0] + "." + digitos[1].substring(0, 8) + "\n");
                    lookahead(1).setLexema(digitos[0] + "." + digitos[1].substring(0, 8));
                }
                if (Float.parseFloat(lookahead(1).getLexema()) > 10E18 || Float.parseFloat(lookahead(1).getLexema()) < -10E18) {
                    erroSemantico("Overflow");
                }
            }

            // carrega o proximo token
            getToken();
        }
        //verificar se todas as variaveis foram utilizadas
        this.variaveis.forEach((key, value) -> {
            if (!value.utilizada) {
                System.out.println("\n\nWarning: Variavel \"" + value.nome + "\" declarada, mas nao utilizada.\n");
            }
        });
    }

    //exibir o erro semantico
    void erroSemantico(String erro) {
        throw new RuntimeException("Erro semantico -> " + erro);
    }

    // Coloca o token lido no buffer de tokens
    private void getToken() {
        // Se o buffer estiver cheio remove o primeiro (atualiza o buffer de tokens para receber o próximo token do analisador)
        if (this.bufferTokens.size() > 0) this.bufferTokens.remove(0);

        // Enquanto o buffer de tokens não estiver cheio, preenche o buffer de tokens com o próximo token
        while (this.bufferTokens.size() < this.tamanhoBuffer && !this.terminou) {
            // Pega o token no indice 0 da lista de tokens retornada pelo analisador lexico, coloca no buffer e
            // remove da lista de tokens
            Token proximoToken = this.tokens.get(0);
            this.tokens.remove(0);
            this.bufferTokens.add(proximoToken);

            // Se chegar no token EOF para de procurar tokens
            if (proximoToken.getNome() == TipoToken.EOF) this.terminou = true;
        }

        // Mostra o último token lido
        System.out.println("Token lido: " + lookahead(1));
    }

    // Lookahead -> Olha para o próximo token lido
    Token lookahead(int i) {
        // Retorna o enesimo elemento do buffer de tokens
        return bufferTokens.get(i - 1);
    }

    //verifica o tipo do token
    boolean match(TipoToken tipo) {
        return (lookahead(1).getNome() == tipo);
    }

}