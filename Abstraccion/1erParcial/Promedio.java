
import java.util.Scanner;

public class Promedio {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        int cal1, cal2, cal3, cal4, cal5;
        int suma, maximo, minimo;
        float promedio;

        System.out.println("Ingresa tus cinco calificaciones:");

        cal1 = entrada.nextInt();
        cal2 = entrada.nextInt();
        cal3 = entrada.nextInt();
        cal4 = entrada.nextInt();
        cal5 = entrada.nextInt();

        // Operaciones
        suma = cal1 + cal2 + cal3 + cal4 + cal5;

        promedio = suma / 5.0f;

        // Obtener maximo y minimo
        maximo = cal1;
        minimo = cal1;

        if (cal2 > maximo) {
            maximo = cal2;
        }

        if (cal3 > maximo) {
            maximo = cal3;
        }

        if (cal4 > maximo) {
            maximo = cal4;
        }

        if (cal5 > maximo) {
            maximo = cal5;
        }

        if (cal2 < minimo) {
            minimo = cal2;
        }

        if (cal3 < minimo) {
            minimo = cal3;
        }

        if (cal4 < minimo) {
            minimo = cal4;
        }

        if (cal5 < minimo) {
            minimo = cal5;
        }

        // Mostrar resultados
        System.out.println("El promedio es: " + promedio);
        System.out.println("La media es: " + promedio);
        System.out.println("La suma es: " + suma);
        System.out.println("El maximo es: " + maximo);
        System.out.println("El minimo es: " + minimo);

        entrada.close();
    }
}
