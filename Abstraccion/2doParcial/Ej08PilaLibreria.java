import java.util.Scanner;
import java.util.Stack;

/** Ejercicio 8: PILA con clases del IDE (java.util.Stack) */
public class Ej08PilaLibreria {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> pila = new Stack<>();
        int op;
        do {
            System.out.print("\n--- PILA (java.util.Stack) ---\n1.Push  2.Pop  3.Tope  4.Mostrar  0.Salir\nOpcion: ");
            op = sc.nextInt();
            switch (op) {
                case 1 -> { System.out.print("Valor: "); pila.push(sc.nextInt()); }
                case 2 -> System.out.println(pila.isEmpty() ? "Pila vacia" : "Sacado: " + pila.pop());
                case 3 -> System.out.println(pila.isEmpty() ? "Pila vacia" : "Tope: " + pila.peek());
                case 4 -> {
                    if (pila.isEmpty()) System.out.println("Pila vacia");
                    else { for (int i = pila.size() - 1; i >= 0; i--) System.out.println("| " + pila.get(i) + " |"); System.out.println("-----"); }
                }
            }
        } while (op != 0);
    }
}
