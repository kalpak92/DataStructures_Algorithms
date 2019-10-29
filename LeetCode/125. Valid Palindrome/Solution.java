/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * Note: For the purpose of this problem, we define empty string as valid palindrome.
 * 
 * Example 1:
 * Input: "A man, a plan, a canal: Panama"
 * Output: true
 * 
 * Example 2:
 * Input: "race a car"
 * Output: false
 */

class Solution {
    public boolean isPalindrome(String s) {
        char[] c = s.toCharArray();
        
        for (int i = 0, j = c.length - 1; i < j; ) 
        {
            if (!Character.isLetterOrDigit(c[i])) 
                i++;
            else if (!Character.isLetterOrDigit(c[j])) 
                j--;
            else if (Character.toLowerCase(c[i++]) != Character.toLowerCase(c[j--])) 
                return false;
        }
        return true;
    }
}