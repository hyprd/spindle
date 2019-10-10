#include <stdio.h> 
#include <stdlib.h> 
#include <string.h> 
#include "mylib.h"
#include "bst.h"

struct bstnode{
    char *key;
    bst right;
    bst left;
};


bst bst_free(bst b){
    b -> right = bst_free(b -> right);
    b -> left = bst_free(b -> left);
    free(b -> key);
    free(b);
    return NULL;
}

void bst_inorder(bst b, void f(char *str)){
    
    bst_inorder(b -> right, f);
    f(b -> key);
    bst_inorder(b -> left, f);
}
bst bst_insert(bst b, char *str){
    if(b == NULL){
        b = emalloc(sizeof *b);
        b -> key = emalloc(strlen(str) + 1 * sizeof(char));
        strcpy(b -> key, str);
        b -> right = NULL;
        b -> left = NULL;
    } else if(strcmp(b -> key, str ) < 0){
        b -> right = bst_insert(b -> right, str);
    } else{
        b -> left = bst_insert(b -> left, str);
    }
    return b;
}
bst bst_new(){
    return NULL;
}

void bst_preorder(bst b, void f(char *str)){
    f(b -> key);
    bst_preorder(b -> right, f);
    bst_preorder(b -> left, f);
}

int bst_search(bst b, char *key){
    if(strcmp(b -> key, key) == 0){
        return 1;
    } else if(strcmp(b -> key, key) < 0){
        return bst_search(b -> right, key);
    } else {
        return bst_search(b -> left, key);
    }
    return 0;
}

