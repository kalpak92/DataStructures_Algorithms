/**
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 * 
 * You may assume no duplicates in the array.
 * 
 * Example 1:
 * Input: [1,3,5,6], 5
 * Output: 2
 * 
 * Example 2:
 * Input: [1,3,5,6], 2
 * Output: 1
 * 
 * Example 3:
 * Input: [1,3,5,6], 7
 * Output: 4
 * 
 * Example 4:
 * Input: [1,3,5,6], 0
 * Output: 0
 */

class Solution {
    public int searchInsert(int[] nums, int target) {
        if(nums == null || nums.length == 0)
            return -1;
        
        int left = 0;
        // Note that the input target might be larger than all elements in nums.
        // Therefore needs to placed at the end of the array. 
        // So, initialize right = nums.length instead of right = len(nums) - 1.
        int right = nums.length;
        
        while(left < right) {
            int mid = left + (right - left)/2;
            
            if(nums[mid] >= target)
                right = mid;
            else
                left = mid + 1;
        }
        return left;
    }
}