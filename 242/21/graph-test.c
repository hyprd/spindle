#include <stdio.h>
#include <stdlib.h>
#include "mylib.h"
#include "graph.h"
#include "queue.h"

int main (void){
    graph g;
    int size, u, v;
    printf("Select size: \n");
    /* Size input handling*/
    if(1 == scanf("%d", &size)){
        g = graph_new(size);
    } else{
        exit(EXIT_FAILURE);
    }
    /* vertex input handling. */
    while(2 == scanf("%d%d", &u, &v)){
        graph_add_edge(g, u, v);

    }
    /*
    graph_add_edge(g, 0, 1);
    graph_add_edge(g, 0, 3);
    graph_add_edge(g, 1, 4);
    graph_add_edge(g, 2, 4);
    graph_add_edge(g, 2, 5);
    graph_add_edge(g, 3, 1);
    graph_add_edge(g, 4,3);
    graph_add_edge(g, 5,5);
    */
    graph_dfs(g);
    graph_print(g);
    graph_free(g);
    return EXIT_SUCCESS;
}
