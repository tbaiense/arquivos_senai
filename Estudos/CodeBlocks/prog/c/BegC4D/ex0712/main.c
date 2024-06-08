#include <stdio.h>
#include <stdlib.h>

int main()
{
    char firstname[15],lastname[15];

    printf("Type your first name:\n");
    scanf("%s",firstname);
    printf("Now, type your last name:\n");
    scanf("%s",lastname);
    printf("Pleased to meet you, %s %s.\n",firstname,lastname);
    return 0;
}
