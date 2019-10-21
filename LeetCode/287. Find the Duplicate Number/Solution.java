/**
 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), 
 * Prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.
 * 
 * Example 1:
 * Input: [1,3,4,2,2]
 * Output: 2
 * 
 * Example 2:
 * Input: [3,1,3,4,2]
 * Output: 3
 * 
 * Note:
 * You must not modify the array (assume the array is read only).
 * You must use only constant, O(1) extra space.
 * Your runtime complexity should be less than O(n2).
 * There is only one duplicate number in the array, but it could be repeated more than once.
 */

 /**
 * Floyd's Tortoise and Hare Algorithm
 *
 * Proof:
 *   start-----entry-------
 *               |        |
 *               --------meeting point
 *   x: distance from start to entry
 *   y: distance from entry to meeting point
 *   c: cycle length
 *
 *   When tortoise and hare meets at meeting point,
 *     tortoise traveled: x + y,
 *     hare traveled: x + y + n*c (which is x + y + several loops inside the circle)
 *
 *   And hare is twice faster than tortoise, so
 *     2(x + y) = x + y + n*c
 *
 *   Then we can get
 *     x = n*c - y
 *     x = (n-1)*c + (c-y)
 *
 *   Which means
 *     traveling from start to entry (distance is x) and
 *     traveling from meeting point to entry (c-y + several loops in circle)
 *     will finally meet at entry
 */

 
 class Solution {
    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length == 0)
        {
            return -1;
        }
        
        int slow = nums[0];
        int fast = nums[nums[0]];
        
        while(slow != fast)
        {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        
        slow = 0;
        while(slow != fast)
        {
            slow = nums[slow];
            fast = nums[fast];
        }
        
        return slow;
    }
}