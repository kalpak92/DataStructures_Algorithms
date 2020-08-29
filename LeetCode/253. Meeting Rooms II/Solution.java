/**
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), \
 * find the minimum number of conference rooms required.
 * Example 1:
 * Input: [[0, 30],[5, 10],[15, 20]]
 * Output: 2
 * 
 * Example 2:
 * Input: [[7,10],[2,4]]
 * Output: 1
 */

 
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals.length < 1)
            return 0;
        
        // Sort the array based on the starting time of the meeting
        Arrays.sort(intervals, (a, b) -> (a[0] -  b[0]));
        
        // Create a minHeap to get the meeting that finishes first
        // Check if the intervals overlap, then we need a separate room, else merge them
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
        minHeap.offer(intervals[0]);
        
        for(int i = 1; i < intervals.length; i++) {
            int[] previous = minHeap.poll();
            int[] current = intervals[i];
            
            // Check if the end time of the previous meeting is <= the start time of the current meeting
            if(previous[1] <= current[0]) {
                // Merge the two, as we can reuse the meeting rooms
                previous[1] = current[1];
            }
            else {
                // we need a separate room.
                minHeap.offer(current);
            }
            minHeap.offer(previous);
        }
        return minHeap.size();
    }
}