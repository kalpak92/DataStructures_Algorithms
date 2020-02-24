/**
 * Given two words word1 and word2, 
 * find the minimum number of steps required to make word1 and word2 the same, where in each step you can delete one character in either string.
 * 
 * Example 1:
 * Input: "sea", "eat"
 * Output: 2
 * Explanation: You need one step to make "sea" to "ea" and another step to make "eat" to "ea".
 * 
 * Note:
 * The length of given words won't exceed 500.
 * Characters in given words can only be lower-case letters.
 */

class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        
        // Very Simple Idea that the number of deletions is equal to the number of places where both strings are different.
        // Find the longest common subsequence. 
        // The rest of the characters have to be deleted from the both the strings, which does not belong to longest common subsequence.
        for (int i = 1; i <= word1.length(); i++)
        {
            for (int j = 1; j <= word2.length(); j++)
            {
                
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) 
                    dp[i][j] = dp[i - 1][j - 1] + 1;        // Add one to the diagonal value in the DP table
                else 
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]); // Max of top and left
            }
        }
        return word1.length() - dp[word1.length()][word2.length()] + word2.length() - dp[word1.length()][word2.length()];
    }
}