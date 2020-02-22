/**
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. 
 * All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. 
 * 
 * Meanwhile, adjacent houses have security system connected and 
 * it will automatically contact the police if two adjacent houses were broken into on the same night.
 * 
 * Given a list of non-negative integers representing the amount of money of each house, 
 * determine the maximum amount of money you can rob tonight without alerting the police.
 * Example 1:
 * Input: [2,3,2]
 * Output: 3
 * Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2),
 *              because they are adjacent houses.
 * 
 * Example 2:
 * Input: [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 *              Total amount you can rob = 1 + 3 = 4.
 */

class Solution {
    public int rob(int[] nums) 
    {
        if(nums.length == 0) 
            return 0;
        if(nums.length == 1) 
            return nums[0];
        
        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }
    
    public int rob(int[] newNums, int start, int end) 
    {
        if (newNums.length == 0)
            return 0;
        
        int[] nums = Arrays.copyOfRange(newNums, start, end + 1);
        
        // If  there is 1 house, return the house itself.
        if(nums.length == 1)
            return nums[0];

        // If there are 2 houses, return the maximum of the two houses.
        if(nums.length == 2)
            return Math.max(nums[0], nums[1]);

        // Create the DP array.
        int[] dp = new int [nums.length];

        // The 1st two elements will be based on the same conditions as mentioned previously/
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for(int i = 2; i < dp.length; i++)
        {
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);   // Either rob the current house and the (i - 2)th house or the previous house.
        }

        return dp[nums.length - 1];
    }
}