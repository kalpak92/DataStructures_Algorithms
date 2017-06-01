#include<stdio.h>
#define bool int
 
/* Function to check if x is power of 2*/
bool isPowerOfTwo (int x)
{
  /* First x in the below expression is for the case when x is 0 */
  return (x!=0) && ((x&(x-1)) == 0);
}
 
/*Driver program to test above function*/
int main()
{
	isPowerOfTwo(31)? printf("Yes\n"): printf("No\n");
	isPowerOfTwo(17)? printf("Yes\n"): printf("No\n");
	isPowerOfTwo(16)? printf("Yes\n"): printf("No\n");
	isPowerOfTwo(2)? printf("Yes\n"): printf("No\n");
	isPowerOfTwo(18)? printf("Yes\n"): printf("No\n");
	isPowerOfTwo(1)? printf("Yes\n"): printf("No\n");
  	return 0;
}