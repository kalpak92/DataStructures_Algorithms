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

import java.util.*;
class MergeIntervals {
    public List<int[]> merge(int[][] intervals) {
        if (intervals.length <= 1)
			return new ArrayList<int[]>();

		// Sort by ascending starting point
		Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));

		List<int[]> result = new ArrayList<>();
        
		int[] newInterval = intervals[0];
		result.add(newInterval);
		
        for (int[] interval : intervals) 
        {    
			if (interval[0] <= newInterval[1])              // Overlapping intervals, move the end if needed
				newInterval[1] = Math.max(newInterval[1], interval[1]);
			else {                                         // Disjoint intervals, add the new interval to the list
				newInterval = interval;
				result.add(newInterval);
                //System.out.println(newInterval[0] + " " + newInterval[1]);
			}
		}
        return result;
    }

    public static void main(String[] args) {
        int[][] arr = {{1,3},{2,6},{8,10},{15,18}};
        MergeIntervals obj = new MergeIntervals();

        List<int[]> result = obj.merge(arr);

        for(int[] i : result)
        {
            System.out.println(i[0] + " " +i[1]);
        }
    }
}