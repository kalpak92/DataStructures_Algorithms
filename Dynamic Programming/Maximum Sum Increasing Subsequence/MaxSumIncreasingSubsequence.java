/**
 * Problem Statement:
 *
 * Given an array of n positive integers. Write a program to find the sum of maximum sum subsequence of the given array
 * such that the integers in the subsequence are in increasing order.
 *
 *
 * Reference:
 * http://www.geeksforgeeks.org/dynamic-programming-set-14-maximum-sum-increasing-subsequence/
 */

 public class MaxSumIncreasingSubsequence
 {
     public int maxSumIncreasingSubseq(int[] arr)
     {
        int[] dp = new int[arr.length];
        int result = 0;
         
        for(int i = 0; i < arr.length; i++)
            dp[i] = arr[i];

        for(int i = 1; i < arr.length; i++)
        {
            for(int j = 0; j < i; j++)
            {
                if(arr[j] < arr[i])
                {
                    dp[i] = Math.max(dp[i], dp[j] + arr[i]);
                }
            }
            result = Math.max(result, dp[i]);
        }
        return result;
     }

     public static void main(String args[]){
        MaxSumIncreasingSubsequence msis = new MaxSumIncreasingSubsequence();
        int arr[] = {1, 101, 10, 2, 3, 100,4};
        int r = msis.maxSumIncreasingSubseq(arr);
        System.out.println(r);
    }
 }