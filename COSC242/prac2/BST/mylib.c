#include <stdio.h>
#include <stdlib.h>
void *emalloc(size_t s){
    void *d = malloc(s);
    if(d == NULL){
        fprintf(stderr, "memory allocation failed!\n");
        exit(EXIT_FAILURE);
    }
    return d;
}
