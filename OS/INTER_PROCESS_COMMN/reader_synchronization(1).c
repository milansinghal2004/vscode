#include <stdio.h>
#include <semaphore.h>

int main() {
    sem_t semaphore;
    char ch;

    sem_init(&semaphore, 0, 1);

    // Open the file in read mode
    FILE *fp = fopen("shared.txt", "r");
    if (fp == NULL) {
        perror("fopen");
        return -1;
    }

    // Acquire the semaphore before reading
    sem_wait(&semaphore);

    // Read one character from the file
    ch = fgetc(fp);
    printf("%c\n", ch);

    // Release the semaphore after reading
    sem_post(&semaphore);

    // Close the file
    fclose(fp);

    return 0;
}
