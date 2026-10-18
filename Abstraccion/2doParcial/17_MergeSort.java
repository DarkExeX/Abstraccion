class Estudiante {
    String nombre;
    double nota;

    // constructor
    Estudiante(String nombre, double nota) {
        this.nombre = nombre;
        this.nota = nota;
    }

    // imprime chido el estudiante
    public String toString() {
        return nombre + " (" + nota + ")";
    }
}

public class MergeSort {

    // enteros
    // divide el arreglo en dos mitades y las ordena
    public static void mergeSort(int[] arreglo) {
        // Si tiene 0 o 1 elementos ya esta ordenado
        if (arreglo.length <= 1) {
            return;
        }

        int mitad = arreglo.length / 2;

        int[] izquierda = new int[mitad];
        int[] derecha = new int[arreglo.length - mitad];

        // copio los datos a cada mitad
        for (int i = 0; i < mitad; i++) {
            izquierda[i] = arreglo[i];
        }
        for (int i = mitad; i < arreglo.length; i++) {
            derecha[i - mitad] = arreglo[i];
        }

        // ordeno cada mitad por recursividad
        mergeSort(izquierda);
        mergeSort(derecha);

        // junto las dos mitades ya ordenadas
        merge(arreglo, izquierda, derecha);
    }

    // junta dos arreglos ordenados en uno solo ordenado
    public static void merge(int[] resultado, int[] izquierda, int[] derecha) {
        int i = 0; // posicion en izquierda
        int j = 0; // posicion en derecha
        int k = 0; // posicion en resultado

        // mientras haya elementos en las dos mitades tomo el menor
        while (i < izquierda.length && j < derecha.length) {
            if (izquierda[i] <= derecha[j]) {
                resultado[k] = izquierda[i];
                i++;
            } else {
                resultado[k] = derecha[j];
                j++;
            }
            k++;
        }

        //si sobraron elementos en izquierda los copio
        while (i < izquierda.length) {
            resultado[k] = izquierda[i];
            i++;
            k++;
        }

        //si sobraron elementos en derecha los copio
        while (j < derecha.length) {
            resultado[k] = derecha[j];
            j++;
            k++;
        }
    }

    // caracteres
    public static void mergeSort(char[] arreglo) {
        if (arreglo.length <= 1) {
            return;
        }

        int mitad = arreglo.length / 2;

        char[] izquierda = new char[mitad];
        char[] derecha = new char[arreglo.length - mitad];

        for (int i = 0; i < mitad; i++) {
            izquierda[i] = arreglo[i];
        }
        for (int i = mitad; i < arreglo.length; i++) {
            derecha[i - mitad] = arreglo[i];
        }

        mergeSort(izquierda);
        mergeSort(derecha);

        merge(arreglo, izquierda, derecha);
    }

    public static void merge(char[] resultado, char[] izquierda, char[] derecha) {
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < izquierda.length && j < derecha.length) {
            if (izquierda[i] <= derecha[j]) {
                resultado[k] = izquierda[i];
                i++;
            } else {
                resultado[k] = derecha[j];
                j++;
            }
            k++;
        }

        while (i < izquierda.length) {
            resultado[k] = izquierda[i];
            i++;
            k++;
        }

        while (j < derecha.length) {
            resultado[k] = derecha[j];
            j++;
            k++;
        }
    }

    // MERGE SORT PARA ESTUDIANTES (nuestro nuevo tipo de dato)
    // aqui comparamos por la nota: de menor a mayor
    public static void mergeSort(Estudiante[] arreglo) {
        if (arreglo.length <= 1) {
            return;
        }

        int mitad = arreglo.length / 2;

        Estudiante[] izquierda = new Estudiante[mitad];
        Estudiante[] derecha = new Estudiante[arreglo.length - mitad];

        for (int i = 0; i < mitad; i++) {
            izquierda[i] = arreglo[i];
        }
        for (int i = mitad; i < arreglo.length; i++) {
            derecha[i - mitad] = arreglo[i];
        }

        mergeSort(izquierda);
        mergeSort(derecha);

        merge(arreglo, izquierda, derecha);
    }

    public static void merge(Estudiante[] resultado, Estudiante[] izquierda, Estudiante[] derecha) {
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < izquierda.length && j < derecha.length) {
            // Aqui la diferencia: comparo las NOTAS, no los objetos completos
            if (izquierda[i].nota <= derecha[j].nota) {
                resultado[k] = izquierda[i];
                i++;
            } else {
                resultado[k] = derecha[j];
                j++;
            }
            k++;
        }

        while (i < izquierda.length) {
            resultado[k] = izquierda[i];
            i++;
            k++;
        }

        while (j < derecha.length) {
            resultado[k] = derecha[j];
            j++;
            k++;
        }
    }

    // metodos para imprimir los arreglos de cada tipo de dato
    public static void imprimir(int[] arreglo) {
        for (int i = 0; i < arreglo.length; i++) {
            System.out.print(arreglo[i] + " ");
        }
        System.out.println();
    }

    public static void imprimir(char[] arreglo) {
        for (int i = 0; i < arreglo.length; i++) {
            System.out.print(arreglo[i] + " ");
        }
        System.out.println();
    }

    public static void imprimir(Estudiante[] arreglo) {
        for (int i = 0; i < arreglo.length; i++) {
            System.out.print(arreglo[i] + "  ");
        }
        System.out.println();
    }

    // aqui probamos todo conndatos ya definidos
    public static void main(String[] args) {

        int[] numeros = {38, 27, 43, 3, 9, 82, 10};
        System.out.println("Enteros");
        System.out.print("Antes:   ");
        imprimir(numeros);
        mergeSort(numeros);
        System.out.print("Despues: ");
        imprimir(numeros);

        char[] letras = {'m', 'e', 'r', 'g', 'e', 's', 'o', 'r', 't'};
        System.out.println("\nCaracteres");
        System.out.print("Antes:   ");
        imprimir(letras);
        mergeSort(letras);
        System.out.print("Despues: ");
        imprimir(letras);

        Estudiante[] estudiantes = {
            new Estudiante("Ana", 8.5),
            new Estudiante("Luis", 6.0),
            new Estudiante("Maria", 9.7),
            new Estudiante("Pedro", 7.2),
            new Estudiante("Sofia", 5.8)
        };
        System.out.println("\nEstudiantes (ordenados por nota)");
        System.out.print("Antes:   ");
        imprimir(estudiantes);
        mergeSort(estudiantes);
        System.out.print("Despues: ");
        imprimir(estudiantes);
    }
}