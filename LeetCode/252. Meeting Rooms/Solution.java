/**
 * Given an array of meeting time intervals consisting of start and end times 
 * [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.
 * 
 * Example 1:
 * Input: [[0,30],[5,10],[15,20]]
 * Output: false
 * 
 * Example 2:
 * Input: [[7,10],[2,4]]
 * Output: true
 */

class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals == null)
            return false;
        if(intervals.length == 0)
            return true;
        
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[]a , int[] b)
            {
                if(a[0] > b[0])
                    return 1;
                else if(a[0] < b[0])
                    return -1;
                else
                    return 0;
            }
        });
        
        for(int i = 0; i < intervals.length - 1; i++)
        {
            if(intervals[i][1] > intervals[i+1][0])
                return false;
        }
        return true;
    }
}