public class Ejercicio20 {
    public static void quickSortIndirecto(Integer[] indices, int[] datos, int bajo, int alto) {
        if (bajo < alto) {
            int pi = particion(indices, datos, bajo, alto);
            quickSortIndirecto(indices, datos, bajo, pi - 1);
            quickSortIndirecto(indices, datos, pi + 1, alto);
        }
    }

    private static int particion(Integer[] indices, int[] datos, int bajo, int alto) {
        int pivote = datos[indices[alto]];
        int i = bajo - 1;

        for (int j = bajo; j < alto; j++) {
            if (datos[indices[j]] < pivote) {
                i++;
                int temp = indices[i];
                indices[i] = indices[j];
                indices[j] = temp;
            }
        }
        int temp = indices[i + 1];
        indices[i + 1] = indices[alto];
        indices[alto] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        int[] datos = {42, 12, 89, 23, 7};
        Integer[] indices = {0, 1, 2, 3, 4};

        quickSortIndirecto(indices, datos, 0, datos.length - 1);

        System.out.print("Ordenamiento indirecto: ");
        for (int idx : indices) System.out.print(datos[idx] + " ");
    }
}
