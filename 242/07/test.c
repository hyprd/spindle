#include <string.h>
#include <stdio.h>
#include <stdlib.h>

#define ARRAY_MAX 100
#define STR_LEN 80

void *emalloc(size_t s){
    void *result = malloc(s);
    if(NULL == result){
        fprintf(stderr, "Memory allocation failed!\n");
        exit(EXIT_FAILURE);
    }
    return result;

}

void greater(char **words, int length, double average){
    if (length > 0){
        if(strlen(words[0]) > average){
            printf("%s\n", words[0]);
           
        }
        greater(words + 1, length - 1, average);
    }
}

int main(void){
    int i;
    int count = 0;
    char *word_list[ARRAY_MAX];
    char word[STR_LEN];
    double average = 0.0;
    while(count < ARRAY_MAX && 1 == scanf("%79s", word)){
        word_list[count] = emalloc(strlen(word) + 1 * sizeof word_list[0][0]);
        strcpy(word_list[count++], word);
        average += strlen(word);
    }
    average = average / count;
    if(count != 0){
        greater(word_list, count, average);
        fprintf(stderr, "%.2f\n", average);
    }
    for(i = 0; i < count; i++){
        free(word_list[i]);
    }
    return EXIT_SUCCESS;
}
