#include <iostream>

using namespace std;

unsigned int reverseBits(unsigned int n) 
{ 
    unsigned int rev = 0, m = 31;
	    while(n)
	    {   
		    if(n & 1)
			    rev |= 1 << m;
		    n >>= 1;
		    m--;
	    }
	return rev;
} 
  
int main() 
{ 
    unsigned int x = 1; 
    cout << reverseBits(x) << endl;
    
    return 0;
}