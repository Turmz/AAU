/*
Aflevering nr. 2
Opgave 3.4
--
Sigvardsen_Tummas_20164825
--
Tummas Jóhan Sigvardsen,
Studien r.: 20164825
*/

#include <stdio.h>
#define HOURS MINUTES*SECONDS
#define MINUTES 60
#define SECONDS 60



int main(void)
{

    //Her intiterceres variablerne
    int input, hours, minutes, seconds;
    

    //Her printes teksten, så brugeren kan forstå, hvad de skal.
    //Her har jeg valgt, ikke at lave et /n efter teksten, for at få det mere naturligt.
    printf("Skriv sekunder: ");

    //Denne funktion gør det muligt at skrive. 
    scanf("%d", &input);


    //Variablerne "weeks, days, hours, minutes, seconds" bliver definerede.
    hours = (input/(HOURS)) %24;
    minutes = (input/MINUTES) %60;
    seconds = (input %SECONDS);

    printf("%d sekunder svarer til ", input);
    
    if (hours == 1)
    	    //Denne funktion udskriver de indtastede variabler.
	    printf(" %d time", hours);  
    else if(hours > 1) 
    	printf(" %d timer", hours);


    if (input %HOURS == 0)
    	    //Denne funktion udskriver de indtastede variabler.
	    printf(".\n");  
    else if (hours > 0)
    	printf(", ");


    if (minutes == 1)
    	    //Denne funktion udskriver de indtastede variabler.
	    printf("%d minut", minutes);  
    else if(minutes > 1)
    	printf("%d minutter", minutes);


    if (minutes >= 1)
    	    //Denne funktion udskriver de indtastede variabler.
	    printf(" og ", minutes);  
    else
    	printf("");


    if (seconds == 1)
    	    //Denne funktion udskriver de indtastede variabler.
	    printf("%d sekund.\n", seconds);  
    else if (seconds > 1)
    	 printf("%d sekunder.\n", seconds);

    return 0;
}