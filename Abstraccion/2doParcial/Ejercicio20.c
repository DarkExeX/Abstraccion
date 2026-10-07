#include <stdio.h>

void swap(int** a, int** b) {
	int* temp = *a;
	*a = *b;
	*b = temp;
}

int particion(int* arr[], int bajo, int alto) {
	int pivote = *arr[alto];
	int i = bajo - 1;

	for (int j = bajo; j < alto; j++) {
		if (*arr[j] < pivote) {
			i++;
			swap(&arr[i], &arr[j]);
		}
	}
	swap(&arr[i + 1], &arr[alto]);
	return i + 1;
}

void quickSortIndirecto(int* arr[], int bajo, int alto) {
	if (bajo < alto) {
		int pi = particion(arr, bajo, alto);
		quickSortIndirecto(arr, bajo, pi - 1);
		quickSortIndirecto(arr, pi + 1, alto);
	}
}

int main() {
	int datos[5] = {42, 12, 89, 23, 7};
	int* ptrs[5];
	for (int i = 0; i < 5; i++) ptrs[i] = &datos[i];

	quickSortIndirecto(ptrs, 0, 4);

	printf("Datos ordenados de forma indirecta: ");
	for (int i = 0; i < 5; i++) printf("%d ", *ptrs[i]);
	printf("\nOriginal sin modificar: ");
	for (int i = 0; i < 5; i++) printf("%d ", datos[i]);
	return 0;
}
