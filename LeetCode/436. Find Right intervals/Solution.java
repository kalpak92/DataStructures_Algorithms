/**
 * You are given an array of intervals, where intervals[i] = [starti, endi] and each starti is unique.
 *
 * The right interval for an interval i is an interval j such that startj >= endi and startj is minimized.
 *
 * Return an array of right interval indices for each interval i. If no right interval exists for interval i, then put -1 at index i.
 *
 * Example 1:
 * Input: intervals = [[1,2]]
 * Output: [-1]
 * Explanation: There is only one interval in the collection, so it outputs -1.
 *
 *
 * Example 2:
 * Input: intervals = [[3,4],[2,3],[1,2]]
 * Output: [-1,0,1]
 * Explanation: There is no right interval for [3,4].
 * The right interval for [2,3] is [3,4] since start0 = 3 is the smallest start that is >= end1 = 3.
 * The right interval for [1,2] is [2,3] since start1 = 2 is the smallest start that is >= end2 = 2.
 *
 *
 * Example 3:
 * Input: intervals = [[1,4],[2,3],[3,4]]
 * Output: [-1,2,-1]
 * Explanation: There is no right interval for [1,4] and [3,4].
 * The right interval for [2,3] is [3,4] since start2 = 3 is the smallest start that is >= end1 = 3.
 *
 * Constraints:
 *
 * 1 <= intervals.length <= 2 * 104
 * intervals[i].length == 2
 * -106 <= starti <= endi <= 106
 * The start point of each interval is unique.
 */


public class Solution {
    public static int[] findRightInterval(int[][] intervals) {
        int[] result = new int[intervals.length];

        //create 2 max heaps to store interval
        PriorityQueue<int[]> startHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        PriorityQueue<int[]> endHeap = new PriorityQueue<>((a,b) -> b[1] - a[1]);

        //create a hashmap<key,value> to store interval and index pair
        Map<int[], Integer> map = new HashMap<>();

        for (int i = 0; i < intervals.length; i++) {
            startHeap.add(intervals[i]);
            endHeap.add(intervals[i]);
            map.put(intervals[i], i);
        }

        for(int i = 0; i < intervals.length; i++) {
            int[] topStart = startHeap.peek();

            // if endHeap.peek() end value > startHeap.peek() start value
            // we will just add -1 to the result array.
            if(!startHeap.isEmpty() && !endHeap.isEmpty() && endHeap.peek()[1] > startHeap.peek()[0]){
                result[map.get(endHeap.poll())] = -1;
            } else if (!startHeap.isEmpty() && !endHeap.isEmpty() && startHeap.peek()[0] >= endHeap.peek()[1]) {
                // loop thorugh the startHeap until we find the smallest start time that is greater than the end time in endHeap.peek() interval
                while(!startHeap.isEmpty() && !endHeap.isEmpty() && startHeap.peek()[0] >= endHeap.peek()[1]) {
                    topStart = startHeap.peek();
                    result[map.get(endHeap.peek())] = map.get(startHeap.peek());
                    startHeap.poll();
                }
                // add back the last interval polled from startHeap,
                // because leftover intervals in endHeap might also need it.
                startHeap.add(topStart);
                endHeap.poll();
            }
        }
        return result;
    }
}
