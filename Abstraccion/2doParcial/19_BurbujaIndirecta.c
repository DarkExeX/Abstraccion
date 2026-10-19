#include <stdio.h>

// typedef permite usar "Jugador" sin escribir "struct" cada vez
typedef struct {
    char nombre[50];
    int puntaje;
} Jugador;

// burbuja indirecta para enteros
// no mueve los numeros, solo ordena un arreglo de posiciones
// en C no se puede devolver un arreglo, asi que "pos" se recibe como parametro
void burbujaEnteros(int datos[], int pos[], int n) {
    // pos = [0, 1, 2, 3, ...]
    for (int i = 0; i < n; i++) {
        pos[i] = i;
    }

    for (int i = 0; i < n - 1; i++) {
        for (int j = 0; j < n - i - 1; j++) {
            // se comparan los datos, pero se cambian las posiciones
            if (datos[pos[j]] > datos[pos[j + 1]]) {
                int temp = pos[j];
                pos[j] = pos[j + 1];
                pos[j + 1] = temp;
            }
        }
    }
}

// Burbuja indirecta para caracteres
void burbujaCaracteres(char datos[], int pos[], int n) {
    for (int i = 0; i < n; i++) {
        pos[i] = i;
    }

    for (int i = 0; i < n - 1; i++) {
        for (int j = 0; j < n - i - 1; j++) {
            if (datos[pos[j]] > datos[pos[j + 1]]) {
                int temp = pos[j];
                pos[j] = pos[j + 1];
                pos[j + 1] = temp;
            }
        }
    }
}

// Burbuja indirecta para jugadores (se compara por puntaje)
void burbujaJugadores(Jugador datos[], int pos[], int n) {
    for (int i = 0; i < n; i++) {
        pos[i] = i;
    }

    for (int i = 0; i < n - 1; i++) {
        for (int j = 0; j < n - i - 1; j++) {
            // se comparan los puntajes, pero se cambian las posiciones
            if (datos[pos[j]].puntaje > datos[pos[j + 1]].puntaje) {
                int temp = pos[j];
                pos[j] = pos[j + 1];
                pos[j + 1] = temp;
            }
        }
    }
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

    burbujaEnteros(numeros, ordenNumeros, nNum);
    burbujaCaracteres(letras, ordenLetras, nLetras);
    burbujaJugadores(jugadores, ordenJugadores, nJugadores);

    printf("--- ENTEROS ---\n");
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
