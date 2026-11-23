#include <stdio.h>
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

    /* Escritura */
    FILE *f = fopen("datos.xml", "w");
    if (f == NULL) { perror("No se pudo crear datos.xml"); return 1; }
    fprintf(f, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
    fprintf(f, "<alumno>\n");
    fprintf(f, "  <nombre>%s</nombre>\n", nombre);
    fprintf(f, "  <edad>%d</edad>\n", edad);
    fprintf(f, "  <calificaciones>\n");
    for (int i = 0; i < 3; i++)
        fprintf(f, "    <calificacion>%d</calificacion>\n", calificaciones[i]);
    fprintf(f, "  </calificaciones>\n");
    fprintf(f, "  <lista>\n");
    for (int i = 0; i < lista.n; i++)
        fprintf(f, "    <elemento>%d</elemento>\n", lista.datos[i]);
    fprintf(f, "  </lista>\n");
    fprintf(f, "</alumno>\n");
    fclose(f);

    /* Lectura */
    f = fopen("datos.xml", "r");
    if (f == NULL) { perror("No se pudo abrir datos.xml"); return 1; }
    char linea[200], n[50] = "";
    int e = 0, valor;
    int arr[MAX], na = 0, lis[MAX], nl = 0;
    while (fgets(linea, sizeof(linea), f) != NULL) {
        if (sscanf(linea, " <nombre>%49[^<]</nombre>", n) == 1) continue;
        if (sscanf(linea, " <edad>%d</edad>", &e) == 1) continue;
        if (sscanf(linea, " <calificacion>%d</calificacion>", &valor) == 1 && na < MAX)
            arr[na++] = valor;
        else if (sscanf(linea, " <elemento>%d</elemento>", &valor) == 1 && nl < MAX)
            lis[nl++] = valor;
    }
    fclose(f);

    printf("%s %d | arreglo:", n, e);
    for (int i = 0; i < na; i++) printf(" %d", arr[i]);
    printf(" | lista:");
    for (int i = 0; i < nl; i++) printf(" %d", lis[i]);
    printf("\n");
    return 0;
}
