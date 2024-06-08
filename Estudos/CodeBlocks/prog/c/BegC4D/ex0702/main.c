#include <stdio.h>
#include <stdlib.h>

int main()
{
    int c;

    printf("I'm waiting for a character:\n");
    c = getchar();
    printf("I waited for the character %d.\n",c);
    return 0;
}
