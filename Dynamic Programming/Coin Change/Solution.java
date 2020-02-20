/**
 * You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 * Example 1:
 * Input: coins = [1, 2, 5], amount = 11
 * Output: 3 
 * 
 * Explanation: 11 = 5 + 5 + 1
 * 
 * Example 2:
 * Input: coins = [2], amount = 3
 * Output: -1
 * 
 * Note:
 * You may assume that you have an infinite number of each kind of coin.
 */
 import java.util.*;
 
 public class Solution
 {
    public static int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1); // fill the array with some maximum value (random)
        
        dp[0]  = 0; // smallest sub problem.
        
        // go all the way to the amount including it. Here 'i' represents how many cents we are trying to make.
        for(int i = 0; i <= amount; i++) 
        {
            for(int j = 0; j < coins.length; j++)
            {
                if(coins[j] <= i)   // check if the coin we are about to check is less than the amount 'i'. This is inherently the subproblem.
                {
                    // 1 corresponds to the current coin and then we try to get the rest from the subproblem 
                    // which is found by subtracting the amount of the coin j from the amount i and accessing the memoized array.
                    dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]); 
                }
                else
                    break;  // optimisation by sorting the coins array before, stop looping.
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

    public static void main(String[] args)
    {
        int[] coins = {2, 5, 8};

        System.out.println(coinChange(coins, 40));
    }
 }
