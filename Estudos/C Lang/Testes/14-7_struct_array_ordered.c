#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[]) {
    struct scores {
        char name[40];
        int score;
    };
    
    struct scores player[4];
    const short sizePlayer = sizeof(player) / sizeof(struct scores);
    for (short x=0; x<sizePlayer; x++) {
        printf("#%d Player\nName: ", x+1);
        scanf("%s", player[x].name);
        printf("Score: ");
        scanf("%d", &player[x].score);
        printf("\n\n");
    }
    
    //Ordenação selection
    int posMenor;
    struct scores copia[1];
    for (short posAtual=0; posAtual<sizePlayer-1; posAtual++) {
        posMenor = posAtual;
        for (short posVer= posAtual+1; posVer<sizePlayer; posVer++) {
            if (player[posVer].score < player[posMenor].score)
                posMenor = posVer;
        }
        if(posMenor != posAtual) {
            copia[0]= player[posAtual];
            player[posAtual] = player[posMenor];
            player[posMenor] = copia[0];
        }
    }
    
    //Exibição
    puts("Player Info:");
    printf("#\tName\tScore\n");
    for (short x=0; x<sizePlayer; x++) {
        printf("%d\t%-12s\t%7d\n", x+1, player[x].name, player[x].score);
    }
    return 0;
}
