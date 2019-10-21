/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * 
 * You may assume no duplicate exists in the array.
 * 
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * 
 * Example 1:
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * 
 * Example 2:
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 */

 class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        
        while(start <= end)
        {
            int mid = start + (end - start)/2;
            
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] >= nums[start])  // pivot > start element so part of the array from the start to the pivot is not rotated.
            {
                if(target >= nums[start] && target < nums[mid]) // if target < pivot, go left
                    end = mid - 1;
                else
                    start = mid + 1;            // go right
            }
            else {
                // pivot is less than the start element. So rotation has happened somewhere from 0 to pivot.
                if (target > nums[mid] && target <= nums[end])
                    start = mid + 1;                            // go right if target is in that range
                else
                    end = mid - 1;
            }
        }
        
        return -1; // if target does not exist.
    }
}