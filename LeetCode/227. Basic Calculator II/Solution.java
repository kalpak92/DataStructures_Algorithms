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
        int result = 0;
        int number = 0;
        int tempSum = 0;
        char operator = '+';
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c))
                number = number * 10 + (int)(c - '0');
            
            if(i == s.length() -1 || (!Character.isDigit(c) && c != ' ')) {
                switch(operator) {
                    case '+':
                        result += tempSum;
                        tempSum = number;
                        break;
                    case '-':
                        result += tempSum;
                        tempSum = -number;
                        break;
                    case '*':
                        tempSum *= number;
                        break;
                    case '/':
                        tempSum /= number;
                        break;
                }
                operator = c;
                number = 0;
            }
        }
        result += tempSum;
        return result;
    }
}