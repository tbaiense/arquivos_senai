/*
Pequeno programa que recebe dois valores de largura e altura e desenha um quadrado. Possui um
bug onde, ao digitar qualquer caractere que não seja numérico, o fluxo entra em um loop infinito.

Thiago M. B. jan,2024
*/
#include <stdio.h>

#define MSG_TAM_INVALIDO "Tamanho inválido. Por favor, digite um valor entre 1 e 255:\n"

int main(void)
{
    unsigned char x_size, y_size;

    puts("Por favor, digite abaixo o número para a largura e altura do quadrado:");
    printf("Tamanho horizontal: ");

    definir_largura:
    int x_temp;
    scanf("%d", &x_temp);
    if(x_temp <= 0 || x_temp > 255)
    {
        printf(MSG_TAM_INVALIDO);
        x_temp = -1;
        goto definir_largura;
    }
    else
        x_size = x_temp * 2 - 1;

    printf("\nAgora, tamanho vertical: ");

    definir_altura:
    int y_temp;
    scanf("%d", &y_temp);
    if(y_temp <= 0 || y_temp > 255)
    {
        printf(MSG_TAM_INVALIDO);
        y_temp = -1;
        goto definir_altura;
    }
    else
        y_size = y_temp;

    printf("\nDesenhando um quadrado de dimensões %hdx%hd...\n", x_size / 2 + 1, y_size);

    putchar(' ');
    for(int prim_linha_pos = 0; prim_linha_pos < x_size; prim_linha_pos++)
        putchar('_');
    printf(" \n");

    for(int y_pos = 0; y_pos < y_size - 1 ; y_pos++)
        {
            putchar('|');
            for(int pos_em_y = 0; pos_em_y < x_size; pos_em_y++)
                putchar(' ');
            printf("|\n");
        }

    putchar('|');
            for(int pos_em_y = 0; pos_em_y < x_size; pos_em_y++)
                putchar('_');
    printf("|\n");


/*
     1234567
     _______
    |       |
    |_______|
*/
}

