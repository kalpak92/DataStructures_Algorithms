/**
 * Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. 
 * If there isn't one, return 0 instead.
 * 
 * Example: 
 * Input: s = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: the subarray [4,3] has the minimal length under the problem constraint.
 * 
 * Follow up:
 * If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n). 
 * 
 */

class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums == null)
            return 0;
        
        int result = Integer.MAX_VALUE;
        int runningSum = 0;
        int window = 0;
        
        for(int i = 0, j = 0;j < nums.length; j++) { // j is the fast pointer, i is the slower pointer
            runningSum += nums[j];
            window++;
            
            while(runningSum >= s) {
                result = Math.min(result,window);// update global ans.
                window--;
                runningSum -= nums[i];
                i++; // move the slower pointer forward and decrease the related nums[j], at the same time window will be decreased by 1.
            }
        }
        return (result == Integer.MAX_VALUE) ? 0: result;
    }
}