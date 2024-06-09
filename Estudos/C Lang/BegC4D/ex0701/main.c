#include <stdio.h>
#include <stdlib.h>

int main()
{
    int c;

    printf("I\'m waiting for a character:\n");
    c = getchar();
    printf("The character I was waiting for is %c.\n",c);
    return 0;
}

