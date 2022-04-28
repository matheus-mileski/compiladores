import java.util.ArrayList;

public class GyhSintatico {
    ArrayList<Token> tokens;
    int tamanhoBuffer = 10;
    ArrayList<Token> bufferTokens;
    boolean terminou = false;

    public GyhSintatico(ArrayList<Token> tokens) {
        this.tokens = tokens;
        bufferTokens = new ArrayList<>();
        getToken();
    }

    private void getToken() {
        if(bufferTokens.size() > 0)
            bufferTokens.remove(0);

        while(bufferTokens.size() < tamanhoBuffer && !terminou) {
            Token proximoToken = tokens.get(0);
            tokens.remove(0);
            bufferTokens.add(proximoToken);

            if(proximoToken.getNome() == TipoToken.EOF)
                terminou = true;
        }

        System.out.println("Token lido: " + lookahead(1));
    }

    Token lookahead(int i) {
        if(bufferTokens.isEmpty())
            return null;
        if(i-1 > bufferTokens.size())
            return bufferTokens.get(bufferTokens.size() - 1);

        return bufferTokens.get(i - 1);
    }

    void match(TipoToken tipo) {
        if(lookahead(1).getNome() == tipo) {
            System.out.println("Match: " + lookahead(1));
            getToken();
        } else
            erroSintatico(tipo.toString());
    }

    void erroSintatico(String... tokens) {
        StringBuilder mensagem = new StringBuilder("Erro sintatico -> Esperado [");
        for (int i = 0; i < tokens.length; i++)
            mensagem.append(tokens[i] += " ");

        mensagem.append("] mas foi encontrado " + lookahead(1));
    }

    // Programa → ':' 'DEC' ListaDeclaracoes ':' 'PROG' ListaComandos;
    public void programa() {
        match(TipoToken.Delim);
        match(TipoToken.PCDec);
        listaDeclaracoes();
        match(TipoToken.Delim);
        match(TipoToken.PCProg);
        listaComandos();
    }

    // ListaDeclaracoes → Declaracao ListaDeclaracoes | Declaracao;
    void listaDeclaracoes() {
        // Tem que reformular pq eu nao entendi o lookahead(4)
    }

    // Declaracao → VARIAVEL ':' TipoVar;
    void declaracao() {
        match(TipoToken.Var);
        match(TipoToken.Delim);
        tipoVar();
    }

    // TipoVar → 'INT' | 'REAL';
    void tipoVar() {
        if(lookahead(1).getNome() ==TipoToken.NumInt)
            match(TipoToken.NumInt);
        else if(lookahead(1).getNome() ==TipoToken.NumReal)
            match(TipoToken.NumReal);
        else
            erroSintatico("INT", "REAL");
    }

    // ExpressaoAritmetica → ExpressaoAritmetica '+' TermoAritmetico | ExpressaoAritmetica '-' TermoAritmetico | TermoAritmetico;

    // TermoAritmetico → TermoAritmetico '*' FatorAritmetico | TermoAritmetico '/' FatorAritmetico | FatorAritmetico;

    // FatorAritmetico → NUMINT | VARIAVEL | '(' ExpressaoAritmetica ')'

    // ExpressaoRelacional → ExpressaoRelacional OperadorBooleano TermoRelacional | TermoRelacional;

    // TermoRelacional → ExpressaoAritmetica OP_REL ExpressaoAritmetica | '(' ExpressaoRelacional ')';

    // OperadorBooleano → 'E' | 'OU';

    // ListaComandos → Comando ListaComandos | Comando;

    // Comando → ComandoAtribuicao | ComandoEntrada | ComandoSaida | ComandoCondicao | ComandoRepeticao | SubAlgoritmo;

    // ComandoAtribuicao → VARIAVEL ':=' ExpressaoAritmetica;

    // ComandoEntrada → 'LER' VARIAVEL;

    // ComandoSaida → 'IMPRIMIR'  (VARIAVEL | CADEIA);

    // ComandoCondicao → 'SE' ExpressaoRelacional 'ENTAO' Comando | 'SE' ExpressaoRelacional 'ENTAO' Comando 'SENAO' Comando;

    // ComandoRepeticao → 'ENQUANTO' ExpressaoRelacional Comando;

    // SubAlgoritmo → 'INI' ListaComandos 'FIM';

}
