/**
 * Given a non-empty array containing only positive integers, 
 * find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.
 * 
 * Note:
 * Each of the array element will not exceed 100.
 * The array size will not exceed 200.
 * 
 * Example 1:
 * Input: [1, 5, 11, 5]
 * Output: true
 * Explanation: The array can be partitioned as [1, 5, 5] and [11].
 * 
 * Example 2:
 * Input: [1, 2, 3, 5]
 * Output: false
 * Explanation: The array cannot be partitioned into equal sum subsets.
 */

class Solution {

    public boolean canPartitionImproved(int[] nums) {
        int target = 0;
        
        for(int i : nums)
            target += i;
        
        if((target & 1) == 1)
            return false;
        
        target /= 2;
        
        // Transition function for 1d solution
        //      dp[i] = dp[i] || dp[i - nums[i]];
        // 
        // dp[i] will depend on dp[i - nums[i]];
        // "i" always large than "i - nums[i]" , we can't have dp[i-nums] be calculated and overwrite before we do it for dp[i]
        // that's why the loop go from high to low.
        
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        
        for(int num: nums)
        {
            for(int i = target; i >= num; i--) 
            {     
                dp[i] = dp[i] || dp[i - num];
            }
        }
        return dp[target];
    }


    public boolean canPartition(int[] nums) {
        int target = 0;
        
        for(int i : nums)
            target += i;
        
        if((target & 1) == 1)
            return false;
        
        target /= 2;
        
        int n = nums.length;
        boolean[][] dp = new boolean[n+1][target + 1];
              
        dp[0][0] = true;
        
        // first column of the DP array is TRUE because we can make ZERO sum with an empty set
        for (int i = 1; i < n + 1; i++) 
        {
            dp[i][0] = true;
        }
        
        // Fill up the DP Array by putting dp[i-i][j] in dp[i][j] if num < sum
        // else decide between dp[i-1][j] || dp[i - 1][j - data[i]]
        
        for (int num = 1; num < n + 1; num++) 
        {
        for (int sum = 1; sum < target + 1; sum++) 
        {
            
            if (sum >= nums[num - 1]) 
            {
                dp[num][sum] = (dp[num - 1][sum] || dp[num - 1][sum -nums[num - 1]]);
            }
            else{
                dp[num][sum] = dp[num - 1][sum];
            }
        }
    }
   
    return dp[nums.length][target];
        
    }
}