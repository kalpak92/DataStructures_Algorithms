/**
 * Given a list of non negative integers, arrange them such that they form the largest number.
 * 
 * Example 1:
 * Input: [10,2]
 * Output: "210"
 * 
 * Example 2:
 * Input: [3,30,34,5,9]
 * Output: "9534330"
 * Note: The result may be very large, so you need to return a string instead of an integer.
 */

 public class Solution {
    public String largestNumber(int[] nums) {
        // Corner Case
        if(nums == null || nums.length == 0)
            return "";
        
        // Convert int[] to String[]
        String[] sNums = new String[nums.length];
        for(int i = 0; i < nums.length; i++) {
            sNums[i] = String.valueOf(nums[i]);
        }
        
        // Sort the Array having the Greater Number first
        Arrays.sort(sNums, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));
        
        // Leetcode Specific Corner Case.
        // Considering a scenario where there
        if(sNums[0].charAt(0) == '0')
			return "0";
        
        // Recreate the result from the sorted array
        StringBuilder result = new StringBuilder();
		for(String s: sNums)
	        result.append(s);
		
		return result.toString();
    }
}
