/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return all possible palindrome partitioning of s.
 * 
 * Example:
 * Input: "aab"
 * Output:
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 */

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        
        int n = s.length();
        
        boolean[][] dp = new boolean[n][n];
        
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
            }
        }
        
        helper(res, new ArrayList<>(), dp, s, 0);
        
        return res;
    }
    
    private void helper(List<List<String>> res, List<String> path, boolean[][] dp, String s, int pos) 
    {
        if(pos == s.length()) 
        {
            res.add(new ArrayList<>(path));
            return;
        }
        
        for(int i = pos; i < s.length(); i++) 
        {
            if(dp[pos][i]) 
            {
                path.add(s.substring(pos,i+1));
                helper(res, path, dp, s, i+1);
                path.remove(path.size()-1);
            }
        }
    }
}