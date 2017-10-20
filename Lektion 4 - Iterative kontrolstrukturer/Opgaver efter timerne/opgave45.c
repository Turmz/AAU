/*

Denne opgaver tager udgangspunkt i følgende udgave af Euclids algoritme, som vi har studeret nøje i denne lektion:

   // General condition loop - Euclid again

#include <stdio.h>

int main(void) {
  int i, j, small, large, remainder;
 
  printf("Enter two non-negative integers: ");
  scanf("%d %d", &i, &j);

  small = i <= j ? i : j;
  large = i <= j ? j : i;
  
  while (small > 0){
    remainder = large % small;
    large = small;
    small = remainder;
  }

  printf("GCD of %d and %d is %d\n\n", i, j, large);
  
  return 0;
}   

Hvad sker der hvis vi dropper ombytningen af i og j, og således risikerer at small bliver større end large i while-løkken? Her er en sådan version af programmet:

#include <stdio.h>

int main(void) {
  int a, b, i, j, remainder;
 
  printf("Enter two non-negative integers: ");
  scanf("%d %d", &a, &b);

  i = a; j = b;  // We don't know if i > j  
  while (j > 0){
    remainder = i % j;
    i = j;
    j = remainder;
  }

  printf("GCD of %d and %d is %d\n\n", a, b, i);
  
  return 0;
}   

Virker dette - hvorfor, eller hvorfor ikke?

*/

#include <stdio.h>

int main(void) {
  int a, b, i, j, remainder;
 
  printf("Enter two non-negative integers: ");
  scanf("%d %d", &a, &b);

  i = a; j = b;  /* We don't know if i > j */  
  while (j > 0){
    remainder = i % j;
    i = j;
    j = remainder;
  }

  printf("GCD of %d and %d is %d\n\n", a, b, i);
  
  return 0;
}  

/*

Den nye udgave virker. Her er programmet vi taler om:

#include <stdio.h>

int main(void) {
  int a, b, i, j, remainder;
 
  printf("Enter two non-negative integers: ");
  scanf("%d %d", &a, &b);

  i = a; j = b;  // We don't know if i > j  
  while (j > 0){
    remainder = i % j;
    i = j;
    j = remainder;
  }

  printf("GCD of %d and %d is %d\n\n", a, b, i);
  
  return 0;
}   

Hvis j > i lige før while-løkken, vil de tre sætninger i kroppen af løkken:

     remainder = i % j;
     i = j;
     j = remainder;

være ækvivalete med:

     remainder = i;
     i = j;
     j = remainder;

altså en ombytning af i og j. Undervejs i løkken vil i være større end (eller lig med) j.

/*