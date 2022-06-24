grammar Gyh;

@members {
    private String _varName;
    private int _varType;
    private String _varValue;
    private Symbol _varSymbol;
    private SymbolTable _symbolTable = new SymbolTable();
}

programa: Delim 'DEC' listaDeclaracoes Delim 'PROG' listaComandos EOF;
listaDeclaracoes: declaracao listaDeclaracoes | declaracao;
declaracao: Var Delim tipoVar
{
    _varName = _input.LT(-3).getText();
    if (_input.LT(-1).getText() == "INT")
        _varType = 0;
    else
        _varType = 1;
    _varValue = null;
    _varSymbol = new Symbol(_varName, _varType, _varValue);

    if(!_symbolTable.contains(_varSymbol.getName())) {
        _symbolTable.addSymbol(_varSymbol);
        System.out.println("adicionado: " + _varSymbol.toString());
    } else
        System.out.println("Erro semantico: " + _varSymbol.toString() + " já existe!");
};
tipoVar: 'INT' | 'REAL';
expressaoAritmetica: expressaoAritmetica '+' termoAritmetico | expressaoAritmetica '-' termoAritmetico | termoAritmetico;
termoAritmetico: termoAritmetico '*' fatorAritmetico | termoAritmetico '/' fatorAritmetico | fatorAritmetico;
fatorAritmetico: NumInt | NumReal | Var | '(' expressaoAritmetica ')';
expressaoRelacional: expressaoRelacional operadorBooleano termoRelacional | termoRelacional;
termoRelacional: expressaoAritmetica OpRel expressaoAritmetica | '(' expressaoRelacional ')';
operadorBooleano: 'E' | 'OU';
listaComandos: comando listaComandos | comando;
comando: comandoAtribuicao | comandoEntrada | comandoSaida | comandoCondicao | comandoRepeticao | subAlgoritmo;
comandoAtribuicao: Var ':=' expressaoAritmetica;
comandoEntrada: 'LER' Var;
comandoSaida: 'IMPRIMIR'  Var | 'IMPRIMIR' Cadeia;
comandoCondicao: 'SE' expressaoRelacional 'ENTAO' comando | 'SE' expressaoRelacional 'ENTAO' comando 'SENAO' comando;
comandoRepeticao: 'ENQTO' expressaoRelacional comando;
subAlgoritmo: 'INI' listaComandos 'FIM';

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