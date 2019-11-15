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

 
/**
 * This is a two pointer solution (greedy solution).
 * Sort start and end intervals. 
 * Take two pointers, one for start time and one for end time. 
 * If the start interval is less than the end interval increment the room counter 
 * since we would need a extra room, else decrement the count since we have freed up the room.
 */

class SolutionII {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length < 1)
            return 0;
        
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        
        for (int i = 0; i < intervals.length; i++)
        {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        
        int i = 0, j = 0, count = 0;
        
        for (i = 0; i < starts.length; i++)
        {
            if (starts[i] < ends[j])
                count ++;
            else
                j++;
        }
        
        return count;
    }
}