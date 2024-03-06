#include <stdio.h>
#include <semaphore.h>

int main() {
    sem_t semaphore;
    char ch = 'a';

    sem_init(&semaphore, 0, 1);

    // Open the file in write mode
    FILE *fp = fopen("shared.txt", "w");
    if (fp == NULL) {
        perror("fopen");
        return -1;
    }

    // Acquire the semaphore before writing
    sem_wait(&semaphore);

    // Write the character 'a' to the file
    fputc(ch, fp);

    // Release the semaphore after writing
    sem_post(&semaphore);

    // Close the file
    fclose(fp);

    return 0;
}
