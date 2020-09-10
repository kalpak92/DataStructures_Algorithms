/**
 * Given an array nums of n integers where n > 1,  
 * return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
 * 
 * Example:
 * Input:  [1,2,3,4]
 * Output: [24,12,8,6]
 * Note: Please solve it without division and in O(n).
 * 
 * Follow up:
 * Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)
 */

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] leftRunningProduct = new int[nums.length];
        int[] rightRunningProduct = new int[nums.length];
        
        leftRunningProduct[0] = 1;
        rightRunningProduct[nums.length - 1] = 1;
        
        /**
         * {              1,         a[0],    a[0]*a[1],    a[0]*a[1]*a[2],  }
         * { a[1]*a[2]*a[3],    a[2]*a[3],         a[3],                 1,  }
         */
        for(int i = 1; i < nums.length; i++) {
            leftRunningProduct[i] = leftRunningProduct[i - 1] * nums[i - 1];
        }
        
        for(int j = nums.length - 2; j >= 0; j--) {
            rightRunningProduct[j] = rightRunningProduct[j + 1] * nums[j + 1];
        }
        
        for(int i = 0; i < nums.length; i++)
            nums[i] = leftRunningProduct[i] * rightRunningProduct[i];
        
        return nums;
    }
}