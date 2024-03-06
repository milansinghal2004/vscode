#include <stdio.h>
void swap(int *xp, int *yp)
{
    int temp = *xp;
    *xp = *yp;
    *yp = temp;
}

void bubbleSort(int arr[], int n)
{
    int i, j;
    for (i = 0; i < n-1; i++)
    for (j = 0; j < n-i-1; j++)
    if (arr[j] > arr[j+1])
    swap(&arr[j], &arr[j+1]);
}

void print(int arr[], int size)
{
    int i;
    for (i=0; i < size; i++)
    printf("%d ", arr[i]);
}

int main()
{
    int arr[] = {38, 9, 29, 7, 2, 15, 28};
    int n = sizeof(arr)/sizeof(arr[0]);
    printf("The array length is %d\n", n);
    printf("Your Unsorted array is - ");
    print(arr, n);
    printf("\n");
    bubbleSort(arr, n);
    printf("The sorted array is -");
    print(arr, n);
    return 0;
}
