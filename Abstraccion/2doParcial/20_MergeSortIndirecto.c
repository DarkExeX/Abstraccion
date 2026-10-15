#include <stdio.h>

// mergesort indirecto (usando punteros)

// Ordenamiento de Enteros
void mezclarEnteros(int *ptrArr[], int l, int m, int r) {
    int n1 = m - l + 1;
    int n2 = r - m;

    // estos son arreglos temporales de punteros
    int *L[n1], *R[n2];
    for (int i = 0; i < n1; i++) L[i] = ptrArr[l + i];
    for (int j = 0; j < n2; j++) R[j] = ptrArr[m + 1 + j];

    int i = 0, j = 0, k = l;
    while (i < n1 && j < n2) {
        // comparamos los valores originales usando el operador '*'
        if (*L[i] <= *R[j]) {
            ptrArr[k] = L[i];
            i++;
        } else {
            ptrArr[k] = R[j];
            j++;
        }
        k++;
    }
    // Copiamos los punteros restantes
    while (i < n1) { ptrArr[k] = L[i]; i++; k++; }
    while (j < n2) { ptrArr[k] = R[j]; j++; k++; }
}

void mergeSortIndirectoEnteros(int *ptrArr[], int l, int r) {
    if (l < r) {
        int m = l + (r - l) / 2;
        mergeSortIndirectoEnteros(ptrArr, l, m);
        mergeSortIndirectoEnteros(ptrArr, m + 1, r);
        mezclarEnteros(ptrArr, l, m, r);
    }
}

// ordenamiento de caracteres
void mezclarCaracteres(char *ptrArr[], int l, int m, int r) {
    int n1 = m - l + 1;
    int n2 = r - m;

    char *L[n1], *R[n2];
    for (int i = 0; i < n1; i++) L[i] = ptrArr[l + i];
    for (int j = 0; j < n2; j++) R[j] = ptrArr[m + 1 + j];

    int i = 0, j = 0, k = l;
    while (i < n1 && j < n2) {
        if (*L[i] <= *R[j]) {
            ptrArr[k] = L[i];
            i++;
        } else {
            ptrArr[k] = R[j];
            j++;
        }
        k++;
    }
    while (i < n1) { ptrArr[k] = L[i]; i++; k++; }
    while (j < n2) { ptrArr[k] = R[j]; j++; k++; }
}

void mergeSortIndirectoCaracteres(char *ptrArr[], int l, int r) {
    if (l < r) {
        int m = l + (r - l) / 2;
        mergeSortIndirectoCaracteres(ptrArr, l, m);
        mergeSortIndirectoCaracteres(ptrArr, m + 1, r);
        mezclarCaracteres(ptrArr, l, m, r);
    }
}

int main() {
    int numeros[] = {38, 27, 43, 3, 9, 82, 10};
    int nNum = sizeof(numeros) / sizeof(numeros[0]);

    char letras[] = {'q', 'w', 'e', 'r', 't', 'y'};
    int nLetras = sizeof(letras) / sizeof(letras[0]);

    // creación de arreglos de punteros
    int *ptrNumeros[nNum];
    for (int i = 0; i < nNum; i++) ptrNumeros[i] = &numeros[i];

    char *ptrLetras[nLetras];
    for (int i = 0; i < nLetras; i++) ptrLetras[i] = &letras[i];

    mergeSortIndirectoEnteros(ptrNumeros, 0, nNum - 1);
    mergeSortIndirectoCaracteres(ptrLetras, 0, nLetras - 1);

    printf("--- ENTEROS ---\nOriginal: ");
    for(int i=0; i<nNum; i++) printf("%d ", numeros[i]);
    printf("\nOrdenado (Indirecto): ");
    for(int i=0; i<nNum; i++) printf("%d ", *ptrNumeros[i]);

    printf("\n\n--- CARACTERES ---\nOriginal: ");
    for(int i=0; i<nLetras; i++) printf("%c ", letras[i]);
    printf("\nOrdenado (Indirecto): ");
    for(int i=0; i<nLetras; i++) printf("%c ", *ptrLetras[i]);
    printf("\n");

    return 0;
}
