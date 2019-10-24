/**
 * Given a 2D array of distinct integers where each row is sorted and each column is also sorted.
 * The matrix does not necessarily have the same height and width.
 * You are also given a target number.
 * 
 * Write a function that returns an array of the row and column indices of the target number, if it is contained in the matrix, and [-1, -1] if not.
 * 
 * Sample Input:
 * [
 *  [1 4 7 12 15 1000]
 *  [2 5 19 31 32 1001]
 *  [3 8 24 33 35 1002]
 *  [40 41 42 44 45 1003]
 *  [99 100 103 106 128 1004]
 * ]
 * 
 * Sample Output:
 *  [3, 3]
 */
public class SearchSortedMatrix
{
    public static int[] searchInSortedMatrix(int[][] matrix, int target) {
        int row = 0;
        int col = matrix[0].length - 1;
        
        while(row < matrix.length && col >=0)
        {
            if(matrix[row][col] > target)
                col--;
            else if(matrix[row][col] < target)
                row++;
            else
                return new int[] {row, col};
        }
        return new int[] {-1, -1};
    }

    public static void main(String[] args) {
        int mat[][] = {
                        {1, 4, 7, 12, 15, 1000},
                        {2, 5, 19, 31, 32, 1001},
                        {3, 8, 24, 33, 35, 1002},
                        {40, 41, 42, 44, 45, 1003},
                        {99, 100, 103, 106, 128, 1004}
                    };

        int[] result = searchInSortedMatrix(mat, 44);

        for (int i: result)
            System.out.print(i + " ");

        System.out.println();
    }
}