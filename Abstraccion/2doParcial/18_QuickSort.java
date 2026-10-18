import java.util.Arrays;

public class QuickSort {
    static class Jugador {
        String nombre;
        int puntaje;

        Jugador(String nombre, int puntaje) {
            this.nombre = nombre;
            this.puntaje = puntaje;
        }
    }

    // Quick sort para enteros
    static void quickSortEnteros(int[] arr, int bajo, int alto) {
        if (bajo < alto) {
            int pos = particionEnteros(arr, bajo, alto);
            quickSortEnteros(arr, bajo, pos - 1);
            quickSortEnteros(arr, pos + 1, alto);
        }
    }

    static int particionEnteros(int[] arr, int bajo, int alto) {
        int pivote = arr[alto];
        int i = bajo - 1;

        for (int j = bajo; j < alto; j++) {
            if (arr[j] <= pivote) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[alto];
        arr[alto] = temp;

        return i + 1;
    }

    // Quick sort para caracteres
    static void quickSortCaracteres(char[] arr, int bajo, int alto) {
        if (bajo < alto) {
            int pos = particionCaracteres(arr, bajo, alto);
            quickSortCaracteres(arr, bajo, pos - 1);
            quickSortCaracteres(arr, pos + 1, alto);
        }
    }

    static int particionCaracteres(char[] arr, int bajo, int alto) {
        char pivote = arr[alto];
        int i = bajo - 1;

        for (int j = bajo; j < alto; j++) {
            if (arr[j] <= pivote) {
                i++;
                char temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        char temp = arr[i + 1];
        arr[i + 1] = arr[alto];
        arr[alto] = temp;

        return i + 1;
    }

    // Quick sort para jugadores (se ordena por puntaje)
    static void quickSortJugadores(Jugador[] arr, int bajo, int alto) {
        if (bajo < alto) {
            int pos = particionJugadores(arr, bajo, alto);
            quickSortJugadores(arr, bajo, pos - 1);
            quickSortJugadores(arr, pos + 1, alto);
        }
    }

    static int particionJugadores(Jugador[] arr, int bajo, int alto) {
        int pivote = arr[alto].puntaje;
        int i = bajo - 1;

        for (int j = bajo; j < alto; j++) {
            if (arr[j].puntaje <= pivote) {
                i++;
                Jugador temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        Jugador temp = arr[i + 1];
        arr[i + 1] = arr[alto];
        arr[alto] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        int[] numeros = {64, 34, 25, 12, 22};
        char[] letras = {'z', 'x', 'a', 'm', 'b'};
        Jugador[] jugadores = {
            new Jugador("David", 999),
            new Jugador("Alan", 890),
            new Jugador("Carlos", 120)
        };

        quickSortEnteros(numeros, 0, numeros.length - 1);
        System.out.println("Enteros ordenados:    " + Arrays.toString(numeros));

        quickSortCaracteres(letras, 0, letras.length - 1);
        System.out.println("Caracteres ordenados: " + Arrays.toString(letras));

        quickSortJugadores(jugadores, 0, jugadores.length - 1);
        System.out.print("Jugadores ordenados:  ");
        for (int i = 0; i < jugadores.length; i++) {
            System.out.print("{" + jugadores[i].nombre + ": " + jugadores[i].puntaje + "} ");
        }
        System.out.println();
    }
}
