/**
 * Consider a matrix M with dimensions width * height, such that every cell has value 0 or 1, 
 * and any square sub-matrix of M of size sideLength * sideLength has at most maxOnes ones.
 * 
 * Return the maximum possible number of ones that the matrix M can have.
 * 
 * Example 1:
 * Input: width = 3, height = 3, sideLength = 2, maxOnes = 1
 * Output: 4
 * 
 * Explanation:
 * In a 3*3 matrix, no 2*2 sub-matrix can have more than 1 one.
 * The best solution that has 4 ones is:
 * [1,0,1]
 * [0,0,0]
 * [1,0,1]
 * 
 * Example 2:
 * Input: width = 3, height = 3, sideLength = 2, maxOnes = 2
 * Output: 6
 * Explanation:
 * [1,0,1]
 * [1,0,1]
 * [1,0,1]
 * 
 * Constraints:
 * 1 <= width, height <= 100
 * 1 <= sideLength <= width, height
 * 0 <= maxOnes <= sideLength * sideLength
 */

class Solution {
    public int maximumNumberOfOnes(int width, int height, int sideLength, int maxOnes) {
        int[][] sq = new int[width][height];
        
        for(int i = 0; i < width; i++)
        {
            for(int j = 0; j < height; j++)
            {
                sq[i%sideLength][j%sideLength]++;
            }
        }
        
        // for(int i = 0; i < sq.length; i++)
        // {
        //     for(int j = 0; j < sq[0].length; j++)
        //     {    
        //         System.out.print(sq[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a , b) -> b - a);
        for(int i = 0; i < sq.length; i++)
        {
            for(int j = 0; j < sq[0].length; j++)
            {    
                pq.offer(sq[i][j]);
            }
        }
        
        int result = 0;
        
        for(int i = 0; i < maxOnes; i++)
            result += pq.poll();
        
        return result;
    }
}