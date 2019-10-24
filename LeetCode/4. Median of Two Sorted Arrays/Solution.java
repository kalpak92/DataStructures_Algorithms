/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * 
 * You may assume nums1 and nums2 cannot be both empty.
 * 
 * Example 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 * 
 * The median is 2.0
 * 
 * Example 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * 
 * The median is (2 + 3)/2 = 2.5
 */

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // we consider that length of arr1 is less than arr2. If that is violated, swap the two and start over.
        if(nums1.length > nums2.length)
            return findMedianSortedArrays(nums2, nums1);
        
        int len1 = nums1.length;
        int len2 = nums2.length;
        
        int low  = 0;
        int high = len1;
        
        while(low <= high)
        {
            int partitionX = low + (high - low) /2;
            int partitionY = (len1 + len2 + 1) / 2 - partitionX;
            
            //if partitionX is 0 it means nothing is there on left side. Use -INF for maxLeftX
            //if partitionX is length of input then there is nothing on right side. Use +INF for minRightX
            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int minRightX = (partitionX == len1) ? Integer.MAX_VALUE : nums1[partitionX];

            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int minRightY = (partitionY == len2) ? Integer.MAX_VALUE : nums2[partitionY];
            
            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                // We have partitioned array at correct place
                // Now get max of left elements and min of right elements to get the median in case of even length combined array size
                // or get max of left for odd length combined array size.
                if ((len1 + len2) % 2 == 0) 
                {
                    return ((double)Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY))/2;
                } 
                else 
                {
                    return (double)Math.max(maxLeftX, maxLeftY);
                }
            }
            else if (maxLeftX > minRightY) 
            {   // we are too far on right side for partitionX. Go on left side.
                high = partitionX - 1;
            } 
            else 
            {   // we are too far on left side for partitionX. Go on right side.
                low = partitionX + 1;
            }
        }
        
        // Only we we can come here is if input arrays were not sorted. Throw in that scenario.
        throw new IllegalArgumentException();
    }
}