#include <stdio.h>

unsigned int getMultiplyBySeven(unsigned int n){
	return ((n << 3) - n);
}

int main(void)
{
	unsigned int n = 4;
	printf("%u\n", getMultiplyBySeven(n));
	return 0;
}