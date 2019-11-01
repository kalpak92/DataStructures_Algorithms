/**
 * Given a collection of intervals, merge all overlapping intervals without using the new operator (ie creating new objects).
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

class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
    
    void display(String name)
    {
        System.out.println(name + " : " +this.start + " " + this.end);
    }
}

public class Intervals
{
    public List<Interval> merge(List<Interval> intervals)
    {
        if(intervals.size() <= 1)
            throw new IllegalArgumentException();

        Collections.sort(intervals, (Interval i1, Interval i2) -> Integer.compare(i1.start, i2.start));

        Iterator<Interval> it = intervals.iterator();
        
        Interval prev = it.hasNext() ? it.next() : null;
        prev.display("Prev");

        while (it.hasNext()) {
            Interval next = it.next();
            next.display("Next");
            if (prev.end >= next.start) 
            {
                prev.end = Math.max(prev.end, next.end);
                it.remove();
            } 
            else {
                prev = next;
            }
        }
        return intervals;
    }

    public static void main(String[] args) {

        Intervals obj = new Intervals();
        List<Interval> intervals = new LinkedList<>();

        intervals.add(new Interval(1,3));
        intervals.add(new Interval(2, 6));
        intervals.add(new Interval(8, 10));
        intervals.add(new Interval(15, 18));
        
        List<Interval> result = obj.merge(intervals);
        for(Interval i : intervals)
            i.display(i.toString());
        
    }
}