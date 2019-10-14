/**
 * Given a string, determine if a permutation of the string could form a palindrome.
 * 
 * Example 1:
 * Input: "code"
 * Output: false
 * 
 * Example 2:
 * Input: "aab"
 * Output: true
 * 
 * Example 3:
 * Input: "carerac"
 * Output: true
 * 
 */
import java.util.*;

class Solution {
    public boolean canPermutePalindrome(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray())
        {
            if (set.contains(c))
                set.remove(c);
            else
                set.add(c);
        }
            if (set.size() < 2)
                return true;
            else
                return false;
    }

    public static void main(String args[])
    {
        Solution s = new Solution();
        System.out.println(s.canPermutePalindrome("abccccdde"));
        System.out.println(s.canPermutePalindrome("a"));
    }
}