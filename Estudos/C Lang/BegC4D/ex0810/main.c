#include <stdio.h>
#include <stdlib.h>

int main()
{
    int a, b;

    a = 5;

    puts("Please input the value o b");
    scanf("%d", &b);

    if(a > b)
    {
        printf("%d is greater than %d\n", a, b);
    }
    else
    {
        printf("%d is not greater than %d\n", a, b);
    }
    return 0;
}
