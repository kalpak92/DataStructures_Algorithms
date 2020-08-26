/**
 * Given a sorted array A of unique numbers, find the K-th missing number starting from the leftmost number of the array.
 * 
 * Example 1:
 * Input: A = [4,7,9,10], K = 1
 * Output: 5
 * 
 * Explanation: 
 * The first missing number is 5.
 * 
 * Example 2:
 * Input: A = [4,7,9,10], K = 3
 * Output: 8
 * Explanation: 
 * The missing numbers are [5,6,8,...], hence the third missing number is 8.
 * 
 * Example 3:
 * Input: A = [1,2,4], K = 3
 * Output: 6
 * Explanation: 
 * The missing numbers are [3,5,6,7,...], hence the third missing number is 6.
 * 
 * Note:
 *     1 <= A.length <= 50000
 *     1 <= A[i] <= 1e7
 *     1 <= K <= 1e8
 */

class Solution {
    public int missingElement(int[] nums, int k) {
        int totalMissingElementsInArray = countMissingElements(nums, nums.length - 1);
        
        if(k > totalMissingElementsInArray)
            return nums[nums.length - 1] + k - totalMissingElementsInArray;
        
        int left = 0;
        int right = nums.length;
        
        while(left < right) {
            int mid = left + (right - left)/2;
            
            int missing = countMissingElements(nums, mid);
            if(missing >= k)
                right = mid;
            else {
                left = mid + 1;
            }
        }
        left--; // //offset after binary search, else the index is not correct, since we have `left = mid + 1`
        return nums[left] + k - countMissingElements(nums, left);
    }
    
    private int countMissingElements(int[] nums, int index) {
        return nums[index] - nums[0] - index;
    }
}