#include <stdio.h>

int main() {
    FILE *fp;
    char ch;

    fp = fopen("shared.txt", "r");
    if (fp == NULL) {
        perror("fopen");
        return -1;
    }

    ch = fgetc(fp);
    printf("%c\n", ch);

    fclose(fp);

    return 0;
}
