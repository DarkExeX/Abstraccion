#include <iostream>

// Función recursiva para calcular Fibonacci
unsigned long long fibonacci(int n) {
    // Casos base: si n es 0 devuelve 0, si n es 1 devuelve 1
    if (n <= 1) {
        return n;
    }
    // Paso recursivo: la suma de los dos números anteriores
    return fibonacci(n - 1) + fibonacci(n - 2);
}

int main() {
    int numero;
    std::cout << "Ingresa la posicion en la serie de Fibonacci (entero positivo): ";
    std::cin >> numero;

    if (numero < 0) {
        std::cout << "La posicion no puede ser negativa." << std::endl;
    } else {
        std::cout << "El numero de Fibonacci en la posicion " << numero << " es " << fibonacci(numero) << std::endl;
    }

    return 0;
}
