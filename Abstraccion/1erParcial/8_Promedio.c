//Promedio
#include <stdio.h>
int main(){
	int cal1, cal2, cal3, cal4, cal5;
	int suma, max, min;
	float promedio;

	printf("Ingresa tus calificaciones: ");
	scanf("%d", &cal1);
	scanf("%d", &cal2);
	scanf("%d", &cal3);
	scanf("%d", &cal4);
	scanf("%d", &cal5);

	//operaciones
	promedio = (cal1+cal2+cal3+cal4+cal5)/5.0;
	suma = cal1+ cal2 + cal3 + cal4 + cal5;

	maximo = cal1;
    minimo = cal1;

    if(cal2 > maximo){
        maximo = cal2;
    }

    if(cal3 > maximo){
        maximo = cal3;
    }

    if(cal4 > maximo){
        maximo = cal4;
    }

    if(cal5 > maximo){
        maximo = cal5;
    }

    if(cal2 < minimo){
        minimo = cal2;
    }

    if(cal3 < minimo){
        minimo = cal3;
    }

    if(cal4 < minimo){
        minimo = cal4;
    }

    if(cal5 < minimo){
        minimo = cal5;
    }

        printf ("El promedio es: %.2f\n", promedio);
        printf("La media es: %.2f\n", promedio);
        printf("La suma es: %d\n", suma);
        printf ("El maximo es: %d\n", max);
        printf ("El minimo es: %d\n", min);

}
