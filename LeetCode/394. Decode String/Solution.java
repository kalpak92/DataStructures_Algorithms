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
        String result = "";
        
        Stack<Integer> counter = new Stack<>();
        Stack<String> character = new Stack<>();
        
        int index = 0;
        
        while(index < s.length())
        {
            if(Character.isDigit(s.charAt(index)))
            {
                int count = 0;
                while(Character.isDigit(s.charAt(index)))
                {
                    count = count * 10 + (s.charAt(index) - '0');
                    index++;
                }
                counter.push(count);
            }
            else if (s.charAt(index) == '[')
            {
                character.push(result);
                result = "";
                index ++;
            }
            else if (s.charAt(index) == ']')
            {
                StringBuilder temp = new StringBuilder(character.pop());
                int loop = counter.pop();
                
                for(int i = 0; i < loop; i++)
                    temp.append(result);
                
                result = temp.toString();
                index++;
            }
            else 
            {
                result += s.charAt(index);
                index++;
            }
        }
        return result;
    }
}