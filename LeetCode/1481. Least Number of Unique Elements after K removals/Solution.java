/**
 * Given an array of integers arr and an integer k. Find the least number of unique integers after removing exactly k elements.
 * 
 * Example 1:
 * Input: arr = [5,5,4], k = 1
 * Output: 1
 * Explanation: Remove the single 4, only 5 is left.
 * 
 * Example 2:
 * Input: arr = [4,3,1,1,3,3,2], k = 3
 * Output: 2
 * Explanation: Remove 4, 2 and either one of the two 1s or three 3s. 1 and 3 will be left.
 * 
 * Constraints:
 * 1 <= arr.length <= 10^5
 * 1 <= arr[i] <= 10^9
 * 0 <= k <= arr.length
 */

public class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));
        
        for(int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        minHeap.addAll(map.keySet());
        
        // Remove from priorityQueue for k times
        while(k > 0) {
            k -= map.get(minHeap.poll());
        }
        
        // After k removal, priorityQueue contains the least number of unique integers.
        
        return (k < 0) ? minHeap.size() + 1 : minHeap.size();
    }
}
