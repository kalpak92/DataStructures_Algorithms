/**
 * A peak element is an element that is greater than its neighbors.
 * Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.
 * The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
 * You may imagine that nums[-1] = nums[n] = -∞.
 * 
 * Example 1:
 * Input: nums = [1,2,3,1]
 * Output: 2
 * Explanation: 3 is a peak element and your function should return the index number 2.
 * 
 * Example 2:
 * Input: nums = [1,2,1,3,5,6,4]
 * Output: 1 or 5 
 * Explanation: Your function can return either index number 1 where the peak element is 2, 
 *              or index number 5 where the peak element is 6.
 * 
 * Follow up: Your solution should be in logarithmic complexity.
 */

class Solution {
    public int findPeakElement(int[] nums) {
        if (nums.length == 1)
            return 0;
        
        int left = 0;
        int right = nums.length - 1;
        
        while(left <= right) {
            int mid = left + (right - left)/2;
            
            if(mid > 0 && mid < nums.length - 1) {
                if(nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1])
                    return mid;
                else if (nums[mid - 1] > nums[mid])
                     right = mid - 1;
                else 
                    left = mid + 1;
            } else if (mid == 0) {
                if(nums[mid] > nums[mid + 1])
                    return 0;
                else
                    return 1;
            } else if (mid == nums.length - 1) {
                if(nums[mid] > nums[mid - 1])
                    return nums.length - 1;
                else
                    return nums.length - 2;
            }
        }
        return -1;
    }
}