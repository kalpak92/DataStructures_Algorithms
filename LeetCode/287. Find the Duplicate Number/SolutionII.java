/**
 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), 
 * Prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.
 * 
 * Example 1:
 * Input: [1,3,4,2,2]
 * Output: 2
 * 
 * Example 2:
 * Input: [3,1,3,4,2]
 * Output: 3
 * 
 * Note:
 * You must not modify the array (assume the array is read only).
 * You must use only constant, O(1) extra space.
 * Your runtime complexity should be less than O(n2).
 * There is only one duplicate number in the array, but it could be repeated more than once.
 */

public class SolutionII {
    public int findDuplicate(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            while(nums[i] <= nums.length && nums[i] != nums[nums[i] - 1])
                swap(nums, i, nums[i] - 1);
        }

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != i+1)
                return nums[i];
        }
        return -1;
    }

    private void swap(int[] nums, int i, int j) {
        nums[i] ^= nums[j];
        nums[j] ^= nums[i];
        nums[i] ^= nums[j];
    }
}
