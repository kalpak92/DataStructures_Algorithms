/**
 * Given an input string, reverse the string word by word.
 * 
 * Example 1:
 * Input: "the sky is blue"
 * Output: "blue is sky the"
 * 
 * Example 2:
 * Input: "  hello world!  "
 * Output: "world! hello"
 * Explanation: Your reversed string should not contain leading or trailing spaces.
 * 
 * Example 3:
 * Input: "a good   example"
 * Output: "example good a"
 * Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
 * 
 * Note:
 * A word is defined as a sequence of non-space characters.
 * Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
 * You need to reduce multiple spaces between two words to a single space in the reversed string.
 */

class Solution {
    public String reverseWordsII(String s) {
        String[] parts = s.trim().split("\\s+");
        
        String result = "";
        
        for(int i = parts.length -1; i > 0; i--)
        {
            result += parts[i]  + " ";
        }
        
        return result + parts[0];
    }

    // In-place solution
    public String reverseWords(String s) 
    {
        // put a blank space in front of the word if this word is not the first word

        // copy the word to the position starts with storeIndex

        // reverse the word

        // update the possible start of next word
        
        if (s.length() < 1) 
            return s; // empty string
        
        int startIdx = 0;
        char[] str = s.toCharArray();
        
        // reverse whole string
        reverse(str, 0, str.length - 1);
        
        // reverse word one by one
        for (int i = 0; i < str.length; i++) 
        {
            if (str[i] != ' ') 
            {
                if (startIdx != 0) 
                    str[startIdx++] = ' ';
                
                int j = i;
                
                while (j < str.length && str[j] != ' ')
                    str[startIdx++] = str[j++];
                
                reverse(str, startIdx - (j - i), startIdx - 1); // startIdx - 1, NOT startIdx; 

                i = j;
            }
        }
        return new String(str, 0, startIdx);
    }

    private void reverse(char[] str, int begin, int end) {
        for (; begin < end; begin++, end--) {
            char tmp = str[begin];
            str[begin] = str[end];
            str[end] = tmp;
        }
    }
}