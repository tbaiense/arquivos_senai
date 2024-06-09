#include <stdio.h>
#include <stdlib.h>

int main()
{
    int alphabet;
    for(alphabet='z'; alphabet>='a'; alphabet--)
        printf("%c", alphabet);
    putchar('\n');
    return 0;
}
