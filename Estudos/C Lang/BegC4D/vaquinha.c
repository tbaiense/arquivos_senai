#include <stdio.h>

int main()
{
/*
  _________    ___
 /         \  /  o\
|           |/\__<  ~-~-~-~-~
 \_________/       \  Olá!!
  || w   ||         \  Eu sou a vaquinha Mary Lu!
  |       |          ~-~-~-~-~
*/
    char mensagem[] = "Olá, eu sou a vaquinha Mary Lu!";
    //puts("Escreva uma mensagem para a vaquinha:");
    //fgets(mensagem, 21, stdin);
    printf("  _________    ___\n");
    printf(" /         \\  /  o\\\n");
    printf("|           |/\\__<  ~-~-~-~-~\n");
    printf(" \\_________/       \\  %s\n", mensagem);
    printf("  || w   ||         ~-~-~-~-~  \n");
    printf("  |       |          \n");
    return(0);
}
