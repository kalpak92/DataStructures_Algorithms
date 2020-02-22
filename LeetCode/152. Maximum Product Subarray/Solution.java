/**
 * Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.
 * 
 * Example 1:
 * Input: [2,3,-2,4]
 * Output: 6
 * 
 * Explanation: [2,3] has the largest product 6.
 * 
 * Example 2:
 * Input: [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 */

class Solution {
    public int maxProduct(int[] nums) {
        if(nums == null | nums.length == 0)
            return 0;
        
        /**
        * There are 3 choices to make:
        * 1. Current number is a positive number
        *       Then prev_max_prod * curr_num gives the maximum product till now.
        *
        * 2. Current number is a negative number
        *       Then consider the case when prev_min_prod * curr_num gives the maximum product till now.
        *
        * 3. Current number is the Starting Position
        * 
        * So, keep track of the maximum and the minimum product and check accordingly.
        * Update the result with the maximum of the result or the maximum product till now.
        *
        */
        
        int[] maxProd = new int[nums.length];
        int[] minProd = new int[nums.length];
        
        maxProd[0] = nums[0];
        minProd[0] = nums[0];
        
        int result = nums[0];
        
        for(int i = 1; i < nums.length; i++)
        {
            maxProd[i] = Math.max( Math.max(maxProd[i - 1] * nums[i], minProd[i - 1] * nums[i]), nums[i]);
            minProd[i] = Math.min( Math.min(maxProd[i - 1] * nums[i], minProd[i - 1] * nums[i]), nums[i]);
            
            result = Math.max(result, maxProd[i]);
        }
        
        return result;
    }
}