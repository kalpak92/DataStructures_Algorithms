/**
 * You are given coins of different denominations and a total amount of money. 
 * Write a function to compute the number of combinations that make up that amount. 
 * 
 * You may assume that you have infinite number of each kind of coin.
 * 
 * Example 1:
 * Input: amount = 5, coins = [1, 2, 5]
 * Output: 4
 * Explanation: there are four ways to make up the amount:
 * 
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 * 
 * Example 2:
 * Input: amount = 3, coins = [2]
 * Output: 0
 * Explanation: the amount of 3 cannot be made up just with coins of 2.
 * 
 * Example 3:
 * Input: amount = 10, coins = [10] 
 * Output: 1
 * 
 * Note:
 * You can assume that
 * 0 <= amount <= 5000
 * 1 <= coin <= 5000
 * the number of coins is less than 500 the answer is guaranteed to fit into signed 32-bit integer
 */

class SolutionImproved {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        
        dp[0] = 1;
        
        // we use one dimensional array (since we dont need all the rows of the table; 
        // only the current row and the previous row is sufficient), 
        // then we can do this: 
        //      dp[i] = dp[i] + dp[i-coin] which is same as : dp[i] += dp[i-coin]. 
        // Also, since in the first solution we have j >= coins[i-1], we start the second iteration in the second solution from coin itself.
        
        // The key is "only the current row and the previous row is sufficient", thus in dp[i] = dp[i] + dp[i-coin], 
        // the first dp[i] means the "current row" and the second means the "last row".
        
        for(int coin: coins)
        {
            for(int i = coin; i <= amount; i++)
            {
                dp[i] = dp[i] + dp[i - coin];
            }
        }
        return dp[amount];
    }
} 