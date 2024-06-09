#include <stdio.h>
#include <stdlib.h>

int main()
{
    int a, b, larger;

    printf("Input the value of A: ");
    scanf("%d", &a);
    printf("Input the value of B: ");
    scanf("%d", &b);

    larger = (a > b) ? a : b;
    printf("%d is larger", larger);
    return 0;
}
