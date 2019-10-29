/**
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 * Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
 * 
 * The order of output does not matter.
 * 
 * Example 1:
 * Input:
 * s: "cbaebabacd" p: "abc"
 * Output:
 * [0, 6]
 * 
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 * 
 * Example 2:
 * Input:
 * s: "abab" p: "ab"
 * Output:
 * [0, 1, 2]
 * 
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 */

class Solution {
    public List<Integer> findAnagrams(String s, String t) {
        
        List<Integer> result = new ArrayList<>();
        
        if(t.length() > s.length())
            return result;

        Map<Character, Integer> map = new HashMap<>();

        for(char c : t.toCharArray())
        {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int begin = 0, end = 0;
        int len = Integer.MAX_VALUE;
        int counter = map.size();
        //String res = "";

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
                if(end - begin == t.length())
                {
                    len = end - begin;
                    result.add(begin);          // add the starting position to the result list.
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
            return new ArrayList<>();
        
        return result;
     }
}