#include <stdio.h>

int main()
{
    int count;
    _Bool loop = 0;
    count = 0;

    for(loop = 1;;)
    {
        printf("%d\t", count);
        count++;
        if(count > 50)
            break;
    }
    putchar('\n');
    printf("\n%d\n", loop);
    return 0;
}
