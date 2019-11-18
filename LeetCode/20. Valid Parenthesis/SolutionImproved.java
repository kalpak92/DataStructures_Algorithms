/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * 
 * An input string is valid if:
 * 
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 * 
 * Example 1:
 * Input: "()"
 * Output: true
 * 
 * Example 2:
 * Input: "()[]{}"
 * Output: true
 * 
 * Example 3:
 * Input: "(]"
 * Output: false
 * Example 4:
 * 
 * Input: "([)]"
 * Output: false
 * 
 * Example 5:
 * Input: "{[]}"
 * Output: true
 */

class SolutionImproved {
    public boolean isValid(String s) {
        if ((s.length() & 1) == 1) 
            return false;
        else {
            Deque<Character> p = new ArrayDeque<>(s.length());
            
            for (int i = 0; i < s.length(); i++)
            {
                switch (s.charAt(i)) 
                {
                    case '(': 
                        p.push(')'); break;
                    case '{': 
                        p.push('}'); break;
                    case '[': 
                        p.push(']'); break;
                    case ')': case '}': case ']': 
                        if (p.isEmpty() || p.pop() != s.charAt(i)) return false;
                }
            }
            return p.isEmpty();
        }
    }
}