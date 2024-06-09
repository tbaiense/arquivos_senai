#include <stdio.h>

#define FIBO_SEQ_LENGH 300

int main()
{
    int fibo, nacci;
    fibo = 0;
    nacci = 1;

    do
    {
        printf("%d ", fibo);
        fibo = fibo + nacci;
        printf("%d ", nacci);
        nacci = nacci + fibo;
    } while(nacci < FIBO_SEQ_LENGH);
    putchar('\n');
    return 0;
}
