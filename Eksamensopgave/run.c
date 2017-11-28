/**
 * Sigvardsen_Tummas_20164825
 *
 * Imperative Programming (IMPR) (DAT1, SW1, IxD3) - AAL - EXAM
 * ----------------------------------------------
 * Name:  Tummas Jóhan Sigvardsen
 * Email: tsgiva16@students.aau.dk
 * Study number: 20164825
 * Study: Interaktionsdesign
 * ----------------------------------------------
 */
 
 
/* ---------------------------------------------------------------------------------------
Lav en funktion, som hvis man kigger alle runderne igennem, så hvis du kigger på rytternavnet,
og siger "dette har jeg ikke allerede" så vil jeg indsætte rytteren. Gør dette ved et loop.
1. Skal både tage hele mit race-array, og mit contestant-array og løbe igennem det.
2. Lave en funktion, der kan løbe igennem mit contestant-array, og se om der er flere med samme navn, og derefter merge dem sammen.
3. Hvis den ikke er tilføjet, så skal du have en funktion der gør det.
 ---------------------------------------------------------------------------------------*/
 
#include <stdlib.h>
#include <stdio.h>
#include <string.h>

#define MAX_EVENT_CHARACTERS 20
#define MAX_NAME_CHARACTERS 20
#define MAX_TEAM_CHARACTERS 4
#define MAX_NATION_CHARACTERS 4
#define MAX_POSITION_CHARACTERS 4
 
 
 
typedef struct race
{
    char event[MAX_EVENT_CHARACTERS];
    char firstName[MAX_NAME_CHARACTERS];
    char lastName[MAX_NAME_CHARACTERS];
    int age;
    char team[MAX_TEAM_CHARACTERS];
    char nation[MAX_NATION_CHARACTERS];
    char position[MAX_POSITION_CHARACTERS];
    int hours;
    int minutes;
    int seconds;
}race;
 
typedef struct contestant
{
    char firstName[MAX_NAME_CHARACTERS];
    char lastName[MAX_NAME_CHARACTERS];
    int age;
    char team[MAX_TEAM_CHARACTERS];
    char nation[MAX_TEAM_CHARACTERS];
    char position[MAX_POSITION_CHARACTERS];
    int points;
}contestant;
 
 
/* Prototypes */
int lines_counter(void);
int readFile(race* allResults);
void fillInContestantStruct(race*, int, contestant*);
void ridersUnder23(race*, int);


 
 
int main(int argc, char const *argv[])
{
    int lines_in_file = lines_counter();

    race allResults[lines_in_file];
    contestant allContestants[lines_in_file];
    int amountOfResults = readFile(allResults);
    ridersUnder23(allResults, amountOfResults);
    fillInContestantStruct(allResults, amountOfResults, allContestants);
    return 0;
}

int lines_counter(void){
    FILE *fp = fopen("cykelloeb-2017", "r");
    int countedLines = 0, ch = 0;
    while(!feof(fp)){
        ch = fgetc(fp);
        if(ch == '\n'){
            countedLines++;
        }
    }

    return countedLines;
}


 
int readFile(race* allResults) {
    int amountOfResults = 0;
    FILE *fp;
    char* filename = "cykelloeb-2017";
 
    fp = fopen(filename, "r");
    if (fp == NULL){
        printf("Could not open file %s",filename);
        return 1;
    }
 
    while(!feof(fp)){
 /*SKRIV TIL ANDERS */
    fscanf(fp, " %s %*c %s %[^\"]%*c %d %s %s %s %d:%d:%d",
        allResults[amountOfResults].event,
        allResults[amountOfResults].firstName,
        allResults[amountOfResults].lastName,
        &allResults[amountOfResults].age,
        allResults[amountOfResults].team,
        allResults[amountOfResults].nation,  
        allResults[amountOfResults].position,
        &allResults[amountOfResults].hours,
        &allResults[amountOfResults].minutes,
        &allResults[amountOfResults].seconds
        );
 
        amountOfResults++;
    }
 
    fclose(fp);
 
   // printf("%d ryttere.\n", amountOfResults);
 
    return amountOfResults;
}


/*
Cykelrytterne tildeles et antal point (et positivt heltal) ud fra deres deltagelse, og deres opnåede resultater,
i de cykelløb som indgår i datamaterialet. Her er reglerne for tildeling af points:

1. Deltagelse og gennemførelse i et cykelløb (indenfor eller uden for en evt. tidsgrænse) giver 2 point.
2. Hvis man gennemfører cykelløbet uden at overskride løbets tidsgrænse får man (M - P)/17 extra-point,
   hvor M er antallet af ryttere der har gennemført løbet (inden for tidsgrænsen) og P er rytterens placering i løbet.
3. Oven i dette får vinderen af et cykelløb 8 ekstra point, nummer to får 5 ekstra point, og nummer tre får 3 ekstra point.

*/

void fillInContestantStruct(race *allResults, int amountofResults, contestant *allContestants){
    int i = 0, comparePostion = 0;
    for(i = 0; i < amountofResults; i++) {
        allContestants[i].points = 0;
        strcpy(allContestants[i].firstName, allResults[i].firstName);
        strcpy(allContestants[i].lastName, allResults[i].lastName);
        allContestants[i].age = allResults[i].age;
        strcpy(allContestants[i].team, allResults[i].team);
        strcpy(allContestants[i].nation, allResults[i].nation);
        strcpy(allContestants[i].position, allResults[i].position);

/* 1. Deltagelse og gennemførelse i et cykelløb (indenfor eller uden for en evt. tidsgrænse) giver 2 point. */
    if(atoi(allContestants[i].position) != 0)
    {
        allContestants[i].points += 2;
        comparePostion = atoi(allContestants[i].position);
    }  

/* 2. Hvis man gennemfører cykelløbet uden at overskride løbets tidsgrænse får man (M - P)/17 extra-point,
      hvor M er antallet af ryttere der har gennemført løbet (inden for tidsgrænsen) og P er rytterens placering i løbet. */
    //Det ville være ok smart, at lave et double for-loop her, men det ville så også medføre, at
    //tiden bliver ekspotionelt mere.

//Pseudokode
    if (comparePostion == "OTL"){
            allContestants[i].points += 0;
    } else if (comparePostion == "DNF"){
            allContestants[i].points += 0;
    } else 
            loop through allContestants[i].position && allResults[amountOfResults].event. For each time
            you meet a new event register the name, and line number. Now go though all the positions
            of the event, and register the numbers of contestants that dont have OTL or DNF postions.
            Give all the contestants points (M-P)/17 where you have "M", which is the number of finished
            contestants and P which is the position where the contestant finished and.

/* 3. Oven i dette får vinderen af et cykelløb 8 ekstra point, nummer to får 5 ekstra point, og nummer tre får 3 ekstra point. */
        if(comparePostion == 1) {
            allContestants[i].points += 8;
        }
        if(comparePostion == 2) {
            allContestants[i].points += 5;
        }
        if(comparePostion == 3) {
            allContestants[i].points += 3;
        }
       
    if(strcmp(allContestants[i].position, "OTF")){
        printf("");
    }
   
   
    printf("%s %s %d %s %s %d\n", allContestants[i].firstName, allContestants[i].lastName, allContestants[i].age, allContestants[i].team, allContestants[i].nation, allContestants[i].points);
    }
}


/**
* ----------------------------------
*   OPGAVE 1:
*   Find og udskriv løbsresultaterne for alle belgiske cykelryttere under 23 år.
*   I denne opgave er det OK at lave en funktion som blot printer resultaterne direkte.
* ----------------------------------
**/
 
void ridersUnder23(race* allResults, int amountofResults){
    printf("\n OPGAVE 1\n \n");
 
    int i = 0;
    for(i = 0; i < amountofResults; i++) {
        if(strcmp(allResults[i].nation, "BEL") == 0 && allResults[i].age < 23)
        printf("%s %s %s %d %s %s %s %d:%d:%d \n",
            allResults[i].event,
            allResults[i].firstName,
            allResults[i].lastName,
            allResults[i].age,
            allResults[i].team,
            allResults[i].nation,  
            allResults[i].position,
            allResults[i].hours,
            allResults[i].minutes,
            allResults[i].seconds);
    else
        printf("");
   
}
}
 
/**
* ----------------------------------
*   OPGAVE 2:
*   Find og udskriv alle de danske ryttere, som har deltaget i et eller flere af de fire cykelløb.
*   Sorter primært disse efter de hold som de kører på. Hvis der er to danske ryttere på samme hold,
*   sorteres de sekundært alfabetisk efter fornavn. Også i denne opgave er det OK at lave en funktion som
*   blot printer resultaterne direkte.
* ----------------------------------
**/
 


/**
* ----------------------------------
*   OPGAVE 3:
*   Udskriv de 10 ryttere som har opnået flest point. Sorter primært rytterne efter antal point.
*   Ved pointlighed sorteres efter alder (den yngste først). Ved alderslighed sorteres
*   alfabetisk efter efternavnet. (Efternavnet er den del af rytterens navn som er skrevet med udelukkende store bogstaver).
* ----------------------------------
**/
 
/**
* ----------------------------------
*   OPGAVE 4:
*   Find for hvert af de fire løb det hold, der har flest ryttere med en placering angivet som OTL eller DNF.
* ----------------------------------
*/
 
/**
* ----------------------------------
*   OPGAVE 5:
*   Find den nation, der samlet set har begået sig bedst i de fire cykelløb.
*   Dette måles efter summen af points, som ryttere fra nationen har opnået i løbene.
*   (Hvis der er pointlighed mellem to eller flere nationer, er det op til dig at vælge én af disse).
* ----------------------------------
**/
 
/**
* ----------------------------------
*   OPGAVE 6:
*   Find i hvert af de fire cykelløb mediantiden af løbet. Mediantiden M af et bestemt cykelløb er den opnåede løbstid,
*   hvor halvdelen af løbstiderne er mindre end eller lig med M, og halvdelen af tiderne er større end eller lig med M.
*   Løbsresultater med en placering angivet som OTL eller DNF indgår ikke, når vi beregner mediantiden.
*   Hvis antallet af ryttere i et løb er lige ønsker vi at gruppen af ryttere med "en høj tid"
*   er én mindre end gruppen med "en lav tid", relativ til M).
* ----------------------------------

    **/
