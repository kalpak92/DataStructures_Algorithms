package Leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author kalpak
 *
 * Given a string, find the first non-repeating character in it and return its index. If it doesn't exist, return -1.
 *
 * Examples:
 *
 * s = "leetcode"
 * return 0.
 *
 * s = "loveleetcode"
 * return 2.
 *
 *
 *
 * Note: You may assume the string contains only lowercase English letters.
 */

class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> characterFrequency = new LinkedHashMap<>();
        
        for(int i = 0; i < s.length(); i++) {
            if(!characterFrequency.containsKey(s.charAt(i)))
                characterFrequency.put(s.charAt(i), i);
            else
                characterFrequency.put(s.charAt(i), -1);
        }
        
        for(Character c : characterFrequency.keySet()) {
            if(characterFrequency.get(c) != -1)
                return characterFrequency.get(c);
        }
        return -1;
    }
}