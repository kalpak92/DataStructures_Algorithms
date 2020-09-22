/**
 * Given two strings s and t, determine if they are isomorphic.
 * 
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * All occurrences of a character must be replaced with another character while preserving the order of characters. 
 * No two characters may map to the same character but a character may map to itself.
 * 
 * Example 1:
 * Input: s = "egg", t = "add"
 * Output: true
 * 
 * Example 2:
 * Input: s = "foo", t = "bar"
 * Output: false
 * 
 * Example 3:
 * Input: s = "paper", t = "title"
 * Output: true
 * 
 * Note:
 * You may assume both s and t have the same length.
 * 
 */

class Solution {
    public boolean isIsomorphic(String s, String t) {
        // Two strings are isomorphic 
        // if the positions of the characters follow the same pattern. 
        
        // So using maps to compare the position patterns.
        
        if(s == null || t == null)
            return false;
        if(s.length() != t.length())
            return false;
        
        Map<Character, Integer> sIndex = new HashMap<>();
        Map<Character, Integer> tIndex = new HashMap<>();
        
        // Whether the two strings are isomorphic can be judged by the index patterns. 
        // In the above example, these two strings are isomorphic with the same index patterns.
        for(int i = 0; i < s.length(); i++) {
            int sIdx = sIndex.getOrDefault(s.charAt(i), -1);
            int tIdx = tIndex.getOrDefault(t.charAt(i), -1);
            
            if(sIdx != tIdx)
                return false;
            
            sIndex.put(s.charAt(i), i);
            tIndex.put(t.charAt(i), i);
        }
        return true;
    }
}