#include <iostream>
#include <vector>

using namespace std;

// funcion recursiva paraborrar el tercio central
void hacerCantor(vector<char>& linea, int inicio, int longitud) {
    if (longitud < 1) return; // Caso base

    int tercio = longitud / 3;

    // borra la parte del medico remplazandola con espacios
    for (int i = inicio + tercio; i < inicio + 2 * tercio; i++) {
        linea[i] = ' ';
    }

    // Si el tercio es mayor a 0, aplicamos la recursividad a los lados restantes
    if (tercio >= 1) {
        hacerCantor(linea, inicio, tercio);                 // lado izquierdo
        hacerCantor(linea, inicio + 2 * tercio, tercio);    // lado derecho
    }
}

int main() {
    int niveles = 4;
    int longitud = 81; // 3 elevado a la potencia de 4

    //empezamos con una línea sólida de '#'
    vector<char> linea(longitud, '#');

    //muestra la línea inicial
    for (char c : linea) cout << c;
    cout << endl;

    //vamos aplicando el algoritmo nivel por nivel para ver la evolucion
    int tamanoActual = longitud;
    for (int i = 0; i < niveles; i++) {
        // ejecutar un nivel de profundidad
        for(int j = 0; j < longitud; j += tamanoActual) {
             hacerCantor(linea, j, tamanoActual);
        }
        tamanoActual /= 3;

        //imprime el resultado de este nivel
        for (char c : linea) cout << c;
        cout << endl;
    }

    return 0;
}
