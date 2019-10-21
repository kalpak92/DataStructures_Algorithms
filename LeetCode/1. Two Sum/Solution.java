/*
 * Given an array of integers, return indices of the two numbers such that they
 * add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may
 * not use the same element twice.
 *
 * Example:
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9, return [0, 1].
 */

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> diffMap = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++)
        {
            if(diffMap.containsKey(nums[i]))
            {
                return new int[]{diffMap.get(nums[i]), i};
            }
            else {
                diffMap.put((target - nums[i]), i);
            }
        }
        
        throw new IllegalArgumentException("No two sum solution.");
    }
}