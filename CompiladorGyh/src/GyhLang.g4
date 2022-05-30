grammar GyhLang;
prog: 'Prox_Aula_Falamos_Mais';
PC: 'DEC' | 'PROG' | 'INT' | 'REAL' | 'LER' | 'IMPRIMIR' | 'SE' | 'SENAO' | 'ENTAO' | 'ENQTO' | 'INI' | 'FIM';
OpRel: '<' | '<=' | '>' | '>=' | '==' | '!=';
Var: [a-z] ([a-z] | [A-Z] | [0-9])*;
NumInt: [0-9]+;
NumReal: [0-9]+'.'[0-9]*;
Delim: ':';
WS: (' ' | '\n' | '\r' | '\t') -> skip;
Comment: '#'+'\n' -> skip;