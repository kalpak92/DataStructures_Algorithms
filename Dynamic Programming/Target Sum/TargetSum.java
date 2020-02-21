/**
 * You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. 
 * Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.
 * 
 * Find out how many ways to assign symbols to make sum of integers equal to target S.
 *
 *  Example 1:
 * Input: nums is [1, 1, 1, 1, 1], S is 3. 
 * Output: 5
 * 
 * Explanation: 
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 * 
 * There are 5 ways to assign symbols to make the sum of nums be target 3.
 * 
 * Note:
 * The length of the given array is positive and will not exceed 20.
 * The sum of elements in the given array will not exceed 1000.
 * Your output answer is guaranteed to be fitted in a 32-bit integer.
 */

class TargetSum {
    // Let p,n  be the sums of numbers with positive and negative symbols, respectively. 
    // Let sum = p + n.
    // p - n = target
    // p - n + 2n = target + 2n
    // p + n = target + 2n
    // n = (p + n -  target) / 2
    // n = (sum - target) / 2
    // Similaryly, p = (sum + target) / 2
    //
    // So the problem is to find a subset P of nums such that sum(p) = {sum(nums) + target) / 2}
    
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        // Calculate the sum of the numbers
        for(int num : nums)
            sum += num;
        
        return (sum < S || ((sum + S) % 2) != 0) ? 0 : subsetSum(nums, (S + sum) >>> 1);
    }

    /*
    let's start with int[][] dp = new int[nums.length][s + 1] 
    where dp is 2-d array with dp[i][j] means number of ways to get sum j with first i elements from nums.

    Then you have the transition dp[i][j] = dp[i-1][j] + dp[i][j-nums[i]], 
        i.e. you can get the sum j either by just repeating all the ways to get sum j by using first i-1 elements, or add nums[i] on top of each way to get sum j-nums[i] using first i elements
    */
    
    public int subsetSum(int[] nums, int target)
    {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        
        for(int num : nums)
        {
            for(int i = target; i >= num; i--)
            {
                dp[i] = dp[i] + dp[i - num];
            }
        }
        
        return dp[target];
    }

    public static void main(String[] args)
    {
        TargetSum ts = new TargetSum();

        int[] arr = {1,1,1,1,1};
        int target = 3;

        System.out.println(ts.findTargetSumWays(arr, target));
    }
}