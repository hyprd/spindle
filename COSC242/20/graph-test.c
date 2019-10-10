#include <stdio.h>
#include <stdlib.h>
#include "mylib.h"
#include "graph.h"
#include "queue.h"

int main (void){
    graph g;
    int size, u, v;
    printf("Select size: \n");
    if(1 == scanf("%d", &size)){
        g = graph_new(size);
    } else{
        exit(EXIT_FAILURE);
    }
    while(2 == scanf("%d%d", &u, &v)){
        graph_add_edge_bidirectional(g,u,v);
    }
    /*
    graph_add_edge_bidirectional(g, 0, 4);
    graph_add_edge_bidirectional(g, 0, 1);
    graph_add_edge_bidirectional(g, 1, 5);
    graph_add_edge_bidirectional(g, 5, 2);
    graph_add_edge_bidirectional(g, 5, 6); 
    graph_add_edge_bidirectional(g, 2, 6);
    graph_add_edge_bidirectional(g, 2, 3);
    graph_add_edge_bidirectional(g, 6, 7);
    graph_add_edge_bidirectional(g, 6, 3);
    graph_add_edge_bidirectional(g, 3, 7);
    */

    graph_bfs(g, 1);  
    graph_print(g);
    graph_free(g);
    return EXIT_SUCCESS;
}
