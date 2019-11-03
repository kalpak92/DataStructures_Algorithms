/**
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 * Note: The solution set must not contain duplicate subsets.
 * 
 * Example:
 * Input: nums = [1,2,3]
 * Output:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 */

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        Arrays.sort(nums);
        
        backtrack(result, new ArrayList<>(), nums, 0);
        
        return result;
    }
    
    private void backtrack(List<List<Integer>> result, List<Integer> temp, int[] nums, int start)
    {
        result.add(new ArrayList<>(temp));
        
        for(int i = start; i < nums.length; i++)
        {
            temp.add(nums[i]);
            
            backtrack(result, temp, nums, i+1);
            
            temp.remove(temp.size() - 1);
        }
    }
}