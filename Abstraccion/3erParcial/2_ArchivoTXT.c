#include <stdio.h>
#define MAX 10

typedef struct {
    int datos[MAX];
    int n;
} Lista;

int main(void) {
    char nombre[50] = "Edder";
    int edad = 19;
    int valores[3] = {10, 20, 30};
    Lista lista = {{7, 8, 9}, 3};

    /* Formato: nombre, edad, cantidad de valores, valores, cantidad de elementos, elementos */
    FILE *f = fopen("datos.txt", "w");
    if (f == NULL) { perror("No se pudo crear datos.txt"); return 1; }
    fprintf(f, "%s\n%d\n3\n", nombre, edad);
    for (int i = 0; i < 3; i++) fprintf(f, "%d\n", valores[i]);
    fprintf(f, "%d\n", lista.n);
    for (int i = 0; i < lista.n; i++) fprintf(f, "%d\n", lista.datos[i]);
    fclose(f);

    f = fopen("datos.txt", "r");
    if (f == NULL) { perror("No se pudo abrir datos.txt"); return 1; }
    char n[50];
    int e, cantidad, arr[MAX], total;
    Lista l = {{0}, 0};
    if (fscanf(f, "%49s %d %d", n, &e, &cantidad) != 3 || cantidad > MAX) {
        printf("Archivo con formato incorrecto\n");
        fclose(f);
        return 1;
    }
    for (int i = 0; i < cantidad; i++)
        if (fscanf(f, "%d", &arr[i]) != 1) { printf("Archivo incompleto\n"); fclose(f); return 1; }
    if (fscanf(f, "%d", &total) != 1 || total > MAX) { printf("Archivo incompleto\n"); fclose(f);
return 1; }
    for (int i = 0; i < total; i++)
        if (fscanf(f, "%d", &l.datos[i]) == 1) l.n++;
    fclose(f);

    printf("%s %d | arreglo:", n, e);
    for (int i = 0; i < cantidad; i++) printf(" %d", arr[i]);
    printf(" | lista:");
    for (int i = 0; i < l.n; i++) printf(" %d", l.datos[i]);
    printf("\n");
    return 0;
}
