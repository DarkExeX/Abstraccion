//calculadora partiendo de la anterior
public class Main {

    //Esta es la clase padre
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

        // Multiplicacion
        int multiplicar() {
            return 0;
        }

        int multiplicar(int num1, int num2) {
            return num1 * num2;
        }

        int multiplicar(int num1, int num2, int num3) {
            return num1 * num2 * num3;
        }

        // Division
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

    //Esta es la clase hija 
    static class CalculadoraNueva extends Calculadora {
    }

    public static void main(String[] args) {

        CalculadoraNueva calculadora = new CalculadoraNueva();

        // Suma
        System.out.println("SUMA");
        System.out.println("Sin parametros: " + calculadora.sumar());
        System.out.println("Con 2 parametros: " + calculadora.sumar(6, 7));
        System.out.println("Con 3 parametros: " + calculadora.sumar(124, 5, 3));

        // Resta
        System.out.println("\nRESTA");
        System.out.println("Sin parametros: " + calculadora.restar());
        System.out.println("Con 2 parametros: " + calculadora.restar(6, 7));
        System.out.println("Con 3 parametros: " + calculadora.restar(124, 5, 3));

        // Multiplicacion
        System.out.println("\nMULTIPLICACION");
        System.out.println("Sin parametros: " + calculadora.multiplicar());
        System.out.println("Con 2 parametros: " + calculadora.multiplicar(6, 7));
        System.out.println("Con 3 parametros: " + calculadora.multiplicar(124, 5, 3));

        // Division
        System.out.println("\nDIVISION");
        System.out.println("Sin parametros: " + calculadora.dividir());
        System.out.println("Con 2 parametros: " + calculadora.dividir(6, 7));
        System.out.println("Con 3 parametros: " + calculadora.dividir(124, 5, 3));
    }
}
