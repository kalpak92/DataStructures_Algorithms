/**
 * Given a collection of candidate numbers (candidates) and a target number (target), 
 * find all unique combinations in candidates where the candidate numbers sums to target.
 * 
 * Each number in candidates may only be used once in the combination.
 * Note:
 * 
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * 
 * Example 1:
 * Input: candidates = [10,1,2,7,6,1,5], target = 8,
 * A solution set is:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 * 
 * Example 2:
 * Input: candidates = [2,5,2,1,2], target = 5,
 * A solution set is:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 */

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        
        backtrack(result, new ArrayList<>(), target, candidates, 0);
        
        return result;
    }
    
    private void backtrack(List<List<Integer>> result, List<Integer> temp, int remain, int[] candidates, int start)
    {
        if (remain < 0)
            return;
        else if (remain == 0)
        {
            result.add(new ArrayList<>(temp));
        }
        else {
            for(int i = start; i < candidates.length; i++)
            {
                if(i > start && candidates[i] == candidates[i - 1])
                    continue;
                
                temp.add(candidates[i]);
                backtrack(result, temp, remain - candidates[i], candidates, i+1);
                temp.remove(temp.size() - 1);
            }
        }
    }
}