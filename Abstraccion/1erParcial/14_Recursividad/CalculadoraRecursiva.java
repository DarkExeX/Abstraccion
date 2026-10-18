//calculadora recursiva partiendo de la anterior
public class Main {

    //Clase padre
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

    //Clase hija
    static class CalculadoraNueva extends Calculadora {

        // multiplicacion recursiva (sumas sucesivas)
        // num1 * num2 = num1 + (num1 * (num2 - 1))
        @Override
        int multiplicar(int num1, int num2) {
            // Caso base
            if (num2 == 0) {
                return 0;
            }
            // Si el multiplicador es negativo, se invierte el signo
            if (num2 < 0) {
                return -multiplicar(num1, -num2);
            }
            // Caso recursivo
            return num1 + multiplicar(num1, num2 - 1);
        }

        // Potencia recursiva (multiplicaciones sucesivas)
        // base^exp = base * base^(exp - 1)
        int potencia(int base, int exponente) {
            // Caso base
            if (exponente == 0) {
                return 1;
            }
            // Caso recursivo
            return base * potencia(base, exponente - 1);
        }

        // Division recursiva (restas sucesivas)
        // num1 / num2 = 1 + ((num1 - num2) / num2)
        @Override
        float dividir(float num1, float num2) {
            if (num2 == 0) {
                System.out.println("No se puede dividir entre 0");
                return 0;
            }
            return dividirRecursivo(num1, num2);
        }

        // Metodo auxiliar para no repetir la validacion de division entre 0
        // en cada llamada recursiva
        private int dividirRecursivo(float dividendo, float divisor) {
            // Caso base
            if (dividendo < divisor) {
                return 0;
            }
            // Caso recursivo
            return 1 + dividirRecursivo(dividendo - divisor, divisor);
        }
    }

    public static void main(String[] args) {

        CalculadoraNueva calculadora = new CalculadoraNueva();

        System.out.println("Multiplicacion recursiva");
        System.out.println("6 * 7 = " + calculadora.multiplicar(6, 7));

        System.out.println("\nPotencia recursiva");
        System.out.println("4 elevado a 6 = " + calculadora.potencia(4, 6));

        System.out.println("\nDivision recursiva");
        System.out.println("45 / 5 = " + calculadora.dividir(45, 5));
    }
}