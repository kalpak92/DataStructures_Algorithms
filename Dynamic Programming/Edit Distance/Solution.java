import java.util.*;
/**
 *
 * Given two strings how many minimum edits(update, delete or add) is needed to convert one string to another
 *
 * Time complexity is O(m*n)
 * Space complexity is O(m*n)
 *
 */
public class Solution
{
    public int editDistanceDP(char[] str1, char[] str2)
    {
        int[][] dp = new int[str1.length + 1][str2.length + 2];

        for(int i = 0; i < dp.length; i++)
            dp[i][0] = i;

        for(int i = 0; i < dp[0].length; i++)
            dp[0][i] = i;

        for(int i = 1; i < str1.length + 1; i++)
        {
            for(int j = 1; j < str2.length + 1; j++)
            {
                if(str1[i - 1] == str2[j - 1])
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1]));
            }
        }

        return dp[str1.length][str2.length];
    }

    public static void main(String[] args)
    {
        String str1 = "";
        String str2 = "a";
        Solution editDistance = new Solution();
        int result = editDistance.editDistanceDP(str1.toCharArray(), str2.toCharArray());
        System.out.println(result);

    }
}