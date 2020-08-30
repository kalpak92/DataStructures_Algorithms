/**
 * Given a string S, check if the letters can be rearranged so that two characters that are adjacent to each other are not the same.
 * If possible, output any possible result.  If not possible, return the empty string.
 * 
 * Example 1:
 * Input: S = "aab"
 * Output: "aba"
 * 
 * Example 2:
 * Input: S = "aaab"
 * Output: ""
 * 
 * Note:
 * 
 *     S will consist of lowercase letters and have length in range [1, 500].
 */

/**
 * ALGORITHM
 *     1. count letter appearance and store in hash[i]
 *     2. find the letter with largest occurence.
 *     3. put the letter into even index numbe (0, 2, 4 ...) char array
 *     4. put the rest into the array
 * 
 * Time O(N): fill hash[] + find the letter + write results into char array
 * Space O(N + 26): result + hash[]
 * 
 * We construct the resulting string in sequence: at position 0, 2, 4, ... and then 1, 3, 5, ...
 * In this way, we can make sure there is always a gap between the same characters
 * 
 * Consider this example: "aaabbbcdd", we will construct the string in this way:
 *  a _ a _ a _ _ _ _ // fill in "a" at position 0, 2, 4
 * a b a _ a _ b _ b // fill in "b" at position 6, 8, 1
 * a b a c a _ b _ b // fill in "c" at position 3
 * a b a c a d b d b // fill in "d" at position 5, 7
 * 
 * if we went to 1,3,5 instead of 6,8,1. It would lead to "abababcdd"
 */

class Solution {
    public String reorganizeString(String S) {
        int[] hash = new int[26];
        
        for (int i = 0; i < S.length(); i++) {
            hash[S.charAt(i) - 'a']++;
        }
        
        int max = 0, letter = 0;
        for (int i = 0; i < hash.length; i++) {
            if (hash[i] > max) {
                max = hash[i];
                letter = i;
            }
        }
        
        if (max > (S.length() + 1) / 2) {
            return ""; 
        }
        
        char[] res = new char[S.length()];
        int idx = 0;
        while (hash[letter] > 0) {
            res[idx] = (char) (letter + 'a');
            idx += 2;
            hash[letter]--;
        }
        
        for (int i = 0; i < hash.length; i++) {
            while (hash[i] > 0) {
                if (idx >= res.length) {
                    idx = 1;
                }
                res[idx] = (char) (i + 'a');
                idx += 2;
                hash[i]--;
            }
        }
        return String.valueOf(res);
    }
}