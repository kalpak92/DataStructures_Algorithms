/* 
* Define the weight of a non-negative integer x to be the number of bits that are set to 1 in its binary representation.
* For ex: 92 in base 2 is 1011100. The weight of 92 is 4.
*
* Write a program which takes as input a non-negative integer x and returns a number y which is not equal to x
* but has the same weight as x and their difference is |y - x|, which is as small as possible.
* Assume x is not 0. 
* For ex: if x = 6, then output should be 5.
*
*
* ALGORITHM:
*
* We flip the bit at index k1 and k2 for k1 > k2. 
* Then the absolute difference between the original integer  and the new one is 2^k1 - 2^k2.
* To minimize this, we should take k1 as small as possible and k2 as close to k1.
*
* Now, we must preserve the weight, so the bit at index k1 has to be different from the bit in k2, 
* otherwise the flips lead to an integer with different weight.
* This means the samllest k1 can be the rightmost bit that's different from the LSB, and k2 must be the very next bit.
* So, the approach is to swap the two rightmost consecutive bits that differ.
*
*/

#include <iostream>

using namespace std;

const int numUnsignedBits = 64;

unsigned long closestIntegerSameBitCount(unsigned long x)
{
    for (int i = 0; i < numUnsignedBits -1; i++)
    {
        if (((x >> i) & 1) != ((x >> (i +1)) & 1))
        {
            unsigned long bitmask = (1L << i) | (1L << (i+1));
            x ^= bitmask;
            return x;
        }
    }

    throw invalid_argument("All the bits are 0 or 1");
}

int main()
{
    int x = 6;
    cout << "The closest integer with the same weight is " << closestIntegerSameBitCount(x) << endl;

    return 0;
}