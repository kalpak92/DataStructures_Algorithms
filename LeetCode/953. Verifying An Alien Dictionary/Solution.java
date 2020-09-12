/**
 * In an alien language, surprisingly they also use english lowercase letters, but possibly in a different order. 
 * The order of the alphabet is some permutation of lowercase letters.
 * Given a sequence of words written in the alien language, and the order of the alphabet, 
 * return true if and only if the given words are sorted lexicographicaly in this alien language.
 * 
 * Example 1:
 * Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
 * Output: true
 * Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.
 * 
 * Example 2:
 * Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
 * Output: false
 * Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1], hence the sequence is unsorted.
 * 
 * Example 3:
 * Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
 * Output: false
 * Explanation: The first three characters "app" match, and the second string is shorter (in size.) 
 * According to lexicographical rules "apple" > "app", because 'l' > '∅', where '∅' is defined as the blank character which is less than any other character (More info).
 * 
 * Constraints:
 *     1 <= words.length <= 100
 *     1 <= words[i].length <= 20
 *     order.length == 26
 *     All characters in words[i] and order are English lowercase letters.
 */

class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] orderMap = new int[26];
        
        for (int i = 0; i < 26; ++i) { 
            // construct mapping to the give order.
            orderMap[order.charAt(i) - 'a'] = i; 
        }
        
        for (int i = 1; i < words.length; ++i) { 
            // Verify the ajacent words order.
            // If compare returns a number greater zero, then the lexicographic order is violated.
            // Return false.
            if (compare(words[i - 1], words[i], orderMap) > 0) { 
                return false; 
            } 
        }
        return true;
    }
    
    // compare the 2 words char by char.
    private int compare(String s, String t, int[] orderMap) {
        for (int i = 0; i < s.length() && i < t.length(); i++) {
            int cmpResult = orderMap[s.charAt(i) - 'a'] - orderMap[t.charAt(i) - 'a'];
            if(cmpResult != 0) {
                return cmpResult;
            } 
        }
        return s.length() - t.length(); // when one word is the prefix of the other, compare their sizes.
    }
}
