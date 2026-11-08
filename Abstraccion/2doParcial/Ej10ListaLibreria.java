import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/** Ejercicio 10: LISTA con clases del IDE (java.util.List / ArrayList) - posiciones base 1 */
public class Ej10ListaLibreria {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> lista = new ArrayList<>();
        int op;
        do {
            System.out.print("\n--- LISTA (java.util.List) ---\n1.Insertar  2.Eliminar  3.Buscar  4.Mostrar  0.Salir\nOpcion: ");
            op = sc.nextInt();
            switch (op) {
                case 1 -> {
                    System.out.print("Posicion: "); int pos = sc.nextInt();
                    System.out.print("Valor: "); int v = sc.nextInt();
                    if (pos < 1 || pos > lista.size() + 1) System.out.println("Posicion invalida");
                    else lista.add(pos - 1, v);
                }
                case 2 -> {
                    System.out.print("Posicion: "); int pos = sc.nextInt();
                    if (pos < 1 || pos > lista.size()) System.out.println("Posicion invalida");
                    else System.out.println("Eliminado: " + lista.remove(pos - 1));
                }
                case 3 -> {
                    System.out.print("Valor: "); int idx = lista.indexOf(sc.nextInt());
                    System.out.println(idx >= 0 ? "Encontrado en posicion " + (idx + 1) : "No encontrado");
                }
                case 4 -> System.out.println(lista.isEmpty() ? "Lista vacia" : lista.toString());
            }
        } while (op != 0);
    }
}
