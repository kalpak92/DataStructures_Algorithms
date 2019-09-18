/*
**  Given a positive integer, output its complement number. 
**  The complement strategy is to flip the bits of its binary representation.
**
**  Note:
**  The given integer is guaranteed to fit within the range of a 32-bit signed integer.
**  You could assume no leading zero bit in the integer’s binary representation.
**  Example 1:
**  Input: 5
**  Output: 2
**  Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.
**  Example 2:
**  Input: 1
**  Output: 0
**  Explanation: The binary representation of 1 is 1 (no leading zero bits), and its complement is 0. So you need to output 0.
*/
#include <iostream>

using namespace std;

class Solution
{
    public:
    /*
    *   We need to flip each bit, but the starting position of the flip starts from the highest bit of 1, 
    *   and the front 0 cannot be flipped.
    *   So we go from high to low traversal, if the first one is encountered, our flag is assigned to true, 
    *   and then it can be flipped.
    */
    int findComplement(int num)
    {
        if (num == 1)
            return 0;

        bool flag = false;

        for (int i = 31; i >= 0; i--)
        {
            if(num & (1 << i))
                flag = true;
            if(flag)
                num ^= (1 << i);
        }
        return num;
    }
};