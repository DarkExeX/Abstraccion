#include <iostream>
#include <vector>

using namespace std;

// función recursiva que divide el espacio y coloca los asteriscos
void generarSierpinski(vector<vector<char>>& matriz, int x, int y, int tamano) {
    // Caso base: si el tamaño es 1, dibujamos la parte más pequeña del fractal
    if (tamano == 1) {
        matriz[x][y] = '*';
        return;
    }
    int mitad = tamano / 2;

    // Llamadas recursivas para los 3 subtriángulos que forman a un triángulo más grande
    generarSierpinski(matriz, x, y, mitad);                 // Esquina base
    generarSierpinski(matriz, x + mitad, y, mitad);         // Desplazamiento en X
    generarSierpinski(matriz, x, y + mitad, mitad);         // Desplazamiento en Y
}

int main() {
    int tamano = 32;
    //crear una cuadrícula llena de espacios vacíos
    vector<vector<char>> matriz(tamano, vector<char>(tamano, ' '));

    // llamamos a la función recursiva comenzando en la coordenada (0,0)
    generarSierpinski(matriz, 0, 0, tamano);

    // Imprimir el resultado en la consola dándole forma piramidal
    for (int y = tamano - 1; y >= 0; y--) {
        // imprime espacios iniciales para centrar el triángulo
        for (int i = 0; i < y; i++) {
            cout << " ";
        }

        // Recorrer la matriz y mostrar su contenido
        for (int x = 0; x + y < tamano; x++) {
            cout << matriz[x][y] << " ";
        }
        cout << endl;
    }

    return 0;
}
