#include <stdio.h>

int main()
{
    int c = -10;

    while(c < 10)
    {
        printf("%d ", c);
        c++;
    }
    while(c >= -10)
    {
        printf("%d ", c);
        c--;
    }
    putchar('\n');
    return 0;
}
