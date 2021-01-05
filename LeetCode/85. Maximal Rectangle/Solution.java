/**
 * Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
 * 
 * Example 1:
 * Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
 * Output: 6
 * Explanation: The maximal rectangle is shown in the above picture.
 * 
 * Example 2:
 * Input: matrix = []
 * Output: 0
 * 
 * Example 3:
 * Input: matrix = [["0"]]
 * Output: 0
 * 
 * Example 4:
 * Input: matrix = [["1"]]
 * Output: 1
 * 
 * Example 5:
 * Input: matrix = [["0","0"]]
 * Output: 0
 * 
 * Constraints:
 * rows == matrix.length
 * cols == matrix.length
 * 0 <= row, cols <= 200
 * matrix[i][j] is '0' or '1'.
 */

public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0)
            return 0;
        
        int result = 0;
        int[] heights = new int[matrix[0].length];
        
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                heights[j] = matrix[i][j] == '1' ? heights[j] + 1 : 0;
            }
            result = Math.max(result, largestRectangleArea(heights));
        }
        return result;
    }
    
    private int largestRectangleArea(int[] heights) {
        int[] firstSmallerToLeft = new int[heights.length];
        int[] firstSmallerToRight = new int[heights.length];

        Deque<Integer> stack = new ArrayDeque<>();
        int result = 0;

        Arrays.fill(firstSmallerToLeft, -1);
        Arrays.fill(firstSmallerToRight, heights.length);

        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && (heights[stack.peek()] >= heights[i])) {
                firstSmallerToRight[stack.poll()] = i;
            }
            if(!stack.isEmpty())
                firstSmallerToLeft[i] = stack.peek();

            stack.push(i);
        }

        for (int i = 0; i < heights.length; i++) {
            result = Math.max(result, heights[i] * (firstSmallerToRight[i] - firstSmallerToLeft[i] - 1));
        }

        return result;
    }
}
