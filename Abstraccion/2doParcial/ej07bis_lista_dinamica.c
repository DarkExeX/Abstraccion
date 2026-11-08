/* Ejercicio 7 bis: LISTA dinamica (nodos con puntero al mismo tipo) - posiciones base 1 */
#include <stdio.h>
#include <stdlib.h>

typedef struct Nodo {
    int dato;
    struct Nodo *sig;
} Nodo;

void insertar(Nodo **cab, int pos, int v) {
    Nodo *nuevo = (Nodo *)malloc(sizeof(Nodo));
    if (!nuevo) { printf("Sin memoria\n"); return; }
    nuevo->dato = v;
    Nodo **pp = cab;
    int i;
    for (i = 1; i < pos && *pp; i++) pp = &(*pp)->sig;
    if (pos < 1 || i < pos) { printf("Posicion invalida\n"); free(nuevo); return; }
    nuevo->sig = *pp;
    *pp = nuevo;
}

int eliminar(Nodo **cab, int pos, int *v) {
    Nodo **pp = cab;
    int i;
    if (pos < 1) return 0;
    for (i = 1; i < pos && *pp; i++) pp = &(*pp)->sig;
    if (!*pp) return 0;
    Nodo *aux = *pp;
    *v = aux->dato;
    *pp = aux->sig;
    free(aux);
    return 1;
}

int buscar(Nodo *cab, int v) {
    int pos = 1;
    for (Nodo *p = cab; p; p = p->sig, pos++) if (p->dato == v) return pos;
    return 0;
}

void mostrar(Nodo *cab) {
    if (!cab) { printf("Lista vacia\n"); return; }
    for (Nodo *p = cab; p; p = p->sig) printf("[%d] -> ", p->dato);
    printf("NULL\n");
}

int main() {
    Nodo *cab = NULL; int op, v, pos;
    do {
        printf("\n--- LISTA DINAMICA ---\n1.Insertar  2.Eliminar  3.Buscar  4.Mostrar  0.Salir\nOpcion: ");
        scanf("%d", &op);
        switch (op) {
            case 1: printf("Posicion: "); scanf("%d", &pos);
                    printf("Valor: "); scanf("%d", &v); insertar(&cab, pos, v); break;
            case 2: printf("Posicion: "); scanf("%d", &pos);
                    if (eliminar(&cab, pos, &v)) printf("Eliminado: %d\n", v); else printf("Posicion invalida\n"); break;
            case 3: printf("Valor: "); scanf("%d", &v); pos = buscar(cab, v);
                    if (pos) printf("Encontrado en posicion %d\n", pos); else printf("No encontrado\n"); break;
            case 4: mostrar(cab); break;
        }
    } while (op != 0);
    while (eliminar(&cab, 1, &v));
    return 0;
}
