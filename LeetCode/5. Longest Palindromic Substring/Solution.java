/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * 
 * Example 1:
 * Input: "babad"
 * Output: "bab"
 * 
 * Note: "aba" is also a valid answer.
 * 
 * Example 2:
 * Input: "cbbd"
 * Output: "bb"
 */

class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        
        String result = null;
        
        int startIdx = 0, maxLen = 0;

        boolean[][] dp = new boolean[len][len]; // dp[i][j] indicates whether substring s starting at index i and ending at j is palindrome or not
        
        // Why are we counting down for i, but counting up for j?
        // Each sub-problem dp[i][j] depends on dp[i+1][j-1] 
        // (dp[i+1][j-1] must be true and s.charAt(i) must equal s.charAt(j) for dp[i][j] to be true).
        
        for(int i = len - 1; i >= 0; i--) // keep increasing the possible palindrome string
        {
            for(int j = i; j < len; j++) 
            {   
                // find the max palindrome within this window of (i,j)
                if(j - i < 3)
                {
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                }
                else {
                    dp[i][j] = (s.charAt(i) == s.charAt(j)) && (dp[i + 1][j - 1]);
                }
                
                //update max palindrome string
                if(dp[i][j] && (j - i + 1 > maxLen)) 
                {
                    startIdx = i;
                    maxLen = j - i + 1;
                }
            }
        }
        return s.substring(startIdx, startIdx + maxLen);
    }
}