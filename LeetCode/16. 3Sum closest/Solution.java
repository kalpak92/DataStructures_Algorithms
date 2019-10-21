/**
 * Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. 
 * Return the sum of the three integers. You may assume that each input would have exactly one solution.
 * 
 * Example:
 * 
 * Given array nums = [-1, 2, 1, -4], and target = 1.
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */

 class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = nums[0] + nums[1] + nums[2];
            
        for(int i = 0; i < nums.length; i++)
        {
            int left = i + 1;
            int right = nums.length - 1;
            
            while(left < right)
            {
                int sum = nums[left] + nums[right] + nums[i];
                
                if(Math.abs(sum - target) < Math.abs(closest - target))  //check for closeness
                    closest = sum;
                
                if(sum > target)
                    right --;
                
                if(sum < target)
                    left ++;
                
                if(sum == target)
                    return closest;
            }
        }
        return closest;
    }
}