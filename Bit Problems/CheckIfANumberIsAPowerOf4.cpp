#include<iostream>
using namespace std;
 
bool isPowerOfFour(unsigned int n)
{
  int count = 0;
  
  // sanity check
  if (n <= 0)
    return false;
    
  /*Check if there is only one bit set in n*/
  if ( n && !(n&(n-1)) )
  {
     /* count 0 bits before set bit */
     while(n > 1)
     {
       n  >>= 1;
       count += 1;
     }      
 
    /*If count is even then return true else false*/
    return (count%2 == 0)? true :false;
  }
 
  /* If there are more than 1 bit set
    then n is not a power of 4*/
  return false;
}    
 
/*Driver program to test above function*/
int main()
{
   int test_no = 32;
   if(isPowerOfFour(test_no))
     printf("%d is a power of 4", test_no);
   else
     printf("%d is not a power of 4", test_no);
   getchar();
}