#include<stdio.h>
void selectionSort(int arr[], int n)
{
    int i, j, k;
    for (i = 0; i < n-1; i++) {
        k = i;
        for (j = i+1; j < n; j++) {
            if (arr[j] < arr[k]) {
                k = j;
            }
        }
        int temp = arr[i];
        arr[i] = arr[k];
        arr[k] = temp;
    }
}

void print(int arr[], int n)
{
    for (int i = 0; i < n; i++) {
        printf("%d ", arr[i]);
    }
    printf("\n");
}

int main()
{
    int arr[] = {38, 9, 29, 7, 2, 15, 28};
    int n = sizeof(arr)/sizeof(arr[0]);
    printf("The array length is %d\n", n);
    printf("Your Unsorted array is - ");
    print(arr, n);
    selectionSort(arr, n);
    printf("The sorted array is -");
    print(arr, n);
}


