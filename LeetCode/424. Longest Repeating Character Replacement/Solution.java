/**
 * Given a string s that consists of only uppercase English letters, you can perform at most k operations on that string.
 * In one operation, you can choose any character of the string and change it to any other uppercase English character.
 * 
 * Find the length of the longest sub-string containing all repeating letters you can get after performing the above operations.
 * Note:
 * Both the string's length and k will not exceed 104.
 * 
 * Example 1:
 * Input:
 * s = "ABAB", k = 2
 * Output:
 * 4
 * Explanation:
 * Replace the two 'A's with two 'B's or vice versa.
 * 
 * Example 2:
 * Input:
 * s = "AABABBA", k = 1
 * Output:
 * 4
 * Explanation:
 * Replace the one 'A' in the middle with 'B' and form "AABBBBA".
 * The substring "BBBB" has the longest repeating letters, which is 4.
 */

public class Solution {
    public int characterReplacement(String s, int k) {
        if (s == null || s.length() == 0) 
            return 0;
        
        Map<Character, Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        int maxCount = 0;
        int result = 0;
        
        while(j < s.length()) {
            char c = s.charAt(j);
            // calculation: put the character into the map
            map.put(c, map.getOrDefault(c, 0) + 1);
            // Find the maxCount
            maxCount = getMaxCharFrequency(map);

            // If windowSize - maxCount > k --> this means we have more characters than needed. So shrink the window
            if(j - i + 1 - maxCount > k) {
                while(j - i + 1 - maxCount > k) {
                    map.put(s.charAt(i), map.get(s.charAt(i)) - 1); // decrease the count
                    maxCount = getMaxCharFrequency(map);            // update the maxCount
                    i++;
                }
            }
            // update the result with the windowSize
            result = Math.max(result, j - i + 1);
            j++;
        }
        return result;
    }
    
    private int getMaxCharFrequency(Map<Character, Integer> map) {
		int maxCount = 0;
		for(int freq : map.values()) {
			maxCount = Math.max(maxCount, freq);
		}
		return maxCount;
    }
}
