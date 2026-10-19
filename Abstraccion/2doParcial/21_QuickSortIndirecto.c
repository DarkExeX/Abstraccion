#include <stdio.h>

typedef struct {
    char nombre[50];
    int puntaje;
} Jugador;


int particionEnteros(int datos[], int pos[], int bajo, int alto) {
    // el pivote es el dato que esta en la ultima posicion
    int pivote = datos[pos[alto]];
    int i = bajo - 1;

    for (int j = bajo; j < alto; j++) {
        // se comparan los datos, pero se cambian las posiciones
        if (datos[pos[j]] <= pivote) {
            i++;
            int temp = pos[i];
            pos[i] = pos[j];
            pos[j] = temp;
        }
    }

    int temp = pos[i + 1];
    pos[i + 1] = pos[alto];
    pos[alto] = temp;

    return i + 1;
}

void ordenarEnteros(int datos[], int pos[], int bajo, int alto) {
    if (bajo < alto) {
        int p = particionEnteros(datos, pos, bajo, alto);
        ordenarEnteros(datos, pos, bajo, p - 1);
        ordenarEnteros(datos, pos, p + 1, alto);
    }
}

// quick sort indirecto para enteros
// No mueve los numeros, solo ordena el arreglo de posiciones
// En C no se puede devolver un arreglo, asi que "pos" se recibe como parametro
void quickSortEnteros(int datos[], int pos[], int n) {
    // pos = [0, 1, 2, 3, ...]
    for (int i = 0; i < n; i++) {
        pos[i] = i;
    }

    ordenarEnteros(datos, pos, 0, n - 1);
}

int particionCaracteres(char datos[], int pos[], int bajo, int alto) {
    char pivote = datos[pos[alto]];
    int i = bajo - 1;

    for (int j = bajo; j < alto; j++) {
        if (datos[pos[j]] <= pivote) {
            i++;
            int temp = pos[i];
            pos[i] = pos[j];
            pos[j] = temp;
        }
    }

    int temp = pos[i + 1];
    pos[i + 1] = pos[alto];
    pos[alto] = temp;

    return i + 1;
}

void ordenarCaracteres(char datos[], int pos[], int bajo, int alto) {
    if (bajo < alto) {
        int p = particionCaracteres(datos, pos, bajo, alto);
        ordenarCaracteres(datos, pos, bajo, p - 1);
        ordenarCaracteres(datos, pos, p + 1, alto);
    }
}

void quickSortCaracteres(char datos[], int pos[], int n) {
    for (int i = 0; i < n; i++) {
        pos[i] = i;
    }

    ordenarCaracteres(datos, pos, 0, n - 1);
}

int particionJugadores(Jugador datos[], int pos[], int bajo, int alto) {
    // el pivote es el puntaje del jugador que esta en la ultima posicion
    int pivote = datos[pos[alto]].puntaje;
    int i = bajo - 1;

    for (int j = bajo; j < alto; j++) {
        // se comparan los puntajes, pero se cambian las posiciones
        if (datos[pos[j]].puntaje <= pivote) {
            i++;
            int temp = pos[i];
            pos[i] = pos[j];
            pos[j] = temp;
        }
    }

    int temp = pos[i + 1];
    pos[i + 1] = pos[alto];
    pos[alto] = temp;

    return i + 1;
}

void ordenarJugadores(Jugador datos[], int pos[], int bajo, int alto) {
    if (bajo < alto) {
        int p = particionJugadores(datos, pos, bajo, alto);
        ordenarJugadores(datos, pos, bajo, p - 1);
        ordenarJugadores(datos, pos, p + 1, alto);
    }
}

void quickSortJugadores(Jugador datos[], int pos[], int n) {
    for (int i = 0; i < n; i++) {
        pos[i] = i;
    }

    ordenarJugadores(datos, pos, 0, n - 1);
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

    // Arreglos donde se guardan las posiciones ordenadas
    int ordenNumeros[5];
    int ordenLetras[5];
    int ordenJugadores[3];

    quickSortEnteros(numeros, ordenNumeros, nNum);
    quickSortCaracteres(letras, ordenLetras, nLetras);
    quickSortJugadores(jugadores, ordenJugadores, nJugadores);

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
