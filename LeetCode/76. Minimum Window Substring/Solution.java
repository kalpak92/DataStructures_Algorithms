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

class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> requiredCharacters = charToOccurrence(t);
        
        // For the window, map all the characters in the window to their frequency.
        Map<Character, Integer> windowCharMap = new HashMap<>();
        
        // Two pointers. We move the right until we the window satisfies all the required characters.
        // Then we take note whether the window beats the smallest satisfiable window we have found so far.
        // We then contract the window using the left pointer, and keep on checking whether the window still satisfies the character requirements. Also we keep on checking if we have beaten the smallest window till now.
        // As soon the window violates the requirements of the characters, we return to expanding the right pointer.
        // We are finished when the right pointer runs over the array.
        
        int left = 0;
        int right = 0;
        
        int totalCharFrequenciesToMatch = requiredCharacters.size();
        int charFrequenciesInWindowMatch = 0;
        
        // Keep track of the best window so far.
        int minWindowLenSoFar = Integer.MAX_VALUE;
        String minWindow = "";
        
        while(right < s.length())
        {
            char charAtRightPointer = s.charAt(right);
            charToHashMap(windowCharMap, charAtRightPointer);
            
            boolean isRightCharRequired = requiredCharacters.containsKey(charAtRightPointer);
            
            if(isRightCharRequired)
            {
                boolean rightCharFreqCheck = requiredCharacters.get(charAtRightPointer).intValue() == windowCharMap.get(charAtRightPointer).intValue();
                
                if (rightCharFreqCheck)
                {
                    charFrequenciesInWindowMatch++;
                }
            }
            
            // if the wiindow satisfies the requirements, we try contracting the left pointer inward until we go over the right pointer.
            while(charFrequenciesInWindowMatch == totalCharFrequenciesToMatch && left <= right)
            {
                char charAtLeft = s.charAt(left);
                int windowSize = right - left + 1;
                
                // update the tracking variables if the best window so far has been defeated.
                if( windowSize < minWindowLenSoFar)
                {
                    minWindowLenSoFar = windowSize;
                    minWindow = s.substring(left, right + 1);
                }
                windowCharMap.put(charAtLeft, windowCharMap.get(charAtLeft) -1);
                
                // was this character part of the requirement?? 
                // if so then, changing the frequency matters.
                
                boolean isLeftCharRequired = requiredCharacters.containsKey(charAtLeft);
                
                if(isLeftCharRequired)
                {
                    // check the frequency threshold of it.
                    boolean isCharFailRequirement = windowCharMap.get(charAtLeft).intValue() <
                                                    requiredCharacters.get(charAtLeft).intValue();
                    
                    if(isCharFailRequirement)
                        charFrequenciesInWindowMatch--;
                }
                
                left++;
            }
            
            right ++;
        }
        
        return minWindow;
    }
    
    private Map<Character, Integer> charToOccurrence(String s)
    {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        
        for(int i = 0; i < s.length(); i++)
        {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);    
        }
        
        return map;
    }
    
    private void charToHashMap(Map<Character, Integer> map, Character c)
    {
        map.put(c, map.getOrDefault(c, 0) + 1);
    }
    
}