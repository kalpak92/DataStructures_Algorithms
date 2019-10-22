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
        int low = 0;
        int high = nums.length - 1;
        
        /*
            The logic behind this is: for each mid, we try to find understand whether the single number is on the left half. 
            The if header tests that nums[mid] is not single and neither is anything on its left.
            
            If mid is even, then there are 2m numbers on the left of mid. 
                For the statement of nums[mid] is not single and neither is anything on its left to hold, 
                we need the 2m numbers to the left of mid to be m pairs, and also nums[mid] be in a pair with nums[mid + 1]. 
                Indeed, we only have to make sure in this case that nums[mid], nums[mid + 1] is a pair. 
                You can prove by contradiction that as long as this holds, the sole single number can't be on the left of mid. 
                Now that the statement of nums[mid] is not single and neither is anything on its left is proven, we can just go to the right half.
            
            If mid is odd, then to prove nums[mid] is not single and neither is anything on its left, 
                we only need to prove that nums[mid - 1], nums[mid] is a pair. mid - 1 is even, and as long as nums[mid - 1], 
                nums[mid - 1 + 1] forms a pair, we can actually use the argument of previous paragraph to prove that no entry to the left of mid is single. 
                And neither is mid itself obviously. With nums[mid] is not single and neither is anything on its left proven, we can again to the right half.

            If nums[mid] is not single and neither is anything on its left not provable, then go to left half since the single number is there.
        */
        
        
        while (low < high)
        {
            int mid = low + (high - low)/2;
            
            int even = (mid % 2 == 0) ? nums[mid] : nums[mid - 1];
            int odd = (mid % 2 == 0) ? nums[mid + 1] :nums[mid];
            if (even == odd) 
            {
                low = mid + 1;
            } 
            else 
            {
                high = (mid / 2) * 2;
            }
        }
        return nums[low];
    }
}