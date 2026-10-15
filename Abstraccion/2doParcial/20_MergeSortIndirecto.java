import java.util.Arrays;

public class Main {

    // Merge sort indirecto para enteros
    // No mueve los numeros, solo ordena un arreglo de posiciones
    static int[] mergeSortEnteros(int[] datos) {
        int[] pos = new int[datos.length];

        // pos = [0, 1, 2, 3, ...]
        for (int i = 0; i < pos.length; i++) {
            pos[i] = i;
        }

        dividirEnteros(datos, pos, 0, datos.length - 1);
        return pos;
    }

    static void dividirEnteros(int[] datos, int[] pos, int ini, int fin) {
        if (ini < fin) {
            int med = (ini + fin) / 2;
            dividirEnteros(datos, pos, ini, med);
            dividirEnteros(datos, pos, med + 1, fin);
            mezclarEnteros(datos, pos, ini, med, fin);
        }
    }

    static void mezclarEnteros(int[] datos, int[] pos, int ini, int med, int fin) {
        int[] temp = new int[fin - ini + 1];
        int i = ini;
        int j = med + 1;
        int k = 0;

        // se comparan los datos, pero se guardan las posiciones
        while (i <= med && j <= fin) {
            if (datos[pos[i]] <= datos[pos[j]]) {
                temp[k] = pos[i];
                i++;
            } else {
                temp[k] = pos[j];
                j++;
            }
            k++;
        }
        while (i <= med) {
            temp[k] = pos[i];
            i++;
            k++;
        }
        while (j <= fin) {
            temp[k] = pos[j];
            j++;
            k++;
        }

        // se regresan las posiciones al arreglo pos
        for (k = 0; k < temp.length; k++) {
            pos[ini + k] = temp[k];
        }
    }

    // ---------- Merge sort indirecto para caracteres ----------
    static int[] mergeSortCaracteres(char[] datos) {
        int[] pos = new int[datos.length];

        for (int i = 0; i < pos.length; i++) {
            pos[i] = i;
        }

        dividirCaracteres(datos, pos, 0, datos.length - 1);
        return pos;
    }

    static void dividirCaracteres(char[] datos, int[] pos, int ini, int fin) {
        if (ini < fin) {
            int med = (ini + fin) / 2;
            dividirCaracteres(datos, pos, ini, med);
            dividirCaracteres(datos, pos, med + 1, fin);
            mezclarCaracteres(datos, pos, ini, med, fin);
        }
    }

    static void mezclarCaracteres(char[] datos, int[] pos, int ini, int med, int fin) {
        int[] temp = new int[fin - ini + 1];
        int i = ini;
        int j = med + 1;
        int k = 0;

        while (i <= med && j <= fin) {
            if (datos[pos[i]] <= datos[pos[j]]) {
                temp[k] = pos[i];
                i++;
            } else {
                temp[k] = pos[j];
                j++;
            }
            k++;
        }
        while (i <= med) {
            temp[k] = pos[i];
            i++;
            k++;
        }
        while (j <= fin) {
            temp[k] = pos[j];
            j++;
            k++;
        }

        for (k = 0; k < temp.length; k++) {
            pos[ini + k] = temp[k];
        }
    }

    public static void main(String[] args) {
        int[] numeros = {38, 27, 43, 3, 9, 82, 10};
        char[] letras = {'q', 'w', 'e', 'r', 't', 'y'};

        int[] posNumeros = mergeSortEnteros(numeros);
        int[] posLetras = mergeSortCaracteres(letras);

        System.out.println("--- ENTEROS ---");
        System.out.println("Original: " + Arrays.toString(numeros));
        System.out.print("Ordenado: ");
        for (int p : posNumeros) {
            System.out.print(numeros[p] + " ");
        }

        System.out.println("\n\n--- CARACTERES ---");
        System.out.println("Original: " + Arrays.toString(letras));
        System.out.print("Ordenado: ");
        for (int p : posLetras) {
            System.out.print(letras[p] + " ");
        }
        System.out.println();
    }
}