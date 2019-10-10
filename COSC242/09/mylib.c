#include <stdio.h>
#include <stdlib.h>
#include "mylib.h"

void *emalloc(size_t s){
    void *p;
    p = malloc(s);
    if (NULL == p){
        fprintf(stderr, "Memory allocation failed!\n");
        exit(EXIT_FAILURE);
    }
    return p;
}

void *erealloc(void *p, size_t s){
    void *a;
    a = realloc(p, s);
    if(NULL == a){
        fprintf(stderr, "Memory allocation failed!\n");
        exit(EXIT_FAILURE);

    }
    return a;
}
