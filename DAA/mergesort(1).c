#include <stdio.h>
void print(int arr[], int n)
{
    int i;
    for (i = 0; i < n; i++)
    {
        printf("%d ", arr[i]);
    }
}

void conquer(int arr[], int si, int mid, int ei)
{
    int merged[ei - si + 1];
    int a = si;
    int b = mid + 1;
    int x = 0; // to track merged index

    while (a <= mid && b <= ei)
    {
        if (arr[a] <= arr[b])
        {
            merged[x++] = arr[a++];
        }
        else
        {
            merged[x++] = arr[b++];
        }
    }
    while (a <= mid)
    {
        merged[x++] = arr[a++];
    }
    while (b <= ei)
    {
        merged[x++] = arr[b++];
    }
    for (int i = 0; i < x; i++)
    {
        arr[si + i] = merged[i];
    }
}

void mergesort(int arr[], int si, int ei)
{
    if (si >= ei)
    {
        return;
    }
    int mid = si + (ei - si) / 2;
    mergesort(arr, si, mid);
    mergesort(arr, mid + 1, ei);
    conquer(arr, si, mid, ei);
}

int main()
{
    printf("Merge Sort\n");
    int arr[] = {38, 9, 29, 7, 2, 15, 28};
    int n = sizeof(arr) / sizeof(arr[0]);
    printf("Unsorted Array: ");
    print(arr, n);

    mergesort(arr, 0, n - 1);
    printf("\nAfter applying merge sort\nThe final array is as follows: ");
    print(arr, n);

    return 0;
}
