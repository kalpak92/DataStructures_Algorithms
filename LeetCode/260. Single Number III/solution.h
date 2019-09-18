/**************************************************************************************
*   Given an array of numbers nums, in which exactly two elements appear only once and 
*   all the other elements appear exactly twice. 
*   Find the two elements that appear only once.
*
*   Example:
*
*   Input:  [1,2,1,3,2,5]
*   Output: [3,5]
*   Note:
*
*   The order of the result is not important. So in the above example, [5, 3] is also correct.
*   Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
*
****************************************************************************************/

#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;

class Solution
{
    public:
        vector<int> singleNumber(vector<int>& nums)
        {
            unordered_map<int, int> table;
            vector<int> result;
            for(int i = 0; i < nums.size(); i++)
            {
                if(table.find(nums[i]) != table.end())
                {
                    table[nums[i]] += 1;
                }
                else {
                    table[nums[i]] = 1;
                }
            }
        
            for (auto i = table.begin(); i != table.end(); i++)
            {
                if( i->second == 1)
                    result.push_back(i->first);
            }
        

            return result;
        }
};
