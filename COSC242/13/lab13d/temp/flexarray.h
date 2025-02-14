#ifndef FLEXARRAY_H_
#define FLEXARRAY_H_

typedef struct flexarrayrec *flexarray;
extern void flexarray_append(flexarray f, int item);
extern void flexarray_sort(flexarray f);
extern void flexarray_print(flexarray f);
extern void flexarray_free(flexarray f);
flexarray flexarray_new();

#endif
