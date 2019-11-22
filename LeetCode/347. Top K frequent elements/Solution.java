/**
 * Given a non-empty array of integers, return the k most frequent elements.
 * 
 * Example 1:
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * 
 * Example 2:
 * Input: nums = [1], k = 1
 * Output: [1]
 * 
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 */

class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> frequency = new HashMap<>();
        for (int i : nums)
        {
            frequency.put(i, frequency.getOrDefault(i,0) + 1);
        }
        
        // create the Min heap based on the frequency of occurrence
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((n1, n2) -> frequency.get(n1)  - frequency.get(n2));
        
        for (int i : frequency.keySet())
        {
            minHeap.add(i);
            
            if(minHeap.size() > k)
                minHeap.poll();
        }
        
        List<Integer> result = new ArrayList<>();
        while(!minHeap.isEmpty())
        {
            result.add(0, minHeap.poll());
        }
        
        return result;
    }
}