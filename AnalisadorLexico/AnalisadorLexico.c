#include "AnalisadorLexico.h"

void inicializaPilha(Pilha *pilha) {
	pilha->topo = NULL;
	pilha->tamanho = 0;
}

bool estaVazia(Pilha *pilha) {
	return (pilha->tamanho == 0);
}

void empilha(Pilha *pilha, char c) {
	
	PtrNoPilha aux;
	aux = (PtrNoPilha) malloc(sizeof(NoPilha));
	aux->simbolo = c;
	aux->proximo = pilha->topo;
	pilha->topo = aux;
	pilha->tamanho++;
}

char topoPilha(Pilha *pilha) {
	
	if (!estaVazia(pilha)) {
		return pilha->topo->simbolo;
	}
	// se a pilha estiver vazia, retorna hífen
	return '-';
}

void desempilha(Pilha *pilha) {
	
	if (!estaVazia(pilha)) {
		PtrNoPilha aux = pilha->topo;
		pilha->topo = pilha->topo->proximo;
		free(aux);
		pilha->tamanho--;
	}
	
}

void destroiPilha(Pilha *pilha) {
	while (!estaVazia(pilha))
		desempilha(pilha);
}

bool automato(char *palavra) {
	
	int estado1 = 1; // Estado inicial Q1 (ramo superior)
	int estado2 = 1; // Estado inicial Q1 (ramo inferior)
	int j; // Indice que divide os ramos
	
	Pilha automato1;
	Pilha automato2;
	inicializaPilha(&automato1);
	inicializaPilha(&automato2);
	
	char c;
	
	for (int i = 0; i <= strlen(palavra); i++) {
		//percorre os caracteres da palavra
		c = palavra[i];
		
		if (debug)
			printf("\nindice: %i, simbolo: %c , estado: Q%i, pilha: %c\n", i, c, estado1, topoPilha(&automato1));
		
		//verifica se o caractere faz parte do alfabeto
		if (c != 'a' && c != 'b' && c != 'c' && c != '\0') {
			destroiPilha(&automato1);
			destroiPilha(&automato2);
			return false;
		}
		
		
		//realiza as transições de estados
		switch (estado1) {
			case 1:
				// ignora a entrada e a pilha
				// adiciona dummy $ e avança para q2
				if (debug)
					printf("empilha -> $\n");
				empilha(&automato1, '$');
				empilha(&automato2, '$');
				estado1 = 2;
				i--; // Ignora a entrada
				
				break;
			case 2:
				// se ler 'a', empilha
				// se ler outro simbolo divide em q3 e q5
				
				if (c == 'a') {
					if (debug)
						printf("empilha -> %c\n", c);
					empilha(&automato1, c);
					empilha(&automato2, c);
				} else {
					estado1 = 3;
					estado2 = 5;
					j = i; // Salva em qual indice houve a separação dos ramos
					i--;
				}
				
				break;
			case 3:
				// se ler 'b' e o topo for 'a', desempilha
				// se ler outro simbolo, e o topo for '$', desempilha
				
				if (c == 'b') {
					if (automato1.topo->simbolo == 'a') {
						if (debug)
							printf("desempilha -> %c\n", automato1.topo->simbolo);
						desempilha(&automato1);
					} else if (automato1.topo->simbolo == '$') {
						// se ler b e o topo da pilha for '$'
						// numero de b > numero de a, verifica o proximo ramo
						if (debug)
							printf("Verificar ramo inferior\n");
						i = strlen(palavra); //encerra o ramo superior
					}
				} else if (automato1.topo->simbolo == '$') {
					// numero de a == numero de b, pilha vazia
					if (debug)
						printf("desempilha -> %c\n", automato1.topo->simbolo);
					desempilha(&automato1);
					estado1 = 4;
					i--;
				} else
					i = strlen(palavra); //encerra o ramo superior
				
				break;
			case 4:
				// se chegar no estado 4, e a entrada for diferente de 'c' ou vazio
				// a palavra é invalida, retorna falso
				if (c != 'c' && c != '\0') {
					return false;
				}
				break;
		}
	}
	
	// caso tenha a mudança para o ultimo estado, mas o for encerre
	// verifica se o último estado é um estado de aceitação ou se a pilha está vazia
	if (estado1 == 4 || estaVazia(&automato1)) {
		
		destroiPilha(&automato1);
		destroiPilha(&automato2);
		return true;
	}
	
	// verifica se houve a ramificação
	if (estado2 > 1) {
		for (int i = j; i <= strlen(palavra); i++) {
			c = palavra[i];
			
			if (debug)
				printf("\nindice: %i, simbolo: %c , estado: Q%i, pilha: %c\n", i, c, estado2, topoPilha(&automato2));
			
			switch (estado2) {
				case 5:
					// se ler 'b' continua no estado q5 e avança a leitura
					// caso contrário, ignora a entrada e avança para Q6
					
					if (c != 'b') {
						estado2 = 6;
						i--;
					}
					
					break;
				case 6:
					// se ler 'c' e o topo da pilha for 'a', desempilha
					// se ler outro simbolo, e o topo for '$', desempilha e avança para Q7
					
					if (c == 'c') {
						if (automato2.topo->simbolo == 'a') {
							if (debug)
								printf("desempilha -> %c\n", automato2.topo->simbolo);
							desempilha(&automato2);
						} else if (automato2.topo->simbolo == '$') {
							// se ler c e o topo da pilha for '$'
							// numero de c > numero de a, palavra invalida
							destroiPilha(&automato1);
							destroiPilha(&automato2);
							return false;
						}
					} else if (automato2.topo->simbolo == '$') {
						// numero de a == numero de c, pilha vazia
						if (debug)
							printf("desempilha -> %c\n", automato2.topo->simbolo);
						desempilha(&automato2);
						estado2 = 7;
						i--;
					}
					
					break;
				case 7:
					// se chegar no estado 7, e a leitura não for vazio
					// tem outro caracter no final da palavra, palavra invalida
					if (c != '\0') {
						destroiPilha(&automato1);
						destroiPilha(&automato2);
						return false;
					}
					
					destroiPilha(&automato1);
					destroiPilha(&automato2);
					return true;
			}
		}
	}
	
	// caso tenha a mudança para o ultimo estado, mas o for encerre
	// verifica se o último estado é um estado de aceitação ou se a pilha está vazia
	if (estado2 == 7 || estaVazia(&automato2)) {
		destroiPilha(&automato1);
		destroiPilha(&automato2);
		return true;
	}
	
	// nenhuma condição de aceitação foi encontrada, palavra invalida
	destroiPilha(&automato1);
	destroiPilha(&automato2);
	return false;
	
}


int main() {
	
	printf("hello");
	
	return 0;
}
