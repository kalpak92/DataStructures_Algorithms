/**
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 * 
 * Example:
 * Input: S = "ADOBECODEBANC", T = "ABC"
 * Output: "BANC"
 * 
 * Note:
 * If there is no such window in S that covers all characters in T, return the empty string "".
 * If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
 */

public class SolutionII {
    public String minWindow(String s, String t) {
        ipublic String minWindow(String s, String t) {
            if(t.length() > s.length()) 
                return "";
            
            Map<Character, Integer> map = new HashMap<>();
            int i = 0; 
            int j = 0;
            int counter = 0;
            int length = Integer.MAX_VALUE;
            String result = "";
            
            for(char c : t.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
            counter = map.size();
            
            while(j < s.length()) {
                // Calculation : Remove the character's counter from the map
                char c = s.charAt(j);
                if(map.containsKey(c)) {
                    map.put(c, map.get(c) - 1);
                    if (map.get(c) == 0)
                        counter--;
                }
                // increase j
                j++;
                
                while(counter == 0) {   // we have a window with all the characters of t
                    // Update the result
                    if(j - i < length) {
                        length = j - i;
                        result = s.substring(i, j);
                    }
                    
                    // Slide the window from the left
                    char temp = s.charAt(i);
                    if(map.containsKey(temp)) {
                        map.put(temp, map.get(temp) +1);
                        if(map.get(temp) > 0)
                            counter++;
                    }
                    i++;
                }
            }
            return result;
        }
    }
}