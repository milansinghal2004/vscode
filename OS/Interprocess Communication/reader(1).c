// Write a c program that opens a file named shared.txt and reads a character from it. Name this program reader.c
// The program should print the character it reads from the file and then close the file.

#include <stdio.h>

int main() {
    FILE *file;

    file = fopen("shared.txt", "r");

    if (file == NULL) {
        printf("Failed to open the file.\n");
        return 1; // Exit with an error code
    }

    char character = fgetc(file);

    if (character == EOF) {
        printf("End of file reached.\n");
    } else {
        printf("Character read from the file: %c\n", character);
    }

    fclose(file);

    return 0;
}