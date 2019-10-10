#include <stdio.h>
#include <stdlib.h>
#include "flexarray.h"

int main (void){
  int item;
  flexarray my_array = flexarray_new();
  while(1 == scanf("%d", &item)){
    flexarray_append(my_array, item);
  }
  flexarray_sort(my_array);
  flexarray_print(my_array);
  flexarray_free(my_array);
  return EXIT_SUCCESS;
}
