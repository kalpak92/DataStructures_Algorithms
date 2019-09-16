/*
**  Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, 
**  find the one that is missing from the array.
**
**  Example 1:
**
**  Input: [3,0,1]
**  Output: 2
**  Example 2:
**
**  Input: [9,6,4,2,3,5,7,0,1]
**  Output: 8
*/
#include <iostream>
#include <vector>

using namespace std;

class Solution {
    public :
    int missingNumber(vector<int>& nums) {
        /*
            1) XOR all the array elements, let the result of XOR be X1.
            2) XOR all numbers from 1 to n, let XOR be X2.
            3) XOR of X1 and X2 gives the missing number.
        */
        int res = 0;
        
        for (int i = 0; i < nums.size(); i++){
            res ^= nums[i];
        }
        
        for (int i = 1; i <= nums.size(); i++) {
            res ^= i;
        }
        
        return res;
    }
};