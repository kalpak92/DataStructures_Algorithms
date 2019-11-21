/**
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 * 
 * Example:
 * Input: [10,9,2,5,3,7,101,18]
 * Output: 4 
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4. 
 * 
 * Note:
 * There may be more than one LIS combination, it is only necessary for you to return the length.
 * Your algorithm should run in O(n2) complexity.
 * Follow up: Could you improve it to O(n log n) time complexity?
 */

class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0)
            return 0;
        
        int[] maxLength = new int[nums.length];
        Arrays.fill(maxLength, 1);
        
        int maxSoFar = 1;
        /*
            We aim to see if we can append the item at nums[i]
            to extend the Longest Increasing Subsequence achieved
            from index 0...j (which is what the cache records)
            We want to solve for maxLength[i] if the value at 'i'
            beats 'j'. If we can we see which is greater between
            these then we have our answer:
            1.) maxLength[i]: The best answer so far for the LIS from 0...i
            2.) maxLength[j] + 1: The value of maxLength[j] is the length
            of the LIS from 0...j, we conceptually "append" this item to
            that LIS by adding 1 to that subproblem answer, yielding a
            potentially new answer for LIS[0..i]
        */
        for(int i = 1; i < nums.length; i++)
        {
            for(int j = 0; j < i; j++)
            {
                if(nums[i] > nums[j])
                {
                    maxLength[i] = Math.max(maxLength[i], maxLength[j] + 1);
                }
            }
            //System.out.println(maxLength[i]);
            maxSoFar = Math.max(maxSoFar, maxLength[i]);
        }
        //System.out.println(maxLength);
        return maxSoFar;
    }
}