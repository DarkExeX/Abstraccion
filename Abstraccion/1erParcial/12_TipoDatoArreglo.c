//Creacion tipo de dato PE
#include <stdio.h>
#include <string.h>
	
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

        //PERSONAS
        struct Persona personas[4];

            strcpy(personas[0].nombre, "Juan");
            strcpy(personas[0].ap, "Matinez");
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
            strcpy(personas[3].ap, "Catañeda");
            strcpy(personas[3].am, "Martinez");
            personas[3].genero = 'F';
            personas[3].edad = 19;

        //AUTOS    
        struct Auto autos[4];

            autos[0].precio = 290000;
		    autos[0].anio = 2024;

            autos[1].precio = 309990;
		    autos[1].anio = 2026;

            autos[2].precio = 450000;
		    autos[2].anio = 2021;

            autos[3].precio = 250000;
		    autos[3].anio = 2025;

            printf("----Autos----\n");
            for(int i = 0; i < 4; i++){
                printf("Auto %d\n", i + 1);
                printf("Precio: %.2f\n", autos[i].precio);
                printf("Anio: %d\n\n", autos[i].anio);
            }

            printf("\n----Personas----\n");
            for(int i = 0; i < 4; i++){
                printf("Persona %d\n", i + 1);
                printf("Nombre: %s\n", personas[i].nombre);
                printf("Apellido paterno: %s\n", personas[i].ap);
                printf("Apellido materno: %s\n", personas[i].am);
                printf("Genero: %c\n", personas[i].genero);
                printf("Edad: %d\n\n", personas[i].edad);
            }

    	return 0;
	
	}