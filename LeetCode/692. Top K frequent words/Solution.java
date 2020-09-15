/**
 * Given a non-empty list of words, return the k most frequent elements.
 * 
 * Your answer should be sorted by frequency from highest to lowest. 
 * If two words have the same frequency, then the word with the lower alphabetical order comes first.
 * 
 * Example 1:
 * Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
 * Output: ["i", "love"]
 * 
 * Explanation: "i" and "love" are the two most frequent words.
 * Note that "i" comes before "love" due to a lower alphabetical order.
 * 
 * Example 2:
 * Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
 * Output: ["the", "is", "sunny", "day"]
 * 
 * Explanation: "the", "is", "sunny" and "day" are the four most frequent words
 * with the number of occurrence being 4, 3, 2 and 1 respectively.
 * 
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Input words contain only lowercase letters.
 * Follow up:
 *      Try to solve it in O(n log k) time and O(n) extra space.
 */

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> wordFrequency = new HashMap<>();
        PriorityQueue<String> pq = new PriorityQueue<>((word1, word2) -> 
                                                        wordFrequency.get(word1).equals(wordFrequency.get(word2)) ? 
                                                        word2.compareTo(word1) : wordFrequency.get(word1) - wordFrequency.get(word2));
        List<String> result = new ArrayList<>();
        
        for(String word : words) {
            wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
        }
        
        for(String word : wordFrequency.keySet()) {
            pq.offer(word);
            
            if(pq.size() > k)
                pq.poll();
        }
        
        while(!pq.isEmpty()) {
            result.add(0, pq.poll());
        }
        
        return result;
    }
}