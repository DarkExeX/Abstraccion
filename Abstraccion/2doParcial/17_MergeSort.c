#include <stdio.h>
#include <string.h>

//tipo de dato estudiante se va a ordenar por mota
typedef struct {
    char nombre[30];
    float nota;
} Estudiante;

//enteros
// junta dos arreglos ordenados (izquierda y derecha) en uno solo ordenado
void mergeEnteros(int resultado[], int izquierda[], int tamIzq, int derecha[], int tamDer) {
    int i = 0; /* posicion en izquierda */
    int j = 0; /* posicion en derecha */
    int k = 0; /* posicion en resultado */

    // mientras haya elementos en las dos mitades, tomo el menor
    while (i < tamIzq && j < tamDer) {
        if (izquierda[i] <= derecha[j]) {
            resultado[k] = izquierda[i];
            i++;
        } else {
            resultado[k] = derecha[j];
            j++;
        }
        k++;
    }

    // Si sobraron elementos en izquierda, los copio
    while (i < tamIzq) {
        resultado[k] = izquierda[i];
        i++;
        k++;
    }

    // Si sobraron elementos enn derecha, los copio
    while (j < tamDer) {
        resultado[k] = derecha[j];
        j++;
        k++;
    }
}

// Divide el arreglo en dos mitades, las ordena y las junta
void mergeSortEnteros(int arreglo[], int tamano) {
    int mitad, i;

    // Si tiene 0 o 1 elementos ya esta ordenado
    if (tamano <= 1) {
        return;
    }

    mitad = tamano / 2;

    // creo las dos mitades
    int izquierda[mitad];
    int derecha[tamano - mitad];

    // copio los datos a cada mitad
    for (i = 0; i < mitad; i++) {
        izquierda[i] = arreglo[i];
    }
    for (i = mitad; i < tamano; i++) {
        derecha[i - mitad] = arreglo[i];
    }

    //ordeno cada mitad por recursividad
    mergeSortEnteros(izquierda, mitad);
    mergeSortEnteros(derecha, tamano - mitad);

    // Junto las dos mitades ya ordenadas
    mergeEnteros(arreglo, izquierda, mitad, derecha, tamano - mitad);
}

//caracteres

void mergeCaracteres(char resultado[], char izquierda[], int tamIzq, char derecha[], int tamDer) {
    int i = 0;
    int j = 0;
    int k = 0;

    while (i < tamIzq && j < tamDer) {
        if (izquierda[i] <= derecha[j]) {
            resultado[k] = izquierda[i];
            i++;
        } else {
            resultado[k] = derecha[j];
            j++;
        }
        k++;
    }

    while (i < tamIzq) {
        resultado[k] = izquierda[i];
        i++;
        k++;
    }

    while (j < tamDer) {
        resultado[k] = derecha[j];
        j++;
        k++;
    }
}

void mergeSortCaracteres(char arreglo[], int tamano) {
    int mitad, i;

    if (tamano <= 1) {
        return;
    }

    mitad = tamano / 2;

    char izquierda[mitad];
    char derecha[tamano - mitad];

    for (i = 0; i < mitad; i++) {
        izquierda[i] = arreglo[i];
    }
    for (i = mitad; i < tamano; i++) {
        derecha[i - mitad] = arreglo[i];
    }

    mergeSortCaracteres(izquierda, mitad);
    mergeSortCaracteres(derecha, tamano - mitad);

    mergeCaracteres(arreglo, izquierda, mitad, derecha, tamano - mitad);
}

/* ============================================================
   estudiantes (nuestro nuevo tipo de dato)
   aqui se compara por la nota de menor a mayor*/

void mergeEstudiantes(Estudiante resultado[], Estudiante izquierda[], int tamIzq,
                      Estudiante derecha[], int tamDer) {
    int i = 0;
    int j = 0;
    int k = 0;

    while (i < tamIzq && j < tamDer) {
        /*aqui se comparan las notas, no la estructura completa */
        if (izquierda[i].nota <= derecha[j].nota) {
            resultado[k] = izquierda[i];
            i++;
        } else {
            resultado[k] = derecha[j];
            j++;
        }
        k++;
    }

    while (i < tamIzq) {
        resultado[k] = izquierda[i];
        i++;
        k++;
    }

    while (j < tamDer) {
        resultado[k] = derecha[j];
        j++;
        k++;
    }
}

void mergeSortEstudiantes(Estudiante arreglo[], int tamano) {
    int mitad, i;

    if (tamano <= 1) {
        return;
    }

    mitad = tamano / 2;

    Estudiante izquierda[mitad];
    Estudiante derecha[tamano - mitad];

    for (i = 0; i < mitad; i++) {
        izquierda[i] = arreglo[i];
    }
    for (i = mitad; i < tamano; i++) {
        derecha[i - mitad] = arreglo[i];
    }

    mergeSortEstudiantes(izquierda, mitad);
    mergeSortEstudiantes(derecha, tamano - mitad);

    mergeEstudiantes(arreglo, izquierda, mitad, derecha, tamano - mitad);
}


void imprimirEnteros(int arreglo[], int tamano) {
    int i;
    for (i = 0; i < tamano; i++) {
        printf("%d ", arreglo[i]);
    }
    printf("\n");
}

void imprimirCaracteres(char arreglo[], int tamano) {
    int i;
    for (i = 0; i < tamano; i++) {
        printf("%c ", arreglo[i]);
    }
    printf("\n");
}

void imprimirEstudiantes(Estudiante arreglo[], int tamano) {
    int i;
    for (i = 0; i < tamano; i++) {
        printf("%s (%.1f)  ", arreglo[i].nombre, arreglo[i].nota);
    }
    printf("\n");
}

int main() {
    //Prueba con enteros
    int numeros[] = {38, 27, 43, 3, 9, 82, 10};
    int tamNumeros = 7;

    printf("Enteros\n");
    printf("Antes:   ");
    imprimirEnteros(numeros, tamNumeros);
    mergeSortEnteros(numeros, tamNumeros);
    printf("Despues: ");
    imprimirEnteros(numeros, tamNumeros);

    //Prueba con caracteres
    char letras[] = {'m', 'e', 'r', 'g', 'e', 's', 'o', 'r', 't'};
    int tamLetras = 9;

    printf("\nCaracteres\n");
    printf("Antes:   ");
    imprimirCaracteres(letras, tamLetras);
    mergeSortCaracteres(letras, tamLetras);
    printf("Despues: ");
    imprimirCaracteres(letras, tamLetras);

    //Prueba con Estudiantes
    Estudiante estudiantes[5];
    int tamEstudiantes = 5;

    strcpy(estudiantes[0].nombre, "Ana");   estudiantes[0].nota = 8.5;
    strcpy(estudiantes[1].nombre, "Luis");  estudiantes[1].nota = 6.0;
    strcpy(estudiantes[2].nombre, "Maria"); estudiantes[2].nota = 9.7;
    strcpy(estudiantes[3].nombre, "Pedro"); estudiantes[3].nota = 7.2;
    strcpy(estudiantes[4].nombre, "Sofia"); estudiantes[4].nota = 5.8;

    printf("\nEstudiantes ordenados por nota \n");
    printf("Antes:   ");
    imprimirEstudiantes(estudiantes, tamEstudiantes);
    mergeSortEstudiantes(estudiantes, tamEstudiantes);
    printf("Despues: ");
    imprimirEstudiantes(estudiantes, tamEstudiantes);

    return 0;
}
