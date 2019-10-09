#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "mylib.h"
#include "rbt.h"

#define IS_BLACK(x) ((NULL == (x)) || (BLACK == (x) -> colour))
#define IS_RED(x) ((NULL != (x)) && (RED == (x) -> colour))

struct rbt_node{
    char *key;
    rbt_colour colour;
    rbt left;
    rbt right;
};

static rbt right_rotate(rbt r){
    rbt temp = r;
    r = r -> left;
    temp -> left = r -> right;
    r -> right = temp;
    return r;
}

static rbt left_rotate(rbt r){
    rbt temp = r;
    r = r -> right;
    temp -> right = r -> left;
    r -> left = temp;
    return r;

}

static rbt rbt_fix(rbt r){
    /* A & A's left child */
    if(IS_RED(r -> left) && IS_RED(r -> left -> left)){
        /* If other child (right) is RED*/
        if(IS_RED(r -> right)){
            r -> colour = RED;
            r -> left -> colour = BLACK;
            r -> right -> colour = BLACK;
        /* If other child (right) is BLACK */  
        } else{
            r = right_rotate(r);
            r -> colour = BLACK;
            r -> right -> colour = RED;
        }
    }
    /* A & A's right child */
    else if(IS_RED(r -> left) && IS_RED(r -> left -> right)){
        /* If other child (left) is RED */
        if(IS_RED(r -> left)){
            r -> colour = RED;
            r -> left -> colour = BLACK;
            r -> right -> colour = BLACK;
        /* If other child (left) is BLACK */    
        } else{
            r -> left  = left_rotate(r -> left);
            r = right_rotate(r);
            r -> colour = BLACK;
            r -> right -> colour = RED;           
        }
    }
    /* B & B's left child */
    else if (IS_RED(r -> right) && IS_RED(r -> right -> left)){
        /* If other child (left) is RED */
        if(IS_RED(r -> left)){
            r -> colour = RED;
            r -> right -> colour = BLACK;
            r -> left -> colour = BLACK;
        /* If other child (left) is BLACK */
        } else{
            r -> right = right_rotate(r -> right);
            r = left_rotate(r);
            r -> colour = BLACK;
            r -> left -> colour = RED;
        }
    }
    /* B & B's right child*/
    else if(IS_RED(r -> right) && IS_RED(r -> right -> right)){
        /* If other child (right) is RED */
        if(IS_RED(r -> left)){
            r -> colour = RED;
            r -> left -> colour = BLACK;
            r -> right -> colour = BLACK;
        } else{
            r = left_rotate(r);
            r -> colour = BLACK;
            r -> left -> colour = RED;
        }
    }
    return r;
}


rbt rbt_delete(rbt r, char *str){
    if(r == NULL || rbt_search(r, str) == 0){
        return r;
    } else if(strcmp(str, r -> key) < 0){
        r -> left = rbt_delete(r -> left, str);
    } else if(strcmp(str, r -> key) > 0){
        r -> right = rbt_delete(r -> right, str);
    }else{
        if(r -> left == NULL && r -> right == NULL){
            free(r -> key);
            free(r);
            r = NULL;
        } else if(r -> left == NULL){
            free(r -> key);
            free(r);
            r = r -> right;
        } else if(r -> right == NULL){
            free(r -> key);
            free(r);
            r = r -> left;
        } else{
            rbt copy = r -> right;
            char *temp;
            while(copy -> left != NULL){
                copy = copy -> left;
            }
            temp = r -> key;
            r -> key = copy -> key;
            copy -> key = temp;
            r -> right = rbt_delete(r -> right, temp);
        }
    }
    return r;
}

void rbt_inorder(rbt r, void f(char *key)){
    if(r == NULL){
        return;
    }
    rbt_inorder(r -> left, f);
    f(r -> key);
    rbt_inorder(r -> right, f);
}

void rbt_preorder(rbt r, void f(char *key)){
    if(r == NULL){
        return;
    }
    f(r -> key);
    rbt_preorder(r -> left, f);
    rbt_preorder(r -> right, f);
}

rbt rbt_new(rbt r){
    r = emalloc(sizeof(struct rbt_node));
    r -> key = NULL;
    r -> left = NULL;
    r -> right = NULL;
    r -> colour = RED;
    return r;
}

rbt rbt_insert(rbt r, char *key){
    if (r == NULL){        
        r = rbt_new(r);
    }
    if(r -> key == NULL){
        r -> key = emalloc(sizeof(char) * (strlen(key) + 1));
        strcpy(r -> key, key);
        return r;
    }
    else if(strcmp(r -> key, key) > 0){
        r -> left = rbt_insert(r -> left, key);
    }
    else if(strcmp(r -> key, key) < 0){
        r -> right = rbt_insert(r -> right, key);
    }
    r = rbt_fix(r); 
    return r;
}

rbt rbt_free(rbt r){
    if (r == NULL){
        return r;
    }
    rbt_free(r -> right);
    rbt_free(r -> left);
    free(r -> key);
    free(r);
    return r;
}

int rbt_search(rbt r, char *key){
    if(r  == NULL){        
        return 0;
    }
    if(strcmp(r -> key, key) == 0){
        printf("Key was found\n");
        return 1;     
    } else if(strcmp(r -> key, key) < 0){
        printf("< 0\n");
        return rbt_search(r -> right, key);
    } else if(strcmp(r -> key, key) > 0){
        printf("> 0\n");
        return rbt_search(r -> left, key);
    }
    return 0;
}

int main (void){
    printf("Creating tree...\n");
    rbt r = rbt_new(r);
    printf("Success\nInserting 8 into tree...\n");
    rbt_insert(r, "8");
    printf("Success\nSearching for key in the tree...\n");
    rbt_search(r, "8");
    printf("Freeing memory...\n");
    rbt_free(r);
    printf("Success\nEnd of program\n");
    return EXIT_SUCCESS;
    
}
