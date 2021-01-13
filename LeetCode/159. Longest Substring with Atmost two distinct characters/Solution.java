/**
 * Given a string s , find the length of the longest substring t  that contains at most 2 distinct characters.
 * 
 * Example 1:
 * Input: "eceba"
 * Output: 3
 * Explanation: t is "ece" which its length is 3.
 * 
 * Example 2:
 * Input: "ccaabbb"
 * Output: 5
 * Explanation: t is "aabbb" which its length is 5.
 */

 import java.util.*;
 class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s.length() == 0)
            return 0;
        
        Map<Character, Integer> map = new HashMap<>();
        int result = Integer.MIN_VALUE;
        int i =0;
        int j = 0;
        
        while(j < s.length()) {
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1); // enter the characters into the map
            
            if(map.size() <= 2) { // since the problem asks from atmost two distinct characters
                result = Math.max(result, j - i + 1);
            } else if(map.size() > 2) { // if more than 2 distinct characters, slide the window
                while(map.size() > 2) { // remove characters from the left side of the window
                    map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                    if(map.get(s.charAt(i)) == 0)   // remove its entry from map when the character count is 0
                        map.remove(s.charAt(i));
                    i++;
                }
            }
            j++;
        }
        return result;
    }
}