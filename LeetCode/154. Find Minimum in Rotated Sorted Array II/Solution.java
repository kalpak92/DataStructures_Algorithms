/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
 * 
 * Find the minimum element.
 * The array may contain duplicates.
 * 
 * Example 1:
 * Input: [1,3,5]
 * Output: 1
 * 
 * Example 2:
 * Input: [2,2,2,0,1]
 * Output: 0
 * 
 * Note:
 * This is a follow up problem to Find Minimum in Rotated Sorted Array.
 * Would allow duplicates affect the run-time complexity? How and why?
 */

class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        
        while(left < right) {
            int mid = left + (right - left)/2;
            
            if(nums[mid] < nums[right])
                right = mid;
            else if (nums[mid] > nums[right])
                left = mid + 1;
            else if(nums[mid] == nums[right]) // when num[mid] and num[hi] are same
                right--;
        }
        return nums[left];
    }
}