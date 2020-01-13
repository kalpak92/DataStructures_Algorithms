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
        if(nums == null || nums.length == 0)
            return new int[0];
        
        int[] result = new int[nums.length - k + 1];
        int idx = 0;
        
        Deque<Integer> q = new LinkedList<>();
        
        // At each i, we keep "promising" elements, which are potentially max number in window [i-(k-1),i] or any subsequent window.
        
        // If an element in the deque and it is out of i-(k-1), we discard them. 
        // We just need to poll from the head, as we are using a deque and elements are ordered as the sequence in the array.
        
        // Now only those elements within [i-(k-1),i] are in the deque. 
        // We then discard elements smaller than a[i] from the tail. 
        // This is because if a[x] <a[i] and x<i, then a[x] has no chance to be the "max" in [i-(k-1),i], or any other subsequent window: a[i] would always be a better candidate.

        // At each step the head of the deque is the max element in [i-(k-1),i]
        
        for(int i = 0; i < nums.length; i++)
        {
            while(!q.isEmpty() && q.peek() < i - k + 1)
            {
                System.out.println("q.peek() < i - k + 1 -");
                q.poll();
            }    
            
            while(!q.isEmpty() && nums[q.peekLast()] < nums[i])
            {
                System.out.println("nums[q.peekLast()] < nums[i]");
                q.pollLast();
            }
            
            q.offer(i);
            System.out.println(q);
            
            if (i >= k - 1)
            {
                System.out.println("Adding to result");
                result[idx++] = nums[q.peek()];
            }
        }
        return result;
    }
}