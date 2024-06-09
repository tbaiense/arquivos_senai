#include <stdio.h>

void limit(int stop);
_Bool verify(int value);

int main()
{
    int s;

    printf("Enter a stopping value [0-100]: ");
    scanf("%d", &s);
    if(verify(s))
    {
        limit(s);
        return(0);
    }
    else
    {
        return(1);
    }
}

void limit(int stop)
{
    int x;

    for(x=0; x<=100; x++)
    {
        printf("%d ", x);
        if(x==stop)
        {
            puts("You won!");
            return;
        }
    }
    puts("I won!");
}

_Bool verify(int value)
{
    if(value >=0 && value <= 100)
    {
        return(1);
    }
    else
    {
        printf("Invalid stopping value. Enter a value between 0 and 100");
        return(0);
    }
}
