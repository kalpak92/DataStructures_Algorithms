/**
 * Given a string s, find the longest palindromic subsequence's length in s. You may assume that the maximum length of s is 1000.
 * 
 * Example 1:
 * Input:
 * "bbbab"
 * Output:
 * 4
 * One possible longest palindromic subsequence is "bbbb".
 * 
 * Example 2:
 * Input:
 * "cbbd"
 * Output:
 * 2
 */

class Solution {
    /**
     * dp[i][j]: the longest palindromic subsequence's length of substring(i, j), here i, j represent left, right indexes in the string
     * 
     * State transition:
     * dp[i][j] = dp[i+1][j-1] + 2 if s.charAt(i) == s.charAt(j)
     * otherwise, dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1])
     * 
     * Initialization: dp[i][i] = 1
     */
    
    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];
        
        // Make the diagonals 1 because individual characters are a palindrome of itself.
        for(int i = 0; i < s.length(); i++)
            dp[i][i] = 1;
        
        // For substrings of length 2, 
        // if the consecutive characters are same, make dp[i][j] = 2 or dp[i][j] = 1 since they individually are a substring.
        for(int i = 0, j = 1; j < s.length(); i++, j++) 
            dp[i][j] = s.charAt(i) == s.charAt(j) ? 2 : 1;
        
        for(int len = 3; len <= s.length(); len++)
        {
            for(int i = 0, j = len - 1; j < s.length(); i++, j++)
            {
                int max = Math.max(dp[i][j - 1], dp[i + 1][j]); // for ex: if len = 3, compare substring (0, 1) and (1, 2) to update dp(0, 2).
                
                if(s.charAt(i) == s.charAt(j))  // start and end characters are same
                {
                    // check 2 plus without left and without right
                    // for ex: if len = 3 in substring (0, 2), 2 + substring(1) = 2 + dp[1][1] to update dp(0, 2)
                    max = Math.max(max, 2 + dp[i + 1][j - 1]); 
                }
                
                dp[i][j] = max;
            }
        }
        return dp[0][s.length() - 1];
    }
}