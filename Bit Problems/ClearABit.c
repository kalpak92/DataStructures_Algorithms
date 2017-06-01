#include <stdio.h>

int clearABit(int n, int k){
	if (k <= 0)
		return n;

	return (n & ~(1 << (k - 1)));
}

int main(void){
	int n = 15;
	int k = 3;

	printf("%d\n", clearABit(n, k));
	return 0;
}