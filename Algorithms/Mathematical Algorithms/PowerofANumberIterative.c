#include <stdio.h>

/* Iterative Function to calculate (x^y) in O(log y) */
float power(int x, int y)
{
	float res = 1.0;	 // Initialize result
	float base = (float)x;
	int exp = y;
	
	if (y < 0)
	{
	    base = 1/(float)x;
	    exp = y * (-1);
	}
    
	while (exp > 0)
	{
		// If exp is odd, multiply base with result
		if (exp & 1)
		{
			res = res*base;
		}

		// exp must be even now
		exp = exp>>1; 
		base *= base; // Change base to base^2
	}
	return res;
}

int main(void){
    printf("%f \n", power(2, 2));
    return 0;
}
