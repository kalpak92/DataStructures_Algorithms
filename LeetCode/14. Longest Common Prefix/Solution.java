/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string "".
 * 
 * Example 1:
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 * 
 * Example 2:
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * Note:
 * All given inputs are in lowercase letters a-z.
 */

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0 || strs == null)
            return "";
        
        String lcp = "";
        
        int index = 0;
        
        for(char c : strs[0].toCharArray())
        {
            for(int i = 1; i < strs.length; i++)
            {
                if(index >= strs[i].length() || c != strs[i].charAt(index))
                    return lcp;
            }
            lcp += c;
            index++;
        }
        return lcp;
    }
}