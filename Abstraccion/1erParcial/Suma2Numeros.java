import java.util.Scanner;

public class Suma2Numeros {

    public static int suma(int num1, int num2) {
        return num1 + num2;
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Ingresa el primer numero:");
        int num1 = entrada.nextInt();

        System.out.println("Ingresa el segundo numero:");
        int num2 = entrada.nextInt();

        int resultado = suma(num1, num2);

        System.out.println("El resultado de la suma es: " + resultado);
    }
}