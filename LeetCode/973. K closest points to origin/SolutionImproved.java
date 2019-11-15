/**
 * We have a list of points on the plane.  Find the K closest points to the origin (0, 0).
 * (Here, the distance between two points on a plane is the Euclidean distance.)
 * 
 * You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)
 * 
 * Example 1:
 * Input: points = [[1,3],[-2,2]], K = 1
 * Output: [[-2,2]]
 * 
 * Explanation: 
 * The distance between (1, 3) and the origin is sqrt(10).
 * The distance between (-2, 2) and the origin is sqrt(8).
 * Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
 * We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].
 * 
 * Example 2:
 * Input: points = [[3,3],[5,-1],[-2,4]], K = 2
 * Output: [[3,3],[-2,4]]
 * (The answer [[-2,4],[3,3]] would also be accepted.)
 * 
 * Note:
 * 1 <= K <= points.length <= 10000
 * -10000 < points[i][0] < 10000
 * -10000 < points[i][1] < 10000
 */

import java.util.concurrent.ThreadLocalRandom;

class Solution 
{
    int[][] points;
    public int[][] kClosest(int[][] points, int K) {
        this.points = points;
        
        sort(0,points.length-1,K);
        
        int[][] output = Arrays.copyOfRange(points, 0, K);
       
        /* for (int i=0; i<K; i++)
            System.out.println(output[i][0]+" "+output[i][1]);
            
        for (int i=0; i<points.length; i++)
            System.out.println(points[i][0]+" "+points[i][1]); */
        return output;
    }
    
    private void sort(int begin, int end, int K){
        if (begin >= end)
            return;
        
        int rand = ThreadLocalRandom.current().nextInt(begin, end);
        
        swap(end, rand);
        
        int pivot = partition(begin,end);
        int leftlength = pivot - begin + 1;
        
        if (K < leftlength)
            sort(begin, pivot-1, K);
        else if (K > leftlength)
            sort(pivot + 1, end, K - leftlength);
    }
    
    private int partition(int begin, int end)
    {
        int pindex = begin - 1;
        int pivot = dist(end);
        
        for(int i = begin; i < end; i++)
        {
            if (dist(i) <= pivot)
            {
                pindex++;
                swap(i, pindex);
            }
        }
        
        swap(pindex + 1, end);
        return pindex + 1;
    }
    
    private void swap(int i, int j) 
    {
        int t0 = points[i][0], t1 = points[i][1];
        
        points[i][0] = points[j][0];
        points[i][1] = points[j][1];
        points[j][0] = t0;
        points[j][1] = t1;
    }
    
    private int dist(int i) 
    {
        return ((points[i][0] * points[i][0]) + (points[i][1] * points[i][1]));
    }

}