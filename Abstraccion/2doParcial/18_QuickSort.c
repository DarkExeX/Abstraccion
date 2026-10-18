#include <stdio.h>

// typedef permite usar "Jugador" sin escribir "struct" cada vez
typedef struct {
    char nombre[50];
    int puntaje;
} Jugador;

// Quick sort para enteros
int particionEnteros(int arr[], int bajo, int alto) {
    int pivote = arr[alto];
    int i = bajo - 1;

    for (int j = bajo; j < alto; j++) {
        if (arr[j] <= pivote) {
            i++;
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    int temp = arr[i + 1];
    arr[i + 1] = arr[alto];
    arr[alto] = temp;

    return i + 1;
}

void quickSortEnteros(int arr[], int bajo, int alto) {
    if (bajo < alto) {
        int pos = particionEnteros(arr, bajo, alto);
        quickSortEnteros(arr, bajo, pos - 1);
        quickSortEnteros(arr, pos + 1, alto);
    }
}

// Quick sort para caracteres
int particionCaracteres(char arr[], int bajo, int alto) {
    char pivote = arr[alto];
    int i = bajo - 1;

    for (int j = bajo; j < alto; j++) {
        if (arr[j] <= pivote) {
            i++;
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    char temp = arr[i + 1];
    arr[i + 1] = arr[alto];
    arr[alto] = temp;

    return i + 1;
}

void quickSortCaracteres(char arr[], int bajo, int alto) {
    if (bajo < alto) {
        int pos = particionCaracteres(arr, bajo, alto);
        quickSortCaracteres(arr, bajo, pos - 1);
        quickSortCaracteres(arr, pos + 1, alto);
    }
}

// Quick sort para jugadores (se ordena por puntaje)
int particionJugadores(Jugador arr[], int bajo, int alto) {
    int pivote = arr[alto].puntaje;
    int i = bajo - 1;

    for (int j = bajo; j < alto; j++) {
        if (arr[j].puntaje <= pivote) {
            i++;
            Jugador temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    Jugador temp = arr[i + 1];
    arr[i + 1] = arr[alto];
    arr[alto] = temp;

    return i + 1;
}

void quickSortJugadores(Jugador arr[], int bajo, int alto) {
    if (bajo < alto) {
        int pos = particionJugadores(arr, bajo, alto);
        quickSortJugadores(arr, bajo, pos - 1);
        quickSortJugadores(arr, pos + 1, alto);
    }
}

int main() {
    int numeros[] = {64, 34, 25, 12, 22};
    int nNum = sizeof(numeros) / sizeof(numeros[0]);

    char letras[] = {'z', 'x', 'a', 'm', 'b'};
    int nLetras = sizeof(letras) / sizeof(letras[0]);

    Jugador jugadores[] = {
        {"David", 999}, {"Alan", 890}, {"Carlos", 120}
    };
    int nJugadores = sizeof(jugadores) / sizeof(jugadores[0]);

    // Enteros
    quickSortEnteros(numeros, 0, nNum - 1);
    printf("Enteros ordenados:    [");
    for (int i = 0; i < nNum; i++) {
        printf("%d", numeros[i]);
        if (i < nNum - 1) printf(", ");
    }
    printf("]\n");

    // Caracteres
    quickSortCaracteres(letras, 0, nLetras - 1);
    printf("Caracteres ordenados: [");
    for (int i = 0; i < nLetras; i++) {
        printf("%c", letras[i]);
        if (i < nLetras - 1) printf(", ");
    }
    printf("]\n");

    // Jugadores
    quickSortJugadores(jugadores, 0, nJugadores - 1);
    printf("Jugadores ordenados:  ");
    for (int i = 0; i < nJugadores; i++) {
        printf("{%s: %d} ", jugadores[i].nombre, jugadores[i].puntaje);
    }
    printf("\n");

    return 0;
}
