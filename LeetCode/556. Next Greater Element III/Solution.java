/**
 * Given a positive integer n, 
 * find the smallest integer which has exactly the same digits existing in the integer n and is greater in value than n. 
 * If no such positive integer exists, return -1.
 * 
 * Note that the returned integer should fit in 32-bit integer, if there is a valid answer but it does not fit in 32-bit integer, return -1.
 * 
 * Example 1:
 * Input: n = 12
 * Output: 21
 * 
 * Example 2:
 * Input: n = 21
 * Output: -1
 * 
 * Constraints:
 * 1 <= n <= 231 - 1
 */

public class Solution {
    public int nextGreaterElement(int n) {
        char[] number = (n+"").toCharArray();
        
        int i, j;
        
        // Starting from right, find the first digit that is smaller than the previous digit.
        for(i = number.length - 1; i > 0;i--) {
            if(number[i - 1] < number[i])
                break;
        }
        
        if(i == 0)  // Edge case: the elements were in decreasing order
            return -1;
        
        // Find the smallest digit to the right of the (i - 1)th position 
        int x = number[i - 1];
        int smallest = i;
        for (j = i + 1; j < number.length; j++)
            if (number[j] > x && number[j] <= number[smallest])
                smallest = j;
        
        // Swap the smallest digit and number[i - 1]
        char temp = number[i-1];
        number[i-1] = number[smallest];
        number[smallest] = temp;
        
        // Sort the digits after (i-1) in ascending order
        Arrays.sort(number, i, number.length);
        
        long val = Long.parseLong(new String(number));
        return (val <= Integer.MAX_VALUE) ? (int) val : -1;
    }   
}
