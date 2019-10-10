#include <stdlib.h>
#include <stdio.h>
#include "mylib.h"
#include "queue.h"

#define QUEUE_LENGTH 5
/* 
 * Queue implementation 
 * Ethan Simmonds 2018
 */
struct queue{
    double *items;
    int head;
    int capacity;
    int num_items;
};

void enqueue(queue q, double val){
    if(q -> num_items < q -> capacity){
        /* (head + num_items) % capacity */
        q -> items[(q -> head + q -> num_items) % q -> capacity] = val;
        q -> num_items++;
        return;
    }
    return;
}

double dequeue(queue q){
    double dq;
    if(q -> num_items > 0){
        /* Return contents of head */
        dq = q -> items[q -> head];
        /* Update head */
        q -> head++;
        /* Remove value */
        q -> num_items--;
        return dq;
    } else{
        return EXIT_FAILURE;
    }
}

queue queue_new(int size){
    queue result = emalloc(sizeof *result);
    result -> capacity = size;
    result -> head = 0;
    result -> num_items = 0;
    result -> items = emalloc(result -> capacity * sizeof result -> items[0]);
    return result;
}


void queue_print(queue q){
    int i = q -> head;
    do{
        printf("%.2f\n", q -> items[i]);
        i = (i + 1) % q -> capacity;

    } while (i != (q -> head + q -> num_items) % q -> capacity);
    return;
}
int queue_size(queue q){
    return q -> num_items;
}

queue queue_free(queue q){
    free(q -> items);
    /*
    free(q -> head);
    free(q -> capacity);
    free(q -> num_items); 
    */
    free(q);
    return q;
}