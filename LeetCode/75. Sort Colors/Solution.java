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
        int left = 0;
        int right = nums.length - 1;
        int current = 0;
        
        while(current <= right) {
            if(nums[current] == 0) {
                int temp = nums[left];
                nums[left] = nums[current];
                nums[current] = temp;
                
                current++;
                left++;
            } else if (nums[current] == 2) {
                int temp = nums[right];
                nums[right] = nums[current];
                nums[current] = temp;
                
                right--;
            } else
                current++;
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