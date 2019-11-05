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

// The trick is to construct the arrays (in the case for 4 elements)

// {              1,         a[0],    a[0]*a[1],    a[0]*a[1]*a[2],  }
// { a[1]*a[2]*a[3],    a[2]*a[3],         a[3],                 1,  }

// Both of which can be done in O(n) by starting at the left and right edges respectively.

// Then multiplying the two arrays element by element gives the required result

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] l  = new int[nums.length];
        int[] r = new int[nums.length];
        
        l[0] = 1;
        for(int i = 1; i < nums.length; i++)
            l[i] = l[i-1] * nums[i-1];
        
        r[nums.length - 1] = 1;
        for(int i = nums.length - 2; i >= 0; i--)
            r[i] = r[i+1]*nums[i+1];
        
        for(int i = 0; i < nums.length; i++)
            nums[i] = l[i] * r[i];
        
        return nums;
    }
}