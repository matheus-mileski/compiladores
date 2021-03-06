import java.util.ArrayList;
import java.util.HashMap;

public class GyhSintatico {
    ArrayList<Token> tokens;    // Lista de tokens que é preenchida pelo analisador léxico
    int tamanhoBuffer = 3; // Tamanho do buffer de tokens
    ArrayList<Token> bufferTokens;  // Buffer de tokens
    boolean terminou = false;   // Auxiliar para verificar se terminaram os tokens do lexico
    HashMap<String, Variavel> variaveis;

    public GyhSintatico(ArrayList<Token> tokens) {
        // Popula a lista de tokens com os tokens retornados do analisador lexico
        this.tokens = new ArrayList<>(tokens);
        // Cria um buffer de tokens
        bufferTokens = new ArrayList<>();
        // Cria HashMap pra armazenar as variaveis
        this.variaveis = new HashMap<String, Variavel>();
        // Vai para a funcao que popula o buffer de tokens
        getToken();
    }

    // Coloca o token lido no buffer de tokens
    private void getToken() {
        // Se o buffer estiver cheio remove o primeiro (atualiza o buffer de tokens para receber o próximo token do analisador)
        if (bufferTokens.size() > 0)
            bufferTokens.remove(0);

        // Enquanto o buffer de tokens não estiver cheio, preenche o buffer de tokens com o próximo token
        while (bufferTokens.size() < tamanhoBuffer && !terminou) {
            // Pega o token no indice 0 da lista de tokens retornada pelo analisador lexico, coloca no buffer e
            // remove da lista de tokens
            Token proximoToken = tokens.get(0);
            tokens.remove(0);
            bufferTokens.add(proximoToken);

            // Se chegar no token EOF para de procurar tokens
            if (proximoToken.getNome() == TipoToken.EOF)
                terminou = true;
        }

        // Mostra o último token lido
        System.out.println("Token lido: " + lookahead(1));
    }

    // Lookahead -> Olha para o próximo token lido
    Token lookahead(int i) {
        // Retorna o enesimo elemento do buffer de tokens
        return bufferTokens.get(i - 1);
    }

    // Funçao match -> Se o token lido possuir o mesmo nome que o fornecido para a funcao da o match, senao
    // mostra um erro léxico
    void match(TipoToken tipo) {
        // Se o token lido for igual ao token fornecido da match
        if (lookahead(1).getNome() == tipo) {
            System.out.println("Match: " + lookahead(1));
            // Atualiza o buffer de tokens e pega o próximo token do léxico
            getToken();
        } else
            // Mostra um erro léxico caso não de match
            erroSintatico(tipo.toString());
    }

    // Exibir erro sintático na tela -> Para a execução do analisador
    // Recebe quais eram os tokens esperados como parametro
    void erroSintatico(String... tokens) {
        StringBuilder mensagem = new StringBuilder("Erro sintatico -> Esperado [ ");
        for (int i = 0; i < tokens.length; i++)
            mensagem.append(tokens[i] += " ");
        mensagem.append("] mas foi encontrado ").append(lookahead(1));

        throw new RuntimeException(mensagem.toString());
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
    // Refatorada:
    // ListaDeclaracoes → Declaracao (ListaDeclaracoes | <<vazio>>);
    void listaDeclaracoes() {
        declaracao();
        if (lookahead(1).getNome() == TipoToken.Var)
            listaDeclaracoes();
    }

    // Declaracao → VARIAVEL ':' TipoVar;
    void declaracao() {
        //salva o token antes da verificacao sintatica
        Token aux = new Token(lookahead(1).getNome(), lookahead(1).getLexema());
        match(TipoToken.Var);
        match(TipoToken.Delim);
        //salva o tipo da variavel antes da verificacao sintatiac
        int tipo = tipoVar();
        //apos a verificacao sintatica, salva o token como variavel no hashmap
        this.variaveis.put(aux.getLexema(), new Variavel(aux.getLexema(), tipo));
    }

    // TipoVar → 'INT' | 'REAL';
    int tipoVar() {
        if (lookahead(1).getNome() == TipoToken.PCInt) {
            match(TipoToken.PCInt);
            return Variavel.INT;
        } else if (lookahead(1).getNome() == TipoToken.PCReal) {
            match(TipoToken.PCReal);
            return Variavel.REAL;
        }

        erroSintatico("INT ou", "REAL");
        return -1;
    }

    // Original:
    // ExpressaoAritmetica → ExpressaoAritmetica '+' TermoAritmetico | ExpressaoAritmetica '-' TermoAritmetico | TermoAritmetico;
    // Refatorada:
    // ExpressaoAritmetica → ExpressaoAritmetica ('+' TermoAritmetico | '-' TermoAritmetico) | TermoAritmetico;
    // Sem recursão a esquerda (A → A b | c fica A → c A_aux; A_aux → b A_aux | <<vazio>>):
    // ExpressaoAritmetica → TermoAritmetico ExpressaoAritmeticaAux
    void expressaoAritmetica() {
        termoAritimetico();
        expressaoAritmeticaAux();
    }

    // ExpressaoAritmeticaAux → ('+' TermoAritmetico | '-' TermoAritmetico) ExpressaoAritmeticaAux | << vazio >>
    void expressaoAritmeticaAux() {
        if (lookahead(1).getNome() == TipoToken.OpAritSoma || lookahead(1).getNome() == TipoToken.OpAritSub) {
            if (lookahead(1).getNome() == TipoToken.OpAritSoma) {
                match(TipoToken.OpAritSoma);
                termoAritimetico();
            } else if (lookahead(1).getNome() == TipoToken.OpAritSub) {
                match(TipoToken.OpAritSub);
                termoAritimetico();
            } else
                erroSintatico("+ ou", "-");
            expressaoAritmeticaAux();
        }
    }

    // Original:
    // TermoAritmetico → TermoAritmetico '*' FatorAritmetico | TermoAritmetico '/' FatorAritmetico | FatorAritmetico;
    // Refatorada:
    // TermoAritmetico → TermoAritmetico ('*' FatorAritmetico | '/' FatorAritmetico) | FatorAritmetico;
    // Sem recursão a esquerda (A → A b | c fica A → c A_aux; A_aux → b A_aux | <<vazio>>):
    // TermoAritmetico → FatorAritmetico TermoAritmeticoAux
    void termoAritimetico() {
        fatorAritimetico();
        termoAritimeticoAux();
    }

    // TermoAritmeticoAux → ('*' FatorAritmetico | '/' FatorAritmetico) TermoAritmeticoAux | << vazio >>
    void termoAritimeticoAux() {
        if (lookahead(1).getNome() == TipoToken.OpAritMult || lookahead(1).getNome() == TipoToken.OpAritDiv) {
            if (lookahead(1).getNome() == TipoToken.OpAritMult) {
                match(TipoToken.OpAritMult);
                fatorAritimetico();
            } else if (lookahead(1).getNome() == TipoToken.OpAritDiv) {
                match(TipoToken.OpAritDiv);
                fatorAritimetico();
            } else
                erroSintatico("* ou", "/");
            termoAritimeticoAux();
        }
    }

    // FatorAritmetico → NUMINT | NUMREAL | VARIAVEL | '(' ExpressaoAritmetica ')'
    void fatorAritimetico() {
        if (lookahead(1).getNome() == TipoToken.NumInt)
            match(TipoToken.NumInt);
        else if (lookahead(1).getNome() == TipoToken.NumReal)
            match(TipoToken.NumReal);
        else if (lookahead(1).getNome() == TipoToken.Var)
            match(TipoToken.Var);
        else if (lookahead(1).getNome() == TipoToken.AbrePar) {
            match(TipoToken.AbrePar);
            expressaoAritmetica();
            match(TipoToken.FechaPar);
        } else
            erroSintatico("NUMERO INTEIRO ou", "NUMERO REAL ou", "VARIAVEL ou", "(");
    }

    // ExpressaoRelacional → ExpressaoRelacional OperadorBooleano TermoRelacional | TermoRelacional;
    // Sem recursão a esquerda (A → A b | c fica A → c A_aux; A_aux → b A_aux | <<vazio>>):
    // ExpressaoRelacional → TermoRelacional ExpressaoRelacionalAux;
    void expressaoRelacional() {
        termoRelacional();
        expressaoRelacionalAux();
    }

    // ExpressaoRelacionalAux → OperadorBooleano TermoRelacional ExpressaoRelacionalAux | << vazio >>;
    void expressaoRelacionalAux() {
        if (lookahead(1).getNome() == TipoToken.OpBoolE || lookahead(1).getNome() == TipoToken.OpBoolOu) {
            operadorBooleano();
            expressaoRelacional();
            expressaoRelacionalAux();
        }
    }

    // TermoRelacional → ExpressaoAritmetica OP_REL ExpressaoAritmetica | '(' ExpressaoRelacional ')';
    void termoRelacional() {
        if (lookahead(1).getNome() == TipoToken.NumInt || lookahead(1).getNome() == TipoToken.NumReal
                || lookahead(1).getNome() == TipoToken.Var) {
            expressaoAritmetica();
            opRel();
            expressaoAritmetica();
        } else if (lookahead(1).getNome() == TipoToken.AbrePar) {
            match(TipoToken.AbrePar);
            expressaoRelacional();
            match(TipoToken.FechaPar);
        } else
            erroSintatico("NUMERO INTEIRO ou", "NUMERO REAL ou", "VARIAVEL ou", "(");
    }

    // Verifica a existencia de um operador relacional
    void opRel() {
        if (lookahead(1).getNome() == TipoToken.OpRelMenor)
            match(TipoToken.OpRelMenor);
        else if (lookahead(1).getNome() == TipoToken.OpRelMenorIgual)
            match(TipoToken.OpRelMenorIgual);
        else if (lookahead(1).getNome() == TipoToken.OpRelMaior)
            match(TipoToken.OpRelMaior);
        else if (lookahead(1).getNome() == TipoToken.OpRelMaiorIgual)
            match(TipoToken.OpRelMaiorIgual);
        else if (lookahead(1).getNome() == TipoToken.OpRelIgual)
            match(TipoToken.OpRelIgual);
        else if (lookahead(1).getNome() == TipoToken.OpRelDif)
            match(TipoToken.OpRelDif);
        else
            erroSintatico("< ou", "<= ou", "> ou", ">= ou", "== ou", "!= ou");
    }

    // OperadorBooleano → 'E' | 'OU';
    void operadorBooleano() {
        if (lookahead(1).getNome() == TipoToken.OpBoolE)
            match(TipoToken.OpBoolE);
        else if (lookahead(1).getNome() == TipoToken.OpBoolOu)
            match(TipoToken.OpBoolOu);
        else
            erroSintatico("E ou", "OU");
    }

    // ListaComandos → Comando ListaComandos | Comando;
    // Refatorada:
    // ListaComandos → Comando (ListaComandos | <<vazio>>);
    void listaComandos() {
        comando();
        if (lookahead(1).getNome() == TipoToken.Var || lookahead(1).getNome() == TipoToken.PCLer
                || lookahead(1).getNome() == TipoToken.PCImprimir || lookahead(1).getNome() == TipoToken.PCSe
                || lookahead(1).getNome() == TipoToken.PCEnqto || lookahead(1).getNome() == TipoToken.PCIni) {
            listaComandos();
        }
    }

    // Comando → ComandoAtribuicao | ComandoEntrada | ComandoSaida | ComandoCondicao | ComandoRepeticao | SubAlgoritmo;
    void comando() {
        if (lookahead(1).getNome() == TipoToken.Var)
            comandoAtribuicao();
        else if (lookahead(1).getNome() == TipoToken.PCLer)
            comandoEntrada();
        else if (lookahead(1).getNome() == TipoToken.PCImprimir)
            comandoSaida();
        else if (lookahead(1).getNome() == TipoToken.PCSe)
            comandoCondicao();
        else if (lookahead(1).getNome() == TipoToken.PCEnqto)
            comandoRepeticao();
        else if (lookahead(1).getNome() == TipoToken.PCIni)
            subAlgoritmo();
        else
            erroSintatico("VARIAVEL ou", "LER ou", "IMPRIMIR ou", "SE ou", "ENQTO ou", "INI");
    }

    // ComandoAtribuicao → VARIAVEL ':=' ExpressaoAritmetica;
    void comandoAtribuicao() {
        match(TipoToken.Var);
        match(TipoToken.Atrib);
        expressaoAritmetica();
    }

    // ComandoEntrada → 'LER' VARIAVEL;
    void comandoEntrada() {
        match(TipoToken.PCLer);
        match(TipoToken.Var);
    }

    // ComandoSaida → 'IMPRIMIR'  (VARIAVEL | CADEIA);
    void comandoSaida() {
        match(TipoToken.PCImprimir);
        if (lookahead(1).getNome() == TipoToken.Var)
            match(TipoToken.Var);
        else if (lookahead(1).getNome() == TipoToken.Cadeia)
            match(TipoToken.Cadeia);
        else
            erroSintatico("VARIAVEL ou", "CADEIA DE CARACTERES");
    }

    // ComandoCondicao → 'SE' ExpressaoRelacional 'ENTAO' Comando | 'SE' ExpressaoRelacional 'ENTAO' Comando 'SENAO' Comando;
    // Refatorada:
    // ComandoCondicao → 'SE' ExpressaoRelacional 'ENTAO' Comando ('SENAO' Comando | <<vazio>>);
    void comandoCondicao() {
        match(TipoToken.PCSe);
        expressaoRelacional();
        match(TipoToken.PCEntao);
        comando();
        if (lookahead(1).getNome() == TipoToken.PCSenao) {
            match(TipoToken.PCSenao);
            comando();
        }
    }

    // ComandoRepeticao → 'ENQUANTO' ExpressaoRelacional Comando;
    void comandoRepeticao() {
        match(TipoToken.PCEnqto);
        expressaoRelacional();
        comando();
    }

    // SubAlgoritmo → 'INI' ListaComandos 'FIM';
    void subAlgoritmo() {
        match(TipoToken.PCIni);
        listaComandos();
        match(TipoToken.PCFim);
    }
}
