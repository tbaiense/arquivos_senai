#include <stdio.h>
#include <stdlib.h>

int main()
{
    int a,b,c;

    printf("I\'m waiting for three characters:\n");
    a = getchar();
    b = getchar();
    c = getchar();
    printf("The three characters are %c, %c and %c.\n",a,b,c);

    return 0;
}