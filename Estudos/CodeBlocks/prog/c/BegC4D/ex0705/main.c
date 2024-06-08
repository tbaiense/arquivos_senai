#include <stdio.h>
#include <stdlib.h>

int main()
{
    int ch;

    printf("Press Enter:\n");
    getchar();
    ch = 'H';
    putchar(ch);
    ch = 'i';
    putchar(ch);
    putchar('!');
    //ch = '\n';
    putchar('\n');
    return 0;
}
