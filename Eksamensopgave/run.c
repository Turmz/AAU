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
/*
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
*/
// RÆTTA ANSI FEILIR


#include <stdlib.h>
#include <stdio.h>
#define MAXCHAR_FILE 110


typedef struct 
{
    char event[20];
    char contestant[20];
    int age;
    char team[4];
    char nation[4];
    char numberFinished[4];
    int hours;
    int minutes;
    int seconds;

}race;



/* Prototypes */
int readFile();


int main(int argc, char const *argv[])
{
    readFile();
    return 0;
}

int readFile() {
    FILE *fp;
    char* filename = "cykelloeb-2017";

    fp = fopen(filename, "r");
    if (fp == NULL){
        printf("Could not open file %s",filename);
        return 1;
    }

    int input;
    input = fscanf(fp, "%s %s %d %s %s %d %d %d %d",
        &event,
        &contestant,
        &age,
        &team,
        &nation,
        &numberFinished,
        &hours,
        &minutes,
        &seconds
    );

    return input;
}

/*  HANDLE DATA
   fscanf(fp, "%s %s %s %d", str1, str2, str3, &year);
   
   printf("Read String1 |%s|\n", str1 );
   printf("Read String2 |%s|\n", str2 );
   printf("Read String3 |%s|\n", str3 );
   printf("Read Integer |%d|\n", year );

   https://www.tutorialspoint.com/c_standard_library/c_function_fscanf.htm

*/