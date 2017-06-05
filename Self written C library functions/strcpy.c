#include <stdio.h>
 
void my_strcpy(char *dest, char *src){
	char* from = src;
	char* to = dest;
 
	while(*from != '\0'){
		*to = *from;
		to++;
		from++;
	}
	*to = '\0';
}
 
int main(void) {
	char dest[100];
	char src[] = "Kalpak Seal";
	my_strcpy(dest, src);
	printf("%s \n", dest);
	return 0;
}