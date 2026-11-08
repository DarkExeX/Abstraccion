import java.util.Scanner;


public class Ej06PilaDinamica {
    private static class Nodo {
        int dato;
        Nodo sig;
        Nodo(int dato) { this.dato = dato; }
    }

    private Nodo tope;

    public boolean vacia() { return tope == null; }

    public void push(int v) {
        Nodo nuevo = new Nodo(v);
        nuevo.sig = tope;
        tope = nuevo;
    }

    public Integer pop() {
        if (vacia()) return null;
        int v = tope.dato;
        tope = tope.sig;
        return v;
    }

    public Integer peek() { return vacia() ? null : tope.dato; }

    public void mostrar() {
        if (vacia()) { System.out.println("Pila vacia"); return; }
        for (Nodo p = tope; p != null; p = p.sig) System.out.println("| " + p.dato + " |");
        System.out.println("-----");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Ej06PilaDinamica p = new Ej06PilaDinamica();
        int op;
        do {
            System.out.print("\n--- PILA DINAMICA ---\n1.Push  2.Pop  3.Tope  4.Mostrar  0.Salir\nOpcion: ");
            op = sc.nextInt();
            switch (op) {
                case 1 -> { System.out.print("Valor: "); p.push(sc.nextInt()); }
                case 2 -> { Integer v = p.pop(); System.out.println(v != null ? "Sacado: " + v : "Pila vacia"); }
                case 3 -> { Integer v = p.peek(); System.out.println(v != null ? "Tope: " + v : "Pila vacia"); }
                case 4 -> p.mostrar();
            }
        } while (op != 0);
    }
}
