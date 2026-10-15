import java.util.Arrays;

public class Main {

    // Burbuja para enteros
    static void burbujaEnteros(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Burbuja para caracteres
    static void burbujaCaracteres(char[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    char temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] numeros = {64, 34, 25, 12, 22};
        char[] letras = {'z', 'x', 'a', 'm', 'b'};

        burbujaEnteros(numeros);
        System.out.println("Enteros ordenados:    " + Arrays.toString(numeros));

        burbujaCaracteres(letras);
        System.out.println("Caracteres ordenados: " + Arrays.toString(letras));
    }
}
