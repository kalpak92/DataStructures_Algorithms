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
  * ALGORITHM
  
  - Create a stack and initialize a variable second with INT_MIN value.
  - Start traversing from the end of array.
  - Check if the current number is lesser than second. If it is, then it means our 132 pattern is satisfied as the stack is taking care of the 32 pattern and the current number satisfies the entire pattern. So return true.
  - If the above is not true, update the peak value in the stack. Keep popping from the stack until stack is empty OR the top value is greater than the current value.
  - Push the current number into the stack.
  - If the loop terminates, it means that the pattern was not found in the array. So, return false.
  */

class Solution {
    public boolean find132pattern(int[] nums) {
        int second = Integer.MIN_VALUE;
        Deque<Integer> stack = new ArrayDeque<>();
        
        for(int i = nums.length - 1; i >= 0; i--) {
            if(nums[i] < second)
                return true;
            else {
                while(!stack.isEmpty() && nums[i] > stack.peek()) {
                    second = stack.pop();
                }
                stack.push(nums[i]);
            }
        }
        return false;
    }
}