/**
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? 
 * Find all unique triplets in the array which gives the sum of zero.
 * 
 * Note:
 * The solution set must not contain duplicate triplets.
 * 
 * Example:
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 * A solution set is:
 * [
 *  [-1, 0, 1],
 *  [-1, -1, 2]
 * ]
 */

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        
        List<List<Integer>> result = new ArrayList<>();
        
        for(int i = 0; i< nums.length - 2; i++)
        {
            if(i == 0 || (i > 0 && nums[i] != nums[i - 1])) // check for duplicates, i.e we skip the same elements for which computation has already been done
            {
                int low = i + 1;
                int high = nums.length - 1;
                int sum = 0 - nums[i];
                
                while(low < high)
                {
                    if (nums[low] + nums[high] == sum)
                    {
                         result.add(Arrays.asList(nums[i], nums[low], nums[high]));
                        
                        // ignore duplicates.
                        while(low < high && nums[low] == nums[low + 1]) low++;
                        while(low < high && nums[high] == nums[high - 1]) high--;
                        
                        // increment and decrement low and high
                        low++;
                        high--;
                    }   
                    else if (nums[low] + nums[high] < sum)
                    {
                        low ++;
                    }
                    else
                    {
                        high--;
                    }
                }
            }
        }
        return result;
    }
}