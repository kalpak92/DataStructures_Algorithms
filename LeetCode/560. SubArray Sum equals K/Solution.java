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
        int result = 0;
        int runningSum = 0;
        
        // Remember the frequency of all prefix sums.
        // runningSum to keep track of sum of all the elements so far. 
        // If we can find a prefix sum in the map for sum-k, 
        //  it means we can form sum == k using the elements after the element corresponding to             that prefix sum till the current element (included). 
        //Count all such sums at each element.
        
        Map<Integer, Integer> prefixSumFreq = new HashMap<>();
        
        prefixSumFreq.put(0, 1);
        
        for(int i = 0; i < nums.length; i++)
        {
            runningSum += nums[i];                      // prefix sum
            
            if(prefixSumFreq.containsKey(runningSum - k))
                result += prefixSumFreq.get(runningSum - k);
            
            prefixSumFreq.put(runningSum, prefixSumFreq.getOrDefault(runningSum, 0) + 1);
        }
        return result;
    }
}