#include <stdio.h>
#include <string.h>

void intercambiarEnteros(int* a, int* b) {
    int t = *a;
    *a = *b;
    *b = t;
}

int particionEnteros(int arr[], int bajo, int alto) {
    int pivote = arr[alto];
    int i = (bajo - 1);
    for (int j = bajo; j < alto; j++) {
        if (arr[j] <= pivote) {
            i++;
            intercambiarEnteros(&arr[i], &arr[j]);
        }
    }
    intercambiarEnteros(&arr[i + 1], &arr[alto]);
    return (i + 1);
}

void quickSortEnteros(int arr[], int bajo, int alto) {
    if (bajo < alto) {
        int pi = particionEnteros(arr, bajo, alto);
        quickSortEnteros(arr, bajo, pi - 1);
        quickSortEnteros(arr, pi + 1, alto);
    }
}

void intercambiarCaracteres(char* a, char* b) {
    char t = *a;
    *a = *b;
    *b = t;
}

int particionCaracteres(char arr[], int bajo, int alto) {
    char pivote = arr[alto];
    int i = (bajo - 1);
    for (int j = bajo; j < alto; j++) {
        if (arr[j] <= pivote) {
            i++;
            intercambiarCaracteres(&arr[i], &arr[j]);
        }
    }
    intercambiarCaracteres(&arr[i + 1], &arr[alto]);
    return (i + 1);
}

void quickSortCaracteres(char arr[], int bajo, int alto) {
    if (bajo < alto) {
        int pi = particionCaracteres(arr, bajo, alto);
        quickSortCaracteres(arr, bajo, pi - 1);
        quickSortCaracteres(arr, pi + 1, alto);
    }
}


int main() {
    int numeros[] = {64, 34, 25, 12, 22};
    int nNum = sizeof(numeros) / sizeof(numeros[0]);
    quickSortEnteros(numeros, 0, nNum - 1);

    printf("Enteros ordenados: ");
    for(int i = 0; i < nNum; i++) printf("%d ", numeros[i]);
    printf("\n");

    char letras[] = {'z', 'x', 'a', 'm', 'b'};
    int nLetras = sizeof(letras) / sizeof(letras[0]);
    quickSortCaracteres(letras, 0, nLetras - 1);

    printf("Caracteres ordenados: ");
    for(int i = 0; i < nLetras; i++) printf("%c ", letras[i]);
    printf("\n");

    return 0;
}
