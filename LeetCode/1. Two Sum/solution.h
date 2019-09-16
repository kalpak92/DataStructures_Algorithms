/*
**  Given an array of integers, return indices of the two numbers such that they add up to a specific target.
**
*   You may assume that each input would have exactly one solution, and you may not use the same element twice.
**
**  Example:
**
**  Given nums = [2, 7, 11, 15], target = 9,
**
**  Because nums[0] + nums[1] = 2 + 7 = 9,
**  return [0, 1].
*/

#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;

class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {

        /*
            1) Traverse the array one by one
            2) just put the `target - num[i]`(not `num[i]`) into the map
                so, when we checking the next num[i], if we found it is exisited in the map.
                which means we found the second one.
        */
        unordered_map<int, int> m;
        vector<int> result;

        for (int i = 0; i < nums.size(); i++)
        {
            if (m.find(nums[i]) != m.end())
            {
                result.push_back(m[nums[i]]);
                result.push_back(i);
            }
            else {
                m[target - nums[i]] = i;
            }
        }
        return result;
    }
};