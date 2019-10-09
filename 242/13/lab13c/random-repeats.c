
#include <stdio.h>
#include <stdlib.h>

int main(void){
  int *my_dynamic_array;
  int array_size = 0;
  int i; 
  printf("Enter the size of my array: ");
  scanf("%d", &array_size);
  
  my_dynamic_array = malloc(array_size * sizeof my_dynamic_array);
  
  for(i = 0; i < array_size; i++){
    my_dynamic_array[i] = rand() % array_size;
  }
  
  printf("What's in my array: \n");
  for(i = 0; i < array_size; i++){
   printf("%d ",my_dynamic_array[i]);   
  }
  printf("\n");
  random_repeats(my_dynamic_array, array_size);
  printf("\n");
  free(my_dynamic_array);
  return EXIT_SUCCESS;

}

void random_repeats(int *a, int n){
    int *array;
    int i;
    array = malloc(n * sizeof array[0]);
    if (NULL == array){
        fprintf(stderr, "memory allocation failed!\n");
        return;
    }
    for (i = 0; i < n; i++){
        array[i] = 0;
    }
    for (i = 0; i < n; i++){
        array[a[i]]++;
    }
    for (i = 0; i < n; i++){
        if (array[i] > 1){
    
            printf("%d occurs %d times", i, array[i]);
        }
    }
    free(array);
    return;
}