/**
 * Given a m x n grid filled with non-negative numbers, 
 * find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 * 
 * Note: You can only move either down or right at any point in time.
 * 
 * Example:
 * Input:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 
 * Output: 7
 * 
 * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 */

class Solution2 {
    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        // each time when we update memo[i][j], we only need grid[i - 1][j] (at the current column) and grid[i][j - 1] (at the left column). 
        // So we need not maintain the full m*n matrix.
        
        int[] memo = new int[n];
        memo[0] = grid[0][0];
        
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(i == 0 && j > 0)
                    memo[j] = memo[j - 1] + grid[i][j];
                else if (i > 0 && j ==0)
                    memo[j] = memo[j] + grid[i][j];
                else if (i > 0 && j > 0)
                    memo[j] = Math.min(memo[j], memo[j-1]) + grid[i][j];
            }
        }
        return memo[n - 1];
    }

    public static void main(String[] args)
    {
        int[][] grid = {{1,3,1}, {1,5,1}, {4,2,1}};

        System.out.println(minPathSum(grid));
    }
}