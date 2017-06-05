#include <stdio.h>
 
char* my_strncpy(char* dest, char* src, int n){
	char* temp = dest;
 
	while(n--){
		*dest++ = *src++;
	}
 
	*dest = '\0';
	return temp;
}
int main(void) {
	char a[50]= "Kalpak Seal";
	char b[50];
 
	my_strncpy(b, a, 4);
 
	printf("The copied string is: %s", b);
	return 0;
}
 
