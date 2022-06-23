grammar Gyh;

programa: Delim 'DEC' listaDeclaracoes Delim 'PROG' listaComandos EOF;
listaDeclaracoes: declaracao listaDeclaracoes | declaracao;
declaracao: Var Delim tipoVar;
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