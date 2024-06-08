#include <stdio.h>
#include <stdlib.h>

int main()
{
    int first, second;

    printf("Input the first value:\n");
    scanf("%d", &first);
    printf("Now, input the second value:\n");
    scanf("%d", &second);
    puts("Evaluating...");

    if(first<second)
    {
        printf("%d is less than %d\n", first, second);
    }
    if(first>second)
    {
        printf("%d is greater than %d\n", first, second);
    }
    if(first==second)
    {
        printf("%d is equal to %d\n", first, second);
    }
    return 0;
}
