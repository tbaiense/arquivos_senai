#include <stdio.h>

#define SIZE 5

void showarray(int array[]);
void arrayinc(int array[]);

int main()
{
    int n[] = { 1, 2, 3, 5, 7 };

    puts("Here\'s your array originally:");
    showarray(n);
    arrayinc(n);
    puts("Here\'s your modified array:");
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

void arrayinc(int array[])
{
    int x;

    for(x=0;x<SIZE;x++)
        array[x]++;
}
