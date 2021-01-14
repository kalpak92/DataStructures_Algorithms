/**
 * Given a string s and an integer k, 
 * return the length of the longest substring of s such that the frequency of each character in this substring is greater than or equal to k. 
 * 
 * Example 1:
 * Input: s = "aaabb", k = 3
 * Output: 3
 * Explanation: The longest substring is "aaa", as 'a' is repeated 3 times.
 * 
 * Example 2:
 * Input: s = "ababbc", k = 2
 * Output: 5
 * Explanation: The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.
 * 
 * Constraints:
 * 1 <= s.length <= 10^4
 * s consists of only lowercase English letters.
 * 1 <= k <= 10^5
 */


public class Solution {
    public int longestSubstring(String s, int k) {
        // how do we explore all possible solutions  where substrings satisfies the given constraints ??
        // Find all sub-strings which have "1" unique character(s) and each character in the substring repeats at least "k" times
        // find all sub-strings which have "2" unique character(s) and each character in the substring repeats at least "k" times
        // ... and so on for "26" unique characters.
        // and get the maximum out of it.
        
        int result = 0;

        for (int uniqueChar = 1; uniqueChar <= 26; uniqueChar++) {
            //System.out.println(uniqueChar);
            result = Math.max(result, longestSubstringWithNUniqueChars(s, k, uniqueChar));
        }
        return result;
    }
    
    private int longestSubstringWithNUniqueChars(String s, int k, int uniqueCharCount) {
        Map<Character, Integer> map = new HashMap<>();
        int result = 0;
        int i =0;
        int j = 0;
        int charFrequencyGreaterThanOrEqualToK = 0;
        
        while(j < s.length()) {
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1); // enter the characters into the map
            
            if(map.get(s.charAt(j)) == k)           // if the counter of the character is k, update the frequency tracker
                charFrequencyGreaterThanOrEqualToK++;
            
            if(map.size() > uniqueCharCount) {     // Need to slide the window when the #unique characters > required
                while(map.size() > uniqueCharCount) {
                    if(map.get(s.charAt(i)) == k)       // Check if current count of that character is k
                        charFrequencyGreaterThanOrEqualToK--;   // reduce the frequency tracker
                    
                    map.put(s.charAt(i), map.get(s.charAt(i)) - 1); 
                    
                    if(map.get(s.charAt(i)) == 0)   // remove its entry from map when the character count is 0
                        map.remove(s.charAt(i));
                    i++;
                }
            }
            
            // if # unique characters match, and all those characters are repeated atleast K times, update the result
            if(map.size() == uniqueCharCount && map.size() == charFrequencyGreaterThanOrEqualToK) {
                result = Math.max(result, j - i + 1);
                //System.out.println(result);
            }
            
            j++;
        }
        return result;
    }
}
