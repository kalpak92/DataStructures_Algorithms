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

class Solution {

    /**
     * Keep a hashmap which stores the characters in string as keys and their positions as values, 
     * and keep two pointers which define the max substring. 
     * Move the right pointer to scan through the string , and meanwhile update the hashmap. 
     * If the character is already in the hashmap, then move the left pointer to the right of the same character last found. 
     * Note that the two pointers can only move forward.
     * 
     */
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if (len == 0)
            return 0;
        
        int result = 0;
        
        Map<Character, Integer> map = new HashMap<>();
        
        for(int i = 0, j = 0; j < len; j++)
        {
            if(map.containsKey(s.charAt(j)))
                i = Math.max(i, map.get(s.charAt(j)) + 1);
            
            map.put(s.charAt(j), j);
            result = Math.max(result, j - i + 1);
        }
        return result;
    }


    /** 
    Time complexity : O(2n) =O(n). In the worst case each character will be visited twice by i and j.
    Space complexity : O(min(m, n)).
                        We need O(k) space for the sliding window, where k is the size of the Set. 
                        The size of the Set is upper bounded by the size of the string n and the size of the charset/alphabet m.
    */
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        
        Set<Character> set = new HashSet<>();
        
        int result = 0;
        int i = 0, j = 0;       // window indices
        
        while(i < len && j < len)
        {
            // check if the character is present in the set. If not, add it.
            if(!set.contains(s.charAt(j)))
            {
                set.add(s.charAt(j++));     // add the character and increment j
                result = Math.max(result, j - i);
            }
            else 
            {
                set.remove(s.charAt(i++));
            }
        }
        return result;
    }


}