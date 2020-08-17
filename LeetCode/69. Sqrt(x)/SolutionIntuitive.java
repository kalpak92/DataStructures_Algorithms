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


public class SolutionIntuitive {
    public int mySqrt(int x) {
        if(x < 2) {
            return x;
        }
        
        int left = 1;
        int right = x;
        int result = 0;
        
        while(left <= right) {
            int mid = left + (right - left) / 2;
            
            if(mid > x/mid) {
                // this means mid^2 > x, so reduce the search range.
                // avoid squaring mid to avoid overflow.
                right = mid - 1;
            }
            else {
                left = mid + 1;
                result = mid;
            }
        }
        return result;
    }
}