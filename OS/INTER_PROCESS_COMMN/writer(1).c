#include <stdio.h>

int main() {
    FILE *fp;
    char ch;

    fp = fopen("shared.txt", "w");
    if (fp == NULL) {
        perror("fopen");
        return -1;
    }

    ch = 'a';
    fputc(ch, fp);

    fclose(fp);

    return 0;
}
