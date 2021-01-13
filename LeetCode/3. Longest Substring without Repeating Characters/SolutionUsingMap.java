/**
 * Given a string, find the length of the longest substring without repeating characters.
 * 
 * Example 1:
 * Input: "abcabcbb"
 * Output: 3 
 * Explanation: The answer is "abc", with the length of 3. 
 * 
 * Example 2:
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * 
 * Example 3:
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3. 
 *              Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */

public class SolutionUsingMap {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0)
            return 0;
        
        Map<Character, Integer> map = new HashMap<>();
        int result = Integer.MIN_VALUE;
        int i = 0;
        int j = 0;
        
        while(j < s.length()) {
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
            
            if(map.size() == j-i+1) {
                result = Math.max(result, j - i + 1);
            } else if(map.size() < j - i + 1) { // some characters are repeating since window size is larger than the map
                while(map.size() < j-i+1) {
                    map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                    if(map.get(s.charAt(i)) == 0)
                        map.remove(s.charAt(i));
                    i++;
                }
            }
            j++;
        }
        return result;
    }
}
