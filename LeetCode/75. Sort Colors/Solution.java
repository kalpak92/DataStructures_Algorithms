/**
 * Given an array with n objects colored red, white or blue, 
 * sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.
 * 
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.\
 * Note: You are not suppose to use the library's sort function for this problem.
 * 
 * Example:
 * Input: [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * 
 * Follow up:
 * A rather straight forward solution is a two-pass algorithm using counting sort.
 * First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
 * Could you come up with a one-pass algorithm using only constant space?
 */

class Solution {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0)
            return;
        
        int low = 0;
        int high = nums.length - 1;
        
        for(int i = low; i <= high;)
        {
            if(nums[i] == 0)        // every element to the left of low pointer should be 0
            {
                int temp = nums[i];
                nums[i] = nums[low];
                nums[low] = temp;
                
                i++;
                low++;
            }
            else if (nums[i] == 2)      // every element to the right of high pointer should be 2
            {
                int temp = nums[i];
                nums[i] = nums[high];
                nums[high] = temp;
                
                high--;
            }
            else
                i++;
        }
    }

    public void sortColors(int[] nums) {
        int n0 = -1, n1 = -1, n2 = -1;
        
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] == 0)
            {
                nums[++n2] = 2;
                nums[++n1] = 1;
                nums[++n0] = 0;
            }
            else if (nums[i] == 1)
            {
                nums[++n2] = 2;
                nums[++n1] = 1;
            }
            else if (nums[i] == 2)
                nums[++n2] = 2;
        }
    }
}