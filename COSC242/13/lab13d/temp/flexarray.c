#include <stdio.h>
#include <stdlib.h>
#include "flexarray.h"

struct flexarrayrec{
  int capacity;
  int itemcount;
  int *items;
};

static void *emalloc(size_t s){
  void *p;
  p = malloc(s);
  if(p == NULL){
    fprintf(stderr, "memory allocation failed!\n");
    exit(EXIT_FAILURE);
  }
  return p;
}

static void *erealloc(void *p, size_t s){
  void *d;
  d = realloc(p, s);
  if(d == NULL){
    fprintf(stderr, "memory allocation failed!\n");
    exit(EXIT_FAILURE);
  }
  return d;
}

void insertion_sort(int *a, int n){
  int key = 0, left = 0, p = 0, i;
  for(p = 1; p < n; p++){
    key = a[p];
    left = p - 1;
    if(p == n / 2){
      for(i = 0; i < n; i++){
        fprintf(stderr, "%d\n", a[i]);
      }
    }
    while(left >= 0 && a[left] > key){
      a[left + 1] = a[left];
      left--;
    }
    a[left + 1] = key;
  }
}

void flexarray_append(flexarray f, int item){
  if(f -> itemcount == f -> capacity){
    f -> capacity += f -> capacity;
    f -> items = erealloc(f -> items, f -> capacity *sizeof f -> items[0]);
  }
  f -> items[f -> itemcount++] = item;
}

flexarray flexarray_new(){
  flexarray result = emalloc(sizeof *result);
  result -> capacity = 2;
  result -> itemcount = 0;
  result -> items = emalloc(result -> capacity * sizeof result -> items[0]);
  return result;
}

void flexarray_print(flexarray f){
  int i;
  for(i = 0; i < f -> itemcount; i++){
    fprintf(stderr, "%d\n", f -> items[i]);
  }
}

void flexarray_free(flexarray f){
  free(f -> items);
  free(f);
}

void flexarray_sort(flexarray f){
  insertion_sort(f -> items, f -> itemcount);

}
