#include <stdio.h>
#include <stdlib.h>

int main()
{
    char resposta;

    do
    {
        puts("O céu está nublado hoje? Responda usando as teclas \'Y\' para \"sim\" e \'N\' para \"não\":\n");
        scanf("%c", &resposta);

        if(resposta=='Y' || resposta=='y') puts("Então, com certeza, choverá! Leve uma sombrinha ;-)");
        else if(resposta=='N' || resposta=='n') puts("Ótimo! Será um belo dia para sair e aproveitar!");
        else
        {
            puts("Por favor, digite uma das duas teclas como resposta. Tente novamente abaixo.");
            resposta = 'i';
        }
    }
    while (resposta=='i');
    return 0;
}
