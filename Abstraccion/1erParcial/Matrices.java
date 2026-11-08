import java.util.Scanner;

public class Matrices {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        int n;

        System.out.println("Multiplicacion de matrices");
        System.out.print("Ingresa el tamaño de las matrices (minimo 3): ");
        n = entrada.nextInt();

        while (n < 3) {
            System.out.print("Ingresa un tamaño minimo de 3: ");
            n = entrada.nextInt();
        }

        int[][] A = new int[n][n];
        int[][] B = new int[n][n];
        int[][] resultado = new int[n][n];

        int constante;

        //Obtener los datos de matriz A
        System.out.println("\nIngresa los elementos de la matriz A:");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                A[i][j] = entrada.nextInt();
            }
        }

        //Obtener los datos de matriz B
        System.out.println("\nIngresa los elementos de la matriz B:");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                B[i][j] = entrada.nextInt();
            }
        }

        // Multiplicar matriz A por una constante
        System.out.print("\nIngresa la constante: ");
        constante = entrada.nextInt();

        System.out.println("\nMatriz A por la constante:");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print((A[i][j] * constante) + "\t");
            }
            System.out.println();
        }

        // Multiplicar matriz A por la matriz B
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                resultado[i][j] = 0;

                for (int k = 0; k < n; k++) {
                    resultado[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        // Mostrar de A * B
        System.out.println("\nResultado de A * B:");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(resultado[i][j] + "\t");
            }
            System.out.println();
        }

        entrada.close();
    }
}