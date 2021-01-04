/**
 * Given an array of integers A, find the sum of min(B), where B ranges over every (contiguous) subarray of A.
 * Since the answer may be large, return the answer modulo 10^9 + 7.
 * 
 * Example 1:
 * Input: [3,1,2,4]
 * Output: 17
 * Explanation: Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4]. 
 * Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.  Sum is 17.
 * 
 * Note:
 * 1 <= A.length <= 30000
 * 1 <= A[i] <= 30000
 * 
 * Example 2:
 * Input: arr = [11,81,94,43,3]
 * Output: 444
 * 
 * Constraints:
 * 1 <= arr.length <= 3 * 104
 * 1 <= arr[i] <= 3 * 104
 */

public class Solution {
    public int sumSubarrayMins(int[] arr) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] left = new int[arr.length];
        int[] right = new int[arr.length];
        int result = 0;
        int mod = (int)1e9 + 7;

        // Initialize the left and right array
        for(int i = 0; i < arr.length; i++) {
            left[i] = i+1;
            right[i] = arr.length - i;
        }

        for(int i = 0; i < arr.length; i++) {
            while(!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                right[stack.peek()] = i - stack.peek(); // distance between element A[i] and its NLE.
                stack.pop();
            }

            if(!stack.isEmpty()) {
                left[i] = i - stack.peek(); // distance between element A[i] and its PLE.
            } else {
                left[i] = i+1;
            }
            stack.push(i);
        }

        for(int i = 0; i < arr.length; i++) {
            result = (result + arr[i] * left[i] * right[i]) % mod;    // sum(A[i]*left[i]*right[i] )
        }
        return (int)result;
    }
}
