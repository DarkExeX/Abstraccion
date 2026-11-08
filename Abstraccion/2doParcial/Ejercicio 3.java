import java.util.Scanner;


public class Ej03PilaEstatica {
    private final int[] datos;
    private int tope = -1;

    public Ej03PilaEstatica(int capacidad) { datos = new int[capacidad]; }

    public boolean vacia() { return tope == -1; }
    public boolean llena() { return tope == datos.length - 1; }

    public void push(int v) {
        if (llena()) { System.out.println("Pila llena (desbordamiento)"); return; }
        datos[++tope] = v;
    }

    public Integer pop() { return vacia() ? null : datos[tope--]; }
    public Integer peek() { return vacia() ? null : datos[tope]; }

    public void mostrar() {
        if (vacia()) { System.out.println("Pila vacia"); return; }
        for (int i = tope; i >= 0; i--) System.out.println("| " + datos[i] + " |");
        System.out.println("-----");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Ej03PilaEstatica p = new Ej03PilaEstatica(5);
        int op;
        do {
            System.out.print("\n--- PILA ESTATICA ---\n1.Push  2.Pop  3.Tope  4.Mostrar  0.Salir\nOpcion: ");
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
