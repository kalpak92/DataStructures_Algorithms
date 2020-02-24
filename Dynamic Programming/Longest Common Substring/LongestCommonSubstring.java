/**
 * http://en.wikipedia.org/wiki/Longest_common_substring_problem
 */

 public class LongestCommonSubstring{
    public int longestCommonSubstring(char str1[], char str2[]){
        int[][] dp = new int[str1.length + 1][str2.length + 1];

        int max = 0;

        for(int i = 1; i <= str1.length; i++)
        {
            for(int j = 1; j <= str2.length; j++)
            {
                if(str1[i - 1] == str2[j - 1])
                {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }

                if(max < dp[i][j])
                    max = dp[i][j];
            }
        }
        return max;
    }

    public static void main(String[] args)
    {
        LongestCommonSubstring lcs = new LongestCommonSubstring();
        char str1[] = "abcdef".toCharArray();
        char str2[] = "zcdemf".toCharArray();
        System.out.println(lcs.longestCommonSubstring(str1, str2));
    }

 }