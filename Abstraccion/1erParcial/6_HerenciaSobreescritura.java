//calculadora partiendo de la anterior
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

        //Multiplicacion por sumas sucesivas
        @Override 
        int multiplicar(int num1, int num2){
            int resultado = 0;

                for(int i = 0; i < num2; i++) {
                    resultado = resultado + num1;
                }
                return resultado;
        }

        //Potencia multiplicaciones sucesivas
        int potencia(int base, int exponente) {
            int resultado = 1;

                for(int i = 0; i < exponente; i++) {
                    resultado = resultado * base;
                }
                return resultado;
        }

        //Division por restas sucesivas
        @Override 
        float dividir(float num1, float num2) {
            int cociente = 0;

                if(num2 == 0) {
                    System.out.println("No se puede dividir entre 0");
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

        CalculadoraNueva calculadora = new CalculadoraNueva();

        System.out.println("Multiplicacion por sumas sucesivas");
        System.out.println("8 * 5 = " + calculadora.multiplicar(6,7));

        System.out.println("\nPotencia por multiplicaciones sucesivas");
        System.out.println("4 elevado a 6 = " + calculadora.potencia(4,6));

        System.out.println("\nDivision por restas sucesivas");
        System.out.println("45 / 5 = " + calculadora.dividir(45,5));
        
    }
}
