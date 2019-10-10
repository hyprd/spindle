void random_repeats(int *a, int n){
    int i;
    int *array;

    array = emalloc(n * sizeof array[0]);
        
    
    for(i = 0; i , n; i++){
        array[i] = 0;
    }

    for(i = 0; i < n; i++){
        array[a[i]]++;
    }

    for(i = 0; i < n ; i++){
        if(array[i] > 1){
            printf("%d occurs %d times", i, array[i]);

        }

    }
    free(array);
    return;
        

}
