/*
Aflevering nr. 3
Opgave 4.6
--
Sigvardsen_Tummas_20164825
--
Tummas Jóhan Sigvardsen,
Studienr.: 20164825

-------------------------------------
I denne lektion har vi set at der findes fine, smarte, og effektive algoritmer til at finde den største fælles divisor af to positive heltal. Se her.

I denne opgave skal du skrive et ligefrem program, der på en simpel og intuitiv måde finder den største fælles divisor af to ikke-negative heltal a og b.
Programmet skal på en systematisk måde - med brug af en løkke - afprøve om forskellig, nøje udvalgte tal er divisorer i både a og b.
Overvej omhyggeligt hvordan løkken starter, og hvordan den slutter. Programmet skal finde den største sådanne divisor: altså største fælles divisor.
Overvej også om der er nogle specialtilfælde vi skal tage os af, inden vi starter løkken?

Programmet skal naturligvis indlæse de to heltal.
Organiser programmet således at det gentager "største fælles divisor testen" indtil et af de indlæste tal er negativ.
Denne organisering er bekvemt, fordi vi på denne måde ikke skal genstarte programmet for at afprøve flere par af inputværdier.

Overvej nøje, hvilke iterative kontrolstrukturer du vil anvende i dette program.

*/

#include <stdio.h>

int main(void) {
  int i, j, small, large, n, gcd_result;
 
  printf("Enter two non-negative integers: ");
  scanf("%d %d", &i, &j);

  small = i <= j ? i : j;
  large = i <= j ? j : i;

  if (small == 0 && large == 0)
    printf("We cannot find gcd in case both inputs are zero\n");
  else if (small == 0)
    printf("GCD of 0 and %d is %d\n", large, large);
  else /* small > 0 && large > 0 */  {
    gcd_result = 1;   /* One is always a common divisor */ 
    for(n = small; n >= 2; --n){
      printf("%d\n", n);
      if (small % n == 0 && large % n == 0){  /* n is greatest common divisor */
         gcd_result = n;
         break;
      }
    }
    printf("GCD of %d and %d is %d\n", large, small, gcd_result);
  }
  
  return 0;
}   
