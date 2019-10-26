/**
 * Given an array nums sorted in non-decreasing order, and a number target, return True if and only if target is a majority element.
 * A majority element is an element that appears more than N/2 times in an array of length N.
 * 
 * Example 1:
 * Input: nums = [2,4,5,5,5,5,5,6,6], target = 5
 * Output: true
 * 
 * Explanation: 
 * The value 5 appears 5 times and the length of the array is 9.
 * Thus, 5 is a majority element because 5 > 9/2 is true.
 * 
 * Example 2:
 * Input: nums = [10,100,101,101], target = 101
 * Output: false
 * 
 * Explanation: 
 * The value 101 appears 2 times and the length of the array is 4.
 * Thus, 101 is not a majority element because 2 > 4/2 is false.
 * 
 * Note:
 * 1 <= nums.length <= 1000
 * 1 <= nums[i] <= 10^9
 * 1 <= target <= 10^9
 */

class Solution {
    public boolean isMajorityElement(int[] nums, int target) 
    {

        int highest = findIndex(nums, target, true);
    
        if (highest == -1) 
            return false;
    
        int lowest = findIndex(nums, target, false);
    
        return highest - lowest + 1 > nums.length / 2;
    }
  
    private int findIndex(int[] nums, int target, boolean isHighIndex) {
        int low = 0;
        int high = nums.length - 1;
        int mid = 0;
        int index = -1;
        
        while (low <= high) 
        {
            mid = low + (high - low) / 2;
            
            if (nums[mid] == target) 
            {
                index = mid;
                if (isHighIndex) 
                {
                    low = mid + 1;
                } 
                else {
                    high = mid - 1;
                }
            } 
            else if (nums[mid] > target) 
            {
                high = mid - 1;
            } 
            else 
            {
                low = mid + 1;
            }
        }
        return index;
    }
}