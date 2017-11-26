
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

// RÆTTA ANSI FEILIR


#include <stdlib.h>
#include <stdio.h>
#include <string.h>


typedef struct 
{
    char event[20];
    char firstName[20];
    char lastName[20];
    int age;
    char team[4];
    char nation[4];
    char numberFinished[4];
    int hours;
    int minutes;
    int seconds;

}Race;



/* Prototypes */
int readFile();


int main(int argc, char const *argv[])
{
    readFile(); 

    return 0;
}

int readFile() {

    Race raceStruct;
    FILE *fp;
    char* filename = "cykelloeb-2017";

    fp = fopen(filename, "r");
    if (fp == NULL){
        printf("Could not open file %s",filename);
        return 1;
    }

    fscanf(fp, " %s %*c %s %[^\"]%*c %d %s %s %s %d:%d:%d",
        raceStruct.event,
        raceStruct.firstName,
        raceStruct.lastName,
        &raceStruct.age, 
        raceStruct.team, 
        raceStruct.nation,  
        raceStruct.numberFinished, 
        &raceStruct.hours,
        &raceStruct.minutes, 
        &raceStruct.seconds
        );

    printf("%s %s %s %d %s %s %s %d:%d:%d", 
        raceStruct.event,
        raceStruct.firstName,
        raceStruct.lastName,
        raceStruct.age, 
        raceStruct.team, 
        raceStruct.nation,  
        raceStruct.numberFinished, 
        raceStruct.hours,
        raceStruct.minutes, 
        raceStruct.seconds
        );

    return 0;
}