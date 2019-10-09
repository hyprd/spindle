/* 1. Because the program references a copy of the value instead of
      referring to the memory address directly.
 */
#include <stdio.h>
#include <stdlib.h>

int main (void){
    int my_array[] = {5, 2, 7, 3, 4};
    int biggest, smallest;
    max_min(my_array, 5, &biggest, &smallest);
    printf("max value is %d, min value is %d\n", biggest, smallest );
    return EXIT_SUCCESS;
}
void max_min(int *a, int n, int *max, int *min){
    int i;
    for(i = 0; i < n; i++){
        if(a[i] < *min || min == NULL){
            *min = a[i];
        }
        if (a[i] > *max || max == NULL){
            *max = a[i];
        }
    }        
}
