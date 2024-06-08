#include <stdio.h>
#include <ctype.h>

int main()
{
    char phrase[] = "Era uma vez um pudim apaixonado. Ele estava andando pela rua quando foi atropelado. Puft! Pudim amassado, pudim amassado, pudim amassado morreu!";
    int index, blank, punct, alpha;

    index = blank = punct = alpha = 0;

    while(phrase[index])
    {
        if(isalpha(phrase[index]))
            alpha++;
        if(isblank(phrase[index]))
            blank++;
        if(ispunct(phrase[index]))
            punct++;
        index++;
    }

    printf("\"%s\"\n", phrase);
    puts("Statistics:");
    printf("%d alphabetic characters\n", alpha);
    printf("%d blanks\n", blank);
    printf("%d punctuation symbols\n", punct);

    return 0;

}
