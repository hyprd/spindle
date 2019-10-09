#ifndef GRAPH_H_
#define GRAPH_H_

/* 
 * Header file for graph definition.
 * Definition for node state of type state_t
 */
typedef enum {VISITED_SELF, VISITED_DESCENDANTS, UNVISITED} state_t;
typedef struct graphrec *graph;
extern graph graph_new(int c);
extern void graph_free(graph g);
extern graph graph_add_edge(graph g, int u, int v);
extern graph graph_add_edge_bidirectional(graph g, int u, int v);
extern void graph_print(graph g);
extern graph graph_bfs(graph g, int src);
extern graph graph_dfs(graph g);
extern void visit(graph g, int v);


#endif