import java.util.Scanner;


public class Ej04ColaEstatica {
    private final int[] datos;
    private int frente = 0, fin = -1, cont = 0;

    public Ej04ColaEstatica(int capacidad) { datos = new int[capacidad]; }

    public boolean vacia() { return cont == 0; }
    public boolean llena() { return cont == datos.length; }

    public void encolar(int v) {
        if (llena()) { System.out.println("Cola llena"); return; }
        fin = (fin + 1) % datos.length;
        datos[fin] = v;
        cont++;
    }

    public Integer desencolar() {
        if (vacia()) return null;
        int v = datos[frente];
        frente = (frente + 1) % datos.length;
        cont--;
        return v;
    }

    public Integer frente() { return vacia() ? null : datos[frente]; }

    public void mostrar() {
        if (vacia()) { System.out.println("Cola vacia"); return; }
        StringBuilder sb = new StringBuilder("Frente -> ");
        for (int i = 0, j = frente; i < cont; i++, j = (j + 1) % datos.length) sb.append("[").append(datos[j]).append("] ");
        System.out.println(sb.append("<- Fin"));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Ej04ColaEstatica c = new Ej04ColaEstatica(5);
        int op;
        do {
            System.out.print("\n--- COLA ESTATICA ---\n1.Encolar  2.Desencolar  3.Frente  4.Mostrar  0.Salir\nOpcion: ");
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
