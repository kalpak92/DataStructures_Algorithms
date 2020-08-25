/**
 * Given an array nums which consists of non-negative integers and an integer m, you can split the array into m non-empty continuous subarrays.
 * 
 * Write an algorithm to minimize the largest sum among these m subarrays.
 * Example 1:
 * Input: nums = [7,2,5,10,8], m = 2
 * Output: 18
 * Explanation:
 * There are four ways to split nums into two subarrays.
 * The best way is to split it into [7,2,5] and [10,8],
 * where the largest sum among the two subarrays is only 18.
 * 
 * Example 2:
 * Input: nums = [1,2,3,4,5], m = 2
 * Output: 9
 * 
 * Example 3:
 * Input: nums = [1,4,4], m = 3
 * Output: 4
 * 
 * Constraints:
 *     1 <= nums.length <= 1000
 *     0 <= nums[i] <= 106
 *     1 <= m <= min(50, nums.length)
 * 
 */

class Solution {
    public int splitArray(int[] nums, int m) {
        if(nums == null || nums.length == 0)
            return -1;
        
        int left = 0;
        int right = 0;
        for(int n : nums) {
            left = Math.max(left, n);
            right += n;
        }
        
        while(left < right) {
            int mid = left + (right - left)/2;
            
            if(isSubarraysLargerThanM(nums, mid, m))
                right = mid;
            else
                left = mid + 1;
        }
        return left;
    }
    
    private boolean isSubarraysLargerThanM(int[] nums, int target, int m) {
        int sum = 0;
        int count = 1;
        
        for(int n : nums) {
            /**
             * here it is actually not from left to right, the order doesn't matter, it is easy to prove:
             * if a + b > t, c + d > t
             * then there is no way to put a + b + c + d in one array, 
             * that is to say,
             *      it could be a + b  c > t, d > t
             *      or a > t, b + c + d > t
             * it doesn't matter, the number of subarrays is still 2, which is equal to a+b>t, and c+d > t
             */
            sum += n;
            if(sum > target) {
                // find a way to form subarray, as said before, it doesn't matter how to form the subarray
                // the number matters, which will not change according to the ways to form a subarray.
                sum = n;
                count++;
            }
            if (count > m)
                return false;   // if count == m, we still have a chance to make mid smaller
        }
        return true;
    }
}