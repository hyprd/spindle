#include <stdio.h>
#include <stdlib.h>


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

static void array_print(int *a, int n){
  int u;
  for(u = 0; u < n; u++){
    printf("%d\n", a[u]);
  }
}

int main (void){
  int capacity = 2;
  int itemcount = 0;
  int item;
  int *my_array = malloc(capacity * sizeof my_array[0]);
  if (NULL == my_array){
    fprintf(stderr, "Memory allocation failed!\n");
    exit(EXIT_FAILURE);
  }
  while(1 == scanf("%d", &item)){
    if (itemcount == capacity){
      capacity += capacity;
      my_array = realloc(my_array, capacity * sizeof my_array[0]);
      if (NULL == my_array){
        fprintf(stderr, "Memory allocation failed!\n ");
        exit(EXIT_FAILURE);
      }
    }
    my_array[itemcount++] = item;
  }
  insertion_sort(my_array, itemcount);
  array_print(my_array, itemcount);
  free(my_array);
  return EXIT_SUCCESS;
}
