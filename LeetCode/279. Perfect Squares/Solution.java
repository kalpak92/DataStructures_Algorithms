/**
 * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
 * 
 * Example 1:
 * Input: n = 12
 * Output: 3 
 * Explanation: 12 = 4 + 4 + 4.
 * 
 * Example 2:
 * Input: n = 13
 * Output: 2
 * Explanation: 13 = 4 + 9.
 */

 /**
  * numSquares(n) = min(numSquares(n-k) + 1) ∀ k ∈ {square numbers}
  *
  * Algorithm:
  * We create a fictional element dp[0]=0 to simplify the logic, which helps in the case that the remainder (n-k) happens to be a square number.
  * As an additional preparation step, we pre-calculate a list of square numbers (i.e. square_nums) that is less than the given number n.
  * As the main step, we then loop from the number 1 to n, to calculate the solution for each number i (i.e. numSquares(i)). 
  *     At each iteration, we keep the result of numSquares(i) in dp[i], while resuing the previous results stored in the array.
  *
  * At the end of the loop, we then return the last element in the array as the result of the solution.
  */

class Solution {
    // Slightly Improved solution
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        
        for (int i = 1; i <= n; i++) 
        {
            int sqrt = (int)Math.sqrt(i);

            // If the number is already a perfect square,
            // then dp[number] can be 1 directly. This is
            // just a optimization for this DP solution.
            if (sqrt * sqrt == i) {
                dp[i] = 1;
                continue;                
            }

            // To get the value of dp[n], we should choose the min
            // value from:
            //     dp[n - 1] + 1,
            //     dp[n - 4] + 1,
            //     dp[n - 9] + 1,
            //     dp[n - 16] + 1
            //     and so on...
            for (int j = 1; j <= sqrt; j++) 
            {
                int dif = i - j * j;
                dp[i] = Math.min(dp[i], (dp[dif] + 1));
            }
        }
        return dp[n];
    }


    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        
        dp[0] = 0;
        
        // Compute the square numbers
        int max_square_idx = (int)Math.sqrt(n) + 1;
        int[] square_num = new int[max_square_idx];
        for(int i = 1; i < max_square_idx; i++)
            square_num[i] = i * i;
        
        for(int i = 1; i <= n; i++)
        {
            for(int j = 1; j < max_square_idx; j++)
            {
                if(i < square_num[j])
                    break;
                dp[i] = Math.min(dp[i], 1 + dp[i - square_num[j]]);
            }
        }
        return dp[n];
    }
}