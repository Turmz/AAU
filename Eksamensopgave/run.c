/*
 * File:   main.c
 * Author: zentut.com
 * Description: Read text file line by line and output it to
 *            the screen.
 */

/* http://www.zentut.com/c-tutorial/c-read-text-file/ */
 

/*
#include <stdio.h>
 
#define MAXCHAR 110
int main() {
    FILE *fp;
    char buffer[MAXCHAR];
    char* filename = "cykelloeb-2017";
    char* lineFormat = "%s\n";

    fp = fopen(filename, "r");
    if (fp == NULL){
        printf("Could not open file %s",filename);
        return 1;
    }

    while (fgets(str, MAXCHAR, fp) != NULL)
        printf("%s", str);
    fclose(fp);
    return 0;
}
*/

/*eNum*/
/* Boolean sum default setur til FALSE, so um teir ikki eru DNF so bara FALSE. */

typedef struct 
{
    *biker biker;
    int positon;
    time time;

}event;

typedef struct
{
    *nation nation;
    int age;
    *team team;

}biker;


typedef struct 
{
    *biker bikers;
    char name[4];      
}team;

typedef struct 
{
   *biker bikers;
    char name[4];  
}nation;

typedef struct 
{
   int hours;
   int minutes;
   int seconds;

}time;


typedef struct 
{
    *event results;
    char* name;

}race;







// race.bikerRes.biker.nation
// nation.time.bikers