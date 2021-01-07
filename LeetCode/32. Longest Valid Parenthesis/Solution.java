/**
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
 * 
 * Example 1:
 * Input: s = "(()"
 * Output: 2
 * Explanation: The longest valid parentheses substring is "()".
 * 
 * Example 2:
 * Input: s = ")()())"
 * Output: 4
 * Explanation: The longest valid parentheses substring is "()()".
 * 
 * Example 3:
 * Input: s = ""
 * Output: 0
 * 
 * Constraints:
 * 0 <= s.length <= 3 * 10^4
 * s[i] is '(', or ')'.
 */

public class Solution {
    public int longestValidParentheses(String s) {
        int result = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        // You can imagine there is a ) at index -1 position
        // i.e. s[-1] = ')'
        stack.push(-1);
        
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(')
                stack.push(i);
            else {
                // if there is a match (i.e. "()"), then we can pop the stack
                // and update the max length by (i - indices.top())
                // (because the string in (indices.top(), i] is a valid parenthese)
                // else if there isn't a match (i.e. "))"), then we can substitute
                // the top of the stack by the latest one
                stack.pop();
                if(stack.isEmpty())
                    stack.push(i);  // if the stack is empty, it means a "))" occurs
                else
                    result = Math.max(result, i - stack.peek());    // "()" occurs
            }
        }
        return result;
    }
}
