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

 import java.util.*;

 public class NumberOfMeetingRooms
 {
     public int minMeetingRooms(int[][] intervals)
     {
         if(intervals.length < 1)
            return 0;

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        minHeap.add(intervals[0]);

        for(int i = 1; i < intervals.length; i++)
        {
            int[] current = intervals[i];
            int[] earliest = minHeap.remove();

            if(current[0] >= earliest[1])
                earliest[1] = current[1];
            else
                minHeap.add(current);

            minHeap.add(earliest);
        }
        return minHeap.size();
     }

     public static void main(String[] args) {
        int[][] arr = {{0, 30}, {5, 10}, {15, 20}};
        NumberOfMeetingRooms obj = new NumberOfMeetingRooms();

        int result = obj.minMeetingRooms(arr);

        System.out.println(result);
     }
 }
