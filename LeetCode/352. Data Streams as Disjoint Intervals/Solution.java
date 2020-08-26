/**
 * Given a data stream input of non-negative integers a1, a2, ..., an, ..., summarize the numbers seen so far as a list of disjoint intervals.
 * For example, suppose the integers from the data stream are 1, 3, 7, 2, 6, ..., then the summary will be:
 * [1, 1]
 * [1, 1], [3, 3]
 * [1, 1], [3, 3], [7, 7]
 * [1, 3], [7, 7]
 * [1, 3], [6, 7]
 * 
 * Follow up:
 * What if there are lots of merges and the number of disjoint intervals are small compared to the data stream's size?
 */

class SummaryRanges {

    private TreeMap<Integer, Integer> treeMap;
    
    public SummaryRanges() {
        treeMap = new TreeMap<>();    
    }
    
    public void addNum(int val) {
        // check if val is already present in the map.
        if(treeMap.containsKey(val))
            return;

        // Get the lower and the higher key
        Integer lowerKey = treeMap.lowerKey(val);
        Integer higherKey = treeMap.higherKey(val);
        
        // Check if the left and the right intervals can be merged.
        if(lowerKey != null && higherKey != null && val == treeMap.get(lowerKey) + 1 && val == higherKey - 1 ) {
            treeMap.put(lowerKey, treeMap.get(higherKey));  // Merge the intervals
            treeMap.remove(higherKey);                      // Remove the right interval
         }
        else if(lowerKey != null && val <= treeMap.get(lowerKey) + 1) {     // check if val is inside or one more than the left interval.
            treeMap.put(lowerKey, Math.max(val, treeMap.get(lowerKey)));    // update the same with the maximum of exisiting val and new val
        }
        else if(higherKey != null && val == higherKey - 1) {     // check if the val is 1 less than the higherKey
            treeMap.put(val, treeMap.get(higherKey));          // then change the higher interval to start from val and remove the existing interval
            treeMap.remove(higherKey);
        }
        else {
            treeMap.put(val, val);
        }
    }
    
    public int[][] getIntervals() {
        List<int[]> result = new ArrayList<>();
        
        for(int key : treeMap.keySet()){
            result.add(new int[]{key, treeMap.get(key)});
        }
        return result.toArray(new int[treeMap.size()][2]);
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * int[][] param_2 = obj.getIntervals();
 */