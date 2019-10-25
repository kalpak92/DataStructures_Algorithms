/**
 * Given two strings s and t , write a function to determine if t is an anagram of s.
 * 
 * Example 1:
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * 
 * Example 2:
 * Input: s = "rat", t = "car"
 * Output: false
 * 
 * Note:
 * You may assume the string contains only lowercase alphabets.
 * 
 * Follow up:
 * What if the inputs contain unicode characters? How would you adapt your solution to such case?
 */

class Solution {

    // Naive solution. Time complexity : O(nlogn). Space Complexity: O(n) because in Java, toCharArray creates a copy of the string.
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        
        char[] a = s.toCharArray();
        char[] b = t.toCharArray();
        
        Arrays.sort(a);
        Arrays.sort(b);
        
        return Arrays.equals(a,b);
    }

    public boolean isAnagramII(String s, String t) {
        if(s.length() != t.length())
            return false;
        
        /**
         * If tt is a rearrangement of ss, we can count occurrences of each letter in the two strings and compare them. 
         * Since both ss and tt contain only letters from a-za−z, a simple counter table of size 26 is suffice.
         * We could first increment the counter for s, then decrement the counter for t. 
         * If at any point the counter drops below zero, return false.
         */
         
        int table[] = new int[26];
        
        for (int i = 0; i < s.length(); i++)
        {
            table[s.charAt(i) - 'a']++;
        }
        
        for(int i = 0; i < t.length(); i++)
        {
            table[t.charAt(i) - 'a']--;
            
            if(table[t.charAt(i) - 'a'] < 0)
                return false;
        }
        return true;
    }

    // Including the follow up. Uses HashTable.
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
        {
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i < s.length(); i++)
        {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) - 1);
        }
        
        for(char c : map.keySet())
        {
            if(map.get(c) != 0)
            {
                return false;
            }
        }
        return true;
    }

}