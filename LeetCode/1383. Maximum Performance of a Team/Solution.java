/**
 * There are n engineers numbered from 1 to n and two arrays: speed and efficiency, 
 * where speed[i] and efficiency[i] represent the speed and efficiency for the i-th engineer respectively. 
 * 
 * Return the maximum performance of a team composed of at most k engineers, since the answer can be a huge number, return this modulo 10^9 + 7.
 * 
 * The performance of a team is the sum of their engineers' speeds multiplied by the minimum efficiency among their engineers. 
 * Example 1:
 * Input: n = 6, speed = [2,10,3,1,5,8], efficiency = [5,4,3,9,7,2], k = 2
 * Output: 60
 * 
 * Explanation: 
 * We have the maximum performance of the team by selecting engineer 2 (with speed=10 and efficiency=4) and 
 * engineer 5 (with speed=5 and efficiency=7). That is, performance = (10 + 5) * min(4, 7) = 60.
 * 
 * Example 2:
 * Input: n = 6, speed = [2,10,3,1,5,8], efficiency = [5,4,3,9,7,2], k = 3
 * Output: 68
 * Explanation:
 * This is the same example as the first but k = 3. We can select engineer 1, engineer 2 and 
 * engineer 5 to get the maximum performance of the team. That is, performance = (2 + 10 + 5) * min(5, 4, 7) = 68.
 * 
 * Example 3:
 * Input: n = 6, speed = [2,10,3,1,5,8], efficiency = [5,4,3,9,7,2], k = 4
 * Output: 72
 * 
 * Constraints:
 * 
 *     1 <= n <= 10^5
 *     speed.length == n
 *     efficiency.length == n
 *     1 <= speed[i] <= 10^5
 *     1 <= efficiency[i] <= 10^8
 *     1 <= k <= n
 */


/**
 * ALGORITHM
 * Performance = sum(speed) * min(efficiency). 
 * Idea is simple: try every efficiency value from highest to lowest and at the same time maintain an as-large-as-possible speed group, 
 * keep adding speed to total speed, if size of engineers group exceeds K, lay off the engineer with lowest speed.
 * 
 * Sort efficiency with descending order. 
 * Because, afterwards, when we iterate whole engineers, every round, when calculating the current performance, 
 * minimum efficiency is the effiency of the new incoming engineer.
 * Maintain a pq to track of the minimum speed in the group. 
 * If size of group is == K, kick the engineer with minimum speed out (since efficiency is fixed by new coming engineer, 
 * the only thing matters now is sum of speed).
 * 
 * Calculate/Update performance.
 */

class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int MOD = (int) (1e9 + 7);
        int[][] engineers = new int[n][2];
        
        for (int i = 0; i < n; ++i) 
    	    engineers[i] = new int[] {efficiency[i], speed[i]};

        Arrays.sort(engineers, (a, b) -> b[0] - a[0]);
        
        // MinHeap based on speed.
        PriorityQueue<Integer> pq = new PriorityQueue<>(k, (a, b) -> a - b);
        long res = Long.MIN_VALUE, totalSpeed = 0;
        
        for (int[] engineer : engineers) {
	        if (pq.size() == k) 
                totalSpeed -= pq.poll();  // layoff the one with min speed
            
            pq.add(engineer[1]);
            totalSpeed = (totalSpeed + engineer[1]);
            
            res = Math.max(res, (totalSpeed * engineer[0]));  // min efficiency is the efficiency of new engineer
        }
        return (int) (res % MOD);
    }
}