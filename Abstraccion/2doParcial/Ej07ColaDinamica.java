import java.util.Scanner;

/** Ejercicio 7: COLA dinamica (nodos con referencia al mismo tipo) */
public class Ej07ColaDinamica {
    private static class Nodo {
        int dato;
        Nodo sig;
        Nodo(int dato) { this.dato = dato; }
    }

    private Nodo frente, fin;

    public boolean vacia() { return frente == null; }

    public void encolar(int v) {
        Nodo nuevo = new Nodo(v);
        if (fin != null) fin.sig = nuevo; else frente = nuevo;
        fin = nuevo;
    }

    public Integer desencolar() {
        if (vacia()) return null;
        int v = frente.dato;
        frente = frente.sig;
        if (frente == null) fin = null;
        return v;
    }

    public Integer frente() { return vacia() ? null : frente.dato; }

    public void mostrar() {
        if (vacia()) { System.out.println("Cola vacia"); return; }
        StringBuilder sb = new StringBuilder("Frente -> ");
        for (Nodo p = frente; p != null; p = p.sig) sb.append("[").append(p.dato).append("] ");
        System.out.println(sb.append("<- Fin"));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Ej07ColaDinamica c = new Ej07ColaDinamica();
        int op;
        do {
            System.out.print("\n--- COLA DINAMICA ---\n1.Encolar  2.Desencolar  3.Frente  4.Mostrar  0.Salir\nOpcion: ");
            op = sc.nextInt();
            switch (op) {
                case 1 -> { System.out.print("Valor: "); c.encolar(sc.nextInt()); }
                case 2 -> { Integer v = c.desencolar(); System.out.println(v != null ? "Atendido: " + v : "Cola vacia"); }
                case 3 -> { Integer v = c.frente(); System.out.println(v != null ? "Frente: " + v : "Cola vacia"); }
                case 4 -> c.mostrar();
            }
        } while (op != 0);
    }
}
