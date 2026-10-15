#include <stdio.h>

// metodo burbuja indirecta (usando punteros)

void burbujaIndirectaEnteros(int *ptrArr[], int n) {
    for (int i = 0; i < n - 1; i++) {
        for (int j = 0; j < n - i - 1; j++) {
            // Compramos los valores a los que apuntan (*ptrArr)
            if (*ptrArr[j] > *ptrArr[j + 1]) {
                // Intercambiamos las direcciones (los punteros), no los datos originales
                int *temp = ptrArr[j];
                ptrArr[j] = ptrArr[j + 1];
                ptrArr[j + 1] = temp;
            }
        }
    }
}

void burbujaIndirectaCaracteres(char *ptrArr[], int n) {
    for (int i = 0; i < n - 1; i++) {
        for (int j = 0; j < n - i - 1; j++) {
            if (*ptrArr[j] > *ptrArr[j + 1]) {
                char *temp = ptrArr[j];
                ptrArr[j] = ptrArr[j + 1];
                ptrArr[j + 1] = temp;
            }
        }
    }
}

int main() {
    // datos Originales (NUNCA cambiarán de posición)
    int numeros[] = {88, 14, 55, 32, 10};
    int nNum = sizeof(numeros) / sizeof(numeros[0]);

    char letras[] = {'z', 'a', 'x', 'b', 'm'};
    int nLetras = sizeof(letras) / sizeof(letras[0]);

    // 2. Creación e inicialización de arreglos de Punteros
    int *ptrNumeros[nNum];
    for (int i = 0; i < nNum; i++) ptrNumeros[i] = &numeros[i];

    char *ptrLetras[nLetras];
    for (int i = 0; i < nLetras; i++) ptrLetras[i] = &letras[i];

    burbujaIndirectaEnteros(ptrNumeros, nNum);
    burbujaIndirectaCaracteres(ptrLetras, nLetras);

    printf("Enteros\n");
    printf("Arreglo original intacto: ");
    for(int i = 0; i < nNum; i++) printf("%d ", numeros[i]); // Leyendo normal

    printf("\nArreglo ordenado (indirecto): ");
    for(int i = 0; i < nNum; i++) printf("%d ", *ptrNumeros[i]); // Leyendo a través del puntero

    printf("\n\n--- CARACTERES ---\n");
    printf("Arreglo original intacto: ");
    for(int i = 0; i < nLetras; i++) printf("%c ", letras[i]);

    printf("\nArreglo ordenado (indirecto): ");
    for(int i = 0; i < nLetras; i++) printf("%c ", *ptrLetras[i]);
    printf("\n");

    return 0;
}
