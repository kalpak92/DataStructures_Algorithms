/**
 * Given a collection of intervals, merge all overlapping intervals.
 * Example 1:
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * 
 * Example 2:
 * Input: [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 */

class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length <= 1)
            return intervals;
        
        List<int []> result = new ArrayList<>();
        
        // Sort on the basis of the start element of each interval
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        // Add the first interval to the list and then check for overlaps
        result.add(intervals[0]);
        int[] currentInterval = intervals[0];
        
        for(int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] <= currentInterval[1])
                currentInterval[1] = Math.max(currentInterval[1], intervals[i][1]);
            else {
                currentInterval = intervals[i];
                result.add(intervals[i]);
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}
