
import java.util.Scanner;

public class CalculadoraBasica {
    private float num1;
    private float num2;

    public CalculadoraBasica(float num1, float num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public float getNum1() {
        return num1;
    }

    public void setNum1(float num1) {
        this.num1 = num1;
    }

    public float getNum2() {
        return num2;
    }

    public void setNum2(float num2) {
        this.num2 = num2;
    }

    public float sumar() {
        return num1 + num2;
    }

    public float restar() {
        return num1 - num2;
    }

    public float multiplicar() {
        return num1 * num2;
    }

    public void dividir() {
        if (num2 == 0) {
            System.out.println("No se puede dividir entre cero.");
        } else {
            System.out.printf("La división es: %.2f%n", num1 / num2);
        }
    }

    public void operacion(int opcion) {
        switch (opcion) {
            case 1:
                System.out.printf("La suma es: %.2f%n", sumar());
                break;

            case 2:
                System.out.printf("La resta es: %.2f%n", restar());
                break;

            case 3:
                System.out.printf("La multiplicación es: %.2f%n", multiplicar());
                break;

            case 4:
                dividir();
                break;

            default:
                System.out.println("Operación no válida.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Calculadora Básica");

        System.out.print("Ingresa el primer número: ");
        float n1 = sc.nextFloat();

        System.out.print("Ingresa el segundo número: ");
        float n2 = sc.nextFloat();

        CalculadoraBasica calc = new CalculadoraBasica(n1, n2);

        System.out.println("\n¿Qué operación desea realizar?");
        System.out.println("1. Suma");
        System.out.println("2. Resta");
        System.out.println("3. Multiplicación");
        System.out.println("4. División");

        System.out.print("Elige una opción: ");
        int opcion = sc.nextInt();

        calc.operacion(opcion);

        sc.close();
    }
}
