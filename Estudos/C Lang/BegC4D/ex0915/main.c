#include <stdio.h>

int main()
{
    float x;

    x = -5.0;
    while(x <= 5.0)
    {
        printf("%.1f\t", x);
        x = x + 0.5;
    }
    putchar('\n');
    return 0;
}
