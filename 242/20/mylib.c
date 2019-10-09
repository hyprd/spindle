#include <stdio.h>
#include <stdlib.h>
#include "mylib.h"

/* 
 * Memory allocation function.
 * @param s the size of memory to allocate
 * @return memory allocation pointer
 */
void *emalloc(size_t s){
    void *d = malloc(s);
    if(NULL == d){
        fprintf(stderr, "Memory allocation failed!\n");
        exit(EXIT_FAILURE);
    }
    return d;
}

/* 
 * Memory reallocation function.
 * @param p the address of the object to reallocate
 * @param s the size of memory to allocate
 * @return memory allocation pointer
 */
void *erealloc(void *p, size_t s){
    void *d = realloc(p, s);
    if(NULL == d){
        fprintf(stderr, "Memory allocation failed!\n");
        exit(EXIT_FAILURE);
    }
    return d;
}
