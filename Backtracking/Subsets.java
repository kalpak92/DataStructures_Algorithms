import java.util.*;

/**
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 * 
 * Note: The solution set must not contain duplicate subsets.
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

 public class Subsets 
 {
     public List<List<Integer>> findSubsets(int[] nums)
     {
         List<List<Integer>> result = new ArrayList<>();
         Arrays.sort(nums);

         backtrack(result, new ArrayList<>(), nums, 0);
         return result;
     }

     private void backtrack(List<List<Integer>> result, List<Integer> temp, int[] nums, int start)
     {
         result.add(new ArrayList<>(temp));
         System.out.println("start = " + start + " result currently -> " + result);

         for(int i = start; i < nums.length; i++)
         {
            temp.add(nums[i]);
            System.out.println("i = " + i + " temp currently -> " + temp);
            System.out.println("Calling Backtrack recursive");
            backtrack(result, temp, nums, i + 1);

            System.out.println("After recursion call. i = " + i);
            temp.remove(temp.size() - 1);
            System.out.println("Temp currently after removal : " + temp);

         }
     }

     public static void main(String[] args) {
         Subsets obj = new Subsets();

         int[] nums = {2, 1, 3};

         System.out.println("Final result : " + obj.findSubsets(nums));
     }
 }