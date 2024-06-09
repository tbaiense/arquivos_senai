#include <stdio.h>
#include <math.h>

int main()
{
    for(float p = 0; p <= 10; p++)
        printf("2 to the power of %.0f is %.0f\n", p, pow(2, p));
    return 0;
}
