#include <stdio.h>

typedef struct {
    char nombre[50];
    int puntaje;
} Jugador;


// mezcla dos mitades ya ordenadas (solo de posiciones)
void mezclarEnteros(int datos[], int pos[], int izq, int medio, int der) {
    int temporal[der - izq + 1];
    int i = izq;       // recorre la mitad izquierda
    int j = medio + 1; // recorre la mitad derecha
    int k = 0;         // recorre el arreglo temporal

    while (i <= medio && j <= der) {
        // se comparan los datos, pero se guardan las posiciones
        if (datos[pos[i]] <= datos[pos[j]]) {
            temporal[k] = pos[i];
            i++;
        } else {
            temporal[k] = pos[j];
            j++;
        }
        k++;
    }

    // lo que sobre de la izquierda
    while (i <= medio) {
        temporal[k] = pos[i];
        i++;
        k++;
    }

    // lo que sobre de la derecha
    while (j <= der) {
        temporal[k] = pos[j];
        j++;
        k++;
    }

    // se copia el temporal de vuelta a pos
    for (int x = 0; x < k; x++) {
        pos[izq + x] = temporal[x];
    }
}

void dividirEnteros(int datos[], int pos[], int izq, int der) {
    if (izq < der) {
        int medio = (izq + der) / 2;
        dividirEnteros(datos, pos, izq, medio);
        dividirEnteros(datos, pos, medio + 1, der);
        mezclarEnteros(datos, pos, izq, medio, der);
    }
}

// Merge sort indirecto para enteros
// No mueve los numeros, solo ordena el arreglo de posiciones
// En C no se puede devolver un arreglo, asi que "pos" se recibe como parametro
void mergeSortEnteros(int datos[], int pos[], int n) {
    // pos = [0, 1, 2, 3, ...]
    for (int i = 0; i < n; i++) {
        pos[i] = i;
    }

    dividirEnteros(datos, pos, 0, n - 1);
}

void mezclarCaracteres(char datos[], int pos[], int izq, int medio, int der) {
    int temporal[der - izq + 1];
    int i = izq;
    int j = medio + 1;
    int k = 0;

    while (i <= medio && j <= der) {
        if (datos[pos[i]] <= datos[pos[j]]) {
            temporal[k] = pos[i];
            i++;
        } else {
            temporal[k] = pos[j];
            j++;
        }
        k++;
    }

    while (i <= medio) {
        temporal[k] = pos[i];
        i++;
        k++;
    }

    while (j <= der) {
        temporal[k] = pos[j];
        j++;
        k++;
    }

    for (int x = 0; x < k; x++) {
        pos[izq + x] = temporal[x];
    }
}

void dividirCaracteres(char datos[], int pos[], int izq, int der) {
    if (izq < der) {
        int medio = (izq + der) / 2;
        dividirCaracteres(datos, pos, izq, medio);
        dividirCaracteres(datos, pos, medio + 1, der);
        mezclarCaracteres(datos, pos, izq, medio, der);
    }
}

// Merge sort indirecto para caracteres
void mergeSortCaracteres(char datos[], int pos[], int n) {
    for (int i = 0; i < n; i++) {
        pos[i] = i;
    }

    dividirCaracteres(datos, pos, 0, n - 1);
}

void mezclarJugadores(Jugador datos[], int pos[], int izq, int medio, int der) {
    int temporal[der - izq + 1];
    int i = izq;
    int j = medio + 1;
    int k = 0;

    while (i <= medio && j <= der) {
        // se comparan los puntajes, pero se guardan las posiciones
        if (datos[pos[i]].puntaje <= datos[pos[j]].puntaje) {
            temporal[k] = pos[i];
            i++;
        } else {
            temporal[k] = pos[j];
            j++;
        }
        k++;
    }

    while (i <= medio) {
        temporal[k] = pos[i];
        i++;
        k++;
    }

    while (j <= der) {
        temporal[k] = pos[j];
        j++;
        k++;
    }

    for (int x = 0; x < k; x++) {
        pos[izq + x] = temporal[x];
    }
}

void dividirJugadores(Jugador datos[], int pos[], int izq, int der) {
    if (izq < der) {
        int medio = (izq + der) / 2;
        dividirJugadores(datos, pos, izq, medio);
        dividirJugadores(datos, pos, medio + 1, der);
        mezclarJugadores(datos, pos, izq, medio, der);
    }
}

// Merge sort indirecto para jugadores (se compara por puntaje)
void mergeSortJugadores(Jugador datos[], int pos[], int n) {
    for (int i = 0; i < n; i++) {
        pos[i] = i;
    }

    dividirJugadores(datos, pos, 0, n - 1);
}

int main() {
    int numeros[] = {88, 14, 55, 32, 10};
    int nNum = sizeof(numeros) / sizeof(numeros[0]);

    char letras[] = {'z', 'a', 'x', 'b', 'm'};
    int nLetras = sizeof(letras) / sizeof(letras[0]);

    Jugador jugadores[] = {
        {"David", 999}, {"Alan", 890}, {"Carlos", 120}
    };
    int nJugadores = sizeof(jugadores) / sizeof(jugadores[0]);

    // arreglos donde se guardan las posiciones ordenadas
    int ordenNumeros[5];
    int ordenLetras[5];
    int ordenJugadores[3];

    mergeSortEnteros(numeros, ordenNumeros, nNum);
    mergeSortCaracteres(letras, ordenLetras, nLetras);
    mergeSortJugadores(jugadores, ordenJugadores, nJugadores);

    printf("Enteros\n");
    printf("Original: ");
    for (int i = 0; i < nNum; i++) {
        printf("%d ", numeros[i]);
    }
    printf("\nOrdenado: ");
    for (int i = 0; i < nNum; i++) {
        printf("%d ", numeros[ordenNumeros[i]]);
    }

    printf("\n\nCaracteres\n");
    printf("Original: ");
    for (int i = 0; i < nLetras; i++) {
        printf("%c ", letras[i]);
    }
    printf("\nOrdenado: ");
    for (int i = 0; i < nLetras; i++) {
        printf("%c ", letras[ordenLetras[i]]);
    }

    printf("\n\nJugadores\n");
    printf("Original: ");
    for (int i = 0; i < nJugadores; i++) {
        printf("{%s: %d} ", jugadores[i].nombre, jugadores[i].puntaje);
    }
    printf("\nOrdenado: ");
    for (int i = 0; i < nJugadores; i++) {
        int p = ordenJugadores[i];
        printf("{%s: %d} ", jugadores[p].nombre, jugadores[p].puntaje);
    }
    printf("\n");

    return 0;
}
