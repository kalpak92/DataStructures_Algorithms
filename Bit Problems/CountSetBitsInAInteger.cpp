#include <iostream>

using namespace std;
 
/* Function to get no of set bits in binary
   representation of passed binary no. */

//Kernighan Algorithm

unsigned int countSetBits(int n)
{
    unsigned int count = 0;
    while (n)
    {
      n &= (n-1) ; //clears the lowest set bit in n.
      count++;
    }
    return count;
}
 
/* Program to test function countSetBits */
int main()
{
  int i = 15;
  int y = countSetBits(i);
  cout << (i^y) << endl;
  
  return 0;
}