// CPP program to swap even and odd bits of a given number.
#include <iostream>
using namespace std;

unsigned int swapBits(unsigned int x)
{
    // Get all even bits of x
    unsigned int even_bits = x & 0xAAAAAAAA;    // A stands for 10101010 in hex.
 
    // Get all odd bits of x
    unsigned int odd_bits  = x & 0x55555555;    // 5 stands for 01010101 in hex.
 
    even_bits >>= 1;  // Right shift even bits
    odd_bits <<= 1;   // Left shift odd bits
 
    return (even_bits | odd_bits); // Combine even and odd bits
}
 
// Driver program to test above function
int main()
{
    unsigned int x = 23; // 00010111
 
    // Output is 43 (00101011)
    cout << swapBits(x) << endl;
 
    return 0;
}