// A simple program to count set bits in all numbers from 1 to n.
#include <stdio.h>
 
// A utility function to count set bits in a number x
unsigned int countSetBitsUtil(unsigned int x);
 
// Returns count of set bits present in all numbers from 1 to n
unsigned int countSetBits(unsigned int n)
{
    int bitCount = 0; // initialize the result
 
    for(int i = 1; i <= n; i++)
       bitCount += countSetBitsUtil(i);
 
    return bitCount;
}
 
// A utility function to count set bits in a number x
unsigned int countSetBitsUtil(unsigned int n)
{
    unsigned int count = 0;
    while (n)
    {
      n &= (n-1) ;
      count++;
    }
    return count;
}
 
// Driver program to test above functions
int main()
{
   int n = 8;
   printf ("Total set bit count is %d", countSetBits(n));
   return 0;
}