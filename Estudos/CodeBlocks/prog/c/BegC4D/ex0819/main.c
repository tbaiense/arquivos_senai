#include <stdio.h>
#include <stdlib.h>

int main()
{
    char choice;

    puts("Meal plans: ");
    puts("A - Breakfast, Lunch and Dinner");
    puts("B - Lunch and Dinner");
    puts("C - Dinner only");

    scanf("%c", &choice);

    printf("You\'ve opted for ");

    switch(choice)
    {
        case 'A':
        case 'a':
            printf("Breakfast, ");
        case 'B':
        case 'b':
            printf("Lunch and ");
        case 'C':
        case 'c':
            printf("Dinner");
        default:
            printf(" as your meal plan.\n");
    }
    return(0);
}
