/**
 * Given a collection of distinct integers, return all possible permutations.
 * 
 * Example:
 * Input: [1,2,3]
 * Output:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 */

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        Arrays.sort(nums);
        
        backtrack(result, new ArrayList<>(), nums);
        
        return result;
    }
    
    private void backtrack(List<List<Integer>> result, List<Integer> temp, int[] nums)
    {
        if(temp.size() == nums.length)
            result.add(new ArrayList<>(temp));
        else
        {
            for(int i = 0; i < nums.length; i++)
            {
                if(temp.contains(nums[i]))
                    continue;
                
                temp.add(nums[i]);
            
                backtrack(result, temp, nums);
            
                temp.remove(temp.size() - 1);
            }
        }
    }
}

