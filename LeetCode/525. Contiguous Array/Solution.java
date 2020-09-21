/**
 * Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.
 * 
 * Example 1:
 * Input: [0,1]
 * Output: 2
 * Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
 * 
 * Example 2:
 * Input: [0,1,0]
 * Output: 2
 * Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
 * 
 * Note: The length of the given binary array will not exceed 50,000. 
 */

class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> sumIndex = new HashMap<>();
        int sum = 0;
        int result = 0;
        
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0)
                nums[i] = -1;
        }
        
        // for the arr [-1,1], 
        // when entering the loop, when i=1, sum =-1+1=0. 
        // The length is i- (-1) -> 1-(-1) = 2. 
        // So put(0,-1) is needed.
        
        // It means that, before we loop this array, the sum is 0 in initial, and because we haven't starting loop, so the index = -1.
        sumIndex.put(0, -1);
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(sumIndex.containsKey(sum))
                result = Math.max(result, i - sumIndex.get(sum));
            else
                sumIndex.put(sum, i);
        }
        return result;
    }
}