import java.util.Arrays;

public class Main {

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

    public static void main(String[] args) {
        int[] numeros = {64, 34, 25, 12, 22};
        char[] letras = {'z', 'x', 'a', 'm', 'b'};

        quickSortEnteros(numeros, 0, numeros.length - 1);
        System.out.println("Enteros ordenados:    " + Arrays.toString(numeros));

        quickSortCaracteres(letras, 0, letras.length - 1);
        System.out.println("Caracteres ordenados: " + Arrays.toString(letras));
    }
}