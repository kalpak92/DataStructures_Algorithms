#include <iostream>

using namespace std;

long SwapBits(int x, int i, int j)
{
    // Extract the ith and jth bits, and check if they differ
    if (((x >> i) & 1) != ((x >> j) & j))
    {
        // ith and jth bits differ. We will swap them by flipping their values.
        // Since x ^ 1 = 1 for x = 0 and x ^ 1 = 0 for x = 1, we create the bitMask accordingly.
        // Time complexity : O(1)
        
        unsigned long bitMask = (1L << i) | (1L << j);
        x ^= bitMask;
    }

    return x;
}

int main()
{
    int x  = 124;
    
    cout << "The number " << x << " with bits reversed at position 2 and 7 is " << SwapBits(x, 2,7) << endl;
    return 0; 
}