#include <stdio.h>
#include <stdlib.h>
#include <math.h>


//INTERFACE
int analysis(double *prod, double *sum,  double d1, double d2);


//IMPLEMENTATION
/*
* QUESTION 1
* - The function computes the nearest integer not greater than d1 and the
* nearest integer not greater than d2 and stores the product of these integers
* in prod and their sum in sum.
* - The function returns 1 if d1 and d2 have the same sign and returns -1
*  if their sign is different. Recall that 0 has no sign, so, design your
* function by treating 0 as a number with a sign different from both a positive
* and a negative number.
*/
int analyse(double *prod, double *sum, double d1, double d2) {
  //must check if the signum of d1 and d2 is the same or different

  //floor of d1 and d2 and the values that exist at the address pointed to by prod and sum
  double floor_d1;
  double floor_d2;


  floor_d1  = floor(d1);
  floor_d2 = floor(d2);


  //calculates the product and the sum of the floor values of d1 and d2
  *prod  =  floor_d1 * floor_d2;
  *sum = floor_d1 + floor_d2;


  //returns -1 if signs are different and 1 if they're the same
  /*
  if((d1 > 0 && d2 > 0) || (d1 < 0 && d2 < 0) || (d1==0 && d2==0)) {
    return 1;
  } else {
    return -1;
  }
  */

  if(d1==0 && d2==0) {
    return 1;
  }

  if(*prod <= 0) {
    return -1;
  } else {
    return 1;
  }

}

  int main(void) {
    double* prod = malloc(sizeof(int));
    double* sum = malloc(sizeof(int));
    double d1, d2;
    d1 = 0;
    d2 = 0;
    printf("%d\n",analyse(prod,sum,d1,d2));
  }
