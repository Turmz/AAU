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
 
#include <stdlib.h>
#include <stdio.h>
#include <string.h>

#define MAX_EVENT_CHARACTERS 30
#define MAX_NAME_CHARACTERS 30
#define MAX_TEAM_CHARACTERS 4
#define MAX_NATION_CHARACTERS 4
#define MAX_POSITION_CHARACTERS 4
#define MAX_TIME 10
 
 
typedef struct race
{
    char event[MAX_EVENT_CHARACTERS];
    char firstName[MAX_NAME_CHARACTERS];
    char lastName[MAX_NAME_CHARACTERS];
    int age;
    char team[MAX_TEAM_CHARACTERS];
    char nation[MAX_NATION_CHARACTERS];
    char position[MAX_POSITION_CHARACTERS];
    char time[MAX_TIME];
}race;
 
typedef struct contestant
{
    char firstName[MAX_NAME_CHARACTERS];
    char lastName[MAX_NAME_CHARACTERS];
    int age;
    char team[MAX_TEAM_CHARACTERS];
    char nation[MAX_TEAM_CHARACTERS];
    int points;
}contestant;
 
 
/* Prototypes */
int lines_counter(void);
int readFile(race* allResults);
void fillInContestantStruct(race*, int, contestant*);
void pointsOne(race*, int, contestant*);
void pointsTwo(race*, int, contestant*);
void pointsThree(race*, int, contestant*);
    /* Assignment 1 */
    void contestantsFromBelgiumUnder23(race*, int);
    /* Assignment 2 */
    int checkIfDuplicate(contestant*, char*, char*, int);
    void contestantsFromDenmark(race*, int, contestant*, contestant*);
    int sortTeamsOfDanishContestants(const void *a, const void *b);
    int sortNamesOfDanishContestants(contestant*, contestant*);
    /* Assignment 3 */
    void topTenContestants(race*, int, contestant*);
    void sortTopTenContestants(contestant*, int);
    int compareTopTenContestants(const void *c, const void *d);



/* Main funtion */
int main(int argc, char const *argv[])
{
    int lines_in_file = lines_counter();

    race allResults[lines_in_file];
    contestant allContestants[lines_in_file];
    contestant danishContestants[lines_in_file];
    int amountOfResults = readFile(allResults);
    fillInContestantStruct(allResults, amountOfResults, allContestants);

    /* Assignments where points were established. */
    pointsOne(allResults, amountOfResults, allContestants);
    pointsTwo(allResults, amountOfResults, allContestants);
    pointsThree(allResults, amountOfResults, allContestants);
    
    /* Menu system for the assignments. */
    int userInput();    
    int input = 1;

    while(input){
    input = userInput();

        switch(input)
        {
        case 1:
            system("clear");    /* Unix */
            system("cls");      /* Windows */
            printf("ASSIGNMENT 1 \n \n");   
            contestantsFromBelgiumUnder23(allResults, amountOfResults);
        break;

        case 2:
            system("clear");    /* Unix */
            system("cls");      /* Windows */   
            printf("ASSIGNMENT 2 \n \n");   
            contestantsFromDenmark(allResults, amountOfResults, allContestants, danishContestants);
        break;

        case 3:
            system("clear");    /* Unix */
            system("cls");      /* Windows */
            printf("ASSIGNMENT 3 \n \n");   
            topTenContestants(allResults, amountOfResults, allContestants);
        break;

        case 4:
            system("clear");    /* Unix */
            system("cls");      /* Windows */
            printf("ASSIGNMENT 4 \n \n");   
            printf("Assignment not finished.\n");
        break;

        case 5:
            system("clear");    /* Unix */
            system("cls");      /* Windows */
            printf("ASSIGNMENT 5 \n \n");   
            printf("Assignment not finished.\n");
        break;

        case 6:
            system("clear");    /* Unix */
            system("cls");      /* Windows */
            printf("ASSIGNMENT 6 \n \n");   
            printf("Assignment not finished.\n");
        break;

        default:
            system("clear");    /* Unix */
            system("cls");      /* Windows */
            printf("Not a valid selection!\n");
            }

        }
    return 0;
}

/* Function to print out the text for the menu system. */
int userInput()
  {
    int choice;
        printf("\n");
        printf("\n");
        printf("|----------------------------|\n");
        printf("|                            |\n");        
        printf("|   (1) :    Assignment 1    |\n");
        printf("|   (2) :    Assignment 2    |\n");
        printf("|   (3) :    Assignment 3    |\n");
        printf("|   (4) :    Assignment 4    |\n");
        printf("|   (5) :    Assignment 5    |\n");
        printf("|   (6) :    Assignment 6    |\n");
        printf("|                            |\n");          
        printf("|----------------------------|\n"); 
        printf("\n");
        printf("\n");
        printf("Enter your desired assignment: ");
        scanf("%d", &choice);
        printf("\n");
    return choice;
  }

/* Function to count lines from file. */
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


/* Function reads file, and fills "race" struct. */ 
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

    fscanf(fp," %s %*c %s %[^\"]%*c %d %s %s %s %s ",
        allResults[amountOfResults].event,
        allResults[amountOfResults].firstName,
        allResults[amountOfResults].lastName,
        &allResults[amountOfResults].age,
        allResults[amountOfResults].team,
        allResults[amountOfResults].nation,  
        allResults[amountOfResults].position,
        allResults[amountOfResults].time
        );
 
        amountOfResults++;
    }
 
/* Function converts the contestants time from a string to an integer,
 * and the returns it as a string. This is done to prevent problems,
 * if a contestant for example gets the result "DND" and therefore "0" time,
 * and not the standard "XX:XX:XX" format.
 */
    int convertSeconds(char *time){

        int seconds = 0;
        int minutes = 0;
        int hours = 0;

        sscanf(time, " %d:%d:%d", &hours, &minutes, &seconds);

        return (hours * 3600) + (minutes * 60) + seconds;
    } 
    fclose(fp);
 
    return amountOfResults;
}

/* Function reads from "race"-struct and fills "contestant" struct. */ 
void fillInContestantStruct(race *allResults, int amountofResults, contestant *allContestants){
    int i = 0;
    for(i = 0; i < amountofResults; i++) {
        allContestants[i].points = 0;
        strcpy(allContestants[i].firstName, allResults[i].firstName);
        strcpy(allContestants[i].lastName, allResults[i].lastName);
        allContestants[i].age = allResults[i].age;
        strcpy(allContestants[i].team, allResults[i].team);
        strcpy(allContestants[i].nation, allResults[i].nation);
    }
}



/**
* ----------------------------------
*   1. Deltagelse og gennemførelse i et cykelløb (indenfor eller uden for en evt. tidsgrænse) giver 2 point. 
* ----------------------------------
**/
void pointsOne(race* allResults, int amountofResults, contestant* allContestants){

    int comparePosition = 0;
    for(int i = 0; i <= amountofResults; i++){
        if(!(strcmp(allResults[i].position, "DNF") == 0))
        {
            allContestants[i].points += 2;
            comparePosition = atoi(allResults[i].position);
        } 
    }
}

/**
* ----------------------------------
*   2. Hvis man gennemfører cykelløbet uden at overskride løbets tidsgrænse får man (M - P)/17 extra-point,
*      hvor M er antallet af ryttere der har gennemført løbet (inden for tidsgrænsen) og P er rytterens placering i løbet.
* ----------------------------------
**/
void pointsTwo(race* allResults, int amountofResults, contestant* allContestants){

    int countedLines = lines_counter();
    int m = 0; // antallet af ryttere der har gennemført løbet
    for (int i = 0; i < countedLines; i++){
        if (!(strcmp(allResults[i].position, "OTL") == 0 || strcmp(allResults[i].position, "DNF") == 0 ))
        {
            m += 1;
        }   
    } 
    for(int j = 0; j < countedLines; j++){
        allContestants[j].points += (m - atoi(allResults[j].position))/17;

    }
}


/**
* ----------------------------------
*   3. Oven i dette får vinderen af et cykelløb 8 ekstra point, nummer to får 5 ekstra point, og nummer tre får 3 ekstra point.
* ----------------------------------
**/
void pointsThree(race* allResults, int amountofResults, contestant* allContestants){
    int comparePosition = 0;
    
    for(int i = 0; i <= amountofResults; i++){
        comparePosition = atoi(allResults[i].position);

    if(comparePosition == 1) {
        allContestants[i].points += 8;
        }
    if(comparePosition == 2) {
        allContestants[i].points += 5;
        }
    if(comparePosition == 3) {
        allContestants[i].points += 3;
        }
       
    if(strcmp(allResults[i].position, "OTL")){
        printf("");
        }
    }    
}



/**
* ----------------------------------
*   OPGAVE 1:
*   Find og udskriv løbsresultaterne for alle belgiske cykelryttere under 23 år.
*   I denne opgave er det OK at lave en funktion som blot printer resultaterne direkte.
* ----------------------------------
**/
/* Function solves "OPGAVE 1". */
void contestantsFromBelgiumUnder23(race* allResults, int amountofResults){
    int i = 0;
    for(i = 0; i <= amountofResults; i++) {
        if(strcmp(allResults[i].nation, "BEL") == 0 && allResults[i].age < 23){
        printf("%s %s %s %d %s %s %s %s \n",
            allResults[i].event,
            allResults[i].firstName,
            allResults[i].lastName,
            allResults[i].age,
            allResults[i].team,
            allResults[i].nation,  
            allResults[i].position,
            allResults[i].time);    
        }

    else {
        printf("");
    }
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
/* Function checks if there are duplicates in the array */
int checkIfDuplicate(contestant* allContestants, char* contestantFirstName, char* contestantLastName, int count){
    int i;
    for(i = 0; i < count; i++){
         if((strcmp(allContestants[i].firstName, contestantFirstName) == 0) &&
            (strcmp(allContestants[i].lastName, contestantLastName) == 0)){
            return 0;
        }         
    }
    return 1;
}

/* Function solves "OPGAVE 2". */
void contestantsFromDenmark(race* allResults, int amountOfResults, contestant* allContestants, contestant *danishContestants){ 
    int countedLines = lines_counter();
    int i = 0;
    int j = 0;
    for(i; i <= amountOfResults; i++) {
        if(checkIfDuplicate(allContestants, allContestants[i].firstName, allContestants[i].lastName, i)){
            if(strcmp(allResults[i].nation, "DEN") == 0){
                strcpy(danishContestants[j].firstName, allContestants[i].firstName);
                strcpy(danishContestants[j].lastName, allContestants[i].lastName);
                strcpy(danishContestants[j].team, allContestants[i].team);
                strcpy(danishContestants[j].nation, allContestants[i].nation);
                j++;      
            }      
       }
    } 
    qsort(danishContestants, j, sizeof(contestant), sortTeamsOfDanishContestants);
    for(i = 0; i < j; i++) {
            printf("%s %s (%s) %s\n",
            danishContestants[i].firstName,
            danishContestants[i].lastName,
            danishContestants[i].team,
            danishContestants[i].nation);
    }
} 

/* Function sorts the teams */
int sortTeamsOfDanishContestants(const void *a, const void *b){
   contestant *contestant_a = (contestant *)a, *contestant_b = (contestant *)b;
   if(strcmp(contestant_a -> team, contestant_b -> team)){
        return strcmp (contestant_a -> team, contestant_b -> team);
   }
    else {
        return sortNamesOfDanishContestants(contestant_a, contestant_b); 
    }
}

/* Function sorts contestants name */
int sortNamesOfDanishContestants(contestant* contestant_a, contestant* contestant_b){ 
    return strcmp(contestant_a -> firstName, contestant_b -> firstName); 
}



/**
* ----------------------------------
*   OPGAVE 3:
*   Udskriv de 10 ryttere som har opnået flest point. Sorter primært rytterne efter antal point.
*   Ved pointlighed sorteres efter alder (den yngste først). Ved alderslighed sorteres
*   alfabetisk efter efternavnet. (Efternavnet er den del af rytterens navn som er skrevet med udelukkende store bogstaver).
* ----------------------------------
**/
/* Function solves "OPGAVE 3". */
void topTenContestants(race* allResults, int amountofResults, contestant* allContestants){
    int i = 0;
    int j= 0;
    sortTopTenContestants(allContestants, amountofResults);
    for(i = 0; j < 10; i++){
        if (checkIfDuplicate(allContestants, allContestants[i].firstName, allContestants[i].lastName, i)){
            j++;
        printf("%s %s, age %d, %d points.\n",
            allContestants[i].firstName,
            allContestants[i].lastName,
            allContestants[i].age,
            allContestants[i].points);
        }
    }
}

/* Function sorts the top ten contestants */
void sortTopTenContestants(contestant *allContestants, int amountOfResults){
    int i = 0;
    qsort(allContestants, amountOfResults, sizeof(contestant), compareTopTenContestants);
}

/* Function sorts the top ten contestants by age and points*/
int compareTopTenContestants(const void *c, const void *d){
    contestant *contestant_c = (contestant*)c, *contestant_d = (contestant* )d;
    int points = 0, age = 0;

    points = (contestant_d -> points - contestant_c -> points);
        if(points == 0){

    age = (contestant_c -> age - contestant_d -> age );
        if(age == 0){
            return (strcmp(contestant_c -> firstName, contestant_d -> firstName) &&
                strcmp(contestant_c -> lastName, contestant_d -> lastName));
        }
        else {
            return age;
        }
    }
        else {
            return points;
    }
}



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
