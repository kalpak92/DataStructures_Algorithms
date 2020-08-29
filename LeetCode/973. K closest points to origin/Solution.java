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

class Solution {

    // Naive solution  Time Complexity: O(NlogN), where N is the length of points. Space Complexity: O(N).
    public int[][] kClosest(int[][] points, int K) {
        int len = points.length;
        
        int[] dists = new int[len];         // store the distance of each point from the origin
        for(int i =0; i < len; i++)
        {
            dists[i] = dist(points[i]);
        }
        
        Arrays.sort(dists);
        int distK = dists[K-1];     // get the kth distance upper limit
        
        int res[][] = new int[K][2];
        int idx = 0;
        
        for(int i = 0; i < len; i++)
        {
            if(dist(points[i]) <= distK)
                res[idx++] = points[i];
        }
        
        return res;
    }
    
    private int dist(int[] point)
    {
        return point[0]*point[0] + point[1]*point[1];
    }

    // Improved Solution using max heap. Time Complexity: O(NlogK)
    
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> (b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[1] * a[1]));

        for(int[] p : points) {
            maxHeap.offer(p);
            // check the size of the heap and pop out unnecessary elements
            if(maxHeap.size() > K)
                maxHeap.poll();   
        }

        int[][] result = new int[K][2];
        while(K > 0) {
            result[K-1] = maxHeap.poll();   // Note: K-1 because of 0 based indexing.
            K--;
        }
        return result;
    }
}