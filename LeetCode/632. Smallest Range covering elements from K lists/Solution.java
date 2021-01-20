/**
 * You have k lists of sorted integers in non-decreasing order. 
 * Find the smallest range that includes at least one number from each of the k lists.
 * 
 * We define the range [a, b] is smaller than range [c, d] if b - a < d - c or a < c if b - a == d - c.
 * 
 * Example 1:
 * Input: nums = [[4,10,15,24,26],[0,9,12,20],[5,18,22,30]]
 * Output: [20,24]
 * Explanation: 
 * List 1: [4, 10, 15, 24,26], 24 is in range [20,24].
 * List 2: [0, 9, 12, 20], 20 is in range [20,24].
 * List 3: [5, 18, 22, 30], 22 is in range [20,24].
 * 
 * Example 2:
 * Input: nums = [[1,2,3],[1,2,3],[1,2,3]]
 * Output: [1,1]
 * 
 * Example 3:
 * Input: nums = [[10,10],[11,11]]
 * Output: [10,11]
 * 
 * Example 4:
 * Input: nums = [[10],[11]]
 * Output: [10,11]
 * 
 * Example 5:
 * Input: nums = [[1],[2],[3],[4],[5],[6],[7]]
 * Output: [1,7]
 * 
 * Constraints:
 * nums.length == k
 * 1 <= k <= 3500
 * 1 <= nums[i].length <= 50
 * -10^5 <= nums[i][j] <= 10^5
 * nums[i] is sorted in non-decreasing order.
 */


public class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<Element> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);
        int maximum = Integer.MIN_VALUE;        // track the maximum value of the values present in the heap
        int start = 0;                          // starting range        
        int end = Integer.MAX_VALUE;            // ending range
        
        // Enter the first element of every list
        // Also, keep track of the maximum value amongst them
        for(int i = 0; i < nums.size(); i++) {
            Element temp = new Element(i, 0, nums.get(i).get(0));
            minHeap.offer(temp);
            maximum = Math.max(maximum, nums.get(i).get(0));
        }
        
        // At any time, the heap is allowed to have K elements, i.e the number of lists
        while(minHeap.size() == nums.size()) {
            Element temp = minHeap.poll();          // Fetch the minimum of the 3 elements
            int row = temp.row;                             
            int col = temp.col;
            
            if(maximum - temp.val < end - start) {      // Check if the range is smaller than the current range --> Update them
                start = temp.val;
                end = maximum;
            }
            
            // Add the next element to temp to the heap. 
            if(col + 1 < nums.get(row).size()) {    // the condition checks if at all the index is valid or not
                minHeap.offer(new Element(row, col+1, nums.get(row).get(col+1)));
                maximum = Math.max(maximum, nums.get(row).get(col+1));  // keep track of the maximum in the heap.
            }
        }
        return new int[]{start, end};
    }

    class Element {
		int row;
		int col;
        int val;

		public Element(int row, int col, int val) {
			this.row = row;
			this.col = col;
            this.val = val;
		}
    }    
}
