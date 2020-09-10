/**
 * Given an array of integers and an integer k, 
 * you need to find the total number of continuous subarrays whose sum equals to k.
 * 
 * Example 1:
 * Input:nums = [1,1,1], k = 2
 * Output: 2
 * 
 * Note:
 * The length of the array is in range [1, 20,000].
 * The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
 */

class Solution {
    public int subarraySum(int[] nums, int k) {
        int[] prefixSum = new int[nums.length + 1];
        int runningSum = 0;
        
        for(int i = 0; i < nums.length; i++) {
            runningSum += nums[i];
            prefixSum[i + 1] = runningSum;
        }
        
        // Now the problem becomes find two items from this prefixSum array 
        // such that prefixSum[j] - prefixSum[i] = k (similar to two sum)
        
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;
        
        for(int i = 0; i < prefixSum.length; i++) {
            if(map.containsKey(prefixSum[i])) {
                result += map.get(prefixSum[i]);
            }
            
            int target = k + prefixSum[i];
            map.put(target, map.getOrDefault(target, 0) + 1);
        }
        return result;
    }
}