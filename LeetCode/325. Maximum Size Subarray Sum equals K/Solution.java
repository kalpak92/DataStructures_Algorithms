/**
 * Given an array nums and a target value k, find the maximum length of a subarray that sums to k. 
 * If there isn't one, return 0 instead.
 * 
 * Note:
 * The sum of the entire nums array is guaranteed to fit within the 32-bit signed integer range.
 * 
 * Example 1:
 * Input: nums = [1, -1, 5, -2, 3], k = 3
 * Output: 4 
 * Explanation: The subarray [1, -1, 5, -2] sums to 3 and is the longest.
 * 
 * Example 2:
 * Input: nums = [-2, -1, 2, 1], k = 1
 * Output: 2 
 * Explanation: The subarray [-1, 2] sums to 1 and is the longest.
 * 
 * Follow Up:
 * Can you do it in O(n) time?
 */

class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        int runningSum = 0;
        int result = 0;
        
        // The Map stores the sum of all elements before index i as key, and i as value. 
        // For each i, check not only the current sum but also (currentSum - previousSum) to see if there is any that equals k, 
        // and update max length.
        
        // What map.containsKey(sum - k) returns is the index where the sum of every element up to that index from index 0 is sum - k, or (7 - 4) == 3, in our example. 
        // Let's say that that index returned by map.containsKey(sum - k) is 2 (randomly chose one that is before index 5). 
        // So knowing that at index 2 the total sum is 4, and at index 5, the total sum is 7, that means the elements between index 2 and index 5 incremented the total sum by 3, or k
        
        Map<Integer, Integer> sumIndex =  new HashMap<>();
        
        for(int i = 0; i < nums.length; i++) {
            runningSum += nums[i];
            
            if(runningSum == k){
                result = i + 1;
            } else if(sumIndex.containsKey(runningSum- k)) {
                result = Math.max(result, i - sumIndex.get(runningSum - k));
            } 
            if(!sumIndex.containsKey(runningSum)) {
                sumIndex.put(runningSum, i);
            }
        }
        return result;
    }
}