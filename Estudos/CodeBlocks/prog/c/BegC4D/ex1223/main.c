#include <stdio.h>

#define SIZE 5

void showarray(int array[]);

int main()
{
    int n[] = { 1, 2, 3, 5, 7 };

    puts("Here\'s your array:");
    showarray(n);
    return 0;
}

void showarray(int array[])
{
    int x;

    for(x=0;x<SIZE;x++)
        printf("%d\t", array[x]);
    putchar('\n');
}
