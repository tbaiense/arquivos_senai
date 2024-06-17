#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <string.h>
#include <math.h>

int main(int argc, char *argv[]) {
    struct president {
        char name[40];
        int year;
    } first = {"George Washington", 1789};
    
    struct president second = {
        "John Adams",
        1797
    };
    
    printf("%-20s | YEAR\n", "PRESIDENT");
    printf("--------------------------------\n");
    printf("%-20s | %d\n", first.name, first.year);
    printf("%-20s | %d\n", second.name, second.year);
    return 0;
}
