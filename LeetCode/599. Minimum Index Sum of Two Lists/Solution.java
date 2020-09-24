/**
 *  Suppose Andy and Doris want to choose a restaurant for dinner, and they both have a list of favorite restaurants represented by strings.
 * You need to help them find out their common interest with the least list index sum. 
 * 
 * If there is a choice tie between answers, output all of them with no order requirement. You could assume there always exists an answer.
 * 
 * Example 1:
 * Input:
 * ["Shogun", "Tapioca Express", "Burger King", "KFC"]
 * ["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
 * Output: ["Shogun"]
 * Explanation: The only restaurant they both like is "Shogun".
 * 
 * Example 2:
 * Input:
 * ["Shogun", "Tapioca Express", "Burger King", "KFC"]
 * ["KFC", "Shogun", "Burger King"]
 * Output: ["Shogun"]
 * Explanation: The restaurant they both like and have the least index sum is "Shogun" with index sum 1 (0+1).
 * 
 * Note:
 *     The length of both lists will be in the range of [1, 1000].
 *     The length of strings in both lists will be in the range of [1, 30].
 *     The index is starting from 0 to the list length minus 1.
 *     No duplicates in both lists.
 * 
 */

class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        String[] result = new String[list1.length];

        // Edge Cases
        if(list1.length == 1) 
            return list1;
        else if(list2.length == 1)
            return list2;
        
        // Store the indices for the hotels from the first list
        Map<String, Integer> hotelIndex = new HashMap<> ();
        
        for(int i = 0; i < list1.length; i++)
            hotelIndex.put(list1[i], i);
        
        int min = Integer.MAX_VALUE;
        List<String> commonInterest = new LinkedList<>();
        
        // For each hotel in list2, check if it exists in the map.
        // If so, compute the index sum and compare it with the existing minimum.
        // If a better candidate is found, flush the list and store the new one. Else, if a similar candidate is found, append.
        for(int i = 0; i < list2.length; i++) {
            if(hotelIndex.containsKey(list2[i])) {
                if(i + hotelIndex.get(list2[i]) < min) {
                    commonInterest.clear();
                    min = i + hotelIndex.get(list2[i]);
                    commonInterest.add(list2[i]);
                }
                else if(i + hotelIndex.get(list2[i]) == min) {
                    commonInterest.add(list2[i]);
                }
            }
        }
        // Convert the linkedlist to the suitable return type.
        result = commonInterest.toArray(new String[commonInterest.size()]);
        return result;
    }
}