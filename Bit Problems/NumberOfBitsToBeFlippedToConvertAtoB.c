#include <stdio.h>

unsigned int countSetBits(int n)
{
    unsigned int count = 0;
    while (n)
    {
      n &= (n-1) ;
      count++;
    }
    return count;
}

int main(void) {
    int a = 8;
    int b = 15;
    
    int c = a ^ b;
    
    printf("%d ", countSetBits(c));
	return 0;
}
