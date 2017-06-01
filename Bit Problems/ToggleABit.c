#include <stdio.h>

int toggleABit(int n, int k){
	if (k <= 0)
		return n;

	return (n ^ (1 << (k - 1)));
}

int main(void){
	int n = 7;
	int k = 3;

	printf("%d\n", toggleABit(n, k));
	return 0;
}