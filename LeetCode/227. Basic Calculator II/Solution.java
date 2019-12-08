/**
 * Implement a basic calculator to evaluate a simple expression string.
 * The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . 
 * The integer division should truncate toward zero.
 * 
 * Example 1:
 * Input: "3+2*2"
 * Output: 7
 * 
 * Example 2:
 * Input: " 3/2 "
 * Output: 1
 * 
 * Example 3:
 * Input: " 3+5 / 2 "
 * Output: 5
 * Note:
 * You may assume that the given expression is always valid.
 * Do not use the eval built-in library function.
 */

class Solution {
    public int calculate(String s) {
        if(s == null || s.length() == 0)
            return 0;
        
        Stack<Integer> stack = new Stack<>();
        
        char op = '+';
        int num = 0;
        
        s += '+';
        
        for(int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            
            if(Character.isDigit(c))
            {
                num = num*10 + (int)(c - '0');
                continue;
            }
            if(c == ' ')
                continue;
            
            if (op == '+')
                stack.push(num);
            else if (op == '-')
                stack.push(-num);
            else if (op == '*')
                stack.push(stack.pop()*num);
            else if (op == '/')
                stack.push(stack.pop()/num);
            
            op = c;
            num = 0;
        }
        
        int result = 0;
        while (!stack.isEmpty())
        {
            result += stack.pop();
        }
        return result;
    }
}