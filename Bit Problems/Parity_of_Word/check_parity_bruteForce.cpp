#include <iostream>
#include <stdlib.h>  // to use strtol function
using namespace std;

/*
    The Brute Force Algorithm iteratively tests the value of each bit while tracking the number of 1s seen so far.
    Since we only care if the number of 1s is even or odd, we cab store the number modulo 2.
*/

short parity(unsigned long x)
{
    short result = 0;
    while (x)
    {
        result += (x & 1);
        x >>= 1;
    }
    return result % 2;
}

int main(int argc, char* argv[])
{
    int x = strtol(argv[1], nullptr, 0);
    cout << "The Parity of the number is " << parity(x) << endl;

    return 0;
}