#include <stdio.h>

int main()
{
    char alphabet;
    for(alphabet='A'; alphabet<='Z'; alphabet++)
        printf("%d\t", alphabet);
    putchar('\n');
    return 0;
}
