#include <stdio.h>

// A simple atoi() function
int myAtoi(char *str)
{
	int res = 0; // Initialize result
	int sign = 1; // Initialize sign as positive
	int i = 0; // Initialize index of first digit
	
	// If number is negative, then update sign
	if (str[0] == '-')
	{
		sign = -1; 
		i++; // Also update index of first digit
	}
	
	// Iterate through all digits and update the result
	for (; str[i] != '\0'; ++i)
		res = res*10 + str[i] - '0';
	
	// Return result with sign
	return sign*res;
}

// Driver program to test above function
int main()
{
	char str[] = "-123";
	int val = myAtoi(str);
	printf ("%d ", val);
	return 0;
}
