/**
 * You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.
 * Define a pair (u,v) which consists of one element from the first array and one element from the second array.
 * 
 * Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.
 * 
 * Example 1:
 * Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
 * Output: [[1,2],[1,4],[1,6]] 
 * Explanation: The first 3 pairs are returned from the sequence: 
 *              1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
 * 
 * Example 2:
 * Input: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
 * Output: [1,1],[1,1]
 * Explanation: The first 2 pairs are returned from the sequence: 
 *              [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
 * 
 * Example 3:
 * Input: nums1 = [1,2], nums2 = [3], k = 3
 * Output: [1,3],[2,3]
 * Explanation: All possible pairs are returned from the sequence: [1,3],[2,3]
 */

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        
        if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0 || k < 0)
            return result;
        
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a, b) -> (a.val - b.val));
        
        //Take the first number from nums1 array and pair it up with all the numbers from the nums2 array.
        for(int j = 0; j < nums2.length; j++)
            minHeap.offer(new Pair(0, j, nums1[0] + nums2[j]));
        
        // Pop from the minHeap and store the result.
        // Push a new pair - nums1+1 and nums2
        for(int i = 0; i < Math.min(k, nums1.length*nums2.length); i++) {
            Pair temp = minHeap.poll();
            
            List<Integer> res = new ArrayList<>();
            res.add(nums1[temp.nums1_idx]);
            res.add(nums2[temp.nums2_idx]);
            result.add(res);
            
            // Check for completion of all elements from nums1 array. 
            // Warning: Don't forget the -1. It's an index
            if(temp.nums1_idx == nums1.length - 1)
                continue;
            
            minHeap.offer(new Pair(temp.nums1_idx + 1, temp.nums2_idx, nums1[temp.nums1_idx + 1] + nums2[temp.nums2_idx]));
        }
        return result;
    }
}


class Pair {
    int nums1_idx;
    int nums2_idx;
    int val;
    
    Pair(int i, int j, int val) {
        this.nums1_idx = i;
        this.nums2_idx = j;
        this.val = val;
    }
}