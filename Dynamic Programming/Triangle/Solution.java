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

 public class Solution
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

        int rowNum = triangle.get(triangle.size() - 1).size();
        int colNum = triangle.size();

        int[][] dp = new int[rowNum][colNum];
        
        int i = 0;
        
        for (Integer n : triangle.get(colNum - 1)) 
        {
            dp[rowNum - 1][i++] = n;
        }
        
        for (int row = rowNum - 2, m = 0; row >= 0; row--, m++) 
        {
            for (int col = 0; col <= colNum - 2 - m; col++) 
            {
                dp[row][col] = Math.min(dp[row + 1][col], dp[row + 1][col + 1])
                            + triangle.get(row).get(col);
            }
        }
        return dp[0][0];
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