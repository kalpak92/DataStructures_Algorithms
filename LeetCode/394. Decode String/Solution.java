/**
 * Given an encoded string, return its decoded string.
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. 
 * 
 * Note that k is guaranteed to be a positive integer.
 * You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
 * 
 * Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].
 * Examples:
 * s = "3[a]2[bc]", return "aaabcbc".
 * s = "3[a2[c]]", return "accaccacc".
 * s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 */

class Solution {
    public String decodeString(String s) {
        if(s.length() == 0)
            return "";
        String result = "";
        Deque<String> stack = new ArrayDeque<>();
        int num = 0;
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if(Character.isDigit(c))
                num = num*10 + (int)(c - '0');
            else if (c == '[') {
                stack.push(num + "");
                stack.push("[");
                num = 0;
            } else if (c == ']') {
                String temp = "";
                while(stack.peek() != "[")
                    temp = stack.pop() + temp;
                
                stack.pop(); // pop the '[' which was used as a marker
                
                int repeat = Integer.valueOf(stack.pop());
                StringBuilder sb = new StringBuilder();
                // decode temp
                for(int j = 0; j < repeat; j++) {
                    sb.append(temp);
                }
                stack.push(sb.toString());
             } else {
                stack.push(c+"");
            }
        }
        while(!stack.isEmpty())
            result = stack.pop() + result;
        
        return result;
    }
}