class Jugador {
    String nombre;
    int puntaje;

    // Constructor
    Jugador(String nombre, int puntaje) {
        this.nombre = nombre;
        this.puntaje = puntaje;
    }
}

public class Main {

    // Ordenar enteros con burbuja
    public static void ordenarEnteros(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Ordenar caracteres con burbuja
    public static void ordenarCaracteres(char[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    char temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Ordenar jugadores segun su puntaje
    public static void ordenarJugadores(Jugador[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                // compara los puntajes
                if (arr[j].puntaje > arr[j + 1].puntaje) {
                    Jugador temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        // Ordenar Enteros
        int[] numeros = {64, 34, 25, 12, 22};
        ordenarEnteros(numeros);

        System.out.print("Enteros ordenados: ");
        for (int i = 0; i < numeros.length; i++) {
            System.out.print(numeros[i] + " ");
        }
        System.out.println();

        // Ordenar Caracteres
        char[] letras = {'z', 'x', 'a', 'm', 'b'};
        ordenarCaracteres(letras);

        System.out.print("Caracteres ordenados: ");
        for (int i = 0; i < letras.length; i++) {
            System.out.print(letras[i] + " ");
        }
        System.out.println();

        // Ordenar Jugadores
        Jugador[] jugadores = {
            new Jugador("David", 999),
            new Jugador("Alan", 890),
            new Jugador("Carlos", 120)
        };
        ordenarJugadores(jugadores);

        System.out.print("Jugadores ordenados: ");
        for (int i = 0; i < jugadores.length; i++) {
            System.out.print("{" + jugadores[i].nombre + ": " + jugadores[i].puntaje + "} ");
        }
        System.out.println();
    }
}
