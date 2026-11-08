import java.util.Scanner;

/** Ejercicio 7 bis: LISTA dinamica (nodos con referencia al mismo tipo) - posiciones base 1 */
public class Ej07bisListaDinamica {
    private static class Nodo {
        int dato;
        Nodo sig;
        Nodo(int dato) { this.dato = dato; }
    }

    private Nodo cabeza;

    public void insertar(int pos, int v) {
        if (pos < 1) { System.out.println("Posicion invalida"); return; }
        Nodo nuevo = new Nodo(v);
        if (pos == 1) { nuevo.sig = cabeza; cabeza = nuevo; return; }
        Nodo ant = cabeza;
        for (int i = 1; i < pos - 1 && ant != null; i++) ant = ant.sig;
        if (ant == null) { System.out.println("Posicion invalida"); return; }
        nuevo.sig = ant.sig;
        ant.sig = nuevo;
    }

    public Integer eliminar(int pos) {
        if (pos < 1 || cabeza == null) return null;
        if (pos == 1) { int v = cabeza.dato; cabeza = cabeza.sig; return v; }
        Nodo ant = cabeza;
        for (int i = 1; i < pos - 1 && ant.sig != null; i++) ant = ant.sig;
        if (ant.sig == null) return null;
        int v = ant.sig.dato;
        ant.sig = ant.sig.sig;
        return v;
    }

    public int buscar(int v) {
        int pos = 1;
        for (Nodo p = cabeza; p != null; p = p.sig, pos++) if (p.dato == v) return pos;
        return 0;
    }

    public void mostrar() {
        if (cabeza == null) { System.out.println("Lista vacia"); return; }
        StringBuilder sb = new StringBuilder();
        for (Nodo p = cabeza; p != null; p = p.sig) sb.append("[").append(p.dato).append("] -> ");
        System.out.println(sb.append("null"));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Ej07bisListaDinamica l = new Ej07bisListaDinamica();
        int op;
        do {
            System.out.print("\n--- LISTA DINAMICA ---\n1.Insertar  2.Eliminar  3.Buscar  4.Mostrar  0.Salir\nOpcion: ");
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
