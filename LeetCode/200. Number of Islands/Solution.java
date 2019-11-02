/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. 
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. 
 * You may assume all four edges of the grid are all surrounded by water.
 * 
 * Example 1:
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 * 
 * Output: 1
 * 
 * Example 2:
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 * 
 * Output: 3
 *
 * Alternative Solution:
 * https://github.com/kalpak92/DataStructures_Algorithms/blob/master/Disjoint%20Sets/CountIslands.java
 */

class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0)
            return 0;
        
        int result = 0;
        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[i].length; j++)
            {
                if(grid[i][j] == '1')
                {
                    result += dfs(grid, i, j);
                }
            }
        }
        return result;
    }
    
    private int dfs(char[][] grid, int i, int j)
    {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0')
            return 0;
            
        grid[i][j] = '0';       // sink the islands and continue hunting for connections.
        
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
        return 1;
    }
}