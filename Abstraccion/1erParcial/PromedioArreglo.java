import java.util.Scanner;

public class PromedioArreglo {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        int[] calificaciones = new int[5];
        int suma = 0;
        int maximo, minimo;
        float promedio;

        // Ingresar las cinco calificaciones
        System.out.println("Ingresa cinco calificaciones:");

        for (int i = 0; i < 5; i++) {
            System.out.print("Calificacion " + (i + 1) + ": ");
            calificaciones[i] = entrada.nextInt();
        }

        // Inicializar maximo y minimo
        maximo = calificaciones[0];
        minimo = calificaciones[0];

        // Realizar las operaciones
        for (int i = 0; i < 5; i++) {
            suma = suma + calificaciones[i];

            if (calificaciones[i] > maximo) {
                maximo = calificaciones[i];
            }

            if (calificaciones[i] < minimo) {
                minimo = calificaciones[i];
            }
        }

        // Calcular promedio y media
        promedio = suma / 5.0f;

        // Mostrar resultados
        System.out.println("\nResultados:");
        System.out.println("La suma es: " + suma);
        System.out.println("El promedio es: " + promedio);
        System.out.println("La media es: " + promedio);
        System.out.println("El maximo es: " + maximo);
        System.out.println("El minimo es: " + minimo);

        entrada.close();
    }
}