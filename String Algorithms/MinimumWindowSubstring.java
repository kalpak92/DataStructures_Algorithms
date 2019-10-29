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

 /**
  * Intuition : the best substring for the answer would simply be a permutation of T if such a substring exists in S, 
  * but otherwise we could have wasteful characters sitting in between the essential characters that make the substring valid as an answer. 
  * Our attempt here is to remove such chars without losing the necessary ones. 
  * After trimming down as much as possible we resume with sliding end right and repeating the whole process.
  */

 import java.util.*;

 public class MinimumWindowSubstring
 {
     public String minWindowSubstr(String s, String t)
     {
        if(t.length() > s.length())
            return "";

        Map<Character, Integer> map = new HashMap<>();

        for(char c : t.toCharArray())
        {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int begin = 0, end = 0;
        int len = Integer.MAX_VALUE;
        int counter = map.size();
        String res = "";

        while(end < s.length())
        {
            char endChar = s.charAt(end);
            
            if(map.containsKey(endChar))
            {
                map.put(endChar, map.get(endChar) - 1);

                if(map.get(endChar) == 0)
                    counter--;
            }
            end ++;

            while(counter == 0)
            {
                if(end - begin < len)
                {
                    len = end - begin;
                    res = s.substring(begin, end);
                }

                char tempC = s.charAt(begin);
                if(map.containsKey(tempC))
                {
                    map.put(tempC, map.get(tempC) + 1);

                    if(map.get(tempC) > 0)
                        counter++;
                }
                begin++;
            }
        }

        if(len == Integer.MAX_VALUE)
            return "";
        
        return res;
     }

     public static void main(String[] args) {
         String s = "ADOBECODEBANCBA";
         String t = "ABC";

         MinimumWindowSubstring obj = new MinimumWindowSubstring();
         System.out.println(obj.minWindowSubstr(s, t));
     }
 }