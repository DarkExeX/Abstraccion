public class Main {

    // Burbuja indirecta para enteros
    // No mueve los numeros, solo ordena un arreglo de posiciones
    static int[] burbujaEnteros(int[] datos) {
        int[] pos = new int[datos.length];

        // pos = [0, 1, 2, 3, ...]
        for (int i = 0; i < pos.length; i++) {
            pos[i] = i;
        }

        for (int i = 0; i < pos.length - 1; i++) {
            for (int j = 0; j < pos.length - i - 1; j++) {
                // se comparan los datos, pero se cambian las posiciones
                if (datos[pos[j]] > datos[pos[j + 1]]) {
                    int temp = pos[j];
                    pos[j] = pos[j + 1];
                    pos[j + 1] = temp;
                }
            }
        }
        return pos;
    }

    // Burbuja indirecta para caracteres
    static int[] burbujaCaracteres(char[] datos) {
        int[] pos = new int[datos.length];

        for (int i = 0; i < pos.length; i++) {
            pos[i] = i;
        }

        for (int i = 0; i < pos.length - 1; i++) {
            for (int j = 0; j < pos.length - i - 1; j++) {
                if (datos[pos[j]] > datos[pos[j + 1]]) {
                    int temp = pos[j];
                    pos[j] = pos[j + 1];
                    pos[j + 1] = temp;
                }
            }
        }
        return pos;
    }

    public static void main(String[] args) {
        int[] numeros = {88, 14, 55, 32, 10};
        char[] letras = {'z', 'a', 'x', 'b', 'm'};

        int[] ordenNumeros = burbujaEnteros(numeros);
        int[] ordenLetras = burbujaCaracteres(letras);

        System.out.println("--- ENTEROS ---");
        System.out.print("Original: ");
        for (int n : numeros) {
            System.out.print(n + " ");
        }
        System.out.print("\nOrdenado: ");
        for (int p : ordenNumeros) {
            System.out.print(numeros[p] + " ");
        }

        System.out.println("\n\n--- CARACTERES ---");
        System.out.print("Original: ");
        for (char c : letras) {
            System.out.print(c + " ");
        }
        System.out.print("\nOrdenado: ");
        for (int p : ordenLetras) {
            System.out.print(letras[p] + " ");
        }
        System.out.println();
    }
}