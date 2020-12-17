/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: 
 * (you may want to display this pattern in a fixed font for better legibility)
 * 
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 
 * And then read line by line: "PAHNAPLSIIGYIR"
 * 
 * Write the code that will take a string and make this conversion given a number of rows:
 * string convert(string s, int numRows);
 * 
 * Example 1:
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * 
 * Example 2:
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * 
 * Example 3:
 * Input: s = "A", numRows = 1
 * Output: "A"
 * 
 * Constraints:
 * 1 <= s.length <= 1000
 * s consists of English letters (lower-case and upper-case), ',' and '.'.
 * 1 <= numRows <= 1000
 */

public class Solution {
    public String convert(String s, int numRows) {
        char[] c = s.toCharArray();
        int len = c.length;
        
        StringBuffer[] sb = new StringBuffer[numRows];
        for(int i = 0; i < numRows; i++)
            sb[i] = new StringBuffer();
        
        int i = 0;
        while(i < len) {
            for(int idx = 0; idx < numRows && i < len; idx++) // Fill it down
                sb[idx].append(c[i++]);
            
            for(int idx = numRows - 2; idx >= 1 && i < len; idx--)  // Fill it obliquely
                sb[idx].append(c[i++]);
        }
        
        for(int idx = 1; idx < sb.length; idx++)
            sb[0].append(sb[idx]);
        
        return sb[0].toString();
    }
}
