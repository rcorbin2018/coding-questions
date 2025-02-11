#include "stack.c"
#include <stdio.h>

void DFS(int graph[][MAX_VERTICES_INT], int numberOfVerticesInGraph, int startVertex) {
    bool visited[MAX_VERTICES_INT] = {false};
    Stack stack;
    stack.top = -1;
    stack_push(&stack, startVertex);
    while(!stack_isempty(&stack)) {
        int currentVertex = stack_pop(&stack);
        if(!visited[currentVertex]) {
            printf("currentVertex: %d \n", currentVertex);
            visited[currentVertex] = true;
            //Push unvisited neighbor vertices onto the stack
            for (int i = startVertex; i <= numberOfVerticesInGraph; i++) {
                if(graph[currentVertex][i] && !visited[i]) {
                    stack_push(&stack, i);
                }
            }
        }
    }
}

int main(int argc, char *argv[]) {
    int numberOfVerticesInGraph;
    int startVertex;
    int edges;
    int graph[MAX_VERTICES_INT][MAX_VERTICES_INT] = {0};

    printf("Enter the number of vertices in the graph: ");
    scanf("%d", &numberOfVerticesInGraph);
    printf("Enter the number of edges in the graph: ");
    scanf("%d", &edges);
    printf("Enter the edges (source destination): \n");
    for (int i = 0; i < edges; i++) {
        int source, destination;
        scanf("%d %d", &source, &destination);
        graph[source][destination] = 1;
        graph[destination][source] = 1;
    }
    
    printf("Enter the start vertex: ");
    scanf("%d", &startVertex);

    printf("graph:\n");
    for (int i = 0; i < MAX_VERTICES_INT; i++) {
        for (int j = 0; j < MAX_VERTICES_INT; j++) {
            printf("%d ", graph[i][j]);
        }
        printf("\n");
    }

    printf("DFS Traversal: \n");
    DFS(graph, numberOfVerticesInGraph, startVertex);
    return 0;
}