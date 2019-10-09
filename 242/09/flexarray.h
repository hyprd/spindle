#ifndef FLEXARRAY_H_
#define FLEXARRAY_H_

typedef struct flexarrayrec *flexarray;

static void merge(int *a, int *w, int length);
static void merge_sort(int *a, int *w, int n);
extern void flexarray_append(flexarray f, int item);
extern void flexarray_free(flexarray f);
extern flexarray flexarray_new();
extern void flexarray_print(flexarray f);
extern void flexarray_sort(flexarray f);

#endif

