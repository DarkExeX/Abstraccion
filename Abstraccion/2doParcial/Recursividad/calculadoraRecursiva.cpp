#include <iostream>
#include <cmath>

//Calculadora Estándar
class CalculadoraEstandar {
protected:
    int resultado;

public:
    CalculadoraEstandar() { resultado = 0; }

    int getResultado() const { return resultado; }

    //la palabra 'virtual' permite redefinir su comportamiento si una clase hija hereda esta funcion
    virtual void multiplicar(int a, int b) {
        resultado = a * b;
    }
    virtual void dividir(int a, int b) {
        if (b != 0) resultado = a / b;
        else { std::cout << "Error: Division por cero.\n"; resultado = 0; }
    }

    virtual void potencia(int base, int exponente) {
        resultado = std::pow(base, exponente);
    }
};

//derivada: Calculadora Iterativa
class CalculadoraIterativa : public CalculadoraEstandar {
public:
    //multiplicación por sumas sucesivas
    void multiplicar(int a, int b) override {
        resultado = 0;
        int iteraciones = std::abs(b); //convertimos b a valor absoluto para el bucle

        for (int i = 0; i < iteraciones; i++) {
            resultado += std::abs(a);
        }

        // Ajustamos el signo final con lógica básica
        if ((a < 0 && b > 0) || (a > 0 && b < 0)) {
            resultado = -resultado;
        }
    }

    // sivisión por restas sucesivas
    void dividir(int a, int b) override {
        if (b == 0) {
            std::cout << "Error: no sepuede dividir entre cero.\n";
            resultado = 0;
            return;
        }

        int cociente = 0;
        int dividendo = std::abs(a);
        int divisor = std::abs(b);

        // Restamos el divisor del dividendo hasta que ya no quepa
        while (dividendo >= divisor) {
            dividendo -= divisor;
            cociente++;
        }

        resultado = cociente;

        // Ajustamos el signo
        if ((a < 0 && b > 0) || (a > 0 && b < 0)) {
            resultado = -resultado;
        }
    }

    //potencia por multiplicaciones sucesivas
    void potencia(int base, int exponente) override {
        if (exponente < 0) {
            std::cout << "Error: solo exponentes positivos.\n";
            resultado = 0;
            return;
        }

        resultado = 1;
        //multiplicamos la base por sí misma "exponente" cantidad de veces
        for (int i = 0; i < exponente; ++i) {
            resultado = resultado * base;
        }
    }
};

int main() {
    CalculadoraIterativa calcAlgoritmica;

    std::cout << "Calculadora por metodos sucesivos\n\n";

    // prueba multiplicación
    calcAlgoritmica.multiplicar(5, 4);
    std::cout << "Multiplicacion (Sumas sucesivas): 5 * 4 = " << calcAlgoritmica.getResultado() << "\n";

    calcAlgoritmica.multiplicar(-6, 3);
    std::cout << "Multiplicacion c/negativo: -6 * 3 = " << calcAlgoritmica.getResultado() << "\n";

    // prueba división
    calcAlgoritmica.dividir(17, 5); // 17 - 5 = 12 - 5 = 7 - 5 = 2. Caben 3.
    std::cout << "\nDivision (Restas sucesivas): 17 / 5 = " << calcAlgoritmica.getResultado() << " (Cociente entero)\n";

    // prueba potencia
    calcAlgoritmica.potencia(2, 5); // 2 * 2 * 2 * 2 * 2
    std::cout << "\nPotencia (Multiplicaciones sucesivas): 2^5 = " << calcAlgoritmica.getResultado() << "\n";

    return 0;
}
