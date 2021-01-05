/**
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, 
 * find the area of largest rectangle in the histogram.
 * 
 * Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
 * The largest rectangle is shown in the shaded area, which has area = 10 unit.
 * 
 * Example 1:
 * Input: heights = [2,1,5,6,2,3]
 * Output: 10
 * Explanation: The above is a histogram where width of each bar is 1.
 * The largest rectangle is shown in the red area, which has an area = 10 units.
 * 
 * Example 2:
 * Input: heights = [2,4]
 * Output: 4
 * 
 * Constraints:
 * 1 <= heights.length <= 105
 * 0 <= heights[i] <= 104
 */

public class Solution {
    public int largestRectangleArea(int[] heights) {
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
