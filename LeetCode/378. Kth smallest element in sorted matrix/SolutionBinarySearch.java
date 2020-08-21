/**
 * Given a n x n matrix where each of the rows and columns are sorted in ascending order, 
 * find the kth smallest element in the matrix.
 * 
 * Note that it is the kth smallest element in the sorted order, not the kth distinct element.
 * Example:
 * matrix = [
 *          [ 1,  5,  9],
 *          [10, 11, 13],
 *          [12, 13, 15]
 *          ],
 * 
 * k = 8,
 * return 13.
 * 
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ n2.
 * 
 * Time Complexity: O(nlog(maxVal))
 */

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        // corner case
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) 
            return -1;
        
        // Here Binary Search will be on the elements itself, contrary to the indexes.
        int left = matrix[0][0];
        int right = matrix[matrix.length - 1][matrix[0].length - 1];
        
        while(left < right) {
            int mid = left + (right - left)/2;
            int count = 0;
            // Need to compute the Search Space
            int col = matrix[0].length - 1;     // top right element
            for(int row = 0; row < matrix.length; row++) {
                // Check if the element is greater than the mid.
                // if so, move towards the left as all elements subsequently underneath will be greater than mid
                while(col >= 0 && matrix[row][col] > mid)
                    col--;
                
                // increment the count of the elements that are <= mid.
                // this will be used to decide the search range going further
                count += (col + 1);
            }
            
            if(count < k)
                left = mid + 1;
            else
                right = mid;
        }
        return left;

    }
}