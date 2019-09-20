#include <stdio.h>

 
int my_strcmp(char* a, char* b){
	return (*a == *b && *a == '\0') ? 0 : (*a == *b) ? my_strcmp(++a, ++b) : 1;

}
 
int main(void) {
	char *a = "Kalpak Seal";
	char *b = "Kalpak Seal";
 
	if (my_strcmp(a, b) == 0){
		printf("Strings are identical");
	}
	else{
		printf("Strings are not identical");
	}
	return 0;
}
