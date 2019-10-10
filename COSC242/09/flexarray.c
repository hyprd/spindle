#include <stdio.h>
#include <stdlib.h>
#include "mylib.h"
#include "flexarray.h"

struct flexarrayrec{
    int capacity;
    int itemcount;
    int *items;
};

void merge(int *a, int *w, int length){
    int p = 0, i = 0;
    int j = (length / 2);
    
    while(i < (length/2) && j < length){
        if(a[i] < a[j]){
            *(w+p) = *(a+i);
            i++;
        } else{
            *(w+p) = *(a+j);
            j++;
        }
        p++;
    }
    while(i < (length/2)){
        w[p] = a[i];
        i++;
        p++;
    }

    while(j < length){
        w[p] = a[j];
        j++;
        p++;
    }
}

void merge_sort(int *a, int *w, int n){
    int i;
    if (n < 2){
        return;
    }
    merge_sort(a,w,(n/2));
    merge_sort(a+(n/2), w, n-(n/2));
    merge(a,w,n);

    
    for(i = 0; i < n; i++){
        *(a+i) = *(w+i);
    }

}



flexarray flexarray_new(){    
    flexarray result = emalloc(sizeof *result);
    result->capacity = 2;
    result->itemcount = 0;
    result->items = emalloc(result->capacity * sizeof result ->items[0]);
    return result;                          
}

void flexarray_append(flexarray f, int num){
    if (f->itemcount == f->capacity){
        f-> capacity += f->capacity;
        f->items = erealloc(f->items, f->capacity *sizeof f[0]);
    }
    f->items[f->itemcount++] = num;
}

void flexarray_print(flexarray f){
    int i;
    for(i = 0; i < f->itemcount; i++){
        printf("%d\n", f->items);

void flexarray_sort(flexarray f){
    int *ws;
    ws = emalloc(f->itemcount * sizeof f[0]);
    merge_sort(f->items, ws, f->itemcount);
    free(ws);
}

void flexarray_free(flexarray f){
    free(f->items);
    free(f);

}

int main(void){
    int item;
    flexarray array = flexarray_new();
    while(1 == scanf("%d", &item)){
        flexarray_append(array, item);
    }
    
    flexarray_sort(array);
    flexarray_print(array);
    flexarray_free(array);
    return EXIT_SUCCESS;

}





