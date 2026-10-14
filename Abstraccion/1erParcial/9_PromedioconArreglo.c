//programa con arreglo
#include <stdio.h>
int main(){
    int cal[5];
    int suma = 0;
    int maximo;
    int minimo;
    float promedio;

    printf("Ingresa tus 5 calificaciones: ");
    for(int i = 0; i < 5; i++) {
        scanf("%d", &cal[i]);
    }

    maximo = cal[0];
    minimo = cal[0];

    for(int i = 0; i < 5; i++){
        suma = suma + cal[i];

        if(cal[i] > maximo) {
            maximo = cal[i];
        }

        if(cal[i] < minimo) {
            minimo = cal[i];
        }

        promedio = suma / 5.0;
    }

    printf("El promedio es: %.2f\n", promedio);
    printf("La media es: %.2f\n", promedio);
    printf("La suma es: %d\n", suma);
    printf("El maximo es: %d\n", maximo);
    printf("El minimo es: %d\n", minimo);
}
