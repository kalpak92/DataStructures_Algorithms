/**
 * Given a list of non-negative numbers and a target integer k, 
 * write a function to check if the array has a continuous subarray of size at least 2 that sums up to a multiple of k, that is, sums up to n*k where n is also an integer.
 * 
 * Example 1:
 * Input: [23, 2, 4, 6, 7],  k=6
 * Output: True
 * 
 * Explanation: Because [2, 4] is a continuous subarray of size 2 and sums up to 6.
 * 
 * Example 2:
 * Input: [23, 2, 6, 4, 7],  k=6
 * Output: True
 * 
 * Explanation: Because [23, 2, 6, 4, 7] is an continuous subarray of size 5 and sums up to 42.
 * 
 * Constraints:
 * 
 *     The length of the array won't exceed 10,000.
 *     You may assume the sum of all the numbers is in the range of a signed 32-bit integer.
 */

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        /**
          * We iterate through the input array exactly once, keeping track of the running sum mod k of the elements in the process. 
          * If we find that a running sum value at index j has been previously seen before in some earlier index i in the array, 
          * then we know that the sub-array (i,j] contains a desired sum.
          *
          * If we can find any two subarray of prefix sum have same mod value, then their difference MUST be divisible by k.
          * So we can use a map to store mod value of each prefix sum in map, with its index.
          * Then check if the map contains the same mod value with size >= 2 in every iteration.
          */
        
        // Corner Case
        if (nums.length < 2)
            return false;
        
        int runningSum = 0;
        Map<Integer, Integer> modMap = new HashMap<>();
        // Corner case
        // If the very first subarray with first two numbers in array could form the result, we need to put mod value 0 and index -1 to make it as a true case
        modMap.put(0, -1);
        
        for(int i = 0; i < nums.length; i++) {
            runningSum += nums[i];
            
            if(k != 0)
                runningSum %= k;
            
            // Check in map
            if(modMap.containsKey(runningSum)) {
                if(i - modMap.get(runningSum) > 1)
                    return true;
            } else {
                modMap.put(runningSum, i);
            }
        }
        return false;        
    }
}