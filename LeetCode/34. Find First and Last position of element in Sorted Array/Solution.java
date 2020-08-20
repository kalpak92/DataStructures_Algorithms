/**
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 * 
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * 
 * If the target is not found in the array, return [-1, -1].
 * 
 * Example 1:
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * 
 * Example 2:
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 */

class Solution {
    public int[] searchRange(int[] nums, int target) {
        // Check for base condition
        if(nums == null || nums.length == 0)
            return new int[]{-1, -1};
        
        int[] result = new int[2];
        int left = 0;
        int right = nums.length - 1;
        
        
        // If A[mid] < target, then the range must begins on the right of mid (hence left = mid+1 for the next iteration)
        // If A[mid] > target, it means the range must begins on the left of mid (right = mid - 1)
        // If A[mid] = target, then the range must begins on the left of or at mid (right = mid)
        
        // Again, we can merge condition 2 and 3 into:
        // 2 * If A[mid] <= target, then i = mid;

        while(left < right) {
            int mid = left + (right - left)/2;
            
            if(target > nums[mid]) {
                left = mid + 1;
            }
            else
                right = mid;
        }
        if(target == nums[left])
            result[0] = left;
        else
            result[0] = -1;
        
        right = nums.length - 1;
        while(left < right) {
            // mid always tends to the floor value.
            // By adding 1, we asking mid to go to ceil, which is what we want.
            int mid = left + (right - left)/2 + 1;
            
            if(target < nums[mid])
                right = mid - 1;
            else
                left = mid;
        }
        if(target == nums[right])
            result[1] = right;
        else
            result[1] = -1;
        
        return result;
    }
}