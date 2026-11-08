
import java.util.Scanner;

public class CalculadoraHerencia {

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
                System.out.println("No se puede dividir entre 0.");
                return 0;
            }
            return num1 / num2;
        }

        float dividir(float num1, float num2, float num3) {
            if (num2 == 0 || num3 == 0) {
                System.out.println("No se puede dividir entre 0.");
                return 0;
            }
            return num1 / num2 / num3;
        }
    }

    // Clase hija que hereda de Calculadora
    static class CalculadoraNueva extends Calculadora {

    }

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        // Se crea un objeto de la clase hija
        CalculadoraNueva calculadora = new CalculadoraNueva();

        int opcion;
        int cantidad;
        int num1, num2, num3;

        System.out.println("CALCULADORA NUEVA CON HERENCIA");

        System.out.println("1. Suma");
        System.out.println("2. Resta");
        System.out.println("3. Multiplicación");
        System.out.println("4. División");

        System.out.print("Elige una opción: ");
        opcion = entrada.nextInt();

        System.out.println("\n¿Cuántos parámetros quieres usar?");
        System.out.println("1. Cero parámetros");
        System.out.println("2. Dos parámetros");
        System.out.println("3. Tres parámetros");

        System.out.print("Elige una opción: ");
        cantidad = entrada.nextInt();

        if (cantidad == 1) {

            switch (opcion) {
                case 1:
                    System.out.println("Resultado: " + calculadora.sumar());
                    break;
                case 2:
                    System.out.println("Resultado: " + calculadora.restar());
                    break;
                case 3:
                    System.out.println("Resultado: " + calculadora.multiplicar());
                    break;
                case 4:
                    System.out.println("Resultado: " + calculadora.dividir());
                    break;
                default:
                    System.out.println("Operación no válida.");
            }

        } else if (cantidad == 2) {

            System.out.print("Ingresa el primer número: ");
            num1 = entrada.nextInt();

            System.out.print("Ingresa el segundo número: ");
            num2 = entrada.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Resultado: " + calculadora.sumar(num1, num2));
                    break;
                case 2:
                    System.out.println("Resultado: " + calculadora.restar(num1, num2));
                    break;
                case 3:
                    System.out.println("Resultado: " + calculadora.multiplicar(num1, num2));
                    break;
                case 4:
                    System.out.println("Resultado: " + calculadora.dividir(num1, num2));
                    break;
                default:
                    System.out.println("Operación no válida.");
            }

        } else if (cantidad == 3) {

            System.out.print("Ingresa el primer número: ");
            num1 = entrada.nextInt();

            System.out.print("Ingresa el segundo número: ");
            num2 = entrada.nextInt();

            System.out.print("Ingresa el tercer número: ");
            num3 = entrada.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Resultado: " + calculadora.sumar(num1, num2, num3));
                    break;
                case 2:
                    System.out.println("Resultado: " + calculadora.restar(num1, num2, num3));
                    break;
                case 3:
                    System.out.println("Resultado: " + calculadora.multiplicar(num1, num2, num3));
                    break;
                case 4:
                    System.out.println("Resultado: " + calculadora.dividir(num1, num2, num3));
                    break;
                default:
                    System.out.println("Operación no válida.");
            }

        } else {
            System.out.println("Cantidad de parámetros no válida.");
        }

        entrada.close();
    }
}
