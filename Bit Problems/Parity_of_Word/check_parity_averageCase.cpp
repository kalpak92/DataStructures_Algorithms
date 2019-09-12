#include <iostream>
#include <stdlib.h>

using namespace std;

// Improves performance in best and average case.
// The time complexity is O(k) with k being the no. of set bits in a number.

short parity (unsigned long x)
{
    int result = 0;
    while (x)
    {
        result ^= 1;
        x = x & (x - 1); // erases the lowest set bit in a word in a single operation.
    }

    return result;
}

int main(int argc, char* argv[])
{
    int x = strtol(argv[1], nullptr, 0);
    cout << "The parity of " << x << " is " << parity(x) << endl;
    return 0;
}