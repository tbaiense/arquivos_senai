#include <stdio.h>

//void busy(void);

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

int main()
{
    busy();
    return 0;
}
