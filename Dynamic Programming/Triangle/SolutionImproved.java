/**
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
 * For example, given the following triangle
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * 
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * 
 * Note:
 * Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 */

import java.util.*;

public class SolutionImproved
{
   public static int minimumTotal(List<List<Integer>> triangle) 
   {
       /**
         * Algorithm:
         * 
         * 'Bottom-up' DP, on the other hand, is very straightforward: we start from the nodes on the bottom row; 
         * the min pathsums for these nodes are the values of the nodes themselves. 
         * 
         * From there, the min pathsum at the ith node on the kth row would be the lesser of the pathsums of its two children plus the value of itself, i.e.:
         * minpath[k][i] = min( minpath[k+1][i], minpath[k+1][i+1]) + triangle[k][i];
         * 
         * Or even better, since the row minpath[k+1] would be useless after minpath[k] is computed, we can simply set minpath as a 1D array, and iteratively update itself:
         * 
         * For the kth level:
         * minpath[i] = min( minpath[i], minpath[i+1]) + triangle[k][i]; 
         */
        int rowNum = triangle.size();
        
        //create a DP array of row size 
        int[] dp = new int [rowNum];
        
        // fill the DP array to the elements of the last row
        for(int i = 0; i < triangle.get(rowNum - 1).size(); i++)
        {
            dp[i] = triangle.get(rowNum - 1).get(i);
        }
        
        // dp[i] = min( dp[i], dp[i+1]) + triangle[k][i]; 
        // Using this recurrence, compute the rest starting from the second last row of the triangle
        // Here i the row and j acts as the column
        for(int i = rowNum - 2; i >= 0; i--)
        {
            for(int j = 0; j <= i; j++)
            {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
   }

   public static void main(String[] args)
   {
       List<List<Integer>> triangle  = new ArrayList<>();

       triangle.add(Arrays.asList(2));
       triangle.add(Arrays.asList(3, 4));
       triangle.add(Arrays.asList(6, 5, 7));
       triangle.add(Arrays.asList(4, 1, 8, 3));

       System.out.println(minimumTotal(triangle));
   }
}