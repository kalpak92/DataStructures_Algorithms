import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author kalpak
 *
 * Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target?
 * Find all unique quadruplets in the array which gives the sum of target.
 *
 * Note:
 *
 * The solution set must not contain duplicate quadruplets.
 *
 * Example:
 *
 * Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
 *
 * A solution set is:
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 */

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums == null || nums.length < 4 ) {
            return Collections.emptyList();
        }
        
        Arrays.sort(nums);
        
        return kSum(nums, 0, 4, target);
    }
    
    private List<List<Integer>> kSum(int[] nums, int start, int k, int target) {
        List<List<Integer>> result = new ArrayList<>();
        
        // Do a 2-Sum.
        if(k == 2) {
            int left = start;
            int right = nums.length - 1;
            
            while(left < right) {
                int sum = nums[left] + nums[right];
                
                if(sum == target) {
                    List<Integer> pair = new ArrayList<>();
                    pair.add(nums[left]);
                    pair.add(nums[right]);
                    
                    result.add(pair);
                    
                    // skip duplicates
                    while(left < right && nums[left] == nums[left + 1]) left++;
                    while(left < right && nums[right] == nums[right - 1]) right--;
                    
                    left++;
                    right--;
                }
                else if (sum < target)
                    left++;
                else
                    right--;
            }
        }
        else {
            // i < nums.length - k + 1, e.g., for 4Sum, i < nums.length - 3
            for(int i = start; i < nums.length - (k - 1); i++) {
                if(i > start && nums[i] == nums[i - 1])         // skip duplicates
                    continue;
                
                // Given the fixed number, solve a (K - 1)-Sum problem
                List<List<Integer>> kMinusOneSum = kSum(nums, i + 1, k - 1, target - nums[i]);
                
                // Prepend the fixed number to result of (K - 1)-Sum
                for(List<Integer> temp : kMinusOneSum) {
                    temp.add(0, nums[i]);
                }
                result.addAll(kMinusOneSum);
            }
        }
        return result;
    }
}