/**
 * Given a set of points in the xy-plane, determine the minimum area of a rectangle formed from these points, 
 * with sides parallel to the x and y axes.
 * 
 * If there isn't any rectangle, return 0.
 * 
 * Example 1:
 * Input: [[1,1],[1,3],[3,1],[3,3],[2,2]]
 * Output: 4
 * 
 * Example 2:
 * Input: [[1,1],[1,3],[3,1],[3,3],[4,1],[4,3]]
 * Output: 2
 * 
 * Note:
 *     1 <= points.length <= 500
 *     0 <= points[i][0] <= 40000
 *     0 <= points[i][1] <= 40000
 *     All points are distinct.
 */

class Solution {
    public int minAreaRect(int[][] points) {
        Map<Integer, Set<Integer>> xToY = new HashMap<>();
        int result = Integer.MAX_VALUE;
        
        for(int[] p : points) {
            xToY.putIfAbsent(p[0], new HashSet<>());
            xToY.get(p[0]).add(p[1]);
        }
        
        for(int[] p1 : points) {
            for(int[] p2 : points) {
                // See if p1 and p2 are diagonal
                if(p1[0] != p2[0] && p1[1] != p2[1]) {
                    // Check if a rectangle can be formed.
                    // i.e p3 and p4 exists.
                    
                    // p3 and p4 needs to satisfy
                    //      p3.x = p2.x, p3.y = p1.y
                    //      p4.x = p1.x, p4.y = p2.y
                    if (xToY.get(p2[0]).contains(p1[1])     // if p3 exists
                        && xToY.get(p1[0]).contains(p2[1]) // if p4 exists
                       ) {
                        int area = Math.abs((p2[0] - p1[0]) * (p2[1] - p1[1]));
                        result = Math.min(result, area);
                    }
                }
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}