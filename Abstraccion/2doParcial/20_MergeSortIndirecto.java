public class MergeSortIndirecto {

    // Clase Jugador (dentro de esta clase para no chocar con otros archivos)
    static class Jugador {
        String nombre;
        int puntaje;

        Jugador(String nombre, int puntaje) {
            this.nombre = nombre;
            this.puntaje = puntaje;
        }
    }

    // Merge sort indirecto para enteros
    // no muere los numeros, solo ordena el arreglo de posiciones
    static int[] mergeSortEnteros(int[] datos) {
        int[] pos = new int[datos.length];

        for (int i = 0; i < pos.length; i++) {
            pos[i] = i;
        }

        dividirEnteros(datos, pos, 0, pos.length - 1);
        return pos;
    }

    static void dividirEnteros(int[] datos, int[] pos, int izq, int der) {
        if (izq < der) {
            int medio = (izq + der) / 2;
            dividirEnteros(datos, pos, izq, medio);
            dividirEnteros(datos, pos, medio + 1, der);
            mezclarEnteros(datos, pos, izq, medio, der);
        }
    }

    static void mezclarEnteros(int[] datos, int[] pos, int izq, int medio, int der) {
        int[] temporal = new int[der - izq + 1];
        int i = izq;       // recorre la mitad izquierda
        int j = medio + 1; // recorre la mitad derecha
        int k = 0;         // recorre el arreglo temporal

        while (i <= medio && j <= der) {
            // se comparan los datos, pero se guardan las posiciones
            if (datos[pos[i]] <= datos[pos[j]]) {
                temporal[k] = pos[i];
                i++;
            } else {
                temporal[k] = pos[j];
                j++;
            }
            k++;
        }

        // lo que sobre de la izquierda
        while (i <= medio) {
            temporal[k] = pos[i];
            i++;
            k++;
        }

        // lo que sobre de la derecha
        while (j <= der) {
            temporal[k] = pos[j];
            j++;
            k++;
        }

        // se copia el temporal de vuelta a pos
        for (int x = 0; x < temporal.length; x++) {
            pos[izq + x] = temporal[x];
        }
    }

    // Merge sort indirecto para caracteres
    static int[] mergeSortCaracteres(char[] datos) {
        int[] pos = new int[datos.length];

        for (int i = 0; i < pos.length; i++) {
            pos[i] = i;
        }

        dividirCaracteres(datos, pos, 0, pos.length - 1);
        return pos;
    }

    static void dividirCaracteres(char[] datos, int[] pos, int izq, int der) {
        if (izq < der) {
            int medio = (izq + der) / 2;
            dividirCaracteres(datos, pos, izq, medio);
            dividirCaracteres(datos, pos, medio + 1, der);
            mezclarCaracteres(datos, pos, izq, medio, der);
        }
    }

    static void mezclarCaracteres(char[] datos, int[] pos, int izq, int medio, int der) {
        int[] temporal = new int[der - izq + 1];
        int i = izq;
        int j = medio + 1;
        int k = 0;

        while (i <= medio && j <= der) {
            if (datos[pos[i]] <= datos[pos[j]]) {
                temporal[k] = pos[i];
                i++;
            } else {
                temporal[k] = pos[j];
                j++;
            }
            k++;
        }

        while (i <= medio) {
            temporal[k] = pos[i];
            i++;
            k++;
        }

        while (j <= der) {
            temporal[k] = pos[j];
            j++;
            k++;
        }

        for (int x = 0; x < temporal.length; x++) {
            pos[izq + x] = temporal[x];
        }
    }


    // Merge sort indirecto para jugadores se compara por puntaje
    static int[] mergeSortJugadores(Jugador[] datos) {
        int[] pos = new int[datos.length];

        for (int i = 0; i < pos.length; i++) {
            pos[i] = i;
        }

        dividirJugadores(datos, pos, 0, pos.length - 1);
        return pos;
    }

    static void dividirJugadores(Jugador[] datos, int[] pos, int izq, int der) {
        if (izq < der) {
            int medio = (izq + der) / 2;
            dividirJugadores(datos, pos, izq, medio);
            dividirJugadores(datos, pos, medio + 1, der);
            mezclarJugadores(datos, pos, izq, medio, der);
        }
    }

    static void mezclarJugadores(Jugador[] datos, int[] pos, int izq, int medio, int der) {
        int[] temporal = new int[der - izq + 1];
        int i = izq;
        int j = medio + 1;
        int k = 0;

        while (i <= medio && j <= der) {
            // se comparan los puntajes, pero se guardan las posiciones
            if (datos[pos[i]].puntaje <= datos[pos[j]].puntaje) {
                temporal[k] = pos[i];
                i++;
            } else {
                temporal[k] = pos[j];
                j++;
            }
            k++;
        }

        while (i <= medio) {
            temporal[k] = pos[i];
            i++;
            k++;
        }

        while (j <= der) {
            temporal[k] = pos[j];
            j++;
            k++;
        }

        for (int x = 0; x < temporal.length; x++) {
            pos[izq + x] = temporal[x];
        }
    }

    public static void main(String[] args) {
        int[] numeros = {88, 14, 55, 32, 10};
        char[] letras = {'z', 'a', 'x', 'b', 'm'};
        Jugador[] jugadores = {
            new Jugador("David", 999),
            new Jugador("Alan", 890),
            new Jugador("Carlos", 120)
        };

        int[] ordenNumeros = mergeSortEnteros(numeros);
        int[] ordenLetras = mergeSortCaracteres(letras);
        int[] ordenJugadores = mergeSortJugadores(jugadores);

        System.out.println("Enteros");
        System.out.print("Original: ");
        for (int n : numeros) {
            System.out.print(n + " ");
        }
        System.out.print("\nOrdenado: ");
        for (int p : ordenNumeros) {
            System.out.print(numeros[p] + " ");
        }

        System.out.println("\n\nCaracteres");
        System.out.print("Original: ");
        for (char c : letras) {
            System.out.print(c + " ");
        }
        System.out.print("\nOrdenado: ");
        for (int p : ordenLetras) {
            System.out.print(letras[p] + " ");
        }

        System.out.println("\n\nJugadores");
        System.out.print("Original: ");
        for (Jugador j : jugadores) {
            System.out.print("{" + j.nombre + ": " + j.puntaje + "} ");
        }
        System.out.print("\nOrdenado: ");
        for (int p : ordenJugadores) {
            System.out.print("{" + jugadores[p].nombre + ": " + jugadores[p].puntaje + "} ");
        }
        System.out.println();
    }
}
