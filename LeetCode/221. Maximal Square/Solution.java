/**
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
 * 
 * Example:
 * Input: 
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 * 
 * Output: 4
 */

class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0)
            return 0;
        
        int result = 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        
        // Initialize the first row and first column
        for(int i = 0; i < matrix[0].length; i++)
        {
            dp[0][i] = matrix[0][i] == '0' ? 0 : 1;
            if(dp[0][i] == 1)
                result = 1;
        }
        
        for(int i = 0; i < matrix.length; i++)
        {
            dp[i][0] = matrix[i][0] == '0' ? 0 : 1;
            if(dp[i][0] == 1)
                result = 1;
        }
        
        // Now for the rest of the matrix
        // For each element matrix[i][j], 
        // if matrix[i][j] == 1
        //      find the minimum of immediate left, top, diagonal and add 1 to it.
        
        for(int i = 1; i < matrix.length; i++)
        {
            for(int j = 1; j < matrix[0].length; j++)
            {
                if(matrix[i][j] == '0')
                    continue;
                
                int temp = Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1]));
                dp[i][j] = temp + 1;
                
                if(dp[i][j] > result)
                    result = dp[i][j];
            }
        }
        return result * result;
    }
}