#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(int argc, char *argv[]) {
    struct date {
        short day;
        short month;
        int year;
    };
    
    struct id {
        char first[20];
        char last[20];
    };
    
    struct human {
        struct id name;
        struct date birthday;
    };
    
    struct human president;
    strcpy(president.name.first, "George");
    strcpy(president.name.last, "Washington");
    president.birthday.day = 22;
    president.birthday.month = 2;
    president.birthday.year = 1732;
    
    printf("%s %s was born on %d/%d/%d\n", president.name.first, president.name.last, president.birthday.month, president.birthday.day, president.birthday.year);
    return 0;
}
