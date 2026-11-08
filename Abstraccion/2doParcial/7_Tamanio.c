//Determinar los bits de la estructura
#include <stdio.h>

	struct Auto{
		float precio;
		int anio;
	};

	struct Persona {
		char nombre[30];
		char ap[30];
		char am[30];
		char genero;
		int edad;
	};

	int main(){

		struct Auto auto1;
		struct Persona persona1;

        //Tamaño de la estructura Auto y sus datos
        printf("--- Estructura Auto ---\n");
		printf("Auto: %zu bytes\n", sizeof(struct Auto));
        printf("float precio: %zu bytes\n", sizeof(auto1.precio));
        printf("int anio: %zu bytes\n", sizeof(auto1.anio));
        printf("\n");

        //Tamaño de la estructura persona y sus datos
        printf("--- Estructura Persona ---\n");
        printf("Persona: %zu bytes\n", sizeof(struct Persona));
		printf("nombre: %zu bytes\n", sizeof(persona1.nombre));
		printf("ap: %zu bytes\n", sizeof(persona1.ap));
		printf("am: %zu bytes\n", sizeof(persona1.am));
		printf("genero: %zu bytes\n", sizeof(persona1.genero));
        printf("int: %zu bytes\n", sizeof(persona1.edad));

    	return 0;

	}
