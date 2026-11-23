#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define MAX 10

typedef struct {
    int datos[MAX];
    int n;
} Lista;

int main(void) {
    char nombre[50] = "Edder";
    int edad = 19;
    int calificaciones[3] = {8, 9, 10};
    Lista lista = {{7, 8, 9, 10}, 4};

    /* Escritura: cada renglon inicia con su tipo de registro */
    FILE *f = fopen("datos.csv", "w");
    if (f == NULL) { perror("No se pudo crear datos.csv"); return 1; }
    fprintf(f, "basico,%s,%d\n", nombre, edad);
    fprintf(f, "arreglo");
    for (int i = 0; i < 3; i++) fprintf(f, ",%d", calificaciones[i]);
    fprintf(f, "\nlista");

    for (int i = 0; i < lista.n; i++) fprintf(f, ",%d", lista.datos[i]);
    fprintf(f, "\n");
    fclose(f);

    /* Lectura */
    f = fopen("datos.csv", "r");
    if (f == NULL) { perror("No se pudo abrir datos.csv"); return 1; }
    char linea[200];
    while (fgets(linea, sizeof(linea), f) != NULL) {
        linea[strcspn(linea, "\r\n")] = '\0';
        char *tipo = strtok(linea, ",");
        if (tipo == NULL) continue;
        if (strcmp(tipo, "basico") == 0) {
            char *n = strtok(NULL, ",");
            char *e = strtok(NULL, ",");
            if (n && e) printf("%s tiene %ld anios\n", n, strtol(e, NULL, 10));
        } else if (strcmp(tipo, "arreglo") == 0 || strcmp(tipo, "lista") == 0) {
            printf("%s:", tipo);
            char *campo;
            while ((campo = strtok(NULL, ",")) != NULL)
                printf(" %ld", strtol(campo, NULL, 10));
            printf("\n");
        } else {
            printf("Registro desconocido: %s\n", tipo);
        }
    }
    fclose(f);
    return 0;
}
