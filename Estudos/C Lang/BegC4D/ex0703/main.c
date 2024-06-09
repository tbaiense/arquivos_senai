#include <stdio.h>
#include <stdlib.h>

int main()
{
    int c;

    printf("I'm waiting for a character:\n");
    c = getc(stdin);
    printf("I waited for the character %c.\n",c);
    return 0;
}
