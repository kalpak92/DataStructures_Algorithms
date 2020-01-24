/**
 * Write an algorithm to determine if a number is "happy".
 * 
 * A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
 * 
 * Example: 
 * Input: 19
 * Output: true
 * 
 * Explanation: 
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 */

class Solution {
    public boolean isHappy(int n) {
        Set<Integer> isPresent = new HashSet<>(); // keep track of all the numbers computed by squaring the sum of digits
        
        // If the number is not 1 or not present in the set, compute next.
        // If present, get out and return false, or if the number is equal to 1, return true.
        while(n != 1 && !isPresent.contains(n))
        {
            isPresent.add(n);
            n = computeNext(n);
        }
        
        return n == 1;
    }
    
    // Helper function to calculate the next by taking the square sum of each digit and return the sum
    private int computeNext(int num)
    {
        int sum = 0;
        
        while(num > 0)
        {
            int digit = num % 10;
            num /= 10;
            sum += digit * digit;
        }
        
        return sum;
    }
}