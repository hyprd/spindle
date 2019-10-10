#include <stdio.h>
#include <stdlib.h>
#include <math.h>
int main(void){
    /* variable declarations */
    int i = 0;
    int f = 0;
    int g = 1;
    int store = 0;

    /* a familiar for loop */
    for (i = 0; i < 40; i++){
        printf("%8d ", g);
        store = g;
        g += f;
        f = store;
        if(i % 5 == 0){
            printf("\n");
        }                
    }
    return EXIT_SUCCESS; /* defined in stdlib.h */
}
