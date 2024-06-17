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
        float hours;
    } xbox;
    printf("Enter the player's name:\n>>> ");
    scanf("%s", xbox.name);
    printf("Enter %s's highest score:\n>>> ", xbox.name);
    scanf("%d", &xbox.highscore);
    printf("Enter how many hours %s has played the game:\n>>> ", xbox.name);
    scanf("%f", &xbox.hours);
    printf("\nPlayer %s has a highscore of %d and has played for %.2f hours", xbox.name, xbox.highscore, xbox.hours);
    return 0;
}
