/**
 * Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.
 * 
 * Return the quotient after dividing dividend by divisor.
 * 
 * The integer division should truncate toward zero.
 * Example 1:
 * Input: dividend = 10, divisor = 3
 * Output: 3
 * 
 * Example 2:
 * Input: dividend = 7, divisor = -3
 * Output: -2
 * 
 * Note:
 * Both dividend and divisor will be 32-bit signed integers.
 * The divisor will never be 0.
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−2^31,  2^31 − 1]. 
 * For the purpose of this problem, assume that your function returns 2^31 − 1 when the division result overflows.
 */

 class Solution
 {
    public int divide(int dividend, int divisor)
    {
        // Handle the overflow condition : Edge case
        if(dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;

        int a = Math.abs(dividend);
        int b = Math.abs(divisor);
        int res = 0;

        while(a - b >= 0)               // can we take divisors away from the divident at least once ??
        {
            int x = 0;                  // 2^0 = 1. x is the exponent here.

            while (a - (b << 1 << x) >= 0)   // Double the divisor each time and check if that can be subtracted from the dividend.
                x++;

            res += 1 << x;              // update the result. 
            a -= b << x;                // reduce the dividend
        }

        return (dividend >= 0 == divisor >= 0) ? res : -res;
    }
 }