class Coche {
    String marca;
    Coche siguiente; // Referencia al mismo tipo de dato

    public Coche(String marca) {
        this.marca = marca;
        this.siguiente = null;
    }
}

public class Ejercicio21 {
    public static void main(String[] args) {
        Coche c1 = new Coche("Toyota");
        Coche c2 = new Coche("Honda");
        a1.siguiente = c2;

        Coche actual = c1;
        while (actual != null) {
            System.out.println("Coche: " + actual.marca);
            actual = actual.siguiente;
        }
    }
}
