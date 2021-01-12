/**
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. 
 * You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return the max sliding window.
 * 
 * Example:
 * Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
 * Output: [3,3,5,5,6,7] 
 * 
 * Explanation: 
 * 
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 * 
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ input array's size for non-empty array.
 * 
 * Follow up:
 * Could you solve it in linear time?
 */

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        int idx = 0;
        Deque<Integer> queue = new LinkedList<>();
        int i = 0;
        int j = 0;
        
        while(j < nums.length) {
            // Remove all elements smaller than the current element from the deque. 
            while(!queue.isEmpty() && nums[j] > queue.peekLast()) {
                queue.pollLast();
            }
            // Add the current element
            queue.offer(nums[j]);
            
            // Check the window size.
            if(j - i + 1 < k)
                j++;            // If not reached, increase the window
            else if(j - i + 1 == k) {   // Window Size reached
                result[idx++] = queue.peekFirst();  // query the answer from the head of the deque
                
                // Need to slide the window 
                if(!queue.isEmpty() && nums[i] == queue.peekFirst()) // remove the left element of the window if present in the deque, since it is no longer needed
                    queue.pollFirst();
                i++;
                j++;
            }
        }
        return result;
    }
}