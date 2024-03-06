// Write a c program that opens a file named shared.txt and writes a character on it. Name this program writer.c
// The program should take a character as input from the user and write it to the file and then close the file.

#include <stdio.h>
int main()
{
    char character;
    FILE *file;                                                         // File pointer
    file = fopen("shared.txt", "w");                                    // Opening the file to add character
    if (file == NULL)                                                   
    {                                                                   // Checking if the file opens
        printf("Failed to open the file.\n");
        return 1; 
    }
    printf("Enter the character to put to the file: ");
    scanf("%c", &character);                                            // Inputting character
    fputc(character, file);                                                 
    fclose(file);
    printf("Character '%c' written to the file.\n", character);         // Printing Character from the file on terminal
    return 0;
}
