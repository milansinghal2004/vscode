#include <stdio.h>

void bubbleSort(int arr[], int size) 
{
    for (int n = 0; n < size - 1; ++n) 
    {
        for (int i = 0; i < size - n - 1; ++i) 
        {
            if (arr[i] > arr[i + 1]) {
            int temp = arr[i];
            arr[i] = arr[i + 1];
            arr[i + 1] = temp;
      }
    }
  }
}

void print(int arr[], int size) 
{
    for (int i = 0; i < size; ++i) 
    {
        printf("%d  ", arr[i]);
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
    bubbleSort(arr, n);
    printf("The sorted array is -");
    print(arr, n);
}