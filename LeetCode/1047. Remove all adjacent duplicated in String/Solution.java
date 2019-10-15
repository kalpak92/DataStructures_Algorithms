/**
 * Given a string S of lowercase letters, a duplicate removal consists of choosing two adjacent and equal letters, and removing them.
 * 
 * We repeatedly make duplicate removals on S until we no longer can.
 * 
 * Return the final string after all such duplicate removals have been made.  It is guaranteed the answer is unique.
 * 
 * Example 1:
 * Input: "abbaca"
 * Output: "ca"
 * 
 * Explanation: 
 * For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, and this is the only possible move.  
 * The result of this move is that the string is "aaca", of which only "aa" is possible, so the final string is "ca".
 */

 import java.util.Stack;

 class Solution {
    public String removeDuplicates(String S) {
        Stack<Character> stack = new Stack<>();
        
        for(char c : S.toCharArray())
        {
            if(!stack.empty() && stack.peek() == c)
                stack.pop();
            else
                stack.push(c);
        }
        
        StringBuilder ans = new StringBuilder();
        //while(!stack.isEmpty())
            //ans.append(stack.pop());
        
        for (char c : stack)
            ans.append(c);
        
        return (ans.toString());
    }
}