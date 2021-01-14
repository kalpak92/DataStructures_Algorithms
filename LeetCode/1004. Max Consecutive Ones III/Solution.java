/**
 * Given an array A of 0s and 1s, we may change up to K values from 0 to 1.
 * Return the length of the longest (contiguous) subarray that contains only 1s. 
 * 
 * Example 1:
 * Input: A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
 * Output: 6
 * Explanation: 
 * [1,1,1,0,0,1,1,1,1,1,1]
 * Bolded numbers were flipped from 0 to 1.  The longest subarray is underlined.
 * 
 * Example 2:
 * Input: A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
 * Output: 10
 * Explanation: 
 * [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
 * Bolded numbers were flipped from 0 to 1.  The longest subarray is underlined.
 * 
 * Note:
 * 1 <= A.length <= 20000
 * 0 <= K <= A.length
 * A[i] is 0 or 1 
 */

public class Solution {
    public int longestOnes(int[] A, int K) {
        int countZeros = 0;
        int i = 0;
        int j = 0;
        int result = 0;
        
        while(j < A.length) {
            // Calculation: If A[j] == 0, increase count
            if (A[j] == 0)
                countZeros++;
            
            if(countZeros > K) { // Need to shrink the window until a zero is removed from the window
                if(A[i] == 0)
                    countZeros--;
                i++;
            }
            // Since we can change upto K values. so the <= case falls here.
            // Update the result by checking for maximum window size.
            result = Math.max(result, j - i + 1);
            j++;
        }
        return result;
    }
}
