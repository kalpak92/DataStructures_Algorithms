/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
 * 
 * Find the minimum element.
 * You may assume no duplicate exists in the array.
 * 
 * Example 1:
 * Input: [3,4,5,1,2] 
 * Output: 1
 * 
 * Example 2:
 * Input: [4,5,6,7,0,1,2]
 * Output: 0
 */

class Solution {
    public int findMin(int[] nums) {
        int result = Integer.MIN_VALUE;
        int left = 0;
        int right = nums.length - 1;
        
        while(left <= right) {
            int mid = left + (right - left)/2;
            
            if(nums[left] <= nums[right])
                return nums[left];
            
            // Prevents overflow
            int next = (mid + 1) % nums.length;
            int prev = (mid - 1 + nums.length) % nums.length;
            
            // Check for minimum element
            if(nums[mid] <= nums[prev] && nums[mid] <= nums[next]) {
                result = nums[mid];
                break;
            }
            
            // Need to go in the direction of the unsorted array
            if(nums[left] <= nums[mid])
                left = mid + 1;
            else if(nums[mid] <= nums[right])
                right = mid - 1;
        }
        return result;
    }
}