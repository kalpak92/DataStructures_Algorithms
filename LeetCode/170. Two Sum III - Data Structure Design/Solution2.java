/**
 * Design and implement a TwoSum class. It should support the following operations: add and find.
 * 
 * add - Add the number to an internal data structure.
 * find - Find if there exists any pair of numbers which sum is equal to the value.
 * 
 * Example 1:
 * add(1); add(3); add(5);
 * find(4) -> true
 * find(7) -> false
 * 
 * Example 2:
 * add(3); add(1); add(2);
 * find(3) -> true
 * find(6) -> false
 */

 
class TwoSum {

    /** Initialize your data structure here. */
    Map<Integer, Boolean> map;
    int minVal = Integer.MAX_VALUE;
    int maxVal = Integer.MIN_VALUE;
    
    public TwoSum() {
        map = new HashMap<>();
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        map.put(number, map.containsKey(number));
        minVal = Math.min(minVal, number);
        maxVal = Math.max(maxVal, number);
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        // check if the value is at all posible
        if(value < minVal*2 || value > maxVal*2)
            return false;

        /**
         * Consider value = 6.
         * If key = 3 and there were two entries of 3,
         * then diff = 3 and map.get(3) will be true.
         * 
         * Else, if key = 4, and diff = 2.
         * we need to check if the map contains 2 along with diff != key
         */
        
        for(int key : map.keySet()) {
            int diff = value - key;
            if(map.containsKey(diff) && (key != diff || map.get(diff) == true))
                return true;
        }
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */