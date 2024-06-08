#include <stdio.h>
#include <stdlib.h>

int main()
{
    char prompt[] = "Program to destroy the World\nPress Enter to explode:";

    printf("%s\n", prompt);
    getc(stdin);
    return 0;
}
