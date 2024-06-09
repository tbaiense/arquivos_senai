#include <stdio.h>
#include <stdlib.h>

int main()
{
    int guess;

    printf("Can you guess the secret number: ");
    scanf("%d", &guess);

    if(guess==10)
    {
        puts("You guessed it!");
        return 0;
    }
    if (guess!=10)
    {
        puts("Wrong!");
        return 1;
    }
}
