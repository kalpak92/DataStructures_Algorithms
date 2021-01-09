/**
 * Given a string s, a k duplicate removal consists of choosing k adjacent and equal letters from s and 
 * removing them causing the left and the right side of the deleted substring to concatenate together.
 * 
 * We repeatedly make k duplicate removals on s until we no longer can.
 * 
 * Return the final string after all such duplicate removals have been made.
 * 
 * It is guaranteed that the answer is unique.
 * 
 * Example 1:
 * Input: s = "abcd", k = 2
 * Output: "abcd"
 * Explanation: There's nothing to delete.
 * 
 * Example 2:
 * Input: s = "deeedbbcccbdaa", k = 3
 * Output: "aa"
 * Explanation: 
 * First delete "eee" and "ccc", get "ddbbbdaa"
 * Then delete "bbb", get "dddaa"
 * Finally delete "ddd", get "aa"
 * 
 * Example 3:
 * Input: s = "pbbcggttciiippooaais", k = 2
 * Output: "ps"
 * 
 * Constraints:
 * 1 <= s.length <= 10^5
 * 2 <= k <= 10^4
 * s only contains lower case English letters.
 */

public class Solution {
    public String removeDuplicates(String s, int k) {
        Deque<Pair> stack = new ArrayDeque<>();
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // check if the adjacent letter is the same. If so, increase the count
            if(!stack.isEmpty() && stack.peek().letter == c)
                stack.peek().count++;
            else {
                stack.push(new Pair(c, 1));
            }
            // Remove from stack if count == k
            if(stack.peek().count == k)
                stack.pop();
        }
        
        // Compose the string from the stack based the count of the letters
        StringBuilder sb = new StringBuilder();
        for (Pair p : stack) {
            for (int i = 0; i < p.count; i++)
                sb.insert(0, p.letter);
        }
        return sb.toString();
    }
    
    class Pair {
        char letter;
        int count;
        
        public Pair(char letter, int count) {
            this.letter = letter;
            this.count = count;
        }
    }
}
