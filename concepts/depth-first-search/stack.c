#include <stdbool.h>
#include <stdio.h>

#define MAX_VERTICES_INT 10

typedef struct Stack {
    int top;
    int vertices[MAX_VERTICES_INT];
} Stack;

void stack_push(struct Stack *stack, int value) {
    int currentTop = (*stack).top;
    //printf("currentTop in push: %d\n", currentTop);
    int currentTopValue = (*stack).vertices[(*stack).top];
    //printf("currentTopValue in push: %d\n", currentTopValue);
    (*stack).top = (*stack).top + 1;
    (*stack).vertices[(*stack).top] = value;
}

int stack_pop(struct Stack *stack) {
    int currentTop = (*stack).top;
    //printf("currentTop in pop: %d\n", currentTop);
    int currentTopValue = (*stack).vertices[(*stack).top];
    //printf("currentTopValue in pop: %d\n", currentTopValue);
    (*stack).top = (*stack).top - 1;
    return currentTopValue;
    // return (*stack).vertices[(*stack).top--];
}

bool stack_isempty(struct Stack *stack) {
    return (*stack).top == -1;
}