/**
 * Given a sequence of n integers a1, a2, ..., an, a 132 pattern is a subsequence ai, aj, ak such that i < j < k and ai < ak < aj. 
 * Design an algorithm that takes a list of n numbers as input and checks whether there is a 132 pattern in the list.
 * 
 * Note: n will be less than 15,000.
 * Example 1:
 * Input: [1, 2, 3, 4]
 * Output: False
 * Explanation: There is no 132 pattern in the sequence.
 * 
 * Example 2:
 * Input: [3, 1, 4, 2]
 * Output: True
 * Explanation: There is a 132 pattern in the sequence: [1, 4, 2].
 * 
 * Example 3:
 * Input: [-1, 3, 2, 0]
 * Output: True
 * Explanation: There are three 132 patterns in the sequence: [-1, 3, 2], [-1, 3, 0] and [-1, 2, 0].
 */

 /**
  * ALGORITHM:  We can start from either side but I think starting from the right allow us to finish in a single pass. 
                The idea is to start from end and search for valid (s2,s3) pairs, we just need to remember the largest valid s3 value, using a stack will be effective for this purpose. 
                A number becomes a candidate for s3 if there is any number on the left bigger than it.
  */

class Solution {
    public boolean find132pattern(int[] nums) {
        if (nums.length == 0)
            return false;
        
        Stack<Integer> stack = new Stack<>();
        int s3 = Integer.MIN_VALUE;
        
        for(int i = nums.length - 1; i >= 0; i--)
        {
            if(nums[i] < s3)
                return true;
            else {
                while(!stack.isEmpty() && nums[i] > stack.peek())
                {
                    s3 = stack.pop();
                }
                stack.push(nums[i]);
            }
        }
        return false;
    }
}