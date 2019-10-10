#include "mylib.h"
#include <stdio.h>
#include <stdlib.h>


void *emalloc(size_t s){
    void *p = malloc(s);
    if (p == NULL){
        fprintf(stderr, "Memory allocation failed!\n");
        exit(EXIT_FAILURE);
    }
    return p;
}

void *erealloc(void *p, size_t s){
    void *a;
    a = realloc(p, s);
    if(a == NULL){
        fprintf(stderr, "Memory allocation failed!\n");
        exit(EXIT_FAILURE);

    }
    return a;
}
