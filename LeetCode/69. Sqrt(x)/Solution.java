/**
 * Implement int sqrt(int x).
 * 
 * Compute and return the square root of x, where x is guaranteed to be a non-negative integer.
 * Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.
 * 
 * Example 1:
 * Input: 4
 * Output: 2
 * 
 * Example 2:
 * Input: 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since the decimal part is truncated, 2 is returned.
 */

class Solution {
    public int mySqrt(int x) {
        if (x < 2)
            return x;
        
        int low = 2;
        int high = x/2;
        long nums  = 0;
        
        while(low <= high)
        {
            int mid = low + (high - low)/2;
            nums = (long) mid * mid;
            
            if (nums > x)
                high = mid - 1;
            else if (nums < x)
                low = mid + 1;
            else
                return mid;
        }
        return high;
    }
}