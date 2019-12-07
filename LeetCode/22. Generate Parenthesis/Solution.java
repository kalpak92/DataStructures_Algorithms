/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * 
 * For example, given n = 3, a solution set is:
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 */

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        backtrack(result, "", 0, 0, n);
        
        return result;
    }
    
    private void backtrack(List<String> result, String str, int open, int close, int n)
    {
        if(str.length() == 2*n)
        {
            result.add(str);
            return;
        }
        
        // First, the first character should be “(“. 
        // Second, at each step, you can either print “(“ or “)”, but print “)” only when there are more “(“s than “)”s. 
        // Stop printing out “(“ when the number of “(“ s hit n. The first actually merges into the second condition.
        
        if(open < n)
        {
            //System.out.println("Before Calling Backtrack ( - open " + open + str);
            backtrack(result, str+"(", open + 1, close, n);
            //System.out.println("After Calling Backtrack ( - open " + open + str);
        }
        
        if(close < open)
        {
            //System.out.println("Before Calling Backtrack ) - close " + close + str);
            backtrack(result, str+")", open, close + 1, n);
            //System.out.println("After Calling Backtrack ) - close " + close + str);
        }
    }
}