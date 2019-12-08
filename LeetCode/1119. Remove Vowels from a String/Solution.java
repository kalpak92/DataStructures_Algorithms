/**
 * Given a string S, remove the vowels 'a', 'e', 'i', 'o', and 'u' from it, and return the new string.
 * 
 * Example 1:
 * Input: "leetcodeisacommunityforcoders"
 * Output: "ltcdscmmntyfrcdrs"
 * 
 * Example 2:
 * Input: "aeiou"
 * Output: ""
 * 
 * Note:
 * S consists of lowercase English letters only.
 * 1 <= S.length <= 1000
 */

class Solution {
    public String removeVowels(String S) {
        String v = "aeiou";
        
        StringBuilder sb = new StringBuilder();
        
        for(char c : S.toCharArray())
        {
            if(v.indexOf(c) == -1)      // check if the character is a vower. indexOf returns -1 if it is not found in the vowel string.
                sb.append(c);           // If not a vowel, then append, else skip.
        }
        return sb.toString();
    }
}