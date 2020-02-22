/**
 * Write a program to check whether a given number is an ugly number.
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 * 
 * Example 1:
 * Input: 6
 * Output: true
 * Explanation: 6 = 2 × 3
 * 
 * Example 2:
 * Input: 8
 * Output: true
 * Explanation: 8 = 2 × 2 × 2
 * 
 * Example 3:
 * Input: 14
 * Output: false 
 * Explanation: 14 is not ugly since it includes another prime factor 7.
 * 
 * Note:
 * 1 is typically treated as an ugly number.
 * Input is within the 32-bit signed integer range: [−231,  231 − 1].
 */

class Solution {
    public boolean isUgly(int num) {
        // Just divide by 2, 3 and 5 as often as possible and then check whether we arrived at 1.
        for (int i=2; i < 6 && num > 0; i++)
            while (num % i == 0)
                num /= i;
    
        return num == 1;
    }
}