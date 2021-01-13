/**
 * Given a string s and an integer k, return the length of the longest substring of s that contains at most k distinct characters.
 * 
 * Example 1:
 * Input: s = "eceba", k = 2
 * Output: 3
 * Explanation: The substring is "ece" with length 3.
 * 
 * Example 2:
 * Input: s = "aa", k = 1
 * Output: 2
 * Explanation: The substring is "aa" with length 2.
 * 
 * Constraints:
 * 1 <= s.length <= 5 * 104
 * 0 <= k <= 50
 */

public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(s.length() == 0 || k == 0)
            return 0;

        Map<Character, Integer> map = new HashMap<>();
        int result = Integer.MIN_VALUE;
        int i =0;
        int j = 0;

        while(j < s.length()) {
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1); // enter the characters into the map

            if(map.size() <= k) { // since the problem asks from atmost k distinct characters
                result = Math.max(result, j - i + 1);
            } else if(map.size() > k) { // if more than k distinct characters, slide the window
                while(map.size() > k) { // remove characters from the left side of the window
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
