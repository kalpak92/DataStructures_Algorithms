/**
 * Implement a basic calculator to evaluate a simple expression string.
 * 
 * The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .
 * 
 * Example 1:
 * Input: "1 + 1"
 * Output: 2
 * 
 * Example 2:
 * Input: " 2-1 + 2 "
 * Output: 3
 * 
 * Example 3:
 * Input: "(1+(4+5+2)-3)+(6+8)"
 * Output: 23
 * 
 * Note:
 * You may assume that the given expression is always valid.
 * Do not use the eval built-in library function.
 */

class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        
        int result = 0;
        int num = 0;
        int sign = 1;
        
        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            
            if(Character.isDigit(c))
            {
                num = num * 10 + (int)(c - '0');
            }
            else if(c == '(')
            {
                stack.push(result);
                stack.push(sign);
                
                // reset
                result = 0;
                sign = 1;
            }
            else if (c == ')')
            {
                result += sign * num;
                num = 0;
                
                result *= stack.pop();
                result += stack.pop();
            }
            else if (c == '+')
            {
                result += sign * num;
                
                num = 0;
                sign  = 1;
            }
            else if (c == '-')
            {
                result += sign * num;
                
                num = 0;
                sign = -1;
            }
        }
        
        if (num != 0)
        {
            result += sign * num;
        }
        
        return result;
    }
}