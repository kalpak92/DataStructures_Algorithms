/***********************************************************************************************************
* 
* Given an array of integers, every element appears three times except for one. Find that single one.
* 
* Note:
* Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
* 
* Example 1:
*
* Input: [2,2,3,2]
* Output: 3
* 
* Example 2:
*
* Input: [0,1,0,1,0,1,99]
* Output: 99
*               
*************************************************************************************************************/

#include <iostream>
#include <vector>
using namespace std;

class Solution
{
    public:
    /*
    ** The general idea of this problem, is to consider all the numbers bit by bit, count the occurrence of '1' in each bit. 
    ** To get the result, check if the number can be divided by 3 (mod 3 = 0), put '0' if true and '1' otherwise.
    */

   int singleNumber(vector<int>& nums) {
        // Use an array of 32 length to count the the bits for all of numbers.
        int c[32] = {0};
        int result = 0;

        // Because the same number appear 3 times, which means the sum of i-th bits for all numbers should be 3 times.
        for (int i = 0; i < 32; i++)
        {
            for (int j =0; j < nums.size(); j++)
            {
                if ((nums[j] >> i) & 1)
                {
                    c[i]++;
                }
            }
            //Sum of the i-th bits mod 3, it must be 0 or 1. 1 means that is the single number bit.
            if (c[i] % 3 == 0)
                result = result | (0 << i);
            else
                result = result | (1 << i);
        }
        
        return result;
    }

};