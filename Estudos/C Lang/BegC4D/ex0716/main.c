#include <stdio.h>
#include <stdlib.h>

int main()
{
    char name[10];

    printf("What is your name\?\n");
    fgets(name,10,stdin);
    printf("Nice to meet you, %s",name);
    return 0;
}
