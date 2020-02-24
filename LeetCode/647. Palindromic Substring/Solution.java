/**
 * Given a string, your task is to count how many palindromic substrings in this string.
 * 
 * The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.
 * 
 * Example 1:
 * Input: "abc"
 * Output: 3
 * Explanation: Three palindromic strings: "a", "b", "c".
 * 
 * Example 2:
 * Input: "aaa"
 * Output: 6
 * Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 * 
 * Note:
 * The input string length won't exceed 1000.
 */

class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        
        int res = 0;
        
        boolean[][] dp = new boolean[n][n];
        
        // How do we make a palindrome? 
        // If the first and last characters match, then it's possible its a palindrome. 
        // Furthermore if every position between the first and last character is also a palindrome then adding the new first and last character would still make it a valid palindrome assuming all the middle elements are also palindromes.
    
        for (int i = n - 1; i >= 0; i--) 
        {
            for (int j = i; j < n; j++) 
            {
                // When j - i < 3, we don't need to know the result of dp[i + 1][j - 1]
                //  j - i == 0: 
                //          we are checking a substring of a single character. It is obvious that such substring must be palindromic.
                //  j - i == 1: we are checking a substring of two characters. 
                //          If we can get to there, then we must pass the check s.charAt(i) == s.charAt(j), 
                //          which means the first character of this string is identical to the second character. 
                //          The string must be palindromic as well.
                //  j - i == 2, we are checking a substring of three characters. 
                //          If we can get to there, then we must pass the check s.charAt(i) == s.charAt(j), 
                //          which means the first character of this string is identical to the second character. 
                //          A string of length 3, with its leftmost character equal to its rightmost character, no matter what its middle character is, must be palindromic as well
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);
                
                
                /** For j - i < 3 part, 
                  *        dp[i + 1][j - 1] implies that i+1 <= j-1. Then it's easy to get j-i >= 2. 
                  * That's why we need a special case here when j-i is not >=2, that is when j-i<3. 
                  */
                  
                if(dp[i][j]) 
                    res++;
            }
        }
        return res;
    }
}