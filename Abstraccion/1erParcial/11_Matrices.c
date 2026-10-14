#include <stdio.h>

int main() {
    int A[2][2] = {{1, 5},
                   {7, 9}};
    int B[2][2] = {{2, 4},
                   {6, 8}};
    int C[2][2];
    int D[2][2];
    int constante = 2;
    int i, j, k;

    // A por  constante
    printf("Matriz A por una constante:\n");

    for (i = 0; i < 2; i++) {
        for (j = 0; j < 2; j++) {
            C[i][j] = A[i][j] * constante;
            printf("%d ", C[i][j]);
        }
        printf("\n");
    }

    //multiplicacion de A por B
    printf("\nMatriz A por matriz B:\n");

    for (i = 0; i < 2; i++) {
        for (j = 0; j < 2; j++) {
            D[i][j] = 0;

            for (k = 0; k < 2; k++) {
                D[i][j] = D[i][j] + A[i][k] * B[k][j];
            }

            printf("%d ", D[i][j]);
        }
        printf("\n");
    }

    return 0;
}
