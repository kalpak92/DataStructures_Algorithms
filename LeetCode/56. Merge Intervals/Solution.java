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
        
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        
        List<int[]> result = new ArrayList<>();
        
        int[] runningInterval = intervals[0];
        result.add(runningInterval);
        
        for(int[] interval : intervals) {
            if(interval[0] <= runningInterval[1]) {
                // Need to merge the intervals
                runningInterval[1] = Math.max(interval[1], runningInterval[1]);
            }
            else {
                // The intervals are disjoint.
                runningInterval = interval;
                result.add(runningInterval);
            }
        }
        return result.toArray(new int [result.size()][]);
    }
}
