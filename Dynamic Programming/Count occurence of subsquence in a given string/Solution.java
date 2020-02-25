/**
 * Given two strings, find the number of times the second string occurs in the first string, whether continuous or discontinuous.
 * 
 * Examples:
 * Input:  
 * string a = "GeeksforGeeks"
 * string b = "Gks"
 * 
 * Output: 4
 * 
 * Explanation:  
 * The four strings are 
 *      'G'ee'k''s'forGeeks
 *      'G'eeksforGee'k''s'
 *      'G'ee'k'sforGeek's'
 *      Geeksfor'G'ee'k''s'
 */

class Solution  
{ 
      
    public static int count(String a, String b) 
    { 
        int m = a.length(); 
        int n = b.length(); 
    
        int dp[][] = new int[m + 1][n + 1]; 
    
        // If first string is empty 
        for (int i = 0; i <= n; ++i) 
            dp[0][i] = 0; 
    
        // If second string is empty 
        for (int i = 0; i <= m; ++i) 
            dp[i][0] = 1; 
    
        // Fill dp[][] in  
        // bottom up manner 
        for (int i = 1; i <= m; i++) 
        { 
            for (int j = 1; j <= n; j++) 
            { 
                // If last characters are  
                // same, we have two options - 
                // 1. consider last characters  
                //    of both strings in solution 
                // 2. ignore last character 
                //    of first string 
                if (a.charAt(i - 1) == b.charAt(j - 1)) 
                    dp[i][j] = dp[i - 1][j - 1] +  
                                dp[i - 1][j]; 
                    
                else
                    // If last character are  
                    // different, ignore last 
                    // character of first string 
                    dp[i][j] = dp[i - 1][j]; 
            } 
        } 
    
        return dp[m][n]; 
    } 
  
    // Driver Code 
    public static void main (String[] args) 
    { 
        Solution obj = new Solution();
        String a = "GeeksforGeeks"; 
        String b = "Gks"; 
        
        System.out.println(obj.count(a, b)); 
    } 
} 