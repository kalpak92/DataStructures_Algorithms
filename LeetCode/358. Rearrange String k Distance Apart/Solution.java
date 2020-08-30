/**
 * Given a non-empty string s and an integer k, rearrange the string such that the same characters are at least distance k from each other.
 * All input strings are given in lowercase letters. If it is not possible to rearrange the string, return an empty string "".
 * 
 * Example 1:
 * Input: s = "aabbcc", k = 3
 * Output: "abcabc" 
 * Explanation: The same letters are at least distance 3 from each other.
 * 
 * Example 2:
 * Input: s = "aaabc", k = 3
 * Output: "" 
 * Explanation: It is not possible to rearrange the string.
 * 
 * Example 3:
 * Input: s = "aaadbbcc", k = 2
 * Output: "abacabcd"
 * 
 * Explanation: The same letters are at least distance 2 from each other.
 */

public class Solution {
    public String rearrangeString(String s, int k) {
        if(k == 0) 
            return s;
        
        int[] freq = new int[26];
        StringBuilder result = new StringBuilder();
        Queue<int[]> wait = new LinkedList<>();
        
        // Compute the frequency
        for (char c : s.toCharArray()) 
            freq[c - 'a']++;
        
        // Create a maxHeap
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        
        for(int i = 0; i < 26; i++) {
            if(freq[i] > 0) 
                pq.add(new int[]{i, freq[i]});
        }
        
        
        while (!pq.isEmpty()) {
            // Greedily, get the character with the highest frequency and add it to the result
            int[] current = pq.poll();
            result.append((char)(current[0] + 'a'));
            current[1]--;       // Decrement its frequency
            
            // Add it to the wait queue, to be processed later, to ensure the k distance
            wait.add(current);
            
            if (wait.size() >= k) {
                // By FIFO, take the first character out of the queue
                // Check if the character frequency is not zero, then add it to the maxHeap                
                int[] front = wait.poll();
                if (front[1] > 0) 
                    pq.add(front);
            }
        }
        return result.length() == s.length() ? result.toString() : "";
    } 
}