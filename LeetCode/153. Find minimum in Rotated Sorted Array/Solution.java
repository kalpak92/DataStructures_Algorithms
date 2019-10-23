/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
 * 
 * Find the minimum element.
 * You may assume no duplicate exists in the array.
 * 
 * Example 1:
 * Input: [3,4,5,1,2] 
 * Output: 1
 * 
 * Example 2:
 * Input: [4,5,6,7,0,1,2]
 * Output: 0
 */

 class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int result = -1;
        
        if (low == high)
            return nums[low];
        
        if (nums[low] < nums[high])
            return nums[low];
        
        while(low <= high)
        {
            int mid = low + (high - low)/2;
            //System.out.println(mid);
            
            if (nums[mid] > nums[mid + 1])
                return nums[mid + 1];
            
            if (nums[mid] < nums[mid - 1])
                return nums[mid];
        
            if(nums[mid] > nums[low])
                low = mid + 1;
            else 
                high = mid - 1;
        }
        return result;
    }
}