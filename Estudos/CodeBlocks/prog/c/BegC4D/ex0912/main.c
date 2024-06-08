#include <stdio.h>

int main()
{
    char primeira_letra, segunda_letra, terceira_letra; // A B C -> A é a primeira, B a segunda, ...

    for(primeira_letra = 'A'; primeira_letra <= 'Z'; primeira_letra++)
    {
        for(segunda_letra = 'A'; segunda_letra <= 'Z'; segunda_letra++)
        {
            for(terceira_letra = 'A'; terceira_letra <= 'Z'; terceira_letra++)
                printf("%c%c%c\n", primeira_letra, segunda_letra, terceira_letra);
        }
    }
    return 0;
}
