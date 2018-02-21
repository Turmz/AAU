/*

Forklar hvad der udskrives af følgende program. Hvor mange gange udføres kroppen af while-løkken? Forudsig først resultatet, og kør dernæst programmet.

#include <stdio.h>
int main(void){
   int i = 0, power = 1;

   while (++i <= 10)
      printf("%5d", power *= 2);
   printf("\n");

   return 0;
}

++i tæller i en op og power *= 2 fordobler power. Men vær sikker på at du forstår værdierne af de to udtryk ++i og power *= 2.

Hvad sker der hvis ++i erstattes af i++?

Det viste program er skrevet i typisk, koncis C-stil, og er på denne måde en typisk repræsentant for den programmeringsstil, som dyrkes af mange C programmører.

Omskriv programmet (stadig med brug af en while-løkke) således at assignments (ala *=) og increments (++) kun har en effekt på variable, men uden direkte at anvende værdierne af disse udtryk, som det er gjort i ovenstående program.

Det er også interessant at omskrive programmet, så det bruger en for-løkke i stedet for en while-løkke. Prøv dette!

Vurder selv hvilken udgave af programmet du foretrækker.

*/


#include <stdio.h>
int main(void){
   int i = 0, power = 1;

   for (i = 0; i <= 9; i++)
      printf("%5d", power *= 2);
   printf("\n");

   return 0;
}


/*

Programmet giver følgende output:

    2    4    8   16   32   64  128  256  512 1024

Kroppen af while-løkken udføres altså 10 gange.

Hvis ++i ertattes af i++ udskrives en ekstra potens af 2:

    2    4    8   16   32   64  128  256  512 1024 2048

Hvorfor? Fordi ++i starter med at tælle i op inden der sammenlignes med 10. i++ returnerer værdien af i til sammenligning med 10, inden optælling.

Programmet i opgaven:

#include <stdio.h>
int main(void){
   int i = 0, power = 1;

   while (++i <= 10)
      printf("%5d", power *= 2);
   printf("\n");

   return 0;
}

er svært at forstå, primært på grund af incrementet af variablen i i det logiske udtryk i while-løkken.

Her er det omskrevne program, som adskiller assignments fra udtryk:

#include <stdio.h>
int main(void){
   int i = 1, power = 1;

   while (i <= 10){
      power = power * 2;
      printf("%5d", power);
      i++;
   }
   printf("\n");

   return 0;
}

Dette program er - efter min bedste overbevisning - et bedre program end det fra opgaveteksten.

Programmet kan også skrives med brug af en for-løkke, hvor for-løkken både kontrollerer variablene i og power:

#include <stdio.h>
int main(void){
   int i, power;

   for(i = 1, power = 2; i <= 10; i++, power *= 2)
      printf("%5d", power);
   printf("\n");

   return 0;
}

Bemærk brugen af kommaet i udtrykket, som indgår i initialiserings-delen af for-løkken. I C er , en operator, med lavest mulig prioritet. x,y er et udtryk på lige fod med x+y. Værdien af udtrykket x,y er y.   x er altså kun nyttig i forhold den sideeffekt den har (typisk på variable).

*/