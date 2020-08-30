/**
 * Given a string S, check if the letters can be rearranged so that two characters that are adjacent to each other are not the same.
 * If possible, output any possible result.  If not possible, return the empty string.
 * 
 * Example 1:
 * Input: S = "aab"
 * Output: "aba"
 * 
 * Example 2:
 * Input: S = "aaab"
 * Output: ""
 * 
 * Note:
 * 
 *     S will consist of lowercase letters and have length in range [1, 500].
 */

/**
 * ALGORITHM
 *     1. count letter appearance and store in hash[i]
 *     2. find the letter with largest occurence.
 *     3. put the letter into even index numbe (0, 2, 4 ...) char array
 *     4. put the rest into the array
 * 
 * Time O(N): fill hash[] + find the letter + write results into char array
 * Space O(N + 26): result + hash[]
 * 
 * We construct the resulting string in sequence: at position 0, 2, 4, ... and then 1, 3, 5, ...
 * In this way, we can make sure there is always a gap between the same characters
 * 
 * Consider this example: "aaabbbcdd", we will construct the string in this way:
 *  a _ a _ a _ _ _ _ // fill in "a" at position 0, 2, 4
 * a b a _ a _ b _ b // fill in "b" at position 6, 8, 1
 * a b a c a _ b _ b // fill in "c" at position 3
 * a b a c a d b d b // fill in "d" at position 5, 7
 * 
 * if we went to 1,3,5 instead of 6,8,1. It would lead to "abababcdd"
 */

class Solution {
    public String reorganizeString(String S) {
    if (S == null || S.length() == 0) {
        return "";
    }

    /* store char-frequency pair into map */
    Map<Character, Integer> map = new HashMap<>();
    for (char c : S.toCharArray()) {
        map.put(c, map.getOrDefault(c, 0) + 1);
    }

    // push all map entry into priority element, by sorting from high frequency to low frequency
    PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(
            (a, b) -> (b.getValue() - a.getValue())
    );
    for (Map.Entry<Character, Integer> entry : map.entrySet()) {
        pq.offer(entry);
    }


    StringBuilder sb = new StringBuilder();
    while (!pq.isEmpty()) {
        // store character with highest frequency in cache
        Map.Entry<Character, Integer> cache = pq.poll();

        // if character in cache is different with tail character in current string
        if (sb.length() == 0 || cache.getKey() != sb.charAt(sb.length() - 1)) {
            sb.append(cache.getKey());
            cache.setValue(cache.getValue() - 1);

            // if current character still have more quota left, push back to queue
            // if (cache.getValue() != 0) {
            //     pq.offer(cache);
            // }
        }

        // if character in cache is same as tail character in current string
        // we need to try the character with second highest frequency
        else {
            Map.Entry<Character, Integer> cache2 = pq.poll();
            // corner case: if no more elements in queue, the input string should be invalid
            // because we do not have any other characters that different with current string tail
            if (cache2 == null) {
                return "";
            }
            sb.append(cache2.getKey());
            cache2.setValue(cache2.getValue() - 1);
            
            // if current character still have more quota left, push back to queue
            if (cache2.getValue() != 0) {
                pq.offer(cache2);
            }
            // // DO NOT FORGET to push top frequency entry into queue as well
            // pq.offer(cache);
        }
        // if current character still have more quota left, push back to queue
        if (cache.getValue() != 0) {
            pq.offer(cache);
        }
    }
    return sb.toString();
}
}