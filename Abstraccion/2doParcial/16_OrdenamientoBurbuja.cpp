#include <stdio.h>
#include <string.h>

struct Jugador{
    char nombre[50];
    int puntaje;
};

void ordenarEnteros(int arr[], int n) {
    for (int i = 0; i < n - 1; i++) {
        for (int j = 0; j < n - i - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
    }
}

void ordenarCaracteres(char arr[], int n) {
    for (int i = 0; i < n - 1; i++) {
        for (int j = 0; j < n - i - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                char temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
    }
}

void ordenarJugadores(Jugador arr[], int n) {
    for (int i = 0; i < n - 1; i++) {
        for (int j = 0; j < n - i - 1; j++) {
            // ordena a los jugadores basandose en el puntaje
            if (arr[j].puntaje > arr[j + 1].puntaje) {
                Jugador temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
    }
}

int main() {
    // Ordenar Enteros
    int numeros[] = {64, 34, 25, 12, 22};
    int nNum = sizeof(numeros) / sizeof(numeros[0]);
    ordenarEnteros(numeros, nNum);

    printf("Enteros ordenados: ");
    for(int i=0; i<nNum; i++) printf("%d ", numeros[i]);
    printf("\n");

    // Ordenar Caracteres
    char letras[] = {'z', 'x', 'a', 'm', 'b'};
    int nLetras = sizeof(letras) / sizeof(letras[0]);
    ordenarCaracteres(letras, nLetras);

    printf("Caracteres ordenados: ");
    for(int i=0; i<nLetras; i++) printf("%c ", letras[i]);
    printf("\n");

    // Ordenar Nuevo Tipo de Dato (Jugador)
    Jugador jugadores[] = {
        {"David", 999}, {"Alan", 890}, {"Carlos", 120}
    };
    int nJugadores = sizeof(jugadores) / sizeof(jugadores[0]);
    ordenarJugadores(jugadores, nJugadores);

    printf("Jugadores ordenados: ");
    for(int i=0; i<nJugadores; i++) printf("{%s: %d} ", jugadores[i].nombre, jugadores[i].puntaje);
    printf("\n");

    return 0;
}
