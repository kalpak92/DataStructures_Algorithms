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
        Map<Character, Integer> map = new HashMap<>();
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        Queue<Character> waitQueue = new LinkedList<>();
        StringBuilder result = new StringBuilder();
        
        // Build the frequency map
        for(char c : s.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);
        
        // Create the maxHeap based on the frequency
        maxHeap.addAll(map.keySet());
        
        while(!maxHeap.isEmpty()) {
            Character temp = maxHeap.poll();
            result.append(temp);
            map.put(temp, map.get(temp) - 1);
            // Push it to the waitQueue
            waitQueue.offer(temp);
            
            // Check if the waitQueue is of size k
            if(waitQueue.size() < k)
                continue;
            
            // else pop from the queue
            Character cache = waitQueue.poll();
            if(map.get(cache) > 0)
                maxHeap.offer(cache);
        }
        return result.length() == s.length() ? result.toString() : "";
    } 
}