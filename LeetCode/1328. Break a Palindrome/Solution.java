/**
 * Given a palindromic string palindrome, replace exactly one character by any lowercase English letter so that the string becomes the lexicographically smallest possible string that isn't a palindrome.
 * After doing so, return the final string.  
 * 
 * If there is no way to do so, return the empty string.
 * 
 * Example 1:
 * Input: palindrome = "abccba"
 * Output: "aaccba"
 * 
 * Example 2:
 * Input: palindrome = "a"
 * Output: ""
 * 
 * Constraints:
 * 1 <= palindrome.length <= 1000
 * palindrome consists of only lowercase English letters.
 */
public class Solution {
    public String breakPalindrome(String palindrome) {
        String s = palindrome;
        // If the sting is of length 1, return ""
        // If all the elements in the string are 'a' 
        //      then replace the last one with 'b' 
        // else replace the first non 'a' member with an 'a'
        
        if(s.length() == 1)
        {
            return "";
        }

        int i = 0, j = s.length() -  1;
        char[] arr = s.toCharArray();

        while(i < j)
        {
            if(s.charAt(j) == 'a')
            {
                j--; 
                i++;
            }
            else {
                arr[i] = 'a';
                return new String(arr);
            }
        }
        arr[s.length() - 1] = 'b';
        return new String(arr); 
    }
}