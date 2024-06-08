#include <stdio.h>
#include <stdlib.h>

int main()
{
    int first, second;

    puts("Please input the first value:");
    scanf("%d", &first);
    puts("Please input the second value:");
    scanf("%d", &second);

    puts("Evaluating...");

    if(first>second)
    {
        printf("%d is greater than %d\n", first, second);
    }
    else if(first<second)
    {
        printf("%d is less than %d\n", first, second);
    }
    else if(first==second)
    {
        printf("%d is equal to %d\n", first, second);
    }
    else
    {
        puts("Invalid value, try with another one");
        return(1);
    }
    return 0;
}
