/**
 * Given an array A of integers, return the number of (contiguous, non-empty) subarrays that have a sum divisible by K.
 * 
 * Example 1:
 * Input: A = [4,5,0,-2,-3,1], K = 5
 * Output: 7
 * 
 * Explanation: 
 * There are 7 subarrays with a sum divisible by K = 5:
 * [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
 * 
 * Note:
 *     1 <= A.length <= 30000
 *     -10000 <= A[i] <= 10000
 *     2 <= K <= 10000
 */

/**
 * Logic:
 * 
 * We can all agree that for an array int[] A, where N = len(A), that there are N prefix sums.
 * prefix[0] = A[0], prefix[1] = A[0] + A[1], ... prefix[i] = A[0] + ... + A[i].
 * Then to calculate how many subarrays are divisible by K is logically equivalent to saying, 
 * how many ways can we pair up all prefix sum pairs (i,j) where i < j such that (prefix[j] - prefix[i]) % K == 0.
 * 
 * Just from that information alone we easily get a O(n^2) solution.
 * Compute all prefix sums, then check all pair to see if k divides the difference between them.
 * 
 * However, if we just exploit some information w.r.t to the remainder of each prefix sum we can manipulate this into a linear algorithm.
 * 
 * Number Theory
 * We need to find all prefix sum pairs (i,j) such tha (p[j] - p[i]) % K == 0.
 * But this is only true, if and only if p[j] % K == p[i] % K
 * Why is this?
 * 
 * According the the division algorithm we can express p[j] and p[i] in the following way.
 * p[j] = bK + r0 where 0 <= r0 < K
 * p[i] = aK + r1 where 0<= r1 < K
 * Then p[j] - p[i] = (b*K + r0) - (a*K + r1) = b*K - a*K + r0 - r1 = K*(b-a) + r0 - r1
 * 
 * Again: p[j] - p[i] = K*(b-a) + (r0-r1), 
 * In other words K only divides p[j] - p[i] iff r0-r1 = 0 <-> r0 = r1 
 * 
 * But we should not forget about elements in the array that do not need a pairing, namely those that are are divisible by K. 
 * That's why I add mod[0] at the end.
 * Also counting pairs => N choose 2 = > n*(n-1) / 2.
 */

class Solution {
    public int subarraysDivByK(int[] A, int K) {
        /**
         * There K mod groups 0...K-1
         * For each prefix sum that does not have remainder 0 it needs to be paired with 1 with the same remainder
         * this is so that the remainders cancel out.
         */
        int[] modFrequency = new int[K];
        int result = 0;
        int runningSum = 0;
        
        for(int i : A) {
            runningSum += i;
            
            int rem = runningSum % K;   // Java has negative remainders
            if(rem < 0) {
                rem += K;
            }    
            modFrequency[rem]++;
        }
        for(int mod : modFrequency) {
            if(mod > 1) {
                result += mod*(mod - 1)/2;
            }
        }
        return result + modFrequency[0];    // including all numbers that divide K  
    }
}