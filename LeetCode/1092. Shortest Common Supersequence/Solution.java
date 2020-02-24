/**
 * Given two strings str1 and str2, return the shortest string that has both str1 and str2 as subsequences.  
 * If multiple answers exist, you may return any of them.
 * 
 * (A string S is a subsequence of string T if deleting some number of characters from T (possibly 0, and the characters are chosen anywhere from T) results in the string S.)
 * Example 1:
 * Input: str1 = "abac", str2 = "cab"
 * Output: "cabac"
 * Explanation: 
 * str1 = "abac" is a subsequence of "cabac" because we can delete the first "c".
 * str2 = "cab" is a subsequence of "cabac" because we can delete the last "ac".
 * The answer provided is the shortest such string that satisfies these properties.
 * 
 * Note:
 * 1 <= str1.length, str2.length <= 1000
 * str1 and str2 consist of lowercase English letters.
 */

class Solution {
    public String shortestCommonSupersequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        
        // If a[i] == b[j], LCS for i and j would be 1 plus LCS till the i-1 and j-1 indexes.
        // Otherwise, we will take the largest LCS if we skip a charracter from one of the string (max(m[i - 1][j], m[i][j - 1]).
        for (int i = 1; i <= text1.length(); i++)
        {
            for (int j = 1; j <= text2.length(); j++)
            {
                
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) 
                    dp[i][j] = dp[i - 1][j - 1] + 1;        // Add one to the diagonal value in the DP table
                else 
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]); // Max of top and left
            }
        }
        
        // Build result.
        StringBuilder sb = new StringBuilder();
        
        int i = text1.length() - 1, j = text2.length() - 1;
        
        while (i >= 0 || j >= 0) 
        { 
            if (i < 0 ^ j < 0) 
            { // only one string reaches left end.
                char c = i < 0 ? text2.charAt(j--) : text1.charAt(i--); // remaining chars in the other string.
                sb.append(c);
            }
            else if (text1.charAt(i) == text2.charAt(j)) 
            { // common char in LCS.
                sb.append(text1.charAt(i)); // append the char of either s1 or s2.
                --i; 
                --j;  
            }
            else 
            {   // the char is not in LCS.
                char c = dp[i][j + 1] > dp[i + 1][j] ? text1.charAt(i--) : text2.charAt(j--); // the char corresponding to larger dp value.
                sb.append(c);
            }
        } 
        return sb.reverse().toString();
    }
}