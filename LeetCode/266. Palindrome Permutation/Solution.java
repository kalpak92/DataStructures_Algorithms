/**
 * Given a string, determine if a permutation of the string could form a palindrome.
 * 
 * Example 1:
 * Input: "code"
 * Output: false
 * 
 * Example 2:
 * Input: "aab"
 * Output: true
 * 
 * Example 3:
 * Input: "carerac"
 * Output: true
 * 
 */


class Solution {
    public boolean canPermutePalindrome(String s) {
        Set<Character> uniqueCharacter = new HashSet<>();
        
        for(int i = 0; i < s.length(); i++) {
            if(uniqueCharacter.contains(s.charAt(i)))
                uniqueCharacter.remove(s.charAt(i));
            else {
                uniqueCharacter.add(s.charAt(i));
            }
        }
        
        if(uniqueCharacter.size() > 1)
            return false;
        return true;
    }
}