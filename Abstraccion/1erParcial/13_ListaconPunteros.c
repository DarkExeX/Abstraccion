//acceder a la lista de manera indirecta
#include <stdio.h>
#include <string.h>

struct Persona {
    char nombre[30];
    char ap[30];
    char am[30];
    char genero;
    int edad;
};

int main() {

    struct Persona personas[4];
    struct Persona *p;

    strcpy(personas[0].nombre, "Juan");
    strcpy(personas[0].ap, "Martinez");
    strcpy(personas[0].am, "Ruiz");
    personas[0].genero = 'M';
    personas[0].edad = 25;

    strcpy(personas[1].nombre, "Ana Lucia");
    strcpy(personas[1].ap, "Romero");
    strcpy(personas[1].am, "Hernandez");
    personas[1].genero = 'F';
    personas[1].edad = 30;

    strcpy(personas[2].nombre, "Alfonso");
    strcpy(personas[2].ap, "Herrera");
    strcpy(personas[2].am, "Gonzalez");
    personas[2].genero = 'M';
    personas[2].edad = 14;

    strcpy(personas[3].nombre, "Melisa");
    strcpy(personas[3].ap, "Castaneda");
    strcpy(personas[3].am, "Martinez");
    personas[3].genero = 'F';
    personas[3].edad = 19;

    // Puntero al arreglo
    p = personas;

    // Mostrar a las personas usando el puntero
    for (int i = 0; i < 4; i++) {
        printf("\nPersona %d\n", i + 1);
        printf("Nombre: %s\n", (p + i)->nombre);
        printf("Apellido paterno: %s\n", (p + i)->ap);
        printf("Apellido materno: %s\n", (p + i)->am);
        printf("Genero: %c\n", (p + i)->genero);
        printf("Edad: %d\n", (p + i)->edad);
    }

    return 0;
}
