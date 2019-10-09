#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define STRING_LEN 80
#define ARRAY_LEN 100

void *emalloc(size_t s){
    void *result = malloc(s);
    if (NULL == result){
        fprintf(stderr, "Memory allocation failed!\n");
        exit(EXIT_FAILURE);
    }
    return result;
}

void greater(char **words, int length, double av){
    if (length > 0){
        if(strlen(words[0]) > av){
            printf("%s\n", words[0]);
        }
        greater(words + 1, length - 1, av);
    }
}

int main (void){
    char *word_list[ARRAY_LEN];
    char word[STRING_LEN];
    double average = 0.0;
    int count = 0;
    int i;
    while(count < ARRAY_LEN && 1 == scanf("%79s", word)){
        word_list[count] = emalloc(strlen(word) + 1 * sizeof(word_list[0][0]));
        strcpy(word_list[count++], word);
        average += strlen(word);
    }
    average = average / count;
    if (count != 0){
        greater(word_list, count, average);
        fprintf(stderr, "%.2f\n", average);
    }

    for(i = 0; i < count; i++){
        free(word_list[i]);
    }
    return EXIT_SUCCESS;
}
