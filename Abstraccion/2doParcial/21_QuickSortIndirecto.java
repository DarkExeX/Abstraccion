public class QuickSortIndirecto {

    static class Jugador {
        String nombre;
        int puntaje;

        Jugador(String nombre, int puntaje) {
            this.nombre = nombre;
            this.puntaje = puntaje;
        }
    }

    // Quick sort indirecto para enteros
    // No mueve los numeros, solo ordena el arreglo de posiciones
    static int[] quickSortEnteros(int[] datos) {
        int[] pos = new int[datos.length];

        // pos = [0, 1, 2, 3, ...]
        for (int i = 0; i < pos.length; i++) {
            pos[i] = i;
        }

        ordenarEnteros(datos, pos, 0, pos.length - 1);
        return pos;
    }

    static void ordenarEnteros(int[] datos, int[] pos, int bajo, int alto) {
        if (bajo < alto) {
            int p = particionEnteros(datos, pos, bajo, alto);
            ordenarEnteros(datos, pos, bajo, p - 1);
            ordenarEnteros(datos, pos, p + 1, alto);
        }
    }

    static int particionEnteros(int[] datos, int[] pos, int bajo, int alto) {
        // el pivote es el dato que esta en la ultima posicion
        int pivote = datos[pos[alto]];
        int i = bajo - 1;

        for (int j = bajo; j < alto; j++) {
            // se comparan los datos, pero se cambian las posiciones
            if (datos[pos[j]] <= pivote) {
                i++;
                int temp = pos[i];
                pos[i] = pos[j];
                pos[j] = temp;
            }
        }

        int temp = pos[i + 1];
        pos[i + 1] = pos[alto];
        pos[alto] = temp;

        return i + 1;
    }

    // Quick sort indirecto para caracteres
    static int[] quickSortCaracteres(char[] datos) {
        int[] pos = new int[datos.length];

        for (int i = 0; i < pos.length; i++) {
            pos[i] = i;
        }

        ordenarCaracteres(datos, pos, 0, pos.length - 1);
        return pos;
    }

    static void ordenarCaracteres(char[] datos, int[] pos, int bajo, int alto) {
        if (bajo < alto) {
            int p = particionCaracteres(datos, pos, bajo, alto);
            ordenarCaracteres(datos, pos, bajo, p - 1);
            ordenarCaracteres(datos, pos, p + 1, alto);
        }
    }

    static int particionCaracteres(char[] datos, int[] pos, int bajo, int alto) {
        char pivote = datos[pos[alto]];
        int i = bajo - 1;

        for (int j = bajo; j < alto; j++) {
            if (datos[pos[j]] <= pivote) {
                i++;
                int temp = pos[i];
                pos[i] = pos[j];
                pos[j] = temp;
            }
        }

        int temp = pos[i + 1];
        pos[i + 1] = pos[alto];
        pos[alto] = temp;

        return i + 1;
    }


    // Quick sort indirecto para jugadores (se compara por puntaje)
    static int[] quickSortJugadores(Jugador[] datos) {
        int[] pos = new int[datos.length];

        for (int i = 0; i < pos.length; i++) {
            pos[i] = i;
        }

        ordenarJugadores(datos, pos, 0, pos.length - 1);
        return pos;
    }

    static void ordenarJugadores(Jugador[] datos, int[] pos, int bajo, int alto) {
        if (bajo < alto) {
            int p = particionJugadores(datos, pos, bajo, alto);
            ordenarJugadores(datos, pos, bajo, p - 1);
            ordenarJugadores(datos, pos, p + 1, alto);
        }
    }

    static int particionJugadores(Jugador[] datos, int[] pos, int bajo, int alto) {
        // el pivote es el puntaje del jugador que esta en la ultima posicion
        int pivote = datos[pos[alto]].puntaje;
        int i = bajo - 1;

        for (int j = bajo; j < alto; j++) {
            // se comparan los puntajes, pero se cambian las posiciones
            if (datos[pos[j]].puntaje <= pivote) {
                i++;
                int temp = pos[i];
                pos[i] = pos[j];
                pos[j] = temp;
            }
        }

        int temp = pos[i + 1];
        pos[i + 1] = pos[alto];
        pos[alto] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        int[] numeros = {88, 14, 55, 32, 10};
        char[] letras = {'z', 'a', 'x', 'b', 'm'};
        Jugador[] jugadores = {
            new Jugador("David", 999),
            new Jugador("Alan", 890),
            new Jugador("Carlos", 120)
        };

        int[] ordenNumeros = quickSortEnteros(numeros);
        int[] ordenLetras = quickSortCaracteres(letras);
        int[] ordenJugadores = quickSortJugadores(jugadores);

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

        System.out.println("\n\n--- JUGADORES ---");
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