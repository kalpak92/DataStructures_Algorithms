/**
 * Given an unsorted integer array nums, find the smallest missing positive integer.
 * 
 * Follow up: Could you implement an algorithm that runs in O(n) time and uses constant extra space.?
 * 
 * Example 1:
 * Input: nums = [1,2,0]
 * Output: 3
 * 
 * Example 2:
 * Input: nums = [3,4,-1,1]
 * Output: 2
 * 
 * Example 3:
 * Input: nums = [7,8,9,11,12]
 * Output: 1
 * 
 * Constraints:
 * 0 <= nums.length <= 300
 * -231 <= nums[i] <= 231 - 1
 */


public class Solution {
    public int firstMissingPositive(int[] nums) {
        // Numbers greater then n can be ignored because the missing integer must be in the range 1..n+1
        for(int i = 0; i < nums.length; i++) {
            while(nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1])
                swap(nums, i, nums[i] - 1);
        }
        
        // for(int i = 0; i < nums.length; i++)
        //     System.out.print(nums[i] + " ");
        
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != i+1)
                return i+1;
        }
        return nums.length+1;
        
    }
    
    private void swap(int[] nums, int i, int j) {
        nums[i] ^= nums[j];
        nums[j] ^= nums[i];
        nums[i] ^= nums[j];
    }
}
