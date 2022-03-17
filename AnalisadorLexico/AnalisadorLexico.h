#ifndef COMPILADORES_ANALISADORLEXICO_H
#define COMPILADORES_ANALISADORLEXICO_H

#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>

// Definições das Estruturas de Dados

typedef struct NoPilha *PtrNoPilha;

typedef struct NoPilha{
	char simbolo;
	PtrNoPilha proximo;
} NoPilha;

typedef struct {
	PtrNoPilha topo;
	int tamanho;
} Pilha;

// Funções Pilha

void inicializaPilha(Pilha *pilha);
bool estaVazia(Pilha *pilha);
void empilha(Pilha *pilha, char c);
char topoPilha(Pilha *pilha);
void desempilha(Pilha *pilha);
void destroiPilha(Pilha *pilha);

// Automato

bool automato(char *string)


#endif //COMPILADORES_ANALISADORLEXICO_H
