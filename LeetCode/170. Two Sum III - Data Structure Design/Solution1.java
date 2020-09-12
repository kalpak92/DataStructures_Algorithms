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
    
    // As noted from discussion, this problem can be solved considering 2 scenarios of tradeoffs.
    // This one considers where find is more prevalent that add.
    
    Set<Integer> numbers;
    Set<Integer> sums;
    /** Initialize your data structure here. */
    public TwoSum() {
        numbers = new HashSet<>();
        sums = new HashSet<>();
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        // for each of the numbers, add them and store it in sums.
        for(int n : numbers)
            sums.add(n + number);
        
        numbers.add(number);
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        return sums.contains(value);
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */