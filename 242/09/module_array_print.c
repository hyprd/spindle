#include <stdio.h>
#include <stdlib.h>
#include "mylib.h"

void insertion_sort(int array[], int count){
    int i, j, key;
    for(i = 0; i < count; i++){
        key = array[i];
        j = i - 1;
        while(j >= 0 && array[j] > key){
            array[j + 1] = array[j];
            j = j - 1;
        }
        array[j + 1] = key;
    }
}

int main (void){
    int capacity = 2;
    int itemcount = 0;
    int item;
    int *my_array = emalloc(capacity * sizeof my_array[0]);
    while(1 == scanf("%d", &item)){
        if (itemcount == capacity){
            capacity += capacity;
            my_array = erealloc(my_array, capacity * sizeof my_array[0]);
        }
        my_array[itemcount++] = item;
    }
    insertion_sort(my_array, itemcount);
    free(my_array);
    return EXIT_SUCCESS;

}
