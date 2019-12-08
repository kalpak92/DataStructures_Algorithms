/**
 * A string S of lowercase letters is given. 
 * We want to partition this string into as many parts as possible so that each letter appears in at most one part, 
 * and return a list of integers representing the size of these parts.
 * 
 * Example 1:
 * Input: S = "ababcbacadefegdehijhklij"
 * Output: [9,7,8]
 * Explanation:
 * The partition is "ababcbaca", "defegde", "hijhklij".
 * This is a partition so that each letter appears in at most one part.
 * A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
 * 
 * Note:
 * S will have length in range [1, 500].
 * S will consist of lowercase letters ('a' to 'z') only.
 */

class Solution {
    public List<Integer> partitionLabels(String S) {
        List<Integer> result = new ArrayList<>();
        
        // keep track of the end index of each of the characters in the string
        int[] endIndex = new int[26];
        
        for(int i = 0; i < S.length(); i++)
        {
            endIndex[S.charAt(i) - 'a'] = i;
        }
        
        int i = 0;
        while(i < S.length())
        {
            int end = endIndex[S.charAt(i) - 'a'];  // fetch the end index of the first character
            
            // check if this is the end index. Else, update the endIndex
            int j = i;
            while(j != end)
            {
                end = Math.max(end, endIndex[S.charAt(j) - 'a']);
                j++;
            }
            
            // the partition has been found. put it into the result list.
            result.add(j - i + 1);
            
            // move the ith index to the next index of j and start the process again.
            i = j + 1;
        }
        return result;
    }
}