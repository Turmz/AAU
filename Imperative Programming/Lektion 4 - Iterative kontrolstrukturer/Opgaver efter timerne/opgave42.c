/*

I denne opgave gives tre positive heltal m, n og k, hvor k er større end 1.
Skriv et program der adderer alle heltal mellem m og n (begge inklusive) hvor i k går op.

Eksempler:

    Hvis m er 5, n er 13 og k er 3 er resultatet 6 + 9 + 12 = 27.
    Hvis m er 5, n er 10 og k er 5 er resultatet 5 + 10 = 15.
    Hvis m er 10, n er 5 og k er 3 ønsker vi at resultatet er 0, idet m er større end n.

Denne opgave stammer fra bogen C by Dissection - anvendt med tilladelse fra forlaget.

*/

#include <stdio.h>

int main(void){

  int k, m, n, i, sum = 0;

  printf("Enter two integers m an n.\n");
  scanf("%d %d", &m, &n);

  printf("Enter an integer k greater than 1.\n");
  scanf("%d", &k);

  for(i=m; i<=n; i++){
    if (i % k == 0){
      sum += i;
    }
  }

  printf("Sum of numbers between %d and %d that are divisible by %d: %d \n", m, n, k, sum);
 
  return 0;
}