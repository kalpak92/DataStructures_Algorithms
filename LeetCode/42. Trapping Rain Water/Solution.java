/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, 
 * compute how much water it is able to trap after raining.
 * 
 * Example:
 * Input: [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 */

class Solution {
    public int trap(int[] height) {
        if(height == null || height.length == 0)
            return 0;
        
        int leftMax = Integer.MIN_VALUE;
        int rightMax = Integer.MIN_VALUE;
        
        int left = 0;
        int right = height.length - 1;
        int result = 0;
        
        while(left < right)
        {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            //System.out.println("leftmax " + leftMax + " rightMax " + rightMax);
            //System.out.println("left " + height[left] + " right " + height[right]);
            if(leftMax < rightMax)
            {
                result += leftMax - height[left];
                //System.out.println(result);
                left++;
            }
            else {
                result += rightMax - height[right];
                //System.out.println(result);
                right--;
            }
        }
        return result;
    }
}

