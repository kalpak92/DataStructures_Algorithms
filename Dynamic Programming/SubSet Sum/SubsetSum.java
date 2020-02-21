/**
 * Given an array of non negative numbers and a total, is there subset of numbers in this array which adds up
 * to given total.
 */

 public class SubsetSum
 {
     public boolean isSubsetSum(int[] data, int total)
     {
         boolean[][] dp = new boolean[data.length + 1][total + 1];

         // Now the first column will have all true values.
         // This is because we can make a ZERO sum with having an empty set.
         for(int i = 0; i < data.length + 1; i++)
            dp[i][0] = true;

        // Fill up the DP Array by putting dp[i-i][j] in dp[i][j] if num < sum
        // else decide between dp[i-1][j] || dp[i - 1][j - data[i]]

        for(int num = 1; num < data.length + 1; num++)
        {
            for(int sum = 1; sum < total + 1; sum++)
            {
                if(sum < data[num - 1])
                    dp[num][sum] = dp[num - 1][sum];
                else
                    dp[num][sum] = dp[num - 1][sum] || dp[num - 1][sum - data[num - 1]];
            }
        }
        return dp[data.length][total];
     }

     public static void main(String[] args) {
         SubsetSum ss = new SubsetSum();
         int arr[] = {2, 3, 7, 8};
         System.out.println(ss.isSubsetSum(arr, 11));
     }
 }