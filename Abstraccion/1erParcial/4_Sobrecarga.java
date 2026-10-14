// Calculadora con parametros: 0, 2 y 3
public class Main {

    static class Calculadora {

        // Suma de numeros
        int sumar() {
            return 0;
        }

        int sumar(int num1, int num2) {
            return num1 + num2;
        }

        int sumar(int num1, int num2, int num3) {
            return num1 + num2 + num3;
        }

        // Resta de numeros
        int restar() {
            return 0;
        }

        int restar(int num1, int num2) {
            return num1 - num2;
        }

        int restar(int num1, int num2, int num3) {
            return num1 - num2 - num3;
        }

        // Multiplicacion de numeros
        int multiplicar() {
            return 0;
        }

        int multiplicar(int num1, int num2) {
            return num1 * num2;
        }

        int multiplicar(int num1, int num2, int num3) {
            return num1 * num2 * num3;
        }

        // Division de numeros
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

    public static void main(String[] args) {

        Calculadora calculadora = new Calculadora();

        // Suma
        System.out.println("SUMA");
        System.out.println("Sin parametros: " + calculadora.sumar());
        System.out.println("Con 2 parametros: " + calculadora.sumar(5, 3));
        System.out.println("Con 3 parametros: " + calculadora.sumar(5, 3, 2));
        System.out.println();

        // Resta
        System.out.println("RESTA");
        System.out.println("Sin parametros: " + calculadora.restar());
        System.out.println("Con 2 parametros: " + calculadora.restar(5, 3));
        System.out.println("Con 3 parametros: " + calculadora.restar(10, 3, 2));
        System.out.println();

        // Multiplicacion
        System.out.println("MULTIPLICACION");
        System.out.println("Sin parametros: " + calculadora.multiplicar());
        System.out.println("Con 2 parametros: " + calculadora.multiplicar(5, 3));
        System.out.println("Con 3 parametros: " + calculadora.multiplicar(5, 3, 2));
        System.out.println();

        // Division
        System.out.println("DIVISION");
        System.out.println("Sin parametros: " + calculadora.dividir());
        System.out.println("Con 2 parametros: " + calculadora.dividir(10, 2));
        System.out.println("Con 3 parametros: " + calculadora.dividir(24, 2, 3));
        System.out.println();
    }
}
