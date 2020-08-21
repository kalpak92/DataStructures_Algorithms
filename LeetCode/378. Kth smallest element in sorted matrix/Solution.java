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
        int n = matrix.length; // no. of rows
        
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);
        
        // Add the first row
        for(int j = 0; j < n; j++)
        {
            //System.out.println(matrix[0][j]);
            minHeap.offer(new Pair (0, j, matrix[0][j]));
        }
        //System.out.println("---------------------");
        for(int i = 0; i < k - 1; i++)
        {
            Pair p = minHeap.poll();
            //System.out.println("i = " + i +" | "+p.a + " " + p.b + " " +p.val);
            
            if(p.a == n - 1)
                continue;
            
            minHeap.offer(new Pair(p.a + 1, p.b, matrix[p.a + 1][p.b]));
        }
        
        return minHeap.poll().val;
        
    }
}

class Pair {
    int a;
    int b;
    int val;
    
    public Pair(int a, int b, int val)
    {
        this.a = a;
        this.b = b;
        this.val = val;
    }
}