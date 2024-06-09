#include <stdio.h>

int main(void)
{
    unsigned short x_size, y_size;

    puts("Por favor, digite abaixo o número tamanho horizontal e vertical o quadrado:");
    printf("Tamanho horizontal: ");
    scanf("%ud", &x_size);
    printf("\nAgora, tamanho vertical: ");
    scanf("%ud", &y_size);
    printf("\nDesenhando um quadrado de dimensões %udx%ud...", x_size, y_size);
}
