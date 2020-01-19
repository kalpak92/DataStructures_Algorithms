/**
 * Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency of any one of its elements.
 * Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.
 * 
 * Example 1:
 * Input: [1, 2, 2, 3, 1]
 * Output: 2
 * 
 * Explanation: 
 * The input array has a degree of 2 because both elements 1 and 2 appear twice.
 * Of the subarrays that have the same degree:
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * The shortest length is 2. So return 2.
 * 
 * Example 2:
 * Input: [1,2,2,3,1,4,2]
 * Output: 6
 * 
 * Note:
 * nums.length will be between 1 and 50,000.
 * nums[i] will be an integer between 0 and 49,999.
 */

class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        Map<Integer, Integer> index = new HashMap<>();
        
        int temp = 0;
        int result = 0;
        
        for(int i = 0; i < nums.length; i++)
        {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
            index.putIfAbsent(nums[i], i);
            
            // if the degree of the current number is more after adding to the map -> update degree and compute result
            if(freq.get(nums[i]) > temp)
            {
                temp = freq.get(nums[i]);               // store the new degree
                result = i - index.get(nums[i]) + 1;    // update the result
            }
            else if (freq.get(nums[i]) == temp)
            {
                result = Math.min(result, i - index.get(nums[i]) + 1);
            }
        }
        
        return result;
    }
}