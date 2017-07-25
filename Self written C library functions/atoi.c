#include <stdio.h>

// A simple atoi() function
int myAtoi(char *str)
{
	int res = 0; // Initialize result
    int i = 0;
	// Iterate through all characters of input string and
	// update result
	for(i = 0; str[i] != '\0'; ++i)
		res = res*10 + str[i] - '0';

	// return result.
	return res;
}

// Driver program to test above function
int main()
{
	char str[] = "89789";
	int val = myAtoi(str);
	printf ("%d ", val);
	return 0;
}
