#include <stdio.h>
#include <math.h>

// modificar o programa para exibir uma onda cossenoidal

#define PI 3.14159
#define WAVELENGTH 35
#define PERIOD .1

int main()
{
    float graph, c, x;

    for(graph = 0; graph < 2*PI; graph+=PERIOD)
    {
        c = cos(graph);
        c+= 1.0;
        for(x = 0; x < c*WAVELENGTH; x++)
            putchar('*');
        putchar('\n');
    }
    return 0;
}
