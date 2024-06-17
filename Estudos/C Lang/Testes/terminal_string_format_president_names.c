#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <string.h>
#include <math.h>

int main(int argc, char *argv[]) {
    char pres[][2][16] = {"George","Washinton","John","Adams","Thomas","Jefferson","James","Monroe"};
    const int rowsPres = sizeof(pres) / sizeof(pres[0]);
    //Encontra o tamanho do maior nome
    int maxFirst = strlen(pres[0][0]) + 2;
    int thisFirst;
    for (short r = 1; r < rowsPres; r++) {
        thisFirst = (strlen(pres[r][0]) > maxFirst);
        maxFirst =  (thisFirst > maxFirst) ? thisFirst : maxFirst;
    }
    //Encontra o tamanho do maior sobrenome
    int maxLast = strlen(pres[0][1]) + 2;
    int thisLast;
    for (short r = 1; r < rowsPres; r++) {
        thisLast = (strlen(pres[r][1]) > maxLast);
        maxFirst =  (thisLast > maxFirst) ? thisLast : maxFirst;
    }
    for (int r = 0; r < rowsPres; r++) {
        printf("%-*s", maxFirst, pres[r][0]);
        printf("%-*s\n", maxLast, pres[r][1]);
    }
    return 0;
}