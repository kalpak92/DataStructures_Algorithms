/**
 * In a given grid, each cell can have one of three values:
 * the value 0 representing an empty cell;
 * the value 1 representing a fresh orange;
 * the value 2 representing a rotten orange.
 * 
 * Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.
 * Return the minimum number of minutes that must elapse until no cell has a fresh orange.  If this is impossible, return -1 instead.
 * 
 * Example 1:
 * Input: [[2,1,1],[1,1,0],[0,1,1]]
 * Output: 4
 * 
 * Example 2:
 * Input: [[2,1,1],[0,1,1],[1,0,1]]
 * Output: -1
 * Explanation:  The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
 * 
 * Example 3:
 * Input: [[0,2]]
 * Output: 0
 * Explanation:  Since there are already no fresh oranges at minute 0, the answer is just 0.
 * 
 * Note:
 * 1 <= grid.length <= 10
 * 1 <= grid[0].length <= 10
 * grid[i][j] is only 0, 1, or 2.
 * 
 */

class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0)
            return -1;
        
        int fresh = 0;
        int days = 0;
        
        // Number of fresh oranges
        
        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[i].length; j++)
            {
                if(grid[i][j] == 1)
                    fresh++;
            }
        }
                
        for(int fresh_old = fresh; fresh > 0; days++)
        {
            for(int i = 0; i < grid.length; i++)
            {
                for(int j = 0; j < grid[i].length; j++)
                {
                    if(grid[i][j] == days + 2)      // start with day count = 0 and process all adjacent oranges which are rotten, i.e have a count of 2. Update the affected oranges with day count += 3 which helps in processing these oranges the next day subsequently.
                        fresh -= helper_rot(i + 1, j, days, grid) +
                                helper_rot(i - 1, j, days, grid) +
                                helper_rot(i, j + 1, days, grid) +
                                helper_rot(i, j - 1, days, grid); // decrement the count of fresh oranges.
                }
            }
            
            // if after a day, fresh count does not change
            if(fresh_old == fresh)
                return -1;
            
            fresh_old = fresh; // update the fresh_old counter.
        }
              
        return days;
    }
    
    private int helper_rot(int i, int j, int days, int[][] grid)
    {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] != 1)
            return 0;
        
        grid[i][j] = days + 3;
        return 1;
    }
}


 