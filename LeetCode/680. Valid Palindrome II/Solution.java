/**
 * Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.
 * 
 * Example 1:
 * Input: "aba"
 * Output: True
 * 
 * Example 2:
 * Input: "abca"
 * Output: True
 * Explanation: You could delete the character 'c'.
 * 
 * Note:
 * The string will only contain lowercase characters a-z. The maximum length of the string is 50000.
 */

class Solution {
    public boolean validPalindrome(String s) {
        for(int i = 0; i < s.length() / 2; i++)
        {
            if(s.charAt(i) != s.charAt(s.length() - 1 - i))
            {
                int j = s.length() - 1 - i;
                return isPalindrome(s, i + 1, j) || isPalindrome(s, i, j-1);
            }
        }
        return true;
    }
    
    private boolean isPalindrome(String a, int i, int j)
    {
        while (i < j)
        {
            if (a.charAt(i) != a.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}