/**
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, 
 * determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 * 
 * Note:
 * The same word in the dictionary may be reused multiple times in the segmentation.
 * You may assume the dictionary does not contain duplicate words.
 * 
 * Example 1:
 * Input: s = "leetcode", wordDict = ["leet", "code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 * 
 * Example 2:
 * Input: s = "applepenapple", wordDict = ["apple", "pen"]
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
 *              Note that you are allowed to reuse a dictionary word.
 * 
 * Example 3:
 * Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output: false
 */

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.isEmpty())
            return false;
        
        int n = s.length();
        
        Set<String> setOfWords = new HashSet<>();
        for(String word: wordDict)
        {
            setOfWords.add(word);    
        }
        
        /**
         * The for loop is looking at ranges or substrings. 
         * If we know that the current substring is in the dictionary AND the substring before it is also in the dictionary 
         * then we know that the str.substring(0, i) is true. J == 0 because the first substring has nothing before it (dp[j- 1] does not exist).
         * 
         * ------- left substring ---- | substring (j, i + 1) | -------right substring ------ |
         * 
         * If we know that str.substring(j,i+1) is in the dictionary, we can only mark it true if the left substring is also in the dictionary.
         * Then, for the right substring, it is str.substring(i + 1, end). 
         * You can only mark dp[end] is true if you know the substring up to i are in dictionary.
         */
        
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        
        for(int len = 1; len <= n; len++)
        {
            for(int i = 0; i < len; i++)
            {
                if(dp[i] && setOfWords.contains(s.substring(i, len)))
                {
                    dp[len] = true;
                    break;
                }
            }
        }
        return dp[n];        
    }
}