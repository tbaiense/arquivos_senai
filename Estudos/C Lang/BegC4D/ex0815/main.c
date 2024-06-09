#include <stdio.h>
#include <stdlib.h>

int main()
{
    int coordinate;

    puts("Input target coordinate:");
    scanf("%d", &coordinate);

    if(coordinate < -5 || coordinate > 5)
    {
        puts("Close enough");
    }
    else
    {
        puts("Target out of range. Try again with a lower coordinate.");
    }
    return 0;
}
