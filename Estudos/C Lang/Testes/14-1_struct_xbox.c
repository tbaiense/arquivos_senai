#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <string.h>
#include <math.h>

int main(int argc, char *argv[]) {
    struct player
    {
        char name[32];
        int highscore;
    };
    struct player xbox;
    struct player daniela;
    printf("Enter the player's name:\n>>> ");
    scanf("%s", xbox.name);
    printf("Enter the %s's highscore:\n>>> ", xbox.name);
    scanf("%d", &xbox.highscore);
    printf("\nPlayer %s has a highscore of %d", xbox.name, xbox.highscore);
    return 0;
}
