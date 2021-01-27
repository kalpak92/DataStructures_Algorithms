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
    public List<Integer> partitionLabelsMergeIntervals(String S) {
        List<Integer> result = new ArrayList<>();
        Map<Character, int[]> map = new HashMap<>();
        
        // Create a map of character and their start and end indices.
        for(int i = 0; i < S.length(); i++) {
            char temp = S.charAt(i);
            
            if(!map.containsKey(temp)) {
                int[] indices = new int[2];
                indices[0] = i;
                indices[1] = i;
                map.put(temp, indices);
            } else {
                int[] indices = map.get(temp);
                indices[1] = i;
                map.put(temp, indices);
            }
        }
        
        for(int i = 0; i < S.length(); i++) {
            char temp = S.charAt(i);
            // Fetch the start and end index of the character from the map
            int start = map.get(temp)[0];
            int end = map.get(temp)[1];
            
            // Now check for characters within this interval. Update the interval if overlaps
            while(i != end) {
                // Go the next character
                i++;
                char ch = S.charAt(i);
                int runningEndIndex = map.get(ch)[1];
                
                if(runningEndIndex > end) {
                    // Overlapping interval. update the end
                    end = runningEndIndex;
                }
            }
            result.add(end - start + 1);    // Store the interval length
        }
        return result;
    }

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