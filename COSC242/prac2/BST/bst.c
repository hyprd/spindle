#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include "mylib.h"
#include "bst.h"

struct bstnode{
    char *key;
    bst left;
    bst right;
};

bst bst_free(bst b){
    if(b == NULL){
        return b;
    }
    b -> left = bst_free(b -> left);
    b -> right = bst_free(b -> right);
    free(b -> key);
    free(b);
    return b;
}

bst bst_new(){
    return NULL;
}

void bst_inorder(bst b, void f(char *str)){
    if(b = NULL){
        return;
    }
    bst_inorder(b -> left, f);
    f(b -> key);
    bst_inorder(b -> right, f);
}

bst bst_insert(bst b, char *str){
    if(b == NULL){
        b = emalloc(sizeof *b);
        b -> key = emalloc((strlen(str) + 1) * (sizeof(b -> key[0])));
        strcpy(b -> key, str);
        b -> left = NULL;
        b -> right = NULL;
        return b;
    } else if(strcmp(b -> key, str) < 0){
        b -> right = bst_insert(b -> right, str);
    } else if(strcmp(b -> key, str) > 0){
        b -> left = bst_insert(b -> left, str);
    }
    return b;
}

void bst_preorder(bst b, void f(char *str)){
    if(b == NULL){
        return;
    }
    f(b -> key);
    bst_preorder(b -> left, f);
    bst_preorder(b -> right, f);
}

int bst_search(bst b, char *str){
    if(b == NULL){
        return 0;
    }
    if(strcmp(b -> key, str) == 0){
        return 1;
    } else if(strcmp(b -> key, str) < 0){
        return bst_search(b -> right, str);
    } else if(strcmp(b -> key, str) > 0){
        return bst_search(b -> left, str);
    }
    return 0;
}
