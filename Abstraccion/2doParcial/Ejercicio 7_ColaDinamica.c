#include <stdio.h>
#include <stdlib.h>

typedef struct Nodo {
    int dato;
    struct Nodo *sig;
} Nodo;

typedef struct {
    Nodo *frente, *fin;
} Cola;

void encolar(Cola *c, int v) {
    Nodo *nuevo = (Nodo *)malloc(sizeof(Nodo));
    if (!nuevo) { printf("Sin memoria\n"); return; }
    nuevo->dato = v;
    nuevo->sig = NULL;
    if (c->fin) c->fin->sig = nuevo; else c->frente = nuevo;
    c->fin = nuevo;
}

int desencolar(Cola *c, int *v) {
    if (!c->frente) return 0;
    Nodo *aux = c->frente;
    *v = aux->dato;
    c->frente = aux->sig;
    if (!c->frente) c->fin = NULL;
    free(aux);
    return 1;
}

void mostrar(Cola *c) {
    if (!c->frente) { printf("Cola vacia\n"); return; }
    printf("Frente -> ");
    for (Nodo *p = c->frente; p; p = p->sig) printf("[%d] ", p->dato);
    printf("<- Fin\n");
}

int main() {
    Cola c = {NULL, NULL}; int op, v;
    do {
        printf("\n--- COLA DINAMICA ---\n1.Encolar  2.Desencolar  3.Frente  4.Mostrar  0.Salir\nOpcion: ");
        scanf("%d", &op);
        switch (op) {
            case 1: printf("Valor: "); scanf("%d", &v); encolar(&c, v); break;
            case 2: if (desencolar(&c, &v)) printf("Atendido: %d\n", v); else printf("Cola vacia\n"); break;
            case 3: if (c.frente) printf("Frente: %d\n", c.frente->dato); else printf("Cola vacia\n"); break;
            case 4: mostrar(&c); break;
        }
    } while (op != 0);
    while (desencolar(&c, &v));
    return 0;
}
