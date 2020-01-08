/**
 * Your are given an array of positive integers nums.
 * Count and print the number of (contiguous) subarrays where the product of all the elements in the subarray is less than k.
 * 
 * Example 1:
 * Input: nums = [10, 5, 2, 6], k = 100
 * Output: 8
 * 
 * Explanation: The 8 subarrays that have product less than 100 are: [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6].
 * Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
 * 
 * Note:
 * 0 < nums.length <= 50000.
 * 0 < nums[i] < 1000.
 * 0 <= k < 10^6.
 */

class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        /**
        * The idea is always keep an max-product-window less than K;
        * Every time add a new number on the right(j), 
        * reduce numbers on the left(i), until the subarray product fit less than k again, (subarray could be empty);
        * Each step introduces x new subarrays, where x is the size of the current window (j + 1 - i);
        
        * Say now we have {1,2,3} and add {4} into it. Apparently, the new subarray introduced here are:
        * {1,2,3,4}, {2,3,4}, {3,4}, {4}, which is the number of elements in the new list.
        * If we also remove some at the left, say we we remove 1, then subarrays are:
        * {2,3,4}, {3,4}, {4}. It is easy to get the result is j - i + 1.
        */
        
        if (nums == null || nums.length == 0 || k == 0)
            return 0;
        
        int result = 0;
        int product = 1;
        
        for(int i = 0, j = 0; j < nums.length; j++)
        {
            product *= nums[j];
            
            while(i <= j && product >= k)
            {
                product /= nums[i];
                i++;
            }
            
            result += j - i + 1;
        }
        return result;
    }
}