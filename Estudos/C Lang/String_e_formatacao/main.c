#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <math.h>

int main(int argc, char *argv[]) {
    char phrase[] = "sed viverra ipsum nunc aliquet bibendum enim facilisis gravida neque convallis a cras semper auctor neque vitae tempus quam pellente";
    int index, alpha, blank, punct;
    alpha = blank = punct = index = 0;
    
    while (phrase[index]) {
        if (isalpha(phrase[index])) 
            alpha++;
        if (isblank(phrase[index]))
            blank++;
        if (ispunct(phrase[index]))
            punct++;
        index++;
    }
    int sizeAlpha = floor(log10f(alpha)) + 1;
    int sizeBlank = abs(sizeAlpha-1);
    int sizePunct = sizeAlpha + sizeBlank -2;
    printf("%s\n\nStatistics:\n\n", phrase);
    printf("%*d alphabetic characters\n", sizeAlpha, alpha);
    printf("%*c%d blanks\n", sizeBlank, ' ', blank);
    printf("%*c%d punctiation symbols", sizePunct, ' ',punct);
    return 0;
}