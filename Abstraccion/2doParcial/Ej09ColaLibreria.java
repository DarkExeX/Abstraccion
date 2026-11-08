import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/** Ejercicio 9: COLA con clases del IDE (java.util.Queue / LinkedList) */
public class Ej09ColaLibreria {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> cola = new LinkedList<>();
        int op;
        do {
            System.out.print("\n--- COLA (java.util.Queue) ---\n1.Encolar  2.Desencolar  3.Frente  4.Mostrar  0.Salir\nOpcion: ");
            op = sc.nextInt();
            switch (op) {
                case 1 -> { System.out.print("Valor: "); cola.offer(sc.nextInt()); }
                case 2 -> System.out.println(cola.isEmpty() ? "Cola vacia" : "Atendido: " + cola.poll());
                case 3 -> System.out.println(cola.isEmpty() ? "Cola vacia" : "Frente: " + cola.peek());
                case 4 -> System.out.println(cola.isEmpty() ? "Cola vacia" : "Frente -> " + cola + " <- Fin");
            }
        } while (op != 0);
    }
}
