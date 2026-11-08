
#include <stdio.h>
#include <stdlib.h>

typedef struct Nodo {
    int dato;
    struct Nodo *sig;
} Nodo;

void push(Nodo **tope, int v) {
    Nodo *nuevo = (Nodo *)malloc(sizeof(Nodo));
    if (!nuevo) { printf("Sin memoria\n"); return; }
    nuevo->dato = v;
    nuevo->sig = *tope;
    *tope = nuevo;
}

int pop(Nodo **tope, int *v) {
    if (*tope == NULL) return 0;
    Nodo *aux = *tope;
    *v = aux->dato;
    *tope = aux->sig;
    free(aux);
    return 1;
}

void mostrar(Nodo *tope) {
    if (!tope) { printf("Pila vacia\n"); return; }
    for (Nodo *p = tope; p; p = p->sig) printf("| %d |\n", p->dato);
    printf("-----\n");
}

int main() {
    Nodo *tope = NULL; int op, v;
    do {
        printf("\n--- PILA DINAMICA ---\n1.Push  2.Pop  3.Tope  4.Mostrar  0.Salir\nOpcion: ");
        scanf("%d", &op);
        switch (op) {
            case 1: printf("Valor: "); scanf("%d", &v); push(&tope, v); break;
            case 2: if (pop(&tope, &v)) printf("Sacado: %d\n", v); else printf("Pila vacia\n"); break;
            case 3: if (tope) printf("Tope: %d\n", tope->dato); else printf("Pila vacia\n"); break;
            case 4: mostrar(tope); break;
        }
    } while (op != 0);
    while (pop(&tope, &v));
    return 0;
}
