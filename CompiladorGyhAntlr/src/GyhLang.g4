grammar GyhLang;

// imports
@header {
    import java.util.ArrayList;
}

// Declarações
@members {
    private String _varName;    // Aux nome da variável
    private String _varType;    // Aux tipo da variável
    private String _varValue;   // Aux valor da variável
    private Symbol _varSymbol;  // Aux simbolo
    private SymbolTable _symbolTable = new SymbolTable();   // Tabela de simbolos

    private String _var;

    private String _varAtrib = "";  // Aux para comando de atribuição
    private String _varExp = "";    // Aux para expressao
    private String _condition = ""; // Aux para condicao

    private ArrayList<Command> listCmd = new ArrayList<Command>();  // Lista de comandos
    private ArrayList<Command> listCmdAux = new ArrayList<Command>();   // Lista de comandos auxiliar

    private ArrayList<Command> listTrue = new ArrayList<Command>(); // Lista de comandos para o if
    private ArrayList<Command> listFalse = new ArrayList<Command>();    // Lista de comandos para o else

    private GyhProgram program = new GyhProgram();

    // Metodo para gerar o código em C
    public void generateCommand(String filename) {
        program.generateTarget(filename);
    }

    // Metodo para verificar se uma variável foi declarada e marcar que essa variável foi utilizada
    public void verificarVar(String nomeVar){
        if(!_symbolTable.contains(nomeVar)){
            throw new RuntimeException("Erro semantico: variavel \"" + nomeVar + "\" não declarada");
        }
        if (!_symbolTable.getSymbol(nomeVar).foiUtilizada()) {
            _symbolTable.getSymbol(nomeVar).setUtilizada();
        }
    }
}

programa: Delim 'DEC' listaDeclaracoes Delim 'PROG' listaComandos EOF
{
    // Verificar se todas as variaveis foram utilizadas
    _symbolTable.getSymbolTable().forEach((key, value) -> {
        if (!value.foiUtilizada()) {
            System.out.println("Warning: Variavel \"" + value.getName() + "\" declarada, mas nao utilizada.\n");
        }
    });

    program.setVarTable(_symbolTable);
    program.setCommand(listCmd);
};

listaDeclaracoes: (declaracao)+;

declaracao: Var Delim tipoVar
{
    _varName = _input.LT(-3).getText();
    _varType = _input.LT(-1).getText();
    _varSymbol = new Symbol(_varName, _varType);

    // Adiciona uma variável a lista de simbolos se essa variável já não foi declarada anteriomente
    if(!_symbolTable.contains(_varSymbol.getName())) {
        _symbolTable.addSymbol(_varSymbol);
    } else {
        throw new RuntimeException("Erro semantico: variavel " + _varSymbol.toString() + " já existe!");
    }
};

tipoVar: 'INT' | 'REAL';

// Monta a expressao atitimética
expressaoAritmetica: expressaoAritmetica '+'{_varExp+=_input.LT(-1).getText();} termoAritmetico
                    | expressaoAritmetica '-' termoAritmetico
                    | termoAritmetico;

// Monta o termo aritimético
termoAritmetico:    termoAritmetico '*'{_varExp+=_input.LT(-1).getText();} fatorAritmetico
                    | termoAritmetico '/'   {
                                                _varExp+=_input.LT(-1).getText();   // Se era pra ser atribuido um INT e foi atribuido um REAL monta um erro
                                                if(_varType.equals("INT")){
                                                    throw new RuntimeException("Erro semantico: Tipo de variavel INT, valor a ser atribuido REAL");
                                                }
                                            }
                    fatorAritmetico
                    | fatorAritmetico;

// Monta o fator aritimético
fatorAritmetico: '-'? {if (_input.LT(-1).getText().equals("-")) _varExp+=_input.LT(-1).getText();}
                NumInt {
                            try {   // Verifica overflow
                                Integer.parseInt(_input.LT(-1).getText());
                            } catch (NumberFormatException e) {
                                throw new RuntimeException("Erro semantico: INT Overflow");
                            }
                            _varExp+=_input.LT(-1).getText();
                        }
                | '-'? {if (_input.LT(-1).getText().equals("-")) _varExp+=_input.LT(-1).getText();}
                NumReal {
                            if(_varType.equals("INT")){ // Se for um REAL mas foi recebido um INT, mostra um erro
                                throw new RuntimeException("Erro semantico: Tipo de variavel INT, valor a ser atribuido REAL");
                            }
                            String[] digitos = _input.LT(-1).getText().split("\\.");
                            String real = _input.LT(-1).getText();
                            if (digitos[1].length() > 8) {
                                System.out.println("\nWarning: Variavel excede a precisao maxima de 8 digitos. Valor truncado.");
                                System.out.println(_input.LT(-1).getText() + " -> " + digitos[0] + "." + digitos[1].substring(0, 8) + "\n");
                                real = digitos[0] + "." + digitos[1].substring(0, 8);
                            }   // Verifica se o numero real excede a precisao maxima
                            if (Float.parseFloat(real) > 10E18 || Float.parseFloat(real) < -10E18) {
                                throw new RuntimeException("Erro semantico: REAL Overflow");
                            }   // Verifica overflow
                            _varExp+=real;
                        }
                | '-'? {if (_input.LT(-1).getText().equals("-")) _varExp+=_input.LT(-1).getText();}
                Var {
                        verificarVar(_input.LT(-1).getText());
                        _varExp+=_input.LT(-1).getText();
                        if(_varType.equals("INT") && _symbolTable.getSymbol(_input.LT(-1).getText()).getTypeStr().equals("REAL")){
                            throw new RuntimeException("Erro semantico: Tipo de variavel INT, valor a ser atribuido REAL");
                        }
                    }
                | '(' {_varExp+=_input.LT(-1).getText();} expressaoAritmetica ')'{_varExp+=_input.LT(-1).getText();};

// Monta o operador booleano
operadorBooleano: 'E' {_varExp+=" && ";}
                | 'OU' {_varExp+=" || ";};

listaComandos: (comando
                    {
                        listCmd.addAll(listCmdAux); // Preenche a lista de comandos com a lista auxiliar
                        listCmdAux.removeAll(listCmdAux);   // Esvazia a lista de comandos auxiliar
                    }
                )+;

comando: comandoAtribuicao | comandoEntrada | comandoSaida | comandoCondicao | comandoRepeticao | subAlgoritmo;

comandoAtribuicao: Var ':='
                        {
                            verificarVar(_input.LT(-2).getText());
                            _varAtrib = _input.LT(-2).getText();
                            _varType = _symbolTable.getSymbol(_varAtrib).getTypeStr();
                            _varExp = "";
                        }
                    expressaoAritmetica
                        {
                            _varType = "";
                            CommandAtrib cmd = new CommandAtrib(_varAtrib, _varExp);
                            listCmdAux.add(cmd);
                        };

comandoEntrada: 'LER' Var
                    {
                        verificarVar(_input.LT(-1).getText());
                        _var = _input.LT(-1).getText();
                        CommandScan cmd = new CommandScan(_var, _symbolTable.getSymbol(_var).getType());
                        listCmdAux.add(cmd);
                    };
comandoSaida: 'IMPRIMIR'  Var
                    {
                        verificarVar(_input.LT(-1).getText());
                        _var = _input.LT(-1).getText();
                        CommandPrint cmd = new CommandPrint(_var, _symbolTable.getSymbol(_var).getType());
                        listCmdAux.add(cmd);
                    }
            | 'IMPRIMIR' Cadeia
                    {
                        CommandPrint cmd = new CommandPrint(_input.LT(-1).getText(), 3);
                        listCmdAux.add(cmd);
                    };

expressaoRelacional: expressaoRelacional operadorBooleano termoRelacional | termoRelacional;

termoRelacional: {_varExp="";} expressaoAritmetica OpRel {_varExp+=" " + _input.LT(-1).getText() + " ";} expressaoAritmetica
                | '(' {_varExp=" " + _input.LT(-1).getText() + " ";} expressaoRelacional ')' {_varExp+=" " + _input.LT(-1).getText() + " ";};

comandoCondicao: 'SE' expressaoRelacional {_condition = _varExp;_varExp = "";}
                 'ENTAO' comando{listTrue.addAll(listCmdAux);listCmdAux.removeAll(listCmdAux);}
                 ('SENAO' comando{listFalse.addAll(listCmdAux);listCmdAux.removeAll(listCmdAux);})?
                    {
                        CommandCond cmd = new CommandCond(_condition, listTrue, listFalse);
                        listTrue.removeAll(listTrue);
                        listFalse.removeAll(listFalse);
                        listCmdAux.add(cmd);
                    };

comandoRepeticao: 'ENQTO' expressaoRelacional {_condition = _varExp;_varExp = "";} comando
                    {
                        CommandRep cmd = new CommandRep(_condition, listCmdAux);
                        listCmdAux.removeAll(listCmdAux);
                        listCmdAux.add(cmd);
                    };

subAlgoritmo: 'INI'{_varExp = "";} (comando)+ 'FIM';

PC: 'DEC' | 'PROG' | 'INT' | 'REAL' | 'LER' | 'IMPRIMIR' | 'SE' | 'SENAO' | 'ENTAO' | 'ENQTO' | 'INI' | 'FIM';
Atrib: ':=';
Delim: ':';
OpRel: '<' | '<=' | '>' | '>=' | '==' | '!=';
OpArit: '*' | '/' | '+' | '-';
AbrePar: '(';
FechaPar: ')';
OpBoolE: 'E';
OpBoolOu: 'OU';
Cadeia: '"' .*? '"';
Var: [a-z] ([a-z] | [A-Z] | [0-9])*;
NumInt: [0-9]+;
NumReal: [0-9]+'.'[0-9]*;

Comentario: '#' ~('\n')* '\n' -> skip;
EspacoBranco: (' ' | '\t' | '\r' | '\n') -> skip;