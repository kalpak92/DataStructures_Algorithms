/**
 * Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.
 * This is case sensitive, for example "Aa" is not considered a palindrome here.
 * 
 * Note:
 * Assume the length of given string will not exceed 1,010.
 * 
 * Example:
 * Input:
 * "abccccdd"
 * 
 * Output:
 * 7
 * 
 * Explanation:
 * One longest palindrome that can be built is "dccaccd", whose length is 7.
 */
import java.util.HashSet;
import java.util.Set;
class Solution {
    public Solution(){}

    public int longestPalindrome(String s) {
        Set<Character> set = new HashSet<>();
        
        for (char c : s.toCharArray()) {
            if (set.contains(c)) 
                set.remove(c);
            else 
                set.add(c);
        }

        int odd = set.size();
        return (odd > 0) ? s.length() - odd + 1 : s.length();
    }

    public static void main(String args[])
    {
        Solution s = new Solution();
        System.out.println(s.longestPalindrome("abccccdde"));
    }
}