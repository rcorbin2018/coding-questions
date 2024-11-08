#include <stdio.h>
#include <string.h>

#define MAX_NAME 256
#define TABLE_SIZE 10

typedef struct {
    char name[MAX_NAME];
    int age;
} person;

unsigned int hash(char *name) {
    int length = strnlen(name, MAX_NAME);
    unsigned int hash_value = 0;
    for (int i = 0; i < length; i++) {
        hash_value += name[i];
        hash_value = (hash_value * name[i]) % TABLE_SIZE;
    }
    return hash_value;
}

int main() {
    printf("Rob => %u\n", hash("Rob"));
    printf("Jenny => %u\n", hash("Jenny"));
    printf("Robbie => %u\n", hash("Robbie"));
    printf("Becca => %u\n", hash("Becca"));
    printf("Ella => %u\n", hash("Ella"));
    printf("Charm => %u\n", hash("Charm"));
    printf("Teddy => %u\n", hash("Teddy"));
    return 0;
}