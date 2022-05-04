import java.util.ArrayList;

public class GyhSintatico {
    ArrayList<Token> tokens;
    int tamanhoBuffer = 3;
    ArrayList<Token> bufferTokens;
    boolean terminou = false;

    public GyhSintatico(ArrayList<Token> tokens) {
        // Popula a lista de tokens com os tokens retornados do analisador lexico
        this.tokens = tokens;
        // Cria um buffer de tokens
        bufferTokens = new ArrayList<>();
        // Vai para a funcao que popula o buffer de tokens
        getToken();
    }

    private void getToken() {
        // Se o buffer de tokens possuir algum token remove
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
        // Retorna nulo se o buffer de tokens estiver vazio
        if(bufferTokens.isEmpty())
            return null;
        // Retorna o ultimo elemento do buffer de tokens se o valor do lookahead for maior que o ultimo indice do buffer de tokens
        if(i-1 > bufferTokens.size())
            return bufferTokens.get(bufferTokens.size() - 1);

        // Retorna o enesimo elemento do buffer de tokens
        return bufferTokens.get(i - 1);
    }

    void match(TipoToken tipo) {
        // Se o proximo token a ser lido possuir o mesmo nome que o fornecido para a funcao da o match
        if(lookahead(1).getNome() == tipo) {
            System.out.println("Match: " + lookahead(1));
            getToken();
        } else
            erroSintatico(tipo.toString());
    }

    void erroSintatico(String... tokens) {
        String mensagem = "Erro sintatico -> Esperado [ ";
        for (int i = 0; i < tokens.length; i++)
            mensagem += tokens[i] += " ";
        mensagem += "] mas foi encontrado " + lookahead(1);

        throw new RuntimeException(mensagem);
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
        if(lookahead(1).getNome() == TipoToken.Var)
            listaDeclaracoes();
        else {
            // vazio
        }
    }

    // Declaracao → VARIAVEL ':' TipoVar;
    void declaracao() {
        match(TipoToken.Var);
        match(TipoToken.Delim);
        tipoVar();
    }

    // TipoVar → 'INT' | 'REAL';
    void tipoVar() {
        if(lookahead(1).getNome() == TipoToken.PCInt)
            match(TipoToken.PCInt);
        else if(lookahead(1).getNome() == TipoToken.PCReal)
            match(TipoToken.PCReal);
        else
            erroSintatico("INT ou", "REAL");
    }

    // Original:
    // ExpressaoAritmetica → ExpressaoAritmetica '+' TermoAritmetico | ExpressaoAritmetica '-' TermoAritmetico | TermoAritmetico;
    // Refatorada:
    // ExpressaoAritmetica → ExpressaoAritmetica ('+' TermoAritmetico | '-' TermoAritmetico) | TermoAritmetico;
    // Sem recursão a esquerda:
    // ExpressaoAritmetica → TermoAritmetico ExpressaoAritmeticaAux
    void expressaoAritmetica() {
        termoAritimetico();
        expressaoAritmeticaAux();
    }
    // ExpressaoAritmeticaAux → ('+' TermoAritmetico | '-' TermoAritmetico) ExpressaoAritmeticaAux | << vazio >>
    void expressaoAritmeticaAux() {
        if(lookahead(1).getNome() == TipoToken.OpAritSoma || lookahead(1).getNome() == TipoToken.OpAritSub) {
            if(lookahead(1).getNome() == TipoToken.OpAritSoma) {
                match(TipoToken.OpAritSoma);
                termoAritimetico();
            } else if(lookahead(1).getNome() == TipoToken.OpAritSub) {
                match(TipoToken.OpAritSub);
                termoAritimetico();
            } else
                erroSintatico("+ ou", "-");
            expressaoAritmeticaAux();
        } else {
            //vazio
        }
    }

    // Original:
    // TermoAritmetico → TermoAritmetico '*' FatorAritmetico | TermoAritmetico '/' FatorAritmetico | FatorAritmetico;
    // Refatorada:
    // TermoAritmetico → TermoAritmetico ('*' FatorAritmetico | '/' FatorAritmetico) | FatorAritmetico;
    // Sem recursão a esquerda:
    // TermoAritmetico → FatorAritmetico TermoAritmeticoAux
    void termoAritimetico() {
        fatorAritimetico();
        termoAritimeticoAux();
    }
    // TermoAritmeticoAux → ('*' FatorAritmetico | '/' FatorAritmetico) TermoAritmeticoAux | << vazio >>
    void termoAritimeticoAux() {
        if(lookahead(1).getNome() == TipoToken.OpAritMult || lookahead(1).getNome() == TipoToken.OpAritDiv) {
            if(lookahead(1).getNome() == TipoToken.OpAritMult) {
                match(TipoToken.OpAritMult);
                fatorAritimetico();
            } else if(lookahead(1).getNome() == TipoToken.OpAritDiv) {
                match(TipoToken.OpAritDiv);
                fatorAritimetico();
            } else
                erroSintatico("* ou", "/");
            termoAritimeticoAux();
        } else {
            //vazio
        }
    }

    // FatorAritmetico → NUMINT | VARIAVEL | '(' ExpressaoAritmetica ')'
    // IMPORTANTE: AQUI NAO ESTA FALTANDO A OPCAO DE NUMERO REAL (NA GRAMATICA DA PROFESSORA)?
    void fatorAritimetico() {
        if(lookahead(1).getNome() == TipoToken.NumInt)
            match(TipoToken.NumInt);
        /*else if(lookahead(1).getNome() == TipoToken.NumReal)
            match(TipoToken.NumInt);*/
        else if(lookahead(1).getNome() == TipoToken.Var)
            match(TipoToken.Var);
        else if (lookahead(1).getNome() == TipoToken.AbrePar) {
            match(TipoToken.AbrePar);
            expressaoAritmetica();
            match(TipoToken.FechaPar);
        } else
            erroSintatico("NUMERO INTEIRO ou", /*"NUMERO REAL ou",*/ "VARIAVEL ou", "(");
    }

    // ExpressaoRelacional → ExpressaoRelacional OperadorBooleano TermoRelacional | TermoRelacional;
    // Sem recursão a esquerda:
    // ExpressaoRelacional → TermoRelacional ExpressaoRelacionalAux;
    void expressaoRelacional() {
        termoRelacionalSemParenteses();
        expressaoRelacionalAux();
    }
    // ExpressaoRelacionalAux → OperadorBooleano TermoRelacional ExpressaoRelacionalAux | << vazio >>;
    void expressaoRelacionalAux() {
        if(lookahead(1).getNome() == TipoToken.OpBoolE || lookahead(1).getNome() == TipoToken.OpBoolOu) {
            operadorBooleano();
            expressaoRelacional();
            expressaoRelacionalAux();
        } else {
            // vazio
        }

    }

    // TermoRelacional → ExpressaoAritmetica OP_REL ExpressaoAritmetica | '(' ExpressaoRelacional ')';
    // IMPORTANTE: NO VIDEO ELE REMOVE O '(' ExpressaoRelacional ')', TEM QUE REFORMULAR A EXPRESSAO PRA FUNCIONAR CERTO
    // IMPORTANTE2: TEM QUE VERIFICAR A EXISTENCIA DO NUMERO REAL NO FATOR ARITIMETICO
    // TermoRelacionalSemParenteses → ExpressaoAritmetica OpRel ExpressaoAritmetica;
    void termoRelacionalSemParenteses() {
        if(lookahead(1).getNome() == TipoToken.NumInt /*|| lookahead(1).getNome() == TipoToken.NumReal*/
                || lookahead(1).getNome() == TipoToken.Var || lookahead(1).getNome() == TipoToken.AbrePar) {
            expressaoAritmetica();
            opRel();
            expressaoAritmetica();
        } else
            erroSintatico("NUMERO INTEIRO ou", /*"NUMERO REAL ou",*/ "VARIAVEL ou", "(");
    }
    // Verifica a existencia de um operador relacional
    void opRel() {
        if(lookahead(1).getNome() == TipoToken.OpRelMenor)
            match(TipoToken.OpRelMenor);
        else if(lookahead(1).getNome() == TipoToken.OpRelMenorIgual)
            match(TipoToken.OpRelMenorIgual);
        else if(lookahead(1).getNome() == TipoToken.OpRelMaior)
            match(TipoToken.OpRelMaior);
        else if(lookahead(1).getNome() == TipoToken.OpRelMaiorIgual)
            match(TipoToken.OpRelMaiorIgual);
        else if(lookahead(1).getNome() == TipoToken.OpRelIgual)
            match(TipoToken.OpRelIgual);
        else if(lookahead(1).getNome() == TipoToken.OpRelDif)
            match(TipoToken.OpRelDif);
        else
            erroSintatico("< ou", "<= ou", "> ou", ">= ou", "== ou", "!= ou");
    }

    // OperadorBooleano → 'E' | 'OU';
    void operadorBooleano() {
        if(lookahead(1).getNome() == TipoToken.OpBoolE)
            match(TipoToken.OpBoolE);
        else if(lookahead(1).getNome() == TipoToken.OpBoolOu)
            match(TipoToken.OpBoolOu);
        else
            erroSintatico("E ou", "OU");
    }

    // ListaComandos → Comando ListaComandos | Comando;
    // Refatorada:
    // ListaComandos → Comando (ListaComandos | <<vazio>>);
    void listaComandos() {
        comando();
        if(lookahead(1).getNome() == TipoToken.Var || lookahead(1).getNome() == TipoToken.PCLer
                || lookahead(1).getNome() == TipoToken.PCImprimir || lookahead(1).getNome() == TipoToken.PCSe
                || lookahead(1).getNome() == TipoToken.PCEnqto || lookahead(1).getNome() == TipoToken.PCIni) {
            listaComandos();
        } else {
            // vazio
        }
    }

    // Comando → ComandoAtribuicao | ComandoEntrada | ComandoSaida | ComandoCondicao | ComandoRepeticao | SubAlgoritmo;
    void comando() {
        if(lookahead(1).getNome() == TipoToken.Var)
            comandoAtribuicao();
        else if(lookahead(1).getNome() == TipoToken.PCLer)
            comandoEntrada();
        else if(lookahead(1).getNome() == TipoToken.PCImprimir)
            comandoSaida();
        else if(lookahead(1).getNome() == TipoToken.PCSe)
            comandoCondicao();
        else if(lookahead(1).getNome() == TipoToken.PCEnqto)
            comandoRepeticao();
        else if(lookahead(1).getNome() == TipoToken.PCIni)
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
        if(lookahead(1).getNome() == TipoToken.Var)
            match(TipoToken.Var);
        else if(lookahead(1).getNome() == TipoToken.Cadeia)
            match(TipoToken.Cadeia);
        else
            erroSintatico("VARIAVEL ou", "CADEIA DE CARACTERES");
    }

    // ComandoCondicao → 'SE' ExpressaoRelacional 'ENTAO' Comando | 'SE' ExpressaoRelacional 'ENTAO' Comando 'SENAO' Comando;
    // Refatorada:
    // ComandoCondicao → 'SE' ExpressaoRelacional 'ENTAO' Comando ('SENAO' Comando | <<vazio>>);
    // IMPORTANTE: TEM QUE IMPLEMENTAR O SENAO NO ANALISADOR LEXICO PRA PODER USAR NO SINTATICO
    void comandoCondicao() {
        match(TipoToken.PCSe);
        expressaoRelacional();
        match(TipoToken.PCEntao);
        comando();
        /*if(lookahead(1).getNome() == TipoToken.PcSenao) {
            match(TipoToken.PCSenao);
            comando();
        } else {
            // vazio
        }*/
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
