#include <stdio.h>

void busy(void);

int main()
{
    busy();
    return 0;
}

void busy(void)
{
    int loop;
    char input[32];

    loop=0;
    while(loop<5)
    {
        printf("C:\\DOS> ");
        fgets(input, 31, stdin);
        loop=loop+1;
    }
}
