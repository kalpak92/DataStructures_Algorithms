/**
 * Given a paragraph and a list of banned words, return the most frequent word that is not in the list of banned words.  
 * It is guaranteed there is at least one word that isn't banned, and that the answer is unique.
 * 
 * Words in the list of banned words are given in lowercase, and free of punctuation.  Words in the paragraph are not case sensitive.  The answer is in lowercase.
 * 
 * Example:
 * Input: 
 * paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
 * banned = ["hit"]
 * Output: "ball"
 * 
 * Explanation: 
 * "hit" occurs 3 times, but it is a banned word.
 * "ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph. 
 * Note that words in the paragraph are not case sensitive,
 * that punctuation is ignored (even if adjacent to words, such as "ball,"), 
 * and that "hit" isn't the answer even though it occurs more because it is banned.
 * 
 * Note:
 * 1 <= paragraph.length <= 1000.
 * 0 <= banned.length <= 100.
 * 1 <= banned[i].length <= 10.
 * The answer is unique, and written in lowercase (even if its occurrences in paragraph may have uppercase symbols, and even if it is a proper noun.)
 * paragraph only consists of letters, spaces, or the punctuation symbols !?',;.
 * There are no hyphens or hyphenated words.
 * Words only consist of letters, never apostrophes or other punctuation symbols.
 * 
 */

class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> ban = new HashSet<>();
        
        for(String w : banned)
            ban.add(w);
        
        Map<String, Integer> count = new HashMap<>();
        
        String[] words = paragraph.replaceAll("[^a-zA-Z]" , " ").toLowerCase().split(" "); // replace all the non letter characters with a space and then convert everything to lower case and split by space.
        
        for (String w : words) 
        {
            if (!ban.contains(w))   // check if the w is not in the list of banned words
                count.put(w, count.getOrDefault(w, 0) + 1);
        }
        
        String result = "";
        
        for(String key : count.keySet())
        {
            if(result.equals("") || count.get(key) > count.get(result)) // initially, we put whatever is the key, i.e when result = "" or we compare the frequency of string in the result with the key 
                result = key;
        }
        return result;
    }
}
