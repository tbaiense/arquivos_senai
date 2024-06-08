#include <stdio.h>
#include <stdlib.h>

#define NAME_LENGTH 4

int main()
{
    char name[NAME_LENGTH];
    printf("Type your full name below:\n");
    fgets(name,NAME_LENGTH,stdin);
    printf("The typed name is %s\n",name);
    return 0;
}
