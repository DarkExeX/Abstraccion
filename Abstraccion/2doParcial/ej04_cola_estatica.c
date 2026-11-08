/* Ejercicio 4: COLA estatica (arreglo circular) */
#include <stdio.h>
#define MAX 5

typedef struct {
    int datos[MAX];
    int frente, fin, cont;
} Cola;

void iniciar(Cola *c) { c->frente = 0; c->fin = -1; c->cont = 0; }
int vacia(Cola *c) { return c->cont == 0; }
int llena(Cola *c) { return c->cont == MAX; }

void encolar(Cola *c, int v) {
    if (llena(c)) { printf("Cola llena\n"); return; }
    c->fin = (c->fin + 1) % MAX;
    c->datos[c->fin] = v;
    c->cont++;
}

int desencolar(Cola *c, int *v) {
    if (vacia(c)) return 0;
    *v = c->datos[c->frente];
    c->frente = (c->frente + 1) % MAX;
    c->cont--;
    return 1;
}

void mostrar(Cola *c) {
    if (vacia(c)) { printf("Cola vacia\n"); return; }
    printf("Frente -> ");
    for (int i = 0, j = c->frente; i < c->cont; i++, j = (j + 1) % MAX)
        printf("[%d] ", c->datos[j]);
    printf("<- Fin\n");
}

int main() {
    Cola c; int op, v;
    iniciar(&c);
    do {
        printf("\n--- COLA ESTATICA ---\n1.Encolar  2.Desencolar  3.Frente  4.Mostrar  0.Salir\nOpcion: ");
        scanf("%d", &op);
        switch (op) {
            case 1: printf("Valor: "); scanf("%d", &v); encolar(&c, v); break;
            case 2: if (desencolar(&c, &v)) printf("Atendido: %d\n", v); else printf("Cola vacia\n"); break;
            case 3: if (vacia(&c)) printf("Cola vacia\n"); else printf("Frente: %d\n", c.datos[c.frente]); break;
            case 4: mostrar(&c); break;
        }
    } while (op != 0);
    return 0;
}
