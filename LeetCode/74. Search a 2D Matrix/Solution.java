/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * 
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * 
 * Example 1:
 * Input:
 *  matrix = [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * 
 * target = 3
 * Output: true
 * 
 * Example 2:
 * 
 * Input:
 * matrix = [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * 
 * target = 13
 * Output: false
 */

class Solution {

    /** This is a O(n+m) solution */
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0)
            return false;
        
        int row = 0;
        int col = matrix[0].length - 1;
        
        while(row < matrix.length && col >= 0 )
        {
            if (matrix[row][col] > target)
                col--;
            else if(matrix[row][col] < target)
                row++;
            else
                return true;
        }
        return false;
    }

    public boolean searchMatrixII(int[][] matrix, int target)
    {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        
        int left = 0;
        int right = matrix.length*matrix[0].length - 1;
        
        while(left <= right) {
            int mid = left + (right - left)/2;
            int middleElement = matrix[mid/matrix[0].length][mid % matrix[0].length];
            
            if(target == middleElement)
                return true;
            else if(target > middleElement)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return false;
    }
}