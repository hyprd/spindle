#include <stdio.h>
#include <stdlib.h>
#include "graph.h"
#include "mylib.h"
#include "queue.h"

struct graphrec{
    int capacity;
    struct vertexrec *vertices;
    int **edges;
};

struct vertexrec{
    int predecessor;
    int capacity;
    int dist;
    int finish;
    state_t state;
};


/*
 * Initialise a new graph.
 * @param c the number of vertices in the graph
 * @return the new graph
 */
graph graph_new(int c){
    int i, u;
    graph result = emalloc(sizeof * result);
    result -> capacity = c;
    result -> vertices = emalloc(result -> capacity * sizeof result -> vertices[0]);
    result -> edges = emalloc(result -> capacity * sizeof result -> edges[0]);
    for(i = 0; i < result -> capacity; i++){
        /* Init number of rows */
        result -> edges[i] = emalloc(result -> capacity * sizeof result -> edges[i][0]);
        /* Init each row individually */
        for(u = 0; u < result -> capacity; u++){
            result -> edges[i][u] = 0;
        }
    }
    /*
     * Set visited state
     * state type comes from vertexrec structure
     */
    for(i = 0; i < result -> capacity; i++){
        result -> vertices[i].state = UNVISITED;
    }
    return result;
}

/*
 * Print out an adajency list and vertex information.
 * @param g a given graph to print information
 */
void graph_print(graph g){
    int u, j, count;
    printf("adajency list:\n");
    for(u = 0; u < g -> capacity; u++){
        printf("%d | ", u);
        count = 0;
        for(j = 0; j < g -> capacity; j++){
            if(g -> edges[u][j] == 1){
                if(count > 0){
                    printf(", %d", j);
                    count++;
                } else{
                    printf("%d", j);
                    count++;
                }
            }
        }
        printf("\n");
    }
    printf("\n");
    printf("vertex distance pred\n");
    for(u = 0; u < g -> capacity; u++){
        printf("%d\t%d\t%d\n", u, g -> vertices[u].dist, g -> vertices[u].predecessor);
    }
}
/* 
 * Free the graph + contents of memory.
 * @param g the graph to be freed 
 */
void graph_free(graph g){
    int i;
    for(i = 0; i < g -> capacity; i++){
        free(g -> edges[i]);
    }
    free(g -> edges);
    free(g -> vertices);
    free(g);
    return;
}

/*
 * Add an edge from vertices u to v (directed graph). 
 * @param g the graph to perform changes to
 * @param u first vertice
 * @param v the second vertice
 * @return post-change graph
 */
graph graph_add_edge(graph g, int u, int v){
    g -> edges[u][v] = 1;
    return g;
}

/*
 * Add edges from vertices u to v, then v to u (undirected graph).
 * @param g the graph to perform changes to
 * @param u first vertice
 * @param v the second vertice
 * @return post-change graph
 */
graph graph_add_edge_bidirectional(graph g, int u, int v){
    g -> edges[u][v] = 1;
    g -> edges[v][u] = 1;
    return g;
}

/* 
 * Conduct a breadth-first search of a graph.
 * @param g a given graph to traverse
 * @param src the source vertex
 */
graph graph_bfs(graph g, int src){
    int i, v, u;
    queue q = queue_new(g -> capacity); 
    for(i = 0; i < g -> capacity; i++){
        /*g -> vertices[i].state = UNVISITED; */
        g -> vertices[i].dist = -1;
        g -> vertices[i].predecessor = -1;       
    }
    g -> vertices[src].state = VISITED_SELF;
    g -> vertices[src].dist = 0;
    enqueue(q, src);
    while(queue_size(q) != 0){
        u = dequeue(q);
        for(v = 0; v < g -> capacity; v++){
            if(g -> edges[v][u] == 1 && g -> vertices[v].state == UNVISITED){
                g -> vertices[v].state = VISITED_DESCENDANTS;
                g -> vertices[v].dist = 1 + g -> vertices[u].dist;
                g -> vertices[v].predecessor = u;
                enqueue(q, v);
            }
        }
        g -> vertices[u].state = VISITED_DESCENDANTS; 
    }
    queue_free(q);
    return g;
}
