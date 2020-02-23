/**
 * Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.
 * You have the following 3 operations permitted on a word:
 * 
 * Insert a character
 * Delete a character
 * Replace a character
 * 
 * Example 1:
 * Input: word1 = "horse", word2 = "ros"
 * Output: 3
 * 
 * Explanation: 
 * horse -> rorse (replace 'h' with 'r')
 * rorse -> rose (remove 'r')
 * rose -> ros (remove 'e')
 * 
 * Example 2:
 * Input: word1 = "intention", word2 = "execution"
 * Output: 5
 * Explanation: 
 * intention -> inention (remove 't')
 * inention -> enention (replace 'i' with 'e')
 * enention -> exention (replace 'n' with 'x')
 * exention -> exection (replace 'n' with 'c')
 * exection -> execution (insert 'u')
 */

class Solution {
    public int minDistance(String str1, String str2) {
        
        /**
        * If the characters are equal, no need for any operation. So copy the diagonal value which is dp[i - 1][j - 1].
        * Else, Check for the minimum amongst. top, diagonal left, and left - and add 1 to it.
        */
        
        int[][] dp = new int[str1.length() + 1][str2.length() + 2];

        for(int i = 0; i < dp.length; i++)
            dp[i][0] = i;

        for(int i = 0; i < dp[0].length; i++)
            dp[0][i] = i;

        for(int i = 1; i < str1.length() + 1; i++)
        {
            for(int j = 1; j < str2.length() + 1; j++)
            {
                if(str1.charAt(i - 1) == str2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1])) + 1;
            }
        }

        return dp[str1.length()][str2.length()];
        
    }
}