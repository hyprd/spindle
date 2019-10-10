#include <stdio.h>
#include <stdlib.h>

void foo(){
    printf("Doing foo\n");

}

void bar(){
    printf("Doing bar\n");

}

void baz(void f()){
    f();

}

int main (void){
    baz(foo);
    baz(bar);
    return EXIT_SUCCESS;

}
