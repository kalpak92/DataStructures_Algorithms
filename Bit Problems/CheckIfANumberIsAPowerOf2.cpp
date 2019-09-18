#include <iostream>

using namespace std;

/* Function to check if x is power of 2*/
bool isPowerOfTwo (int x)
{
	/* First x in the below expression is for the case when x is 0 */
	return (x<=0) ? false : (x & (x - 1)) == 0;
}

int main()
{
	cout << isPowerOfTwo(21) << endl;
	return 0;
}

