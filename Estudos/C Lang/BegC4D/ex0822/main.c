#include <stdio.h>

int main()
{
    int a, b, larger;

    printf("Input the value of A: ");
    scanf("%d", &a);
    printf("Input the value of B: ");
    scanf("%d", &b);

    if(a > b) larger = a;
    else larger = b;
    printf("%d is larger", larger);
    return 0;
}
