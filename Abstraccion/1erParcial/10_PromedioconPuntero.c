// Promedio con puntero al arreglo
#include <stdio.h>

int main() {
    int cal[5];
    int *p;
    int suma = 0;
    int maximo;
    int minimo;
    float promedio;

    printf("Ingresa tus 5 calificaciones:\n");

    for(int i = 0; i < 5; i++) {
        scanf("%d", &cal[i]);
    }

    // Apuntar al inicio del arreglo
    p = cal;

    maximo = *(p + 0);
    minimo = *(p + 0);

    // Realizar las operaciones con el puntero
    for(int i = 0; i < 5; i++) {
        suma = suma + *(p + i);

        if(*(p + i) > maximo) {
            maximo = *(p + i);
        }

        if(*(p + i) < minimo) {
            minimo = *(p + i);
        }
    }

    // Calcular promedio
    promedio = suma / 5.0;

    printf("\nEl promedio es: %.2f\n", promedio);
    printf("La media es: %.2f\n", promedio);
    printf("La suma es: %d\n", suma);
    printf("El maximo es: %d\n", maximo);
    printf("El minimo es: %d\n", minimo);

    return 0;
}
