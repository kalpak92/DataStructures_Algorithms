import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author kalpak
 * Given a string, we can "shift" each of its letter to its successive letter, for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence:
 *
 * "abc" -> "bcd" -> ... -> "xyz"
 *
 * Given a list of non-empty strings which contains only lowercase alphabets, group all strings that belong to the same shifting sequence.
 *
 * Example:
 *
 * Input: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"],
 * Output:
 * [
 *   ["abc","bcd","xyz"],
 *   ["az","ba"],
 *   ["acef"],
 *   ["a","z"]
 * ]
 */


class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> stringGroups = new HashMap<>();
        List<List<String>> result = new ArrayList<>();
        
        for(String str : strings) {
            String key = hashString(str);
            List<String> temp = stringGroups.getOrDefault(key, new ArrayList<>());
            temp.add(str);
            stringGroups.put(key, temp);
        }
        
        for(String key : stringGroups.keySet()){
            result.add(stringGroups.get(key));
        }
        
        return result;
    }
    
    private String hashString(String word) {
        char[] temp = word.toCharArray();
        StringBuilder hashKey = new StringBuilder();
        
        for(int i = 1; i < temp.length; i++) {
            int diff = temp[i] - temp[i - 1];
            // Consider az and ba
            // where az = 0->25 and ba = 0->-1
            if(diff < 0){
                diff += 26;
            }
            hashKey.append(diff);
            hashKey.append(",");
        }
        return hashKey.toString();
    }
}