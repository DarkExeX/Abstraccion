#include <iostream>

// Función recursiva para calcular el factorial
unsigned long long factorial(int n) {
    // Caso base: el factorial de 0 y 1 es 1
    if (n <= 1) {
        return 1;
    }
    // momento recursivo: n * factorial de (n-1)
    return n * factorial(n - 1);
}

int main() {
    int numero;
    std::cout << "Ingresa un numero entero positivo: ";
    std::cin >> numero;

    if (numero < 0) {
        std::cout << "El factorial no esta definido para numeros negativos." << std::endl;
    } else {
        std::cout << "El factorial de " << numero << " es " << factorial(numero) << std::endl;
    }

    return 0;
}
