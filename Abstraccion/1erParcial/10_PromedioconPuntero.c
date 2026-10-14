//promedio con puntero al arreglo
#include <stdio.h>
int main(){
    int cal[5];
    int *p;
    int suma = 0;
    int maximo;
    int minimo;
    float promedio;

    printf("Ingresa tus 5 calificaciones: ");
    for(int i = 0; i < 5; i++) {
        scanf("%d", &cal[i]);
    }

    p = cal;

    maximo = *(p + 0);
    minimo = *(p + 0);

    for(int i = 0; i < 5; i++){
        suma = suma + *(p + i);

        if(*(p + i) > maximo) {
            maximo = *(p + i);
        }

        if(cal[i] < minimo) {
            minimo = *(p + i);
        }

        promedio = suma / 5.0;
    }

    printf("El promedio es: %.2f\n", promedio);
    printf("La media es: %.2f\n", promedio);
    printf("La suma es: %d\n", suma);
    printf("El maximo es: %d\n", maximo);
    printf("El minimo es: %d\n", minimo);
}
