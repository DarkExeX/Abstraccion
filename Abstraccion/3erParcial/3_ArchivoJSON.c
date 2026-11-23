#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define MAX 10

typedef struct {
    int datos[MAX];
    int n;
} Lista;

void escribirArreglo(FILE *f, const char *clave, int *v, int n, int ultimo) {
    fprintf(f, "  \"%s\": [", clave);
    for (int i = 0; i < n; i++) fprintf(f, "%s%d", i > 0 ? ", " : "", v[i]);
    fprintf(f, "]%s\n", ultimo ? "" : ",");        /* sin coma al final */
}

int leerArreglo(const char *texto, const char *clave, int *destino, int max) {
    char patron[60];
    snprintf(patron, sizeof(patron), "\"%s\": [", clave);
    const char *p = strstr(texto, patron);
    if (p == NULL) return 0;
    p += strlen(patron);
    int n = 0;
    char *fin;
    while (*p != ']' && n < max) {
        destino[n++] = (int) strtol(p, &fin, 10);
        if (fin == p) break;
        p = fin;
        while (*p == ',' || *p == ' ') p++;
    }
    return n;
}

int main(void) {
    char nombre[50] = "Edder";
    int edad = 19;
    int calificaciones[3] = {8, 9, 10};
    Lista lista = {{7, 8, 9, 10}, 4};

    /* Escritura */
    FILE *f = fopen("datos.json", "w");
    if (f == NULL) { perror("No se pudo crear datos.json"); return 1; }
    fprintf(f, "{\n");
    fprintf(f, "  \"nombre\": \"%s\",\n", nombre);
    fprintf(f, "  \"edad\": %d,\n", edad);
    escribirArreglo(f, "calificaciones", calificaciones, 3, 0);
    escribirArreglo(f, "lista", lista.datos, lista.n, 1);
    fprintf(f, "}\n");
    fclose(f);

    /* Lectura: se carga todo el archivo en memoria */
    f = fopen("datos.json", "r");
    if (f == NULL) { perror("No se pudo abrir datos.json"); return 1; }
    char texto[1000];
    size_t leidos = fread(texto, 1, sizeof(texto) - 1, f);
    texto[leidos] = '\0';
    fclose(f);

    char n[50] = "";
    int e = 0, arr[MAX], lis[MAX];
    char *p = strstr(texto, "\"nombre\": \"");
    if (p) sscanf(p, "\"nombre\": \"%49[^\"]\"", n);
    p = strstr(texto, "\"edad\": ");
    if (p) sscanf(p, "\"edad\": %d", &e);
    int na = leerArreglo(texto, "calificaciones", arr, MAX);
    int nl = leerArreglo(texto, "lista", lis, MAX);

    printf("%s %d | arreglo:", n, e);
    for (int i = 0; i < na; i++) printf(" %d", arr[i]);
    printf(" | lista:");
    for (int i = 0; i < nl; i++) printf(" %d", lis[i]);
    printf("\n");
    return 0;
}
