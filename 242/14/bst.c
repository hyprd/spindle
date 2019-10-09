#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct bst_node{
    char *key;
    bst left;
    bst right;
};

void bst_delete(bst b, char *str){
    /* Stopping case */
    if (b == NULL){
        return 0;
    }
    /* If the key is greater than the key at the current node - delete key from RIGHT subtree */
    else if(strcmp(str, b -> key) > 0){
        b -> right = bst_delete(b -> right, str);     
    }
    /* If the key is less than the key at the current node - delete key from LEFT subtree */
    else if(strcmp(str, b -> key) < 0){
        b -> left = bst_delete(b -> left, str);
    }
    /* Node splice cases */
    else{
        /* If the node is a leaf, set the node pointer to NULL */
        if(b -> left == NULL && b -> right == NULL){
            free(b -> key);
            free(b);
            b = NULL;            
        }
        /* If the node has one child, set pointer to the child. Free key and free node*/
        else if(b -> left == NULL){
            free(b -> key);
            free(b);
            b = b -> right

        } else if(b -> right == NULL){
            free(b -> key);
            free(b);
            b = b -> left;

        }
        else{

        }
    }
}

void bst_inorder(bst b, void f(char *str)){
    /* Stopping case */
    if (b == NULL){
        return 0;
    }
    /* Traverse left subtree */
    bst_inorder(b -> left, f));
    /* Apply to key */
    f(b -> key);
    /* Traverse left subtree */
    bst_inorder(b -> right, f);
}

bst bst_free(bst b){

}


void bst_new(){
    return NULL;
}

bst bst_insert(bst b, char *key){
    /* Stopping case */
    if(b == NULL){
        return 0;
    }
    /* If the key arg is greater than the key at the current node, insert key arg into LEFT subtree */
    if(strcmp(b -> key, key) > 0){
        b -> left  = bst_insert(b -> left, key);
    }
    /* If the key arg is less than the key at the curent node, insert key arg into RIGHT subtree */
    if(strcmp(b -> key, key) < 0){
        b -> right = bst_insert(b -> right, key);
    }
    return key;

}

void bst_search(bst b, char *str){
    /* Stopping case */
    if(b -> key == NULL){
        return 0;
    }
    /* If the key arg is the same as the current node, return 1 to signify that the node was found */
    if(strcmp(b -> key, key) == 0){
        return 1;
    }
    /* if the key arg is less than the current node, search the RIGHT subtree */
    else if(strcmp(b -> key, key) < 0){
        return bst_search(b -> right, key);

    }
    /* If the key arg is greater than the current node, search the LEFT subtree */
    else if(strcmp(b -> key, key) > 0){
        return bst_search(b -> left, key);
    }

}

void bst_preorder(bst b, void f(char *str)){
    /* Stopping case */
    if (b == NULL){
        return 0;
    }
    /* Apply function to key */
    f(b -> key);
    /* Preorder traverse LEFT subtree */
    bst_preorder(b -> left, f);
    /* Preorder traverse RIGHT subtree */
    bst_preorder(b -> right, f);
}
