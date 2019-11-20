/**
 * Given an array of strings, group anagrams together.
 * 
 * Example:
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 *  ["ate","eat","tea"],
 *  ["nat","tan"],
 *  ["bat"]
 * ]
 * 
 * Note:
 * All inputs will be in lowercase.
 * The order of your output does not matter.
 */

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // we create a hash of the string and store them in the hashmap.
        
        Map<String, List<String>> map = new HashMap<>();
        
        for(int i = 0; i < strs.length; i++)
        {
            String str = strs[i];       // pick a string and work on it.
            
            int[] counter = new int[26];    // create a counter array that counts on frequency of each letter in the word
            
            for(int j = 0; j < str.length(); j++)
            {
                counter[str.charAt(j) - 'a']++;     // iterate through the string and increment the corresponding index by subtracting the 'a' from the character.
            }
            
            // create a hash string now.
            // Eg: cat becomes 1a1c1t. caabbt becomes 2a2b1c1t
            StringBuilder sb = new StringBuilder("");
            
            for(int j = 0; j < counter.length; j++)
            {
                if(counter[j] > 0)
                {
                    sb.append(counter[j]);
                    sb.append((char)('a'+j));   // restore back the character by adding 'a' to the counter values.
                }
            }
            
            String hash = sb.toString();        // convert the hash to string
            
            // if the hash is not there in the map, put the key and initialize an empty arraylist for the key
            if(!map.containsKey(hash))
                map.put(hash, new ArrayList<String>());
            
            // enter the string for the corresponding hash.
            map.get(hash).add(str);
        }
        
        return new ArrayList<List<String>>(map.values());
    }
}