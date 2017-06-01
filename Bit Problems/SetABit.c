#include <stdio.h>

int setABit(int n, int k){
	if (k <= 0)
		return n;

	return (n | (1 << (k - 1)));
}

int main(void){
	int n = 9;
	int k = 3;

	printf("%d\n", setABit(n, k));
	return 0;
}