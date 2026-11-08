#include <stdio.h>
#define MAX 5

typedef struct {
    int datos[MAX];
    int tope;
} Pila;

void iniciar(Pila *p) { p->tope = -1; }
int vacia(Pila *p) { return p->tope == -1; }
int llena(Pila *p) { return p->tope == MAX - 1; }

void push(Pila *p, int v) {
    if (llena(p)) { printf("Pila llena (desbordamiento)\n"); return; }
    p->datos[++p->tope] = v;
}

int pop(Pila *p, int *v) {
    if (vacia(p)) return 0;
    *v = p->datos[p->tope--];
    return 1;
}

void mostrar(Pila *p) {
    if (vacia(p)) { printf("Pila vacia\n"); return; }
    for (int i = p->tope; i >= 0; i--) printf("| %d |\n", p->datos[i]);
    printf("-----\n");
}

int main() {
    Pila p; int op, v;
    iniciar(&p);
    do {
        printf("\n--- PILA ESTATICA ---\n1.Push  2.Pop  3.Tope  4.Mostrar  0.Salir\nOpcion: ");
        scanf("%d", &op);
        switch (op) {
            case 1: printf("Valor: "); scanf("%d", &v); push(&p, v); break;
            case 2: if (pop(&p, &v)) printf("Sacado: %d\n", v); else printf("Pila vacia\n"); break;
            case 3: if (vacia(&p)) printf("Pila vacia\n"); else printf("Tope: %d\n", p.datos[p.tope]); break;
            case 4: mostrar(&p); break;
        }
    } while (op != 0);
    return 0;
}