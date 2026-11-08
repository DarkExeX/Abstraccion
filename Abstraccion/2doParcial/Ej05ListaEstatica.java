import java.util.Scanner;

/** Ejercicio 5: LISTA estatica (arreglo) - posiciones base 1 */
public class Ej05ListaEstatica {
    private final int[] datos;
    private int n = 0;

    public Ej05ListaEstatica(int capacidad) { datos = new int[capacidad]; }

    public void insertar(int pos, int v) {
        if (n == datos.length) { System.out.println("Lista llena"); return; }
        if (pos < 1 || pos > n + 1) { System.out.println("Posicion invalida"); return; }
        for (int i = n; i >= pos; i--) datos[i] = datos[i - 1];
        datos[pos - 1] = v;
        n++;
    }

    public Integer eliminar(int pos) {
        if (pos < 1 || pos > n) return null;
        int v = datos[pos - 1];
        for (int i = pos - 1; i < n - 1; i++) datos[i] = datos[i + 1];
        n--;
        return v;
    }

    public int buscar(int v) {
        for (int i = 0; i < n; i++) if (datos[i] == v) return i + 1;
        return 0;
    }

    public void mostrar() {
        if (n == 0) { System.out.println("Lista vacia"); return; }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) sb.append("[").append(datos[i]).append("] ");
        System.out.println(sb);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Ej05ListaEstatica l = new Ej05ListaEstatica(10);
        int op;
        do {
            System.out.print("\n--- LISTA ESTATICA ---\n1.Insertar  2.Eliminar  3.Buscar  4.Mostrar  0.Salir\nOpcion: ");
            op = sc.nextInt();
            switch (op) {
                case 1 -> { System.out.print("Posicion: "); int pos = sc.nextInt(); System.out.print("Valor: "); l.insertar(pos, sc.nextInt()); }
                case 2 -> { System.out.print("Posicion: "); Integer v = l.eliminar(sc.nextInt()); System.out.println(v != null ? "Eliminado: " + v : "Posicion invalida"); }
                case 3 -> { System.out.print("Valor: "); int pos = l.buscar(sc.nextInt()); System.out.println(pos > 0 ? "Encontrado en posicion " + pos : "No encontrado"); }
                case 4 -> l.mostrar();
            }
        } while (op != 0);
    }
}
