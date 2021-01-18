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


class Solution {
    public String reorganizeString(String S) {
        if (S == null || S.length() == 0)
            return "";
        
        Map<Character, Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<Character,Integer>> maxHeap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        StringBuilder result = new StringBuilder();
        
        // Create a character-frequency map
        for(char c : S.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        // Add the characters to the priority queue based on their decreasing order of frequency
        for(Map.Entry<Character,Integer> entry : map.entrySet()) {
            maxHeap.offer(entry);
        }
        
        while(!maxHeap.isEmpty()) {
            Map.Entry<Character,Integer> temp = maxHeap.poll();
            
            if(result.length() == 0 || temp.getKey() != result.charAt(result.length() - 1)) {
                result.append(temp.getKey());
                // Reduce the count of the character
                temp.setValue(temp.getValue() - 1);
                
                // if the characters still needs to be accomodated
                if(temp.getValue() != 0)
                    maxHeap.offer(temp);
            } else {
                // if character in temp is same as the last character in result
                // we need to try the character with second highest frequency
                Map.Entry<Character,Integer> temp2 = maxHeap.poll();
                
                // corner case: if there are no more elements in heap, the input string should be invalid
                // because we do not have any other characters that are different than the last character of the result
                if (temp2 == null)
                    return "";
                
                result.append(temp2.getKey());
                temp2.setValue(temp2.getValue() - 1);
                if(temp2.getValue() != 0)
                    maxHeap.offer(temp2);
                
                // Also push the temp.
                maxHeap.offer(temp);
            }
        }
        return result.toString();
    }
}