#include <stdio.h>

int main()
{
    char caractere;

    printf("Por favor, digite o caractere \'A\', \'B\' ou \'C\' adiante: ");
    scanf("%c", &caractere);

    switch(caractere)
    {
        case 'A':
            printf("%c de abelha!", caractere);
            break;
        case 'B':
            printf("%c de bola!", caractere);
            break;
        case 'C':
            printf("%c de cabelo!", caractere);
            break;
        default:
            printf("Hmm... Alguma coisa está errada. Digite um dos caracteres mencionados, por favor.");
    }
    return 0;
}
