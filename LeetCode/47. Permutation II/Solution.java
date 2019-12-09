/**
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 * 
 * Example:
 * Input: [1,1,2]
 * Output:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 */

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        
        List<List<Integer>> result = new ArrayList<>();
        
        backtrack(result, new ArrayList<>(), nums, new boolean [nums.length]);
        
        return result;
    }
    
    private void backtrack(List<List<Integer>> result, List<Integer> temp, int[] nums, boolean[] used)
    {
        if(temp.size() == nums.length)
            result.add(new ArrayList<>(temp));
        else
        {
            for(int i = 0; i < nums.length; i++)
            {
                if(used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) // check if already i is used or the number is same as the previous number
                    continue;
                
                used[i] = true;     // mark the number as used
                temp.add(nums[i]);
                backtrack(result, temp, nums, used);
                
                used[i] = false;       // unmark the same.
                temp.remove(temp.size() - 1);
            }
        }
    }
}