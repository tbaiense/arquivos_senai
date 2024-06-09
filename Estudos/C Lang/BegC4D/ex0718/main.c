#include <stdio.h>
#include <stdlib.h>

int main()
{
    char firstname[15],lastname[15];

    printf("Type your first name:\n");
    fgets(firstname,15,stdin);
    printf("Now, type your last name:\n");
    fgets(lastname,15,stdin);
    printf("Pleased to meet you, %s %s.\n",firstname,lastname);
    return 0;
}
