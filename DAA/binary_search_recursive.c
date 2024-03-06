#include <stdio.h>

int binarySearch(int arr[], int low, int high, int target) {
    if (low <= high) {
        int mid = low + (high - low) / 2;
        if (arr[mid] == target) {
            return mid;
        }
        if (arr[mid] < target) {
            return binarySearch(arr, mid + 1, high, target);
        } else {
            return binarySearch(arr, low, mid - 1, target);
        }
    }
    return -1;
}

int main() {
    int arr[] = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20};
    int n = sizeof(arr) / sizeof(arr[0]);
    int target = 14;
    int result = binarySearch(arr, 0, n - 1, target);
    if (result != -1) { 
        printf("Element found at index %d", result);
    } 
    else {
        printf("Element not found in the array.");
    }
    return 0;
}
