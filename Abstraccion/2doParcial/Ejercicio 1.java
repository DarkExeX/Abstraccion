class Matriz {
    private int[][] datos;

    public Matriz(int[][] datos) {
        this.datos = datos;
    }

    public Matriz multiplicar(Matriz otra) {
        int r = this.datos.length;
        int c = otra.datos[0].length;
        int m = otra.datos.length;
        int[][] res = new int[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                for (int k = 0; k < m; k++) {
                    res[i][j] += this.datos[i][k] * otra.datos[k][j];
                }
            }
        }
        return new Matriz(res);
    }

    public void mostrar() {
        for (int[] fila : datos) {
            for (int val : fila) System.out.print(val + " ");
            System.out.println();
        }
    }
}

public class Ejercicio1_Deptal2 {
    public static void main(String[] args) {
        Matriz A = new Matriz(new int[][]{{1, 2}, {3, 4}});
        Matriz B = new Matriz(new int[][]{{5, 6}, {7, 8}});
        Matriz C = A.multiplicar(B);
        C.mostrar();
    }
}
