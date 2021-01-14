/**
 * Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. 
 * So the median is the mean of the two middle value.
 * 
 * Examples:
 * [2,3,4] , the median is 3
 * [2,3], the median is (2 + 3) / 2 = 2.5
 * 
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Your job is to output the median array for each window in the original array.
 * For example,
 * 
 * Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.
 * Window position                Median
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       1
 *  1 [3  -1  -3] 5  3  6  7       -1
 *  1  3 [-1  -3  5] 3  6  7       -1
 *  1  3  -1 [-3  5  3] 6  7       3
 *  1  3  -1  -3 [5  3  6] 7       5
 *  1  3  -1  -3  5 [3  6  7]      6
 * 
 * Therefore, return the median sliding window as [1,-1,-1,3,5,6].
 * 
 * Note: 
 * You may assume k is always valid, ie: k is always smaller than input array's size for non-empty array.
 * Answers within 10^-5 of the actual value will be accepted as correct.
 */

public class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] result = new double[nums.length - k + 1];
        PriorityQueue<Integer> low = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> high = new PriorityQueue<>();
        int i = 0;
        int j = 0;
        int idx = 0;
        
        while(j < nums.length) {
            // Calculation: Insert to Heaps
            low.add(nums[j]);
            high.add(low.poll());
            
            if(high.size() > low.size())
                low.add(high.poll());
            
            if(j - i + 1 < k) {
                j++;
            } else if(j - i + 1 == k) {
                // Calculate the result
                result[idx++] = low.size() == high.size() ? (double)((long) low.peek()+(long)high.peek())/2:(double) low.peek();
                
                // slide the window
                if(!low.remove(nums[i]))
                    high.remove(nums[i]);
                i++;
                j++;
            }
        }
        return result;
    }
}
