/**
 * Given a 2D matrix on m and n containing only 0s and 1s. Each 0 represents land and each 1 represents a part of the river.
 * A river consists of any number of 1s that are adjacent either horizontally or vertically . 
 * The number of 1s forming a river determine the size of the river.
 * 
 * Write a function that returns that returns the array of the sizes of all rivers represented by the input matrix.
 * 
 * Note : Sizes can be in any order.
 */

import java.util.ArrayList;

class RiverSizes {
  public static ArrayList<Integer> riverSizes(int[][] matrix) {
		if(matrix == null || matrix.length == 0)
			return new ArrayList<Integer>();
		
		ArrayList<Integer> result = new ArrayList<>();
		
		for(int i = 0; i < matrix.length; i++)
		{
			for (int j = 0; j < matrix[i].length; j++)
			{
				if (matrix[i][j] == 1)
				{
					result.add(getRiverSize(matrix, i, j));
				}
			}
		}
		return result;
  }
	
	public static int getRiverSize(int[][] grid, int i, int j)
	{
		if(i >= 0 && i < grid.length && j >= 0 && j < grid[i].length && grid[i][j] == 1)
		{
				// convert grid[i][j] to 0 to mark it as checked
				grid[i][j] = 0;

				// return 1 along sum of all the river sizes nearby ( horizontally and vertically)
				return 1 + getRiverSize(grid, i+1, j) + getRiverSize(grid, i-1, j) + getRiverSize(grid, i, j-1) + getRiverSize(grid, i, j+1);
		}
		return 0;
	}
}
