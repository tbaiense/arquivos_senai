#include <stdio.h>

int main()
{
    int code;

    printf("Please input the error code: ");
    scanf("%d", &code);

    switch(code)
    {
        case 1:
            puts("Drive fault, not your fault.\n");
            break;
        case 2:
            puts("Illegal format, call a lawer.\n");
            break;
        case 3:
            puts("Bad filename, spank it.\n");
            break;
        default:
            puts("That is not 1, 2 or 3.");
    }
    return 0;
}
