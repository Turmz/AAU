/*
Aflevering nr. 1
Opgave 2.5
--
Sigvardsen_Tummas_20164825
--
Tummas Jóhan Sigvardsen,
Studie nr.: 20164825
*/

#include <stdio.h>

int main(void)
{

    //Her intiterceres variablerne
    int input, weeks, days, hours, minutes, seconds;
    

    //Her printes teksten, så brugeren kan forstå, hvad de skal.
    //Her har jeg valgt, ikke at lave et /n efter teksten, for at få det mere naturligt.
    printf("Skriv sekunder: ");

    //Denne funktion gør det muligt at skrive. 
    scanf("%d", &input);


    //Variablerne "weeks, days, hours, minutes, seconds" bliver definerede.
    weeks = (input/(60*60*24*7));
    days = (input/(60*60*24)) %7;
    hours = (input/(60*60)) %24;
    minutes = (input/60) %60;
    seconds = (input %60);

    //Denne funktion udskriver de indtastede variabler.
    printf("%d uger, %d dage, %d timer, %d minutter og %d sekunder.\n", weeks, days, hours, minutes, seconds);

    return 0;
}