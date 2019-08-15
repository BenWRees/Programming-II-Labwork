#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef int* CHECKARR;

//INTERFACE
CHECKARR checkNEW(int N);
int checkSTORE(CHECKARR as, int N, int row, int col, int val);
int checkFETCH(CHECKARR as, int N, int row, int col);


//IMPLEMENTATION
/*
* This function must create a new checkered array of size NxN. In the definition
* of the function you must explicitly use malloc (and NOT calloc) to allocate
* the exact amount of memory that is required to store the array.
* Think carefully about how to use malloc and about how much memory you are allocating.
*/
CHECKARR checkNEW(int N) {
  CHECKARR array;
  if(N<=0) {
    fprintf(stderr, "N is negative \n");
     exit(0);
  }
  if(N>0) {}
    array = (CHECKARR) malloc((1+(N*N)) * sizeof(int)/2);
    if(array == NULL) {
      fprintf(stderr, "out of memory\n");
      exit(0);
    }
    memset(array,0,((1+(N*N))*sizeof(int))/2);
    return array;
}


/*
* This function must store an integer value val at position (row, col) of a
* checkered array of size NxN. The definition must take into account possible
* errors. The function must return -1 for any errors, and must return 1 otherwise.
*/

int checkSTORE(CHECKARR as, int N, int row, int col, int val) {
  if(row > N || col > N || 0 > row || 0 > col) {
    fprintf(stderr, "either row or column value is out of boound \n");
    return -1;
  }

  if(N<=0) {
    fprintf(stderr, "N is negative \n");
    return -1;
  }

  if(row%2 != col%2) {
    fprintf(stderr, "Cannot move to a square with different parity");
    return -1;
  }

  if(as == NULL) {
    fprintf(stderr, "Array does not exist \n");
    return -1;
  }



  *(as+(((row*N)+col)/2)) = val;
  return 1;
}


/*
* This function must fetch and return the value stored at position (row, col)
* in a checkered array of size NxN. The function must return -1 for any errors.
*/

int checkFETCH(CHECKARR as, int N, int row, int col) {
  if(row > N || col > N || 0 > row || 0 > col) {
    fprintf(stderr, "either row or column value is out of boound \n");
    return -1;
  }
  if(row%2 != col%2) {
    fprintf(stderr, "Cannot move to a square with different parity");
    return -1;
  }
  if(as == NULL) {
    fprintf(stderr, "Array does not exist \n");
    return -1;
  }

  if(N<=0) {
    fprintf(stderr, "N is negative \n");
    return -1;
  }

  //work out right index
  return *(as+(((row*N)+col)/2));

}
