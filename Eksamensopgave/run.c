/*
 * File:   main.c
 * Author: zentut.com
 * Description: Read text file line by line and output it to
 *			  the screen.
 */

/* http://www.zentut.com/c-tutorial/c-read-text-file/ */
 
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


	while()
	while (fgets(str, MAXCHAR, fp) != NULL)
		printf("%s", str);
	fclose(fp);
	return 0;
}