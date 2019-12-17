/**
 * Design a data structure that supports all following operations in average O(1) time.
 * 
 * insert(val): Inserts an item val to the set if not already present.
 * remove(val): Removes an item val from the set if present.
 * getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.
 * 
 * Example:
 * // Init an empty set.
 * RandomizedSet randomSet = new RandomizedSet();
 * // Inserts 1 to the set. Returns true as 1 was inserted successfully.
 * randomSet.insert(1);
 * 
 * // Returns false as 2 does not exist in the set.
 * randomSet.remove(2);
 * 
 * // Inserts 2 to the set, returns true. Set now contains [1,2].
 * randomSet.insert(2);
 * 
 * // getRandom should return either 1 or 2 randomly.
 * randomSet.getRandom();
 * 
 * // Removes 1 from the set, returns true. Set now contains [2].
 * randomSet.remove(1);
 * 
 * // 2 was already in the set, so return false.
 * randomSet.insert(2);
 * 
 * // Since 2 is the only number in the set, getRandom always return 2.
 * randomSet.getRandom();
 */

class RandomizedSet {
    Map<Integer, Integer> mapValToIndexInList;
    List<Integer> value;
    int index;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        mapValToIndexInList = new HashMap<>();
        value = new ArrayList<>();
        index = 0;
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (mapValToIndexInList.containsKey(val))
            return false;
        
        value.add(val);
        mapValToIndexInList.put(val, value.size() -1);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        int index = mapValToIndexInList.getOrDefault(val, -1);  // get the index of the element from the map
        
        if (index == -1)
            return false;
        
        Collections.swap(value, index, value.size() - 1);   // swap the value at that index with the last element in the list
        
        // update the map with the index of the value that got swapped in the process
        int valSwapped = value.get(index);
        mapValToIndexInList.put(valSwapped, index);
        
        // remove it from the value array in O(1)
        value.remove(value.size() - 1);
        
        // return after removing the value from the map
        return mapValToIndexInList.remove(val) != null ;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        java.util.Random rand = new java.util.Random();
        
        return value.get(rand.nextInt(value.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */