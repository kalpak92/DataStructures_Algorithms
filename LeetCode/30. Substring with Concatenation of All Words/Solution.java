/**
 * You are given a string, s, and a list of words, words, that are all of the same length. 
 * Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.
 * 
 * Example 1:
 * Input:
 * s = "barfoothefoobarman",
 * words = ["foo","bar"]
 * Output: [0,9]
 * 
 * Explanation: Substrings starting at index 0 and 9 are "barfoo" and "foobar" respectively.
 * The output order does not matter, returning [9,0] is fine too.
 * 
 * Example 2:
 * Input:
 * s = "wordgoodgoodgoodbestword",
 * words = ["word","good","best","word"]
 * Output: []
 */

import java.util.*;
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        if (s == null || words == null || s.length() == 0 || words.length == 0) {
            return new ArrayList<>();
        }
        
        Map<String, Integer> map = new HashMap<>(); // maps the frequency of each word
        for(String word: words)
        {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        
        List<Integer> result = new ArrayList<>();
        
        int n = s.length();
        int numWords = words.length;
        int wordLen = words[0].length();
        
        // scan through 's'. for each i, determine if (i to i+num*len) is valid.
        for(int i = 0; i < n - numWords * wordLen + 1; i++)
        {
            Map<String, Integer> seen = new HashMap<>();  // to be reset for each i
            int j = 0;
            
            while(j < numWords)
            {
                String word = s.substring(i+j*wordLen, i+(j+1)*wordLen);
                
                if(map.containsKey(word))
                {
                    seen.put(word, seen.getOrDefault(word, 0) + 1);
                    
                    if (seen.get(word) > map.getOrDefault(word, 0))
                        break;
                }
                else
                    break;
                
                j++;
            }
            if (j == numWords)
                result.add(i);
        }
        
        return result;
    }
}