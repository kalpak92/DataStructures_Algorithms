#include <stdio.h>
#include <string.h>
 
void myMemcpy(void* des, void* src, size_t n){
    char* csrc = (char *)src;
    char* cdest = (char *)des;
 
    for(int i=0; i<n; i++){
        cdest[i] = csrc[i];
    }
}
 
int main(void) {
    char csrc[] = "Kalpak Seal";
    char cdes[100];
 
    myMemcpy(cdes, csrc, strlen(csrc)+1);
    printf("The copied string is %s\n", cdes);
 
    int isrc[] = {10, 20, 30, 40, 50};
    int n = sizeof(isrc)/sizeof(isrc[0]);
    int idst[n];
 
    myMemcpy(idst, isrc, sizeof(isrc));
 
    printf("The copied array is: ");
    for (int i = 0; i < n; i++){
    	printf("%d ", idst[i]);
    }
    printf("\n");
 
	return 0;
}
