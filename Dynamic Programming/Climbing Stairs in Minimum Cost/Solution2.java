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
 */

public class Solution2
{
    public static int[] memo;
    public static int minCostClimbingStairs(int[] cost)
    {
        int n = cost.length;
        memo = new int[n];
        return Math.min(minCost(cost, n-1), minCost(cost, n-2));
    }

    private static int minCost(int[] cost, int n)
    {
        if (n < 0)
            return 0;
        
        if (n == 0 || n == 1)
            return cost[n];

        if (memo[n] != 0)
            return memo[n];

        memo[n] = cost[n] + Math.min(minCost(cost, n-1), minCost(cost, n-2));
        return memo[n];
    }

    public static void main(String[] args)
    {
        int[] cost = {10, 15, 20};
        int[] cost1 = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};

        System.out.println(minCostClimbingStairs(cost1));
    }
}