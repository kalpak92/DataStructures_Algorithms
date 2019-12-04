/**
 * You are given coins of different denominations and a total amount of money amount. 
 * Write a function to compute the fewest number of coins that you need to make up that amount. 
 * If that amount of money cannot be made up by any combination of the coins, return -1.
 * 
 * Example 1:
 * Input: coins = [1, 2, 5], amount = 11
 * Output: 3 
 * Explanation: 11 = 5 + 5 + 1
 * 
 * Example 2:
 * Input: coins = [2], amount = 3
 * Output: -1
 * 
 * Note:
 * You may assume that you have an infinite number of each kind of coin.
 */

class Solution {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        
        dp[0]  = 0;
        
        // Solve every subproblem from 1 to amount
        for(int i = 0; i <= amount; i++)
        {
            // For each coin we are given
            for(int j = 0; j < coins.length; j++)
            {
                // If it is less than or equal to the sub problem amount
                if(coins[j] <= i)
                {
                    // Check if it gives us a more optimal solution
                    dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
                }
                else
                    break;
            }
        }

        /*
            dp[amount] has our answer. If we do not have an answer then dp[amount]
            will be amount + 1 and hence dp[amount] > amount will be true. 
            We then return -1.
            
            Otherwise, dp[amount] holds the answer
        */
        return dp[amount] > amount ? -1 : dp[amount];
        
    }
}