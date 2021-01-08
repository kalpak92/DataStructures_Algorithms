/**
 * Implement a basic calculator to evaluate a simple expression string.
 *
 * The expression string contains only non-negative integers, +, -, *, / operators , open ( and closing parentheses ) and empty spaces .
 * The integer division should truncate toward zero.
 *
 * You may assume that the given expression is always valid. All intermediate results will be in the range of [-2147483648, 2147483647].
 *
 * Follow up: Could you solve the problem without using built-in library functions.
 *
 *
 *
 * Example 1:
 * Input: s = "1 + 1"
 * Output: 2
 *
 * Example 2:
 * Input: s = " 6-4 / 2 "
 * Output: 4
 *
 * Example 3:
 * Input: s = "2*(5+5*2)/3+(6/2+8)"
 * Output: 21
 *
 * Example 4:
 * Input: s = "(2+6* 3+5- (3*14/7+2)*5)+3"
 * Output: -12
 *
 * Example 5:
 * Input: s = "0"
 * Output: 0
 *
 * Constraints:
 *
 * 1 <= s <= 104
 * s consists of digits, '+', '-', '*', '/', '(', ')' and ' '.
 * s is a valid expression.
 */

public class Solution {
    public int calculate(String s) {
        int l1 = 0;
        int o1 = 1;
        int l2 = 1;
        int o2 = 1;
        
        Deque<Integer> stack = new ArrayDeque<>();
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if(Character.isDigit(c)) {
                int num = (int)(c - '0');
                
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    i++;
                    num = num*10 + (int)(s.charAt(i) - '0');
                }
                l2 = (o2 == 1) ? (l2 * num) : (l2 / num);
            } else if (c == '(') {
                // cache the current data
                stack.push(l1);
                stack.push(o1);
                stack.push(l2);
                stack.push(o2);
                
                // Reset the values
                l1 = 0;
                o1 = 1;
                l2 = 1;
                o2 = 1;
            } else if (c == ')') {
                // store the calculation that has been done until now
                int num = l1 + o1 * l2;
                
                // pop out the stack.
                // Note: to be done in the reverse order
                o2 = stack.poll(); 
                l2 = stack.poll();
                o1 = stack.poll(); 
                l1 = stack.poll();
                
                // update 
                l2 = (o2 == 1) ? (l2 * num) : (l2 / num);
            } else if (c == '*' || c == '/') {
                o2 = (c == '*') ? 1 : -1;
            } else if (c == '+' || c == '-') {
                l1 = l1 + o1 * l2;
                o1 = (c == '+' ? 1 : -1);

                l2 = 1; o2 = 1;
            }
        }
        return l1 + o1 * l2;
    }
}