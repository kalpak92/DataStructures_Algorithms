/**
 * Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.
 * 
 * Example 1:
 * Input: [0,1]
 * Output: 2
 * Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
 * 
 * Example 2:
 * Input: [0,1,0]
 * Output: 2
 * Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
 * 
 * Note: The length of the given binary array will not exceed 50,000. 
 */

class Solution {
    public int findMaxLength(int[] nums) {
        int sum = 0;
        int result = 0;
        // To find the maximum length, we need a dict to store the value of count (as the key) and its associated index (as the value). 
        // We only need to save a count value and its index at the first time, when the same count values appear again, 
        // we use the new index subtracting the old index to calculate the length of a subarray. 
        // A variable max_length is used to to keep track of the current maximum length.
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0)
                sum++;
            else
                sum--;
            
            if(map.containsKey(sum))
                result = Math.max(result, i - map.get(sum));
            else
                map.put(sum, i);
        }
        return result;
    }
}