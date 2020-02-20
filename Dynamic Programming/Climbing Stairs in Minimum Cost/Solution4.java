/**
 * On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).
 * 
 * Once you pay the cost, you can either climb one or two steps. 
 * You need to find minimum cost to reach the top of the floor, and you can either start from the step with index 0, or the step with index 1.
 * 
 * Example 1:
 * Input: cost = [10, 15, 20]
 * Output: 15
 * Explanation: Cheapest is start on cost[1], pay that cost and go to the top.
 * 
 * Example 2:
 * Input: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
 * Output: 6
 * Explanation: Cheapest is start on cost[0], and only step on 1s, skipping cost[3].
 * 
 */

 public class Solution4
 {
    public static int minCostClimbingStairs(int[] cost)
    {
        int n = cost.length;
        
        int a = cost[0];
        int b = cost[1];

        if(n <=2 )
            return Math.min(a, b);

        for(int i = 2; i < n; i++)
        {
            int temp  = cost[i] + Math.min(a, b);
            a = b;
            b = temp;
        }

        return Math.min(a, b);
    }

    public static void main(String[] args)
    {
        int[] cost = {10, 15, 20};
        int[] cost1 = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};

        System.out.println(minCostClimbingStairs(cost));
    }
 }


