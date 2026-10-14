//Calculadora básica
#include <stdio.h>
int main(){

	float num1, num2, resultado;
	int operacion;

	printf("Ingresa 2 numeros: \n");
	scanf("%f", &num1);
	scanf("%f", &num2);

	printf("¿Que operacion desea realizar?, considerando: \n 1.Suma\n 2.Resta\n 3.Multiplicacion\n 4.Division\n ");
	scanf("%d", &operacion);

	switch(operacion){
		case 1:
			resultado = num1 + num2;
			printf("La suma es: %.2f\n", resultado);
			break;

		case 2:
			resultado = num1 - num2;
			printf("La resta es: %.2f\n", resultado);
			break;

		case 3:
			resultado = num1 * num2;
			printf("La multiplicacion es: %.2f\n", resultado);
			break;

		case 4:
            if (num2 != 0) {
                resultado = num1 / num2;
                printf("La division es: %.2f\n", resultado);
            } else {
                printf("No se puede dividir entre cero.\n");
            }
            break;

		default:
        printf("Operacion no valida.\n");
        break;
	}
}
