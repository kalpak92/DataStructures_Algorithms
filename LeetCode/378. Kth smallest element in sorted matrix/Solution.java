/**
 * Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.
 * 
 * Note that it is the kth smallest element in the sorted order, not the kth distinct element.
 * 
 * Example:
 * matrix = [
 *    [ 1,  5,  9],
 *    [10, 11, 13],
 *    [12, 13, 15]
 * ],
 * k = 8,
 * 
 * return 13.
 * 
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ n2.
 */

 /**
  * ALGORITHM:
    1. Build a minHeap of elements from the first row.
    2. Do the following operations k-1 times :
        a)  Every time when you poll out the root(Top Element in Heap), you need to know the row number and column number of that element
            (so we can create a tuple class here), 
        b)  Replace that root with the next element from the same column.
  */
  class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        // Base Condition
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return -1;
        
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a, b) -> (a.val - b.val));
        int row = matrix.length;
        
        // Add the elements of the first row
        for(int col = 0; col < matrix[0].length; col++) {
            minHeap.offer(new Pair(0, col, matrix[0][col]));
        }
        
        // Now loop k-1 times, as the first row is already added.
        for(int i = 0; i < k - 1; i++) {
            // pop out an element from the minHeap.
            // insert corresponding next element in that row.
            Pair temp = minHeap.poll();
            
            // check if it's the last row. Then don't do anything.
            if(temp.row == matrix.length - 1)
                continue;
            
            minHeap.offer(new Pair(temp.row + 1, temp.col, matrix[temp.row + 1][temp.col]));
        }
        
        return minHeap.poll().val;
    }
    
}

class Pair {
    int row;
    int col;
    int val;
    Pair(int row, int col, int val) {
        this.row = row;
        this.col = col;
        this.val = val;
    }
}