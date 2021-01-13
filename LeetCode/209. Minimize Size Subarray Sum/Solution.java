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
        if(nums == null || nums.length == 0)
            return 0;
        
        int result = Integer.MAX_VALUE;
        int windowSum = 0;
        int i = 0;
        int j = 0;
        
        while(j < nums.length) {
            windowSum += nums[j];
            
            if(windowSum < s)
                j++;
            else if(windowSum >= s) {
                // Shrink the window
                while(windowSum >= s) {
                    result = Math.min(result, j - i + 1);   // Important to note that we need to perform the check for minimum window inside the while loop for the best window and not outside, since we are interested in a lower bound
                    windowSum -= nums[i];
                    i++;
                }
                j++;
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}