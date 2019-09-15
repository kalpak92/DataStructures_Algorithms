#include <iostream>
#include <stdlib.h>

using namespace std;
/*
    XOR has the property of being associative as well as commutatuve, i.e the order in which we perform 
    the XORs dont change the result.
    The XOR of a group of bits is its parity.
    We exploit this fact to use the CPU's word level XOR instruction to process multiple bits at a time.
    
    Note that the leading bits are not meaningful and we have to explicitly extrract the result from the least-significant bit.
    
    The time complexity is O(log n), where n is the word size.
*/
short parity(unsigned long x)
{
    x ^= x >> 32;
    x ^= x >> 16;
    x ^= x >> 8;
    x ^= x >> 4;
    x ^= x >> 2;
    x ^= x >> 1;

    return  (x & 0x1);
}

int main(int argc, char* argv[])
{
    int x = strtol(argv[1], nullptr, 0);
    cout << "The parity of " << x << " is " << parity(x) << endl;
    return 0;
}