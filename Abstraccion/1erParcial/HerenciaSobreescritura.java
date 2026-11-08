
import java.util.Scanner;

public class HerenciaSobreescritura {

    // Clase padre
    static class Calculadora {

        // Suma
        int sumar() {
            return 0;
        }

        int sumar(int num1, int num2) {
            return num1 + num2;
        }

        int sumar(int num1, int num2, int num3) {
            return num1 + num2 + num3;
        }

        // Resta
        int restar() {
            return 0;
        }

        int restar(int num1, int num2) {
            return num1 - num2;
        }

        int restar(int num1, int num2, int num3) {
            return num1 - num2 - num3;
        }

        // Multiplicación
        int multiplicar() {
            return 0;
        }

        int multiplicar(int num1, int num2) {
            return num1 * num2;
        }

        int multiplicar(int num1, int num2, int num3) {
            return num1 * num2 * num3;
        }

        // División
        float dividir() {
            return 0;
        }

        float dividir(float num1, float num2) {
            if (num2 == 0) {
                System.out.println("No se puede dividir entre 0");
                return 0;
            }
            return num1 / num2;
        }

        float dividir(float num1, float num2, float num3) {
            if (num2 == 0 || num3 == 0) {
                System.out.println("No se puede dividir entre 0");
                return 0;
            }
            return num1 / num2 / num3;
        }
    }

    // Clase hija
    static class CalculadoraNueva extends Calculadora {

        // Multiplicación por sumas sucesivas
        @Override
        int multiplicar(int num1, int num2) {
            int resultado = 0;

            for (int i = 0; i < Math.abs(num2); i++) {
                resultado = resultado + num1;
            }

            if (num2 < 0) {
                resultado = -resultado;
            }

            return resultado;
        }

        // Potencia por multiplicaciones sucesivas
        int potencia(int base, int exponente) {
            int resultado = 1;

            for (int i = 0; i < exponente; i++) {
                resultado = resultado * base;
            }

            return resultado;
        }

        // División por restas sucesivas
        @Override
        float dividir(float num1, float num2) {
            int cociente = 0;

            if (num2 == 0) {
                System.out.println("No se puede dividir entre 0");
                return 0;
            }

            if (num1 < 0 || num2 < 0) {
                System.out.println("La division solo se puede realizar con numeros positivos");
                return 0;
            }

            while (num1 >= num2) {
                num1 = num1 - num2;
                cociente++;
            }

            return cociente;
        }
    }

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        CalculadoraNueva calculadora = new CalculadoraNueva();

        int opcion;
        int num1, num2;

        do {
            System.out.println("\nCALCULADORA NUEVA");
            System.out.println("1. Multiplicacion por sumas sucesivas");
            System.out.println("2. Potencia por multiplicaciones sucesivas");
            System.out.println("3. Division por restas sucesivas");
            System.out.println("4. Salir");
            System.out.print("Selecciona una opcion: ");

            opcion = entrada.nextInt();

            switch (opcion) {

                case 1:
                    System.out.print("Ingresa el primer numero: ");
                    num1 = entrada.nextInt();

                    System.out.print("Ingresa el segundo numero: ");
                    num2 = entrada.nextInt();

                    System.out.println("Resultado: " +
                        calculadora.multiplicar(num1, num2));
                    break;

                case 2:
                    System.out.print("Ingresa la base: ");
                    num1 = entrada.nextInt();

                    System.out.print("Ingresa el exponente: ");
                    num2 = entrada.nextInt();

                    if (num2 < 0) {
                        System.out.println("El exponente debe ser positivo o cero");
                    } else {
                        System.out.println("Resultado: " +
                            calculadora.potencia(num1, num2));
                    }
                    break;

                case 3:
                    System.out.print("Ingresa el dividendo: ");
                    num1 = entrada.nextInt();

                    System.out.print("Ingresa el divisor: ");
                    num2 = entrada.nextInt();

                    System.out.println("Resultado: " +
                        calculadora.dividir(num1, num2));
                    break;

                case 4:
                    System.out.println("Fin del programa");
                    break;

                default:
                    System.out.println("Opcion no valida");
            }

        } while (opcion != 4);

        entrada.close();
    }
}
