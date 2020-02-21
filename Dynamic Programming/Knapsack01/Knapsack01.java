public class Knapsack01
{
    /**
     * 0/1 Knapsack Problem - Given items of certain weights/values and maximum allowed weight
     * how to pick items to pick items from this set to maximize sum of value of items such that
     * sum of weights is less than or equal to maximum allowed weight.
     *
     * Time complexity - O(W*total items)
     *
     * Youtube link
     * https://www.youtube.com/watch?v=nLmhmB6NzcM&list=PLDN4rrl48XKpZkf03iYFl-O29szjTrs_O&index=54
     * https://en.wikipedia.org/wiki/Knapsack_problem
     */
    public int bottomUpDP(int[] val, int[] wt, int W)
    {
        int[][] dp = new int[val.length + 1][W + 1];

        for(int i = 0; i <= val.length; i++)
        {
            for(int j = 0; j <= W; j++)
            {
                if(i == 0 || j == 0)
                {
                    dp[i][j] = 0;
                    continue;
                }

                if(wt[i - 1] <= j)
                {
                    dp[i][j] = Math.max(dp[i - 1][j], val[i - 1] + dp[i - 1][j - wt[i - 1]]);
                }
                else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[val.length][W];
    }

    public static void main(String args[]){
        Knapsack01 k = new Knapsack01();
        int val[] = {22, 20, 15, 30, 24, 54, 21, 32, 18, 25};
        int wt[] = {4, 2, 3, 5, 5, 6, 9, 7, 8, 10};
        int r = k.bottomUpDP(val, wt, 30);
        //int r1 = k.topDownRecursive(val, wt, 30);
        System.out.println(r);
        //System.out.println(r1);
    }
}