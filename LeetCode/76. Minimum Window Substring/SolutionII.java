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
        if(t.length()> s.length()) 
            return "";
        
        Map<Character, Integer> map = new HashMap<>();
        
        for(char c : t.toCharArray())
        {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        int counter = map.size();
        
        int begin = 0, end = 0;
        //int head = 0;
        int len = Integer.MAX_VALUE;
        String res = "";
        
        while(end < s.length())
        {
            char c = s.charAt(end);
            
            if( map.containsKey(c) )
            {
                map.put(c, map.get(c) - 1);
                
                if(map.get(c) == 0) 
                    counter--;
            }
            end++;
            
            System.out.println(map + " counter " + counter);
            
            while(counter == 0)
            {
                if(end-begin < len){
                    len = end - begin;
                    //head = begin;
                    res = s.substring(begin, end);
                }
                
                char tempc = s.charAt(begin);
                System.out.println("Begin: " + tempc);
                
                if(map.containsKey(tempc))
                {    
                    map.put(tempc, map.get(tempc) + 1);
                    
                    if(map.get(tempc) > 0){
                        counter++;
                    }
                }
                
                
                begin++;
            }
            
        }
        
        if(len == Integer.MAX_VALUE) 
            return "";
        //return s.substring(head, head+len);
        return res;
    }
}