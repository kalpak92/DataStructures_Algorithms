/**
 * You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once. 
 * Find this single element that appears only once.
 * 
 * Example 1:
 * Input: [1,1,2,3,3,4,4,8,8]
 * Output: 2
 * 
 * Example 2:
 * Input: [3,3,7,7,10,11,11]
 * Output: 10
 * 
 * Note: Your solution should run in O(log n) time and O(1) space.
 */

 class Solution {
    public int singleNonDuplicate(int[] nums) {
        if(nums.length == 1) 
            return nums[0];
        
        int left = 0;
        int right = nums.length - 1;
        
        while(left <= right) {
            int mid = left + (right - left)/2;
            
            if((mid-1 >= 0 && nums[mid-1] == nums[mid]) || (mid + 1 < nums.length && nums[mid+1] == nums[mid])){ // nums[mid] is not single
                int currLen = right - left; // actual length - 1                
                
                if((currLen/2) % 2 == 0){           //Even
                    if(nums[mid-1] == nums[mid]){   // Match is on the left hand side
                        right = mid - 2;            // Skip mid-1 and mid as we know they are not single
                    }
                    else{
                        // The element is on the right hand side
                        left = mid + 2;
                    }
                }
                else{                               // Odd
                    if(nums[mid-1] == nums[mid]){   // Match is on the left hand side
                        left = mid + 1;             // Go Right
                    }
                    else{
                        // Go Left
                        right = mid - 1;
                    }
                }
            }
            else 
                return nums[mid];
        }
        
        return nums[left];
    }
}