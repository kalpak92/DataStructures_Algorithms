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
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int counter = 0;
        int result = 0;
        
        while(right < s.length())
        {
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1);
            // for every distinct character, increment the counter
            if(map.get(c) == 1)
            {
                counter ++;
            }
            right++;
            
            // when counter goes beyond 2, slide window from left
            while(counter > 2)
            {
                char temp = s.charAt(left);
                map.put(temp, map.get(temp) - 1);   // decrement the occurrence of the character.
                // if the character count reduces to zero, decrement counter
                if(map.get(temp) == 0)
                    counter--;
                
                left++;
            }
            
            result = Math.max(result, right - left);
        }
        return result;
    }
}