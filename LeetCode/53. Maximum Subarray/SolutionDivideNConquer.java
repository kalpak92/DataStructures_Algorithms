/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 * 
 * Example:
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * 
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * 
 * Follow up:
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 */

public class SolutionDivideNConquer {
    public int maxSubArray(int[] nums) {
        return maxSubArray(nums, 0, nums.length - 1);
    }
    
    private int maxSubArray(int[] nums, int left, int right) {
        // base condition
        if(left > right)
            return Integer.MIN_VALUE;
        
        int mid = left + (right - left)/2;
        
        int leftMax = maxSubArray(nums, left, mid - 1);
        int rightMax = maxSubArray(nums, mid + 1, right);
        
        // Check if the maximum subarray spans the two halves. 
        // For this case, we use a linear algorithm: starting from the middle element and move to both ends (left and right ends), record the maximum sum we have seen. 
        // In this case, the maximum sum is finally equal to the middle element plus the maximum sum of moving leftwards and the maximum sum of moving rightwards.
        
        int sum = 0;
        int leftSum = 0;
        for(int i = mid - 1; i >= left; i--) {
            sum += nums[i];
            leftSum = Math.max(leftSum, sum);
        }
        
        sum = 0;
        int rightSum = 0;
        for(int i = mid + 1; i <= right; i++) {
            sum += nums[i];
            rightSum = Math.max(rightSum, sum);
        }
        
        // Return the maximum of the lefthalf, righthalf or the sum spanning across both the halves.
        return Math.max(Math.max(leftMax, rightMax) , leftSum + rightSum + nums[mid]);
    }
}